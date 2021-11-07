package com.jaxadev.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: ArrayList<Order> = ArrayList()

        OrderApi.orderService.getOrders().enqueue(object : Callback<ArrayList<Order>> {
            override fun onResponse(
                call: Call<ArrayList<Order>>,
                response: Response<ArrayList<Order>>
            ) {

                response.body()?.let { result.addAll(it) }

                Log.d("OrderlarKeldi", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<ArrayList<Order>>, t: Throwable) {
                Log.d("FailureBo'ldi", "onFailure: $t")
            }

        })

    }
}