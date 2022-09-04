package com.ionc.apps.cursos.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ciudades : AppCompatActivity() {

    //3 - Crear una constante para que lo cache el TAG
    val TAG = "com.ionc.apps.cursos.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        //1 - Empatar la variable de Kotlin con el id del elemento de la interfaz
        val bindGuanatos = findViewById<Button>(R.id.bGuanatos)
        val bindCdmx = findViewById<Button>(R.id.bCdmx)

        //2 - Crear los listeners de los botones para los intents
        bindGuanatos.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            //4 - Vamos a pasarle el valor deseado al TAG
            intent.putExtra(TAG, "3979770")
            startActivity(intent)
        } )

        bindCdmx.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "3530597")
            startActivity(intent)
        } )

    }
}