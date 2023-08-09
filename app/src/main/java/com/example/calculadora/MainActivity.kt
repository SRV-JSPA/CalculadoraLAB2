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
            '^' -> a*a
            else -> throw IllegalArgumentException("El operador/signo no es válido ")
        }

        var num1:Button = findViewById(R.id.num1)
        var num2:Button = findViewById(R.id.num2)
        var num3:Button = findViewById(R.id.num3)
        var num4:Button = findViewById(R.id.num4)
        var num5:Button = findViewById(R.id.num5)
        var num6:Button = findViewById(R.id.num6)
        var num7:Button = findViewById(R.id.num7)
        var num8:Button = findViewById(R.id.num8)
        var num9:Button = findViewById(R.id.num9)
        var suma:Button = findViewById(R.id.suma)
        var num0:Button = findViewById(R.id.num0)
        var resta:Button = findViewById(R.id.resta)
        var multiplicacion:Button = findViewById(R.id.multiplicacion)
        var division:Button = findViewById(R.id.division)
        var modulo:Button = findViewById(R.id.modulo)
        var potencia:Button = findViewById(R.id.potencia)
        var limpiar:Button = findViewById(R.id.limpiar)
        var back:Button = findViewById(R.id.back)
        var parentesisA:Button = findViewById(R.id.parentesisA)
        var parentesisB:Button = findViewById(R.id.parentesisB)
        var ans:Button = findViewById(R.id.ans)
        var igual:Button = findViewById(R.id.igual)


        num1.setOnClickListener(){
            calcular(num1)
        }

    }
}
