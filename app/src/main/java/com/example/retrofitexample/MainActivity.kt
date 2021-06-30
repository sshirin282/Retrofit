package com.example.retrofitexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    val BASE_URL= "https://jsonplaceholder.typicode.com/"
    lateinit var TextView:TextView
    var list:ArrayList<MyDatItem> = ArrayList<MyDatItem>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApiClass()
        TextView=findViewById(R.id.text1)
        recyclerView=findViewById(R.id.recycler)

    }
    private fun getApiClass() {
        val retrofitBuilder =Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(Apiinterface::class.java)

        val retrofitData =retrofitBuilder.getData()



        retrofitData.enqueue(object : Callback<List<MyDatItem>>{
            override fun onResponse(call: Call<List<MyDatItem>>?, response: Response<List<MyDatItem>>?) {

                val responseBody = response?.body()!!
                Log.e("response>>>>", response?.body().toString())
                list=ArrayList<MyDatItem>()

                val i:Int=0
                    val ja:JSONArray= JSONArray(response.body())
                    for (i in 0 until ja.length()){
                        val jb:JSONObject=ja.getJSONObject(i)
                    val userId:String=jb.getString("userId")
                        val id:String=jb.getString("userId")
                        val title:String=jb.getString("userId")
                        val body:String=jb.getString("userId")

                    val myDatItem=MyDatItem(userId,id, title, body)
//                        myDatItem.userId= userId
//                        myDatItem.id= id
//                        myDatItem.title=title
//                        myDatItem.body=body
//                        list.add(myDatItem)
                    }
                adapter=Adapter(this@MainActivity,list)
                val layoutManager= LinearLayoutManager(this@MainActivity)
                recyclerView.layoutManager=layoutManager
                recyclerView.adapter=adapter


//                val myStringBuilder= StringBuilder()
//                for(MyDatItem in responseBody){
////                    myStringBuilder.append(MyDatItem.userId)
////                   myStringBuilder.append("/n")
//                    Log.e("response>>>>", response?.body().toString())
//                    val i:Int=0
//                    val ja:JSONArray= JSONArray(response.body())
//                    for (i in 0 until ja.length())
//                        val jb:JSONObject=ja.getJSONObject(i)
//                    val userId:String=jb.getString("userId")
//
//                    val myDatItem=MyDatItem(userId = userId
////                    myDatItem.id= id
////                    myDatItem.title=title
////                    myDatItem.body= body
//                    )
//
//                }

               // TextView.text= myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDatItem>>?, t: Throwable?) {
              Log.d("MainActivity","onFailure: "+t?.message)
            }
        })





    }
}