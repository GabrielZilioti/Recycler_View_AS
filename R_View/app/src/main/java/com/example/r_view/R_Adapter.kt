package com.example.r_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class R_Adapter (private val lista: List<R_Item>) : RecyclerView.Adapter<R_Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imagem:ImageView = itemView.findViewById(R.id.imagem)
        val titulo:TextView = itemView.findViewById(R.id.titulo)
        val data:TextView = itemView.findViewById(R.id.data)
        val posicao:TextView = itemView.findViewById(R.id.posicao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = lista[position]
        holder.imagem.setImageResource(currentItem.imagem)
        holder.titulo.text = currentItem.titulo
        holder.data.text = currentItem.data
        holder.posicao.text = "${position + 1}"
    }

    override fun getItemCount() = lista.size
}