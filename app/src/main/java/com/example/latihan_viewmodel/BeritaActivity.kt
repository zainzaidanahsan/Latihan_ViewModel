package com.example.latihan_viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_berita.*
import kotlinx.android.synthetic.main.item_berita.*

class BeritaActivity : AppCompatActivity() {
    lateinit var rvBerita : RecyclerView
    lateinit var adapterBerita : BeritaAdapter
    lateinit var beritaVm : BeritaViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        toolbarBerita.setTitle("Berita Terkini")
        setDataBerita()
        beritaVm = ViewModelProvider(this).get(BeritaViewModel::class.java)
        beritaVm.getBerita()
        beritaVm.beritaList.observe(this, Observer {
            adapterBerita.setData(it as ArrayList<ListBerita>)
        })



    }

    fun setDataBerita(){
        rvBerita = findViewById(R.id.rvBerita)
        adapterBerita = BeritaAdapter(ArrayList())

        rvBerita.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        rvBerita.adapter =adapterBerita

        adapterBerita.onClick = {
            val intent = Intent(this, IsiBerita::class.java)
            intent.putExtra("dataBerita", it)
            startActivity(intent)
        }

    }
}