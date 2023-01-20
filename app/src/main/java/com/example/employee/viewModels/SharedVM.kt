/*
 * *
 *  * Created by Prady on 09/09/22, 12:27 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 09/09/22, 12:13 PM
 *
 */

package com.example.employee.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.liquid.gold.repositories.SharedRepo
import com.example.employee.Model.EmptyRequest
import com.example.employee.helpers.Coroutines

class SharedVM(private val repository: SharedRepo) : ViewModel() {

    var latitude: MutableLiveData<Double> = MutableLiveData()
    var logitude: MutableLiveData<Double> = MutableLiveData()
    var fullAddress: MutableLiveData<String> = MutableLiveData()
    val error: MutableLiveData<Error> = MutableLiveData()

    init {
        error.value = Error()
    }

//    fun setLatitude(latitude: Double) {
//        this.latitude.postValue(latitude)
//    }
//
//    fun setLongitude(longitude: Double) {
//        logitude.postValue(longitude)
//    }
//
//    fun setFullAddress(fullAddress: String) {
//        this.fullAddress.postValue(fullAddress)
//    }
//
//    var appVerCheck = MutableLiveData<String>()
//    fun verifyAppVer(request: EmptyRequest) {
//        Coroutines.io {
//            appVerCheck.postValue(repository.checkAppVersion(request))
//        }
//    }
//
//
//    var getBearerToken = MutableLiveData<String>()
//    fun getBearerToken(request: BearRequest) {
//        Coroutines.io {
//            getBearerToken.postValue(repository.getBearerToken(request))
//        }
//    }
//
    var employeeList = MutableLiveData<String>()
    fun employeeList(request: EmptyRequest) {
        Coroutines.io {
            employeeList.postValue(repository.employeeList(request))
        }
    }
//
//    var banner = MutableLiveData<String>()
//    fun banner(request: EmptyRequest) {
//        Coroutines.io {
//            banner.postValue(repository.banner(request))
//        }
//    }
//
//    var subcat = MutableLiveData<String>()
//    fun subcat(request: SubcategoryRequest) {
//        Coroutines.io {
//            subcat.postValue(repository.subcat(request))
//        }
//    }
//
//    var productlist = MutableLiveData<String>()
//    fun productlist(request: ProductListRequest) {
//        Coroutines.io {
//            productlist.postValue(repository.getProdcutlist(request))
//        }
//    }
//
//    var treanidng = MutableLiveData<String>()
//    fun treanidng(request: ProductListRequest) {
//        Coroutines.io {
//            treanidng.postValue(repository.getProdcutlist(request))
//        }
//    }
//
//    var bestseller = MutableLiveData<String>()
//    fun bestseller(request: ProductListRequest) {
//        Coroutines.io {
//            bestseller.postValue(repository.getProdcutlist(request))
//        }
//    }
//
//
//    var prdoctditails = MutableLiveData<String>()
//    fun prdoctditails(request: ProductDetailsRequest) {
//        Coroutines.io {
//            prdoctditails.postValue(repository.getProductDetails(request))
//        }
//    }


    data class Error(var error: String? = null)
}