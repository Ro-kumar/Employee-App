/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.app.liquid.gold.utils

import android.view.View

class VisibiltyExt {
    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    fun View.toggleVisibility(): View {
        visibility = if (visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
        return this
    }
}