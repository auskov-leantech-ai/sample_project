package com.example.github.sample.presentation.register

import com.example.github.sample.R
import com.example.github.sample.exstension.setOnDebouncedClickListener
import com.example.github.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_register

    override val viewModel by viewModel<RegisterViewModel>()

    override fun initView() {
        baseSubscribe(viewModel)

        button_register.setOnDebouncedClickListener {
            viewModel.fieldValidation(
                edit_text_register_email.text.toString().trim(),
                edit_text_register_password.text.toString().trim(),
                edit_text_register_password_repeat.text.toString().trim()
            )
        }

        image_view_register_back_welcome.setOnDebouncedClickListener {
            viewModel.navigateToBack()
        }
    }
}
