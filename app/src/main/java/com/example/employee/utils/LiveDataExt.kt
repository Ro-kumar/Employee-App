/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.example.employee.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LiveDataExt {
    fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
        liveData.observe(this, Observer { it?.let { t -> action(t) } })
    }

    fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, action: (t: T) -> Unit) {
        liveData.observe(this, Observer { it?.let { t -> action(t) } })
    }
}

/* Usage : Old way to observe live data
viewModel.newProfilePicture.observe(this, Observer { string ->
    //Do something here
})

/*Observe live data with extension
observe(viewModel.newProfilePicture){ string ->
    //Do something here
}

/*Observe live data with extention + dedicated function
It will make code cleaner when you have long code to handle variable of live data
*/
observe(viewModel.newProfilePicture, ::showProfilePicture)

...

private fun showProfilePicture(url: String){
    //Do something here
}
*/