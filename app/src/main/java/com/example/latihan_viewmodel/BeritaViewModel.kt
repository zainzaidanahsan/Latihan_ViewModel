package com.example.latihan_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeritaViewModel:ViewModel() {
    val berita = arrayListOf(
     ListBerita("BERITA TERKINI Putri Candrawathi Ikut Tembak Brigadir J, Ditanggapi soal Temuan Komnas HAM", "Tribun-Medan", R.drawable.sambo),
     ListBerita("Berita Persib Bandung: Kondisi Terkini Erwin Ramdani Usai Naik Meja Operasi", "Tempo-Sport", R.drawable.erwin),
     ListBerita("Rupiah Berpeluang Menguat di Rentang Rp14.820 - Rp14.860 per Dolar AS", "Tempo", R.drawable.rupiah)
 )

    val beritaList :MutableLiveData<List<ListBerita>> = MutableLiveData()

    fun getBerita(){
        var berita= berita
        beritaList.value = berita
}

}