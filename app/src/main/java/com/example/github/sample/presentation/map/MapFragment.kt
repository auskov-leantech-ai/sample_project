package com.example.github.sample.presentation.map

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment(), OnMapReadyCallback {
    override var layoutId: Int = R.layout.fragment_map

    override val viewModel by viewModel<MapViewModel>()

    override fun initView() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        viewModel.map = googleMap ?: return
        requestLocationPermission()
    }

    private val readLocationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isAcceptPermission ->
        if (isAcceptPermission) {
            viewModel.geo()
        }
    }

    private fun requestLocationPermission() {
        readLocationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}
