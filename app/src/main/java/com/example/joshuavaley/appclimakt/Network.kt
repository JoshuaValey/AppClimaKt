package com.example.joshuavaley.appclimakt

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity

class Network {

    companion object {
        /**
         * Funcion para verificar coneción
         * @param activity
         * @see connectivityManager: Administra temas de red
         * @see networkInfo: almacena el estado de la red.
         * @return devuelve un boolean que verifica si hay o no red disponible.
         */
        fun hayRed(activity: AppCompatActivity):Boolean{

            var connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo = connectivityManager.activeNetworkInfo

            return networkInfo != null && networkInfo.isConnected

        }
    }
}