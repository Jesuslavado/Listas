package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapted.FilmAdapter
import com.example.listas.databinding.ActivityMainBinding
import androidx.core.widget.addTextChangedListener
import com.example.listadoparques.ActivityWhitMenus

class MainActivity :ActivityWhitMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val decoration= DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FilmProvider.filmList[2].title
        //binding.recicler.layoutManager=GridLayoutManager(this, 2) 2 columnas
        binding.recicler.layoutManager=LinearLayoutManager(this)
        binding.recicler.adapter=FilmAdapter(FilmProvider.filmList)
        //binding.recicler.addItemDecoration(decoration)

        var adapter = FilmAdapter(FilmProvider.filmList)
        binding.recicler.adapter=adapter
        binding.Filtro.addTextChangedListener {Filtro ->
            val filtroFilm = FilmProvider.filmList.filter { Film ->
                Film.title.lowercase().contains(Filtro.toString().lowercase()) }
            adapter.actualizarPelis(filtroFilm)
        }
    }
}