/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 5:11 PM
 *
 */

package com.example.employee.data.remote

import java.io.IOException

/* It's a Kotlin class that extends the IOException class and takes a message as a parameter */
class ApiException(message: String) : IOException(message)

/* NoInternetException is a class that extends IOException and takes a String as a parameter. */
class NoInternetException(message: String) : IOException(message)