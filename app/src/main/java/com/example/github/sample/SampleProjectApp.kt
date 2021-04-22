package com.example.github.sample

import android.app.Application
import com.example.github.sample.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleProjectApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            this.modules(
                listOf(
                    dataModule,
                    repositoryModule,
                    viewModelModule,
                    mapperModule,
                    adapterModule,
                    databaseModule
                )
            )
            this.androidContext(this@SampleProjectApp)
        }
    }
}
