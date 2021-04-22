package com.example.github.sample.presentation.log_in

import com.example.github.sample.R
import com.example.github.sample.exstension.setOnDebouncedClickListener
import com.example.github.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_login

    override val viewModel by viewModel<LoginViewModel>()

    override fun initView() {
        baseSubscribe(viewModel)

        button_login.setOnDebouncedClickListener {
            viewModel.fieldValidation(
                edit_text_login_email.text.toString().trim(),
                edit_text_login_password.text.toString().trim()
            )
        }

        image_view_login_back_welcome.setOnDebouncedClickListener {
            viewModel.navigateToBack()
        }
    }
}
