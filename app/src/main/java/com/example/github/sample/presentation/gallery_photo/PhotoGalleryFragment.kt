package com.example.github.sample.presentation.gallery_photo

import com.example.github.sample.R
import com.example.github.sample.presentation.base.BaseFragment
import com.example.github.sample.presentation.gallery_photo.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.fragment_gallery_photo.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoGalleryFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_gallery_photo

    override val viewModel by viewModel<PhotoGalleryViewModel>()

    private val photoAdapter by inject<PhotoAdapter>()

    override fun initView() {
        baseSubscribe(viewModel)
        initAdapter()

        viewModel.photoLiveData.observe(viewLifecycleOwner, { list ->
            photoAdapter.submitList(list)
        })
    }

    private fun initAdapter() {
        list_photo.adapter = photoAdapter

        photoAdapter.onDeleteClickListener = { photo ->
            viewModel.deletePhoto(photo)
        }

        photoAdapter.onAddClickListener = {
            viewModel.navigateToActionChoiceDialog()
        }

//        photoAdapter.onClickListener = {
//
//        }

        photoAdapter.onBindListener = {
            viewModel.navigationToGalleryPhotoDetailsFragment()
        }
    }
}
