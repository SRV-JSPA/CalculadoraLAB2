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
import android.widget.TextView
import android.widget.Button
import java.util.Stack


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.resultado)


        var num0: Button = findViewById(R.id.num0)
        var num1: Button = findViewById(R.id.num1)
        var num2: Button = findViewById(R.id.num2)
        var num3: Button = findViewById(R.id.num3)
        var num4: Button = findViewById(R.id.num4)
        var num5: Button = findViewById(R.id.num5)
        var num6: Button = findViewById(R.id.num6)
        var num7: Button = findViewById(R.id.num7)
        var num8: Button = findViewById(R.id.num8)
        var num9: Button = findViewById(R.id.num9)
        var suma: Button = findViewById(R.id.suma)
        var resta: Button = findViewById(R.id.resta)
        var multiplicacion: Button = findViewById(R.id.multiplicacion)
        var division: Button = findViewById(R.id.division)
        var modulo: Button = findViewById(R.id.modulo)
        var potencia: Button = findViewById(R.id.potencia)
        var parentesisA: Button = findViewById(R.id.parentesisA)
        var parentesisB: Button = findViewById(R.id.parentesisB)
        var igual: Button = findViewById(R.id.igual)
        num1.setOnClickListener() {
            calcular(num1)
        }
        num2.setOnClickListener() {
            calcular(num2)
        }
        num3.setOnClickListener() {
            calcular(num3)
        }
        num4.setOnClickListener() {
            calcular(num4)
        }
        num5.setOnClickListener() {
            calcular(num5)
        }
        num6.setOnClickListener() {
            calcular(num6)
        }
        num7.setOnClickListener() {
            calcular(num7)
        }
        num8.setOnClickListener() {
            calcular(num8)
        }
        num9.setOnClickListener() {
            calcular(num9)
        }
        suma.setOnClickListener() {
            calcular(suma)
        }
        num0.setOnClickListener() {
            calcular(num0)
        }
        resta.setOnClickListener() {
            calcular(resta)
        }
        multiplicacion.setOnClickListener() {
            calcular(multiplicacion)
        }
        division.setOnClickListener() {
            calcular(division)
        }
        modulo.setOnClickListener() {
            calcular(modulo)
        }
        potencia.setOnClickListener() {
            calcular(potencia)
        }
        parentesisA.setOnClickListener() {
            calcular(parentesisA)
        }
        parentesisB.setOnClickListener() {
            calcular(parentesisB)
        }
        igual.setOnClickListener() {

            var numero =  evaluar(textView.text as String)
            textView.text = "$numero"
        }






    }



    fun calcular(boton: Button){
        boton.setOnClickListener{
            var textView = findViewById<TextView>(R.id.resultado)
            var texto = boton.text.toString()
            var textoActual = textView.text.toString()
            var textoFinal = "$textoActual $texto"
            textView.text = textoFinal
        }



    }

    fun evaluar(str: String): Double {
        //Codigo basado en tareas pasadas de estructuras de datos y ChatGPT
        val expresion = str.split(" ").filter { it.isNotEmpty() }
        val numeros = Stack<Double>()
        val operadores = Stack<String>()

        val ordenOP = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2, "^" to 3)

        for (token in expresion) {
            if (token.toDoubleOrNull() != null) {
                numeros.push(token.toDouble())
            } else if (token == "(") {
                operadores.push(token)
            } else if (token == ")") {
                while (operadores.peek() != "(") {
                    val op = operadores.pop()
                    val num2 = numeros.pop()
                    val num1 = numeros.pop()
                    val resp = calculadora(op, num1, num2)
                    numeros.push(resp)
                }
                operadores.pop() // Pop "("
            } else {
                while (!operadores.isEmpty() && operadores.peek() != "(" && ordenOP.getValue(token) <= ordenOP.getValue(operadores.peek())) {
                    val op = operadores.pop()
                    val num2 = numeros.pop()
                    val num1 = numeros.pop()
                    val resp = calculadora(op, num1, num2)
                    numeros.push(resp)
                }
                operadores.push(token)
            }
        }

        while (!operadores.isEmpty()) {
            val op = operadores.pop()
            val num2 = numeros.pop()
            val num1 = numeros.pop()
            val resp = calculadora(op, num1, num2)
            numeros.push(resp)
        }

        return numeros.pop()
    }




        fun calculadora(operador: String, a: Double, b: Double ): Double {
            return when (operador) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> a / b
                "%" -> a % b
                "^" -> a * a
                else -> throw IllegalArgumentException("El operador/signo no es válido ")
            }


    }
}
