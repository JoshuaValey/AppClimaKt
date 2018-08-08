package com.example.joshuavaley.appclimakt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
 //------------------ String "CLAVE" que sera mandado a la siguiente actividad ------------------------
    val TAG = "com.example.joshuavaley.appclimakt.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        //--------------------------- Declaracion de recursos ------------------
        var btnMexico = findViewById<Button>(R.id.btnCiudadMexico)
        var btnGuate = findViewById<Button>(R.id.btnCiudadGuatemala)
        var btnShanghai = findViewById<Button>(R.id.btnShangai)

        //--------------------------- OnClick btn Mexico ------------------
        btnMexico.setOnClickListener{ intentCiudad(TAG, "3530597")}

        //--------------------------- OnClick btn GT ------------------
        btnGuate.setOnClickListener{ intentCiudad(TAG, "3598132")}

        //--------------------------- OnClick btn Shanghai ------------------
        btnShanghai.setOnClickListener { intentCiudad(TAG, "1796236")/*<-- valor mandado a la otra actividad*/ }


    }

    fun intentCiudad(tag:String,idCiudad:String){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra(tag, idCiudad)// <-- valor mandado a la otra actividad
        startActivity(intent)
    }

}
