/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.example.employee.utils

import android.graphics.Color

class ColorConversionExt {
    fun String.hextoRGB(): Triple<String, String, String> {
        var name = this
        if (!name.startsWith("#")) {
            name = "#$this"
        }
        var color = Color.parseColor(name)
        var red = Color.red(color)
        var green = Color.green(color)
        var blue = Color.blue(color)

        return Triple(red.toString(), green.toString(), blue.toString())
    }

    fun Int.colorToHexString(): String? {
        var data = String.format("#%06X", -0x1 and this).replace("#FF", "#")
        return data
    }
}