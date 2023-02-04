package com.example.data.dependency_injection

import retrofit2.Retrofit

class RetrofitManager(private val retrofit: Retrofit) {

    fun getRetrofit(): Retrofit = retrofit

    inline fun <reified T> getApiServices(serviceClass: Class<T>): T {
        return getRetrofit().create(serviceClass)
    }
}