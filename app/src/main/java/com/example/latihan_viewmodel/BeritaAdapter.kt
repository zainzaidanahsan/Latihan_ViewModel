package com.example.latihan_viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter(var listBerita: ArrayList<ListBerita>): RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {
    var onClick : ((ListBerita) -> Unit)? = null
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var judulBerita = view.findViewById<TextView>(R.id.txtJudulBerita)
        var sumberBerita = view.findViewById<TextView>(R.id.sumberBerita)
        var img = view.findViewById<ImageView>(R.id.imgBerita)
        var card = view.findViewById<CardView>(R.id.cardViewBerita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judulBerita.text = listBerita[position].judul
        holder.sumberBerita.text = listBerita[position].sumber
        holder.img.setImageResource(listBerita[position].img)
        holder.card.setOnClickListener{
            onClick?.invoke(listBerita[position])
        }
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }
    fun setData(daftarBerita: ArrayList<ListBerita>){
        this.listBerita = daftarBerita
    }
}