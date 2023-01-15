package com.example.proyecto_android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_android.R
import com.example.proyecto_android.databinding.FragmentTeamBinding
import com.example.proyecto_android.equipo_recursos.MyAdapter
import com.example.proyecto_android.equipo_recursos.personaje

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //aqui habria que meter lo que hace las otra aplicaciones en en el create


        //creamos los diferentes objetos con sus propiedades apartir del constructor
        val jugador1 = personaje("Nombre: Sipha", "Raza: Humano", "Clase: clerigo","Origen: Anm", R.drawable.heroe1)
        val jugador2 = personaje("Nombre: Dorn", "Raza: Humano", "Clase: caballero", "Origen: Aguaprofunda", R.drawable.heroe2)
        val jugador3 = personaje("Nombre: Xzar", "Raza: Humano", "Clase: hechicero", "Origen: Thay", R.drawable.heroe3)
        val jugador4 = personaje("Nombre: Imoen", "Raza: Humano", "Clase: guerrero", "Origen: Luskan", R.drawable.heroe4 )
        val jugador5 = personaje("Nombre: Tobar", "Raza: Gnomo", "Clase: pícaro", "Origen: Lantan", R.drawable.heroe5)
        val jugador6 = personaje("Nombre: Drizzt", "Raza: Drow", "Clase: montaraz", "Origen: Menzoberranz", R.drawable.heroe6)
        val aventureros = mutableListOf(jugador1, jugador2, jugador3, jugador4, jugador5, jugador6)


        //introduzco el recyclerview que he llamado myrecycler en una variable
        val recyclerView = binding.myRecycler
        //le indico que haga una llamada de los datos en "este (this)" layout
        val llm = LinearLayoutManager(requireContext())
        //y que la llamada de datos sea en el recyclerview
        recyclerView.layoutManager = llm
        //traigo de myadapter la lista de personajes llamada aventureros
        val adapter = MyAdapter(aventureros)
        recyclerView.adapter = adapter







    }
}