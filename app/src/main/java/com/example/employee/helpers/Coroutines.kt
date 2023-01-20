/*
 * *
 *  * Created by Prady on 02/09/22, 6:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 02/09/22, 5:11 PM
 *
 */

package com.example.employee.helpers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {

    /**
     * "It takes a lambda that takes no arguments and returns nothing, and it runs that lambda on the
     * main thread."
     *
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @param work suspend (() -> Unit)
     */
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    /**
     * "This function takes a lambda that takes no arguments and returns nothing, and runs it in a
     * coroutine on the IO thread."
     *
     * The function is called io, and it takes a lambda that takes no arguments and returns nothing.
     * The lambda is called work. The function runs the lambda in a coroutine on the IO thread
     *
     * @param work suspend (() -> Unit)
     */
    fun io(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
}