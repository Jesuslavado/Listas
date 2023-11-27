package com.example.listadoparques

import android.content.Intent
import android.icu.text.IDNA.Info
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.listas.EditarPelis
import com.example.listas.MainActivity
import com.example.listas.R
import androidx.appcompat.app.AlertDialog


open class ActivityWhitMenus: AppCompatActivity() {
    companion object {
        var actividadActual =0;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Relacionamos la clase con el layout del menú que hemos creado:
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        //Desactivar la opción de la actividad en la que ya estamos:
        for (i in 0 until   menu.size()) {
            if (i== actividadActual) menu.getItem(i).isEnabled =false
            else menu.getItem(i).isEnabled= true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.peliculas ->  {
                actividadActual = 0
                //Hacemos que se abra la pantalla del listado de parques:
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)

                true
            }

            R.id.aplicacion -> {
                actividadActual= 1
                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, Info::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            R.id.editar -> {
                actividadActual= 1
                //Hacemos que se abra la pantalla del formulario para añadir parques:
                val intent = Intent(this, EditarPelis::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }
            R.id.lupa ->{
                actividadActual = 3;
                true
            }
            R.id.salir ->{
                actividadActual = 4;
                //Hacemos que al seleccionar exit, nos muestre un mensaje de si quermos salir de la app o no
                var miDialogo = AlertDialog.Builder(this)
                AlertDialog.Builder(this)
                    .setTitle("Salir")
                    .setMessage("¿Desea Salir de la Aplicacion?")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        finish()
                    })
                    .setNegativeButton(android.R.string.cancel,  { dialog, which ->
                    })
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}