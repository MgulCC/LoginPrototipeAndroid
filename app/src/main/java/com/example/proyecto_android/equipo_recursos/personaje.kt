package com.example.proyecto_android.equipo_recursos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class personaje(var nombre: String, var raza: String, var clase: String, var descripcion: String, var imagen: Int) : Parcelable
//este es el constructor de el objeto personaje