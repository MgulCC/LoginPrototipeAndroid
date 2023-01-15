package com.example.proyecto_android

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigator
import com.example.proyecto_android.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding
    private lateinit var preferences: SharedPreferences //sirve


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.appBarSecond.toolbar)

        preferences = getSharedPreferences("mispreferencias", MODE_PRIVATE) // Inicializa y guarda en mispreferencias
        val usuario = preferences.getString("usuario", "Invitado").toString()



        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.fragmentContainerView)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.teamFragment,
                R.id.galleryFragment,
                R.id.contactFragment
            ), drawerLayout

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val year = setDate()


        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.nombreusuario).text = usuario
        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.fechadehoy).text = year

    }

    private fun setDate(): String {

        val fechaHoy = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        val textoFecha = sdf.format(fechaHoy.time)

        return textoFecha

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.mi_toolbar, menu)
        return true
    }

    // La función sirve de evento al pulsar un item del toolbar superior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exitapp) {

            // Alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setMessage("¿Seguro que quieres salir?")
            builder.setPositiveButton("Si") { dialog, i ->

                // Enviar a login (main activity)
                startActivity(Intent(this, MainActivity::class.java))

                // Finish
                finish()
            }
            builder.setNegativeButton("No", null)
            val dialog = builder.create()
            dialog.show()

        }
        return super.onOptionsItemSelected(item)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}