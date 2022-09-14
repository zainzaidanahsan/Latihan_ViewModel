package com.example.latihan_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_isi_berita.*

class IsiBerita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_berita)
        getData()
    }
    fun getData(){
        val getBerita = intent.getSerializableExtra("dataBerita") as ListBerita
        toolbarIsiBerita.title = getBerita.sumber
        imgIsi.setImageResource(getBerita.img)
        judulIsiBerita.text = getBerita.judul
    }
}