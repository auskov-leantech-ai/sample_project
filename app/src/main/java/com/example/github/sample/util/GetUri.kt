package com.example.github.sample.util

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import com.example.github.sample.BuildConfig
import java.io.File

fun getURIFile(context: Context): Uri {
    val fileDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    val file = File.createTempFile(Variables.PREFIX_PHOTO, Variables.MIMI_TYPE_JPG, fileDir)

    return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file)
}


