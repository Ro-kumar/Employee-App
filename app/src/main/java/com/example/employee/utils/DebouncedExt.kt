/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 3:47 PM
 *
 */

package com.example.employee.utils

import android.view.View

inline fun View.onDebouncedListener(
    delayInClick: Long = 5000L,
    crossinline listener: (View) -> Unit
) {
    val enableAgain = Runnable { isEnabled = true }

    setOnClickListener {
        if (isEnabled) {
            isEnabled = false
            postDelayed(enableAgain, delayInClick)
            listener(it)
        }
    }
}