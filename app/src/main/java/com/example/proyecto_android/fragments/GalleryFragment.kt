package com.example.proyecto_android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.proyecto_android.databinding.FragmentGalleryBinding
import com.example.proyecto_android.galeria_recursos.Adaptergaleria
import com.example.proyecto_android.galeria_recursos.escenasypaisajes


class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagen1 = escenasypaisajes(
            "https://static1.thegamerimages.com/wordpress/wp-content/uploads/2020/06/ReturnToIcewindDale20Years.jpg?q=50&fit=contain&w=750&h=395&dpr=1.5",
            "Lago Maer Dualdon a la sombra del pico kelvin"
        )
        val imagen2 = escenasypaisajes("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/87214b7c-2c49-44b5-b76f-bafd704e538e/dquixw-9678aad0-5df2-4c3a-b77a-1b1c96d5f509.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzg3MjE0YjdjLTJjNDktNDRiNS1iNzZmLWJhZmQ3MDRlNTM4ZVwvZHF1aXh3LTk2NzhhYWQwLTVkZjItNGMzYS1iNzdhLTFiMWM5NmQ1ZjUwOS5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.BJRkvBWQKhBngJTPpyPF9IsvFFlM8Uwri95Km3l1oUw",
            "Pueblo de Kuldahar")
        val imagen3 = escenasypaisajes("https://www.mobygames.com/images/promo/original/1483923998-1901273652.jpg", "Ciudad de Targos")
        val imagen4 = escenasypaisajes(
            "https://images-geeknative-com.exactdn.com/wp-content/uploads/2020/09/17201205/DnDCelebration_Video_backgrounds-2.jpg?strip=all&lossy=1&ssl=1",
            "Aventureros en la nieve"
        )
        val ilustraciones = listOf(imagen1, imagen2, imagen3, imagen4)

        val adapter = Adaptergaleria(ilustraciones)
        binding.viewpager.adapter = adapter
    }
}