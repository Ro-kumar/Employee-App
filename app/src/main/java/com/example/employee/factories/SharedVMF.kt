/*
 * *
 *  * Created by Prady on 09/09/22, 12:27 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 09/09/22, 12:13 PM
 *
 */

package com.app.liquid.gold.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.liquid.gold.repositories.SharedRepo
import com.example.employee.viewModels.SharedVM

@Suppress("UNCHECKED_CAST")

class SharedVMF(
    private val repository: SharedRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SharedVM(repository) as T
    }
}