package com.example.github.sample.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {

    abstract var layoutId: Int

    open val viewModel: BaseViewModel? = null

    private fun getBaseActivity(): BaseActivity = activity as BaseActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel?.navController = findNavController()
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindViewModel()
    }

    private fun bindViewModel() {

        viewModel?.isInProgress?.observe(viewLifecycleOwner, { isInProgress ->
            if (isInProgress) {
                getBaseActivity().showProgressDialog()
            } else {
                getBaseActivity().hideProgressDialog()
            }
        })
    }

    protected fun baseSubscribe(viewModel: BaseViewModel) {
        viewModel.message.observe(this, Observer { message ->
            view?.let { view ->
                when (message.type) {
                    BaseViewModel.BaseMessage.Type.SHORT,
                    BaseViewModel.BaseMessage.Type.LONG,
                    BaseViewModel.BaseMessage.Type.INSTANT -> {
                        val text = message.messageId?.let {
                            getString(it)
                        } ?: message.message
                        text?.let {
                            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
                        }
                    }
                    else -> {
                        //ignore
                    }
                }
            }
        })
    }

    protected abstract fun initView()

}
