package com.ionc.apps.cursos.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    //XII - Creamos las variables que van a pintar los valores en la UI
    var kCiudad:TextView? = null
    var kGrados:TextView? = null
    var kEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //XIII - Hacer el bind de las variables con los valores de la UI
        kCiudad = findViewById(R.id.uiCiudad)
        kGrados = findViewById(R.id.uiGrados)
        kEstatus = findViewById(R.id.uiEstatus)

        //5 - Crear variable para cachar el nuevo valor del TAG
        val ciudad = intent.getStringExtra("com.ionc.apps.cursos.appclima.ciudades.CIUDAD")

        //W2 - Validamos que tengamos internet - el siguiente paso es importar Volley en Gradle
        if (Network.hayRed(this)){
            //ejecutar solicitud HTTP
            //KEY de la api: 0aae85ba75e48aad247e870d4ea09fe8
            //codigo ID ciudad zapopan: 3979770
            //W4 - Probar que la API conteste
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=0aae85ba75e48aad247e870d4ea09fe8&units=metric&lang=es")

        }else{
            //mensaje de error
            Toast.makeText(this, "asegurate de tener internet", Toast.LENGTH_LONG).show()
        }

        //6 - Pintar el nuevo valor en un Toast para ver si no hay problemas
        //Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        // X - Empatar los valores de la interfaz con las de la clase Ciudad

        //val ciudadguanatos = Ciudad("Zapopan", 33, "nos estamos quemando")
        //val ciudadcdmx = Ciudad("Tacubaya", 28, "todavia aguantan")

        // XI - Creamos el if para dependiendo de la ciudad seleccionada cambie a sus datos de Ciudad
        when (ciudad) {
            "ciudad-guanatos" -> {
                //Cuando la ciudad es Guanatos

                //XIII - Hacemos que jale el if con los datos de la condicional de Guanatos
                //kCiudad?.text = ciudadguanatos.nombre
                //kGrados?.text = ciudadguanatos.grados.toString() + "º"
                //kEstatus?.text = ciudadguanatos.estatus

            }
            "ciudad-cdmx" -> {
                //Cuando la ciudad es CDMX

                //XIII - Hacemos que jale el if con los datos de la condicional de CDMX
                //kCiudad?.text = ciudadcdmx.nombre
                //kGrados?.text = ciudadcdmx.grados.toString() + "º"
                //kEstatus?.text = ciudadcdmx.estatus

            }
            else -> {
                Toast.makeText(this, "Nada que mostrar", Toast.LENGTH_SHORT).show()
            }


        }

    }

    //W3 - Metodo para Volley
    private fun solicitudHTTPVolley(url:String){
        val pila = Volley.newRequestQueue(this)


        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener <String>{
                response ->
            try {
                Log.d("solicitudHTTPVolley", response)

                //W6 - Hacemos que la magia de GSON actue el parseo
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                //W6.1 - Puedes ejecutar el debug y probar si va todo ok con esta instruccion
                //Log.d("GSON", ciudad.name)

                //W7 - Hacemos el mapeo ahora si
                kCiudad?.text = ciudad.name
                kGrados?.text = ciudad.main?.temp.toString() + "º"
                kEstatus?.text = ciudad.weather?.get(0)?.description

            }catch (e:Exception){

            }
        }, Response.ErrorListener {  })
        pila.add(solicitud)
    }

}