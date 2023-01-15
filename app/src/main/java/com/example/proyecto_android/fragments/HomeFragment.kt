package com.example.proyecto_android.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.proyecto_android.R
import com.example.proyecto_android.databinding.FragmentGalleryBinding

import com.example.proyecto_android.databinding.FragmentHomeBinding
import com.example.proyecto_android.galeria_recursos.Adaptergaleria
import com.example.proyecto_android.galeria_recursos.escenasypaisajes


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var preferences: SharedPreferences //sirve


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        preferences = requireContext().getSharedPreferences("mispreferencias", AppCompatActivity.MODE_PRIVATE) // Inicializa y guarda en mispreferencias
        val usuario = preferences.getString("usuario", "Invitado").toString()
        binding.bienvenido.setText(usuario)

    }
}