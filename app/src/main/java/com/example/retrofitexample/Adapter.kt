package com.example.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val list:List<MyDatItem>)
    : RecyclerView.Adapter<Adapter.ViewHolder>(){
    private val inflater:LayoutInflater=
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val textView1:TextView=view.findViewById(R.id.text1)
        val textView2:TextView=view.findViewById(R.id.text2)
        val textView3:TextView=view.findViewById(R.id.text3)
        val textView4:TextView=view.findViewById(R.id.text4)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val rowList=inflater.inflate(R.layout.list,parent,false)
        return ViewHolder(rowList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//       holder.textView1.text=list.get(position).userId
//        holder.textView2.text=list.get(position).id
        holder.textView3.text=list.get(position).title
        holder.textView4.text=list.get(position).body
    }

    override fun getItemCount(): Int {
      return list.size
    }
}