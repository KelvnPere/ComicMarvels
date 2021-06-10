package com.example.comicmarvels.utils

import android.content.Context
import android.net.ConnectivityManager
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class Constant {

    companion object {
        const val BASE_URL = "http://gateway.marvel.com/v1/public/"
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "9835469d6261806a6daa6fd11da16077"
        const val PRIVATE_KEY = "d0f1ecc8b5f24d8b3c9118baa2e997a3cd6af190"
        const val limit = "100"


        fun hash(): String {
            val input = "$ts$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting
        }
    }


}