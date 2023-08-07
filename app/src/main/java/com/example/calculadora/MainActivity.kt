//Universidad del Valle de Guatemala
//Programación de Plataformas Móviles
//Profesor Moisés Alonso
//Sección 10
//Laboratorio #2
//Santiago Pereira 22318
//Rodrigo Marchena 22398
//Nancy Mazariegos 22513

package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var resultado:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado=findViewById(R.id.resultado)
    }
    fun calcular (view: View){
       var botton=view as Button
       var textobutton = botton.text.toString()
       var concatenar=resultado?.text.toString()+textobutton
        var imprimir = limpiarCeros(concatenar)
        if(textobutton == "="){
            var resp = 0.0

        } else if(textobutton == "C"){

        }
    }
    fun limpiarCeros (str: String ): String{
        var i = 0
        while(i<str.length && str[i]=='0')i++
        var bs = StringBuffer(str)
        bs.replace(0,i,"")
        return bs.toString()
    }

    fun evaluar (str: String):String?{
        return null
    }

    fun calculadora(a: Int, b: Int, operador: Char): Int {
        return when (operador) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            '%' -> a % b
            else -> throw IllegalArgumentException("El operador/signo no es válido ")
        }
    }
}
