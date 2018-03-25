package com.example.giri.jsonparsinginkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview.layoutManager = LinearLayoutManager(this)
        val URL="https://api.androidhive.info/contacts/"
        val request = Request.Builder().url(URL).build()
        val Client= OkHttpClient()
        Client.newCall(request).enqueue(object:Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                  println("Error")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()

                val json = gson.fromJson(body, Json::class.java)
                runOnUiThread { recycleview.adapter=Adaptor(json) }
            }

        })
    }
    class Json(val contacts: List<Contacts>)

    class Contacts(val id: String, val name: String, val email: String, val address: String,
                val gender: String,val phone:Phone )
    class Phone(val mobile: String,val home:String,val office:String)
}
