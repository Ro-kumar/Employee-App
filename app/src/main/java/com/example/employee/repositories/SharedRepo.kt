/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 5:13 PM
 *
 */

package com.app.liquid.gold.repositories

import android.util.Log
import com.example.employee.Model.EmptyRequest
import com.example.employee.data.remote.MyApi
import com.example.employee.data.remote.SafeApiRequest
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class SharedRepo (
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun employeeList(request: EmptyRequest): String {
        var response = String()
        try {
            val jsonObject = Gson().toJson(request, EmptyRequest::class.java)
            val body = jsonObject.toString()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
            response = apiRequest { api.getEmployeeList() }
        } catch (e: Exception) {
            e.printStackTrace()

            Log.e("dfj",e.toString())
        }
        return response
    }


}