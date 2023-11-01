package com.example.sabersenior.CacaPalavra

import android.app.Application
import com.example.sabersenior.BuildConfig
import timber.log.Timber


class CacaPalavra : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree(){
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    //log in firebase
                }
            })
        }
    }
}