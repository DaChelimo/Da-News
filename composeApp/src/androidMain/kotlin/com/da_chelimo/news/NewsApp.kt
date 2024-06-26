package com.da_chelimo.news

import android.app.Application
import di.initKoin

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

}