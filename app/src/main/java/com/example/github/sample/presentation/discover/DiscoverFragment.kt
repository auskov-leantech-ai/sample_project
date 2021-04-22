package com.example.github.sample.presentation.discover

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_discover.*

class DiscoverFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_discover

    override fun initView() {
        bottom_navigation_view.itemIconTintList = null
        val navHost = childFragmentManager.findFragmentById(R.id.fragment_discover) as NavHostFragment
        bottom_navigation_view.setupWithNavController(navHost.navController)
    }
}
