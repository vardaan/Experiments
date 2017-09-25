package com.myntra.android.saha

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SahaClient {
    companion object {
        private val BASE_URL = "http://localhost.com:8080"
        var sahaClient: SahaApi? = null
        fun getInstance(): SahaApi {
            if (sahaClient == null) {
                val client = OkHttpClient.Builder().build();
                val gson = Gson()
                val retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// execution mechanism
                        .addConverterFactory(GsonConverterFactory.create(gson))// how the objects will be converted
                        .client(client)// will make the underlying calls
                        .baseUrl(BASE_URL)// base url for our requests
                        .build()

                sahaClient = retrofit.create(SahaApi::class.java)
            }
            return sahaClient!!

        }

    }
}