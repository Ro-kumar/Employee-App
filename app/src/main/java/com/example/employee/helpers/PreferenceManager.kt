/*
 * *
 *  * Created by Prady on 30/09/22, 3:37 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 30/09/22, 3:36 PM
 *
 */
package com.example.employee.helpers

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager private constructor(context: Context) {
    var sharedPreferences: SharedPreferences
    var context: Context
    var editor: SharedPreferences.Editor
    fun clear() {
        editor.clear().commit()
    }

    fun logout() {
        editor.clear()
        editor.apply()
        editor.commit()
    }

    var userid: String?
        get() = sharedPreferences.getString("userid", "")
        set(userid) {
            editor.putString("userid", userid)
            editor.commit()
        }
    var userType: String?
        get() = sharedPreferences.getString("userType", "")
        set(userType) {
            editor.putString("userType", userType)
            editor.commit()
        }

    fun getmobilno(): String? {
        return sharedPreferences.getString("mobile", "0")
    }

    fun setMobileno(mobile: String?) {
        editor.putString("mobile", mobile)
        editor.commit()
    }

    var userName: String?
        get() = sharedPreferences.getString("username", "")
        set(userName) {
            editor.putString("username", userName)
            editor.commit()
        }
    var userImg: String?
        get() = sharedPreferences.getString("UserImg", "")
        set(userName) {
            editor.putString("UserImg", userName)
            editor.commit()
        }
    var companyImg: String?
        get() = sharedPreferences.getString("CompanyImg", "")
        set(userName) {
            editor.putString("CompanyImg", userName)
            editor.commit()
        }
    var city: String?
        get() = sharedPreferences.getString("city", "")
        set(city) {
            editor.putString("city", city)
            editor.commit()
        }
    var firebaseVerifyId: String?
        get() = sharedPreferences.getString("FirebaseverifyId", "")
        set(userType) {
            editor.putString("FirebaseverifyId", userType)
            editor.commit()
        }
    var latitude: String?
        get() = sharedPreferences.getString("latitude", "")
        set(userType) {
            editor.putString("latitude", userType)
            editor.commit()
        }
    var longitude: String?
        get() = sharedPreferences.getString("longitude", "")
        set(userType) {
            editor.putString("longitude", userType)
            editor.commit()
        }
    var gpsAddress: String?
        get() = sharedPreferences.getString("gpsAddress", "")
        set(userType) {
            editor.putString("gpsAddress", userType)
            editor.commit()
        }
    var email: String?
        get() = sharedPreferences.getString("email", "")
        set(email) {
            editor.putString("email", email)
            editor.commit()
        }
    var landmark: String?
        get() = sharedPreferences.getString("Landmark", "")
        set(setLandmark) {
            editor.putString("Landmark", setLandmark)
            editor.commit()
        }
    var address: String?
        get() = sharedPreferences.getString("Address", "")
        set(setAddress) {
            editor.putString("Address", setAddress)
            editor.commit()
        }
    var pincode: String?
        get() = sharedPreferences.getString("Pincode", "")
        set(setPincode) {
            editor.putString("Pincode", setPincode)
            editor.commit()
        }
    var state: String?
        get() = sharedPreferences.getString("State", "")
        set(State) {
            editor.putString("Pincode", State)
            editor.commit()
        }
    var token: String?
        get() = sharedPreferences.getString("Token", "")
        set(Token) {
            editor.putString("Token", Token)
            editor.commit()
        }
    var tempToken: String?
        get() = sharedPreferences.getString("TempToken", "")
        set(Token) {
            editor.putString("TempToken", Token)
            editor.commit()
        }
    var loggedIn: String?
        get() = sharedPreferences.getString("LoggedIn", "")
        set(Token) {
            editor.putString("LoggedIn", Token)
            editor.commit()
        }
    var otp: String?
        get() = sharedPreferences.getString("otp", "")
        set(Token) {
            editor.putString("otp", Token)
            editor.commit()
        }
    var orderId: String?
        get() = sharedPreferences.getString("OrderId", "")
        set(Token) {
            editor.putString("OrderId", Token)
            editor.commit()
        }
    var upiId: String?
        get() = sharedPreferences.getString("UpiId", "")
        set(Token) {
            editor.putString("UpiId", Token)
            editor.commit()
        }
    var merchantCode: String?
        get() = sharedPreferences.getString("MerchantCode", "")
        set(Token) {
            editor.putString("MerchantCode", Token)
            editor.commit()
        }
    var appName: String?
        get() = sharedPreferences.getString("AppName", "")
        set(Token) {
            editor.putString("AppName", Token)
            editor.commit()
        }
    var appLogo: String?
        get() = sharedPreferences.getString("AppLogo", "")
        set(Token) {
            editor.putString("AppLogo", Token)
            editor.commit()
        }
    var referCode: String?
        get() = sharedPreferences.getString("ReferCode", "")
        set(Token) {
            editor.putString("ReferCode", Token)
            editor.commit()
        }
    var appDownloadLink: String?
        get() = sharedPreferences.getString("DownloadLink", "")
        set(Token) {
            editor.putString("DownloadLink", Token)
            editor.commit()
        }

    companion object {
        @JvmStatic
        lateinit var instance: PreferenceManager
            private set

        fun init(context: Context) {
            instance = PreferenceManager(context)
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("tituservice", Context.MODE_PRIVATE)
        this.context = context
        editor = sharedPreferences.edit()
    }
}