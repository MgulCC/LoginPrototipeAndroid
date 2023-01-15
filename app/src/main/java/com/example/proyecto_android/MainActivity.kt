package com.example.proyecto_android

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.proyecto_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        preferences = getSharedPreferences("mispreferencias", MODE_PRIVATE) // Inicializa y guarda en mispreferencias





        binding.botonlogin.setOnClickListener(){
            val usuario = binding.userbox.text.toString()
            val contrasenia = binding.passwordbox.text.toString()

            if(usuario.isEmpty()){
                binding.userbox.setError("Introduce usuario")

            }else if(contrasenia.isEmpty()){

                binding.passwordbox.setError("Introduce contraseña")
            }else{

                if((usuario == "aficionado" && contrasenia == "123456" ) or
                    (usuario == "jugador" && contrasenia == "qwerasdf" ) or
                    (usuario == "directivo" && contrasenia == "asdfasdf" ) ){
                    val intent = Intent(this, SecondActivity::class.java)
                    //intent.putExtra("inversion", contrasenia.text)
                    //spinnerCode.selectedItem.toString()
                    startActivity(intent)
                    finish()

                    val editor = preferences.edit()
                    editor.putString("usuario", usuario)
                    editor.apply()


                }else{
                    Toast.makeText(this, "no has introducido los datos correctos", Toast.LENGTH_SHORT).show()
                    //binding.userbox.setError("Usuario incorrecto")
                    //binding.passwordbox.setError("Contraseña incorrecta")
                }
            }

        }

        binding.botoninvitados.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            //intent.putExtra("user", textoUser)
            //intent.putExtra("inversion", textViewAmount.text)
            //spinnerCode.selectedItem.toString()
            startActivity(intent.putExtra("invitado", true))
            finish()
        }



    }


}