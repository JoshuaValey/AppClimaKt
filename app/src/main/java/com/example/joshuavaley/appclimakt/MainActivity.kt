package com.example.joshuavaley.appclimakt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import android.content.Intent
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    var txtCiudad:TextView? = null
    var txtGrados:TextView? = null
    var txtEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //------------------- Init de Recursos -----------------

        txtCiudad = findViewById(R.id.txtCiudad)
        txtGrados = findViewById(R.id.txtGrados)
        txtEstatus = findViewById(R.id.txtEstatus)

        //----------------------- Recuperar dato del boton seleccionado ------------------
        val ciudad = intent.getStringExtra("com.example.joshuavaley.appclimakt.ciudades.CIUDAD")

        //---------------------------------- Validar Red --------------------
        if (Network.hayRed(this)) {
            //Solicitud HTTP
            solicitudHttpVolley("http://api.openweathermap.org/data/2.5/weather?id=${ciudad}&appid=179b7002084a8751be40ec2e4d4e5eb1&units=metric&lang=es")
            //API KEY: 179b7002084a8751be40ec2e4d4e5eb1
            // GT ID: 3598132
            // CDX ID: 3530597
        } else
            Toast.makeText(this, "NO HAY RED", Toast.LENGTH_SHORT).show()
    }

    private fun solicitudHttpVolley(url:String){

        var  queue = Volley.newRequestQueue(this)
        var solicitud = StringRequest(Request.Method.GET, url, Response.Listener {
            response ->
            try {
                Log.d("SolicitudHTTP", response)

                var gson = Gson()
                var ciudad =  gson.fromJson(response, Ciudad::class.java)
                txtCiudad?.text = ciudad.name
                txtGrados?.text = ciudad.main?.temp.toString()+"°"
                txtEstatus?.text = ciudad.weather?.get(0)?.description

            }catch (e:Exception){
                    Log.d("error solicitud", e.toString())
            }
        },Response.ErrorListener {Toast.makeText(this, "ERROR DE SOLICITUD", Toast.LENGTH_LONG).show()  })
        queue.add(solicitud)
    }



}
