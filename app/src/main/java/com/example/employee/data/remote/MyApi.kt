/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 5:13 PM
 *
 */

package com.example.employee.data.remote

import com.example.employee.helpers.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


public interface MyApi {
    @GET("getEmployeeList.php")
    suspend fun getEmployeeList(
    ): Response<String>




    /* Creating a singleton object of MyApi. */
    companion object {
        /**
         * It creates a Retrofit instance.
         * @param networkConnectionInterceptors This is the interceptor that we created in the previous
         * @return Retrofit.Builder()
         */
        operator fun invoke(
            networkConnectionInterceptors: NetworkConnectionInterceptors
        ): MyApi {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptors)
                .addInterceptor(interceptor)
                .build()
            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}