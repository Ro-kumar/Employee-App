/*
 * *
 *  * Created by Prady on 09/09/22, 12:05 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 09/09/22, 12:05 PM
 *
 */
package com.example.employee.helpers

import com.example.employee.helpers.PreferenceManager.Companion.init
import android.app.Application
import com.example.employee.data.remote.MyApi
import com.example.employee.data.remote.NetworkConnectionInterceptors
import com.app.liquid.gold.repositories.SharedRepo
import com.app.liquid.gold.factories.SharedVMF
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppController : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppController))
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { NetworkConnectionInterceptors(instance()) }

        bind() from singleton { SharedRepo(instance()) }
        bind() from provider { SharedVMF(instance()) }


    }

    override fun onCreate() {
        super.onCreate()
        context = this
        init(this)
    }

    companion object {
        var context: AppController? = null
            private set
    }
}