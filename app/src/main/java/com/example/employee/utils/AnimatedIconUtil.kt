/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.app.liquid.gold.utils

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.example.employee.utils.TAG

class AnimatedIconUtil {
    // Animated icons
    fun startIcon(imageView: ImageView?) {
        if (imageView == null) {
            return
        }
        startIcon(imageView.drawable)
    }

    fun startIcon(drawable: Drawable?) {
        if (drawable == null) {
            return
        }
        try {
            (drawable as Animatable).start()
        } catch (e: ClassCastException) {
            Log.e(TAG, "icon animation requires AnimVectorDrawable")
        }
    }

    fun resetAnimatedIcon(imageView: ImageView?) {
        if (imageView == null) {
            return
        }
        try {
            val animatable = imageView.drawable as Animatable
            animatable.stop()
            imageView.setImageDrawable(null)
            imageView.setImageDrawable(animatable as Drawable)
        } catch (e: ClassCastException) {
            Log.e(TAG, "resetting animated icon requires AnimVectorDrawable")
        }
    }
}