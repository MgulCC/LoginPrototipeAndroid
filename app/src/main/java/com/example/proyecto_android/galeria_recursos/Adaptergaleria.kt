package com.example.proyecto_android.galeria_recursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto_android.R
import com.example.proyecto_android.databinding.HolderGalleryBinding



class Adaptergaleria(val ilustraciones: List<escenasypaisajes>) : RecyclerView.Adapter<Adaptergaleria.EstaCelda>() {

    inner class EstaCelda(val binding: HolderGalleryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstaCelda {
        val layoutinflater = LayoutInflater.from(parent.context)
        val binding = HolderGalleryBinding.inflate(layoutinflater, parent, false)
        val layoutCelda = EstaCelda(binding)
        return layoutCelda
    }

    override fun onBindViewHolder(holder: EstaCelda, position: Int) {
        val paisaje = ilustraciones[position]
        Glide.with(holder.itemView)
            .load(paisaje.imagen)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.binding.imageviewCelda2)

        holder.binding.textoimagen.text = paisaje.titulo
    }

    override fun getItemCount(): Int {
        return ilustraciones.size
    }
}