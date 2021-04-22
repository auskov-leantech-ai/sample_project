package com.example.github.sample.presentation.welcome

import com.example.github.sample.R
import com.example.github.sample.exstension.setOnDebouncedClickListener
import com.example.github.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_welcome.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_welcome

    override val viewModel by viewModel<WelcomeViewModel>()

    override fun initView() {
        viewModel.getCurrentUser()

        button_welcome_login.setOnDebouncedClickListener {
            viewModel.navigateToLogin()
        }

        button_welcome_register.setOnDebouncedClickListener {
            viewModel.navigateToRegister()
        }
    }
}
