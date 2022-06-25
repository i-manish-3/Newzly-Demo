package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val songs:List<Model>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = songs[position].title
        holder.txtDesc.text = songs[position].desc
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val txtDesc = itemView.findViewById<TextView>(R.id.txtDesc)
    }
}

