package com.example.listas.adapted

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listas.Film
import com.example.listas.databinding.ItemFilmBinding

class FilmViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding= ItemFilmBinding.bind(view)
    fun render(filmodel:Film)
    {
        binding.FilmName.text= filmodel.title
        binding.FilmDirector.text=filmodel.director
        binding.FimYear.text=filmodel.year.toString()
        Glide.with(binding.FilmPhoto.context).load(filmodel.photo).into(binding.FilmPhoto)
    }
}