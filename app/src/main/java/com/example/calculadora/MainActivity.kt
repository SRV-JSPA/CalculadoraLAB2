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
import java.lang.Exception
import java.util.Stack


class MainActivity : AppCompatActivity() {
    var resultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado = findViewById(R.id.resultado)
    }

    fun calcular(view: View) {
        var botton = view as Button
        var textobutton = botton.text.toString()
        var concatenar = resultado?.text.toString() + textobutton
        var imprimir = limpiarCeros(concatenar)
        if (textobutton == "=") {
            var resp = 0.0

        } else if (textobutton == "C") {

        }
    }

    fun limpiarCeros(str: String): String {
        var i = 0
        while (i < str.length && str[i] == '0') i++
        var bs = StringBuffer(str)
        bs.replace(0, i, "")
        return bs.toString()
    }

    fun evaluar(str: String): Int {
        val operands = Stack<Int>()
        val operators = Stack<Char>()

        val precedence = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)

        fun applyOperator() {
            val operator = operators.pop()
            val operand2 = operands.pop()
            val operand1 = operands.pop()
            when (operator) {
                '+' -> operands.push(operand1 + operand2)
                '-' -> operands.push(operand1 - operand2)
                '*' -> operands.push(operand1 * operand2)
                '/' -> operands.push(operand1 / operand2)
            }
        }

        val tokens = str.split(" ")
        for (token in tokens) {
            when {
                token.toIntOrNull() != null -> operands.push(token.toInt())
                token[0] in "+-*/" -> {
                    while (operators.isNotEmpty() && operators.peek() != '(' &&
                        precedence[token[0]]!! <= precedence[operators.peek()]!!
                    ) {
                        applyOperator()
                    }
                    operators.push(token[0])
                }

                token == "(" -> operators.push(token[0])
                token == ")" -> {
                    while (operators.isNotEmpty() && operators.peek() != '(') {
                        applyOperator()
                    }
                    operators.pop()
                }
            }
        }

        while (operators.isNotEmpty()) {
            applyOperator()
        }

        return operands.pop()
    }


    fun tipo(ch: String): Int {
        return when (ch) {
            "+" -> 1
            "-" -> 1
            "*" -> 2
            "/" -> 2
            "%" -> 2
            "^" -> 3
            else -> 0
        }

        fun calculadora(a: Int, b: Int, operador: Char): Int {
            return when (operador) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                '/' -> a / b
                '%' -> a % b
                '^' -> a * a
                else -> throw IllegalArgumentException("El operador/signo no es válido ")
            }

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
            var num0: Button = findViewById(R.id.num0)
            var resta: Button = findViewById(R.id.resta)
            var multiplicacion: Button = findViewById(R.id.multiplicacion)
            var division: Button = findViewById(R.id.division)
            var modulo: Button = findViewById(R.id.modulo)
            var potencia: Button = findViewById(R.id.potencia)
            var limpiar: Button = findViewById(R.id.limpiar)
            var back: Button = findViewById(R.id.back)
            var parentesisA: Button = findViewById(R.id.parentesisA)
            var parentesisB: Button = findViewById(R.id.parentesisB)
            var ans: Button = findViewById(R.id.ans)
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
            limpiar.setOnClickListener() {
                calcular(limpiar)
            }
            back.setOnClickListener() {
                calcular(back)
            }
            parentesisA.setOnClickListener() {
                calcular(parentesisA)
            }
            parentesisB.setOnClickListener() {
                calcular(parentesisB)
            }
            ans.setOnClickListener() {
                calcular(ans)
            }
            igual.setOnClickListener() {
                calcular(igual)
            }

        }
    }
}
