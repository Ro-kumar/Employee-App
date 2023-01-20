/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 5:13 PM
 *
 */

package com.example.employee.helpers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}