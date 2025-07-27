package com.chat.verver.utils

import android.content.Context

fun isUserLoggedIn(context: Context): Boolean{
    val prefs=context.getSharedPreferences("verver_prefs", Context.MODE_PRIVATE)

    return prefs.getBoolean("is_logged_in",false)

}