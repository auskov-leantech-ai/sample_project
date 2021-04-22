package com.example.github.sample.presentation.action_choice_dialog

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast
import com.example.github.sample.R
import com.example.github.sample.exstension.setOnDebouncedClickListener
import com.example.github.sample.presentation.base.BaseBottomSheetFragment
import com.example.github.sample.util.Variables
import com.example.github.sample.util.getURIFile
import kotlinx.android.synthetic.main.fragment_action_choice_dialog.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActionChoicePhotoDialog : BaseBottomSheetFragment() {
    override var layoutId: Int = R.layout.fragment_action_choice_dialog

    override val viewModel by viewModel<ActionChoicePhotoViewModel>()

    override fun getTheme(): Int = R.style.Theme_FullScreenDialog

    override fun initView() {

        text_view_cancellation.setOnDebouncedClickListener {
            viewModel.navigateToBack()
        }

        text_view_take_photo_dialog.setOnDebouncedClickListener {
            viewModel.cameraPhoto = getURIFile(requireContext())
            startActivityForResult(
                viewModel.takePhoto()
                    .putExtra(MediaStore.EXTRA_OUTPUT, viewModel.cameraPhoto),
                Variables.SELECT_CAMERA
            )
        }

        text_view_choose_photo_dialog.setOnDebouncedClickListener {
            startActivityForResult(viewModel.getPhotoFromGallery(), Variables.SELECT_PICTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Canceled", Toast.LENGTH_SHORT).show()
        } else if (requestCode == Variables.SELECT_PICTURE && data != null) {
            viewModel.insertPhoto(data.data)
            viewModel.navigateToBack()

        } else if (requestCode == Variables.SELECT_CAMERA) {
            viewModel.insertPhoto(viewModel.cameraPhoto)
            viewModel.navigateToBack()
        }
    }
}

