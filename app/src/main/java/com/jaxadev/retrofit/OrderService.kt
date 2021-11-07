package com.jaxadev.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://10.10.10.55:8080"

interface OrderService {

    @GET("/getOrders")
    fun getOrders(): Call<ArrayList<Order>>

}

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object OrderApi {

    val orderService: OrderService by lazy { retrofit.create(OrderService::class.java) }

}

