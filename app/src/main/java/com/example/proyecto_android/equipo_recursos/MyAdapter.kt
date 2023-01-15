package com.example.proyecto_android.equipo_recursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_android.databinding.HolderItemBinding


class MyAdapter (val listado :MutableList<personaje>) : RecyclerView.Adapter<MyAdapter.HojadePersonaje>() {
        //declarar la clase hoja de personaje para las celdas del listado
        inner class HojadePersonaje(val binding: HolderItemBinding) :
                RecyclerView.ViewHolder(binding.root) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HojadePersonaje {
                val dibujante = LayoutInflater.from(parent.context)
                val vista = HolderItemBinding.inflate(dibujante, parent, false)
                val celda = HojadePersonaje(vista)
                return celda
        }

        //esta funcion se encarga de introducir los diferentes atributos de los objetos en los textview
        override fun onBindViewHolder(celdaActual: HojadePersonaje, position: Int) {
                val jugador = listado[position]

                celdaActual.binding.nombreid.text = jugador.nombre
                celdaActual.binding.razaid.text = jugador.raza
                celdaActual.binding.claseid.text = jugador.clase
                celdaActual.binding.descripcionid.text = jugador.descripcion
                celdaActual.binding.fotico.setBackgroundResource(jugador.imagen)



        }


        //Funcion que que nos devuelve la cantidad de obejetos de la coleccion
        override fun getItemCount(): Int {
                return listado.size
        }






}




