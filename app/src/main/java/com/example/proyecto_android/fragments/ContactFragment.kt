package com.example.proyecto_android.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.proyecto_android.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.botondireccion.setOnClickListener{
            val y = "38.09422181576634"
            val x = "-3.631258604754885"
            val myUri = Uri.parse("$y,$x(Escuela Estech)")
            val intent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(intent)


        }

        binding.botoncorreo.setOnClickListener{
            val addresses = arrayOf("info@escuelaestech.es", "secretaria@escuelaestech.es")
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, addresses)

            }
            startActivity(intent)

        }

        binding.botontelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("tel:953636000")
            startActivity(intent)

        }

        binding.botonwhats.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val mobileNumber = "697246008"
            val message = "holaaa"
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone="+"+34"+ mobileNumber + "&text="+ message)
            startActivity(intent)

        }

        binding.enviarboton.setOnClickListener {
            val nombre = binding.nombretexto.text
            val correo = binding.correotexto.text
            val telefono = binding.telefonotexto.text.toString()
            val comentario = binding.comentariotexto.text

            if(nombre!!.isEmpty()){
                binding.nombrebox.setError("Introduce nombre")

            }else if(correo!!.isEmpty()){
                binding.correobox.setError("Introduce correo")

            }else if(telefono.isEmpty()){
                binding.correobox.setError("Introduce teléfono")

            }else if(comentario!!.isEmpty()){
                binding.comentariobox.setError("escribe un comentario")

            }else{

                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("¿estas seguro de enviar estos datos?")
                builder.setPositiveButton("Si") { dialog, i ->

                    val addresses = arrayOf("info@escuelaestech.es", "secretaria@escuelaestech.es")
                    val subject = "¿que quieres saber?"
                    val text = "hola, soy $nombre, este es mi teléfono $telefono y mi correo es $correo, me gustaria decirles: $comentario"

                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:")
                        putExtra(Intent.EXTRA_EMAIL, addresses)
                        putExtra(Intent.EXTRA_SUBJECT, subject)
                        putExtra(Intent.EXTRA_TEXT, text)
                    }
                    startActivity(intent)
                }
                builder.setNegativeButton("No", null)
                val dialog = builder.create()
                dialog.show()

            }
        }
    }
}