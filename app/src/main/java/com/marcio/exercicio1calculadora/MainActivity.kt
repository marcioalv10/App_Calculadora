package com.marcio.exercicio1calculadora

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variáveis para os botões numéricos
        var bt0 = findViewById<Button>(R.id.button0)

        var bt1 = findViewById<Button>(R.id.button1)
        var bt2 = findViewById<Button>(R.id.button2)
        var bt3 = findViewById<Button>(R.id.button3)
        var bt4 = findViewById<Button>(R.id.button4)
        var bt5 = findViewById<Button>(R.id.button5)
        var bt6 = findViewById<Button>(R.id.button6)
        var bt7 = findViewById<Button>(R.id.button7)
        var bt8 = findViewById<Button>(R.id.button8)
        var bt9 = findViewById<Button>(R.id.button9)

        //Variavel para a exibição do Visor da Calculadora
        var visor = findViewById<TextView>(R.id.visor)

        //Variaveis para os botões de funções
        var btAC = findViewById<Button>(R.id.button_ac)
        var btVirgula = findViewById<Button>(R.id.buttonVirgula)
        var btMais = findViewById<Button>(R.id.buttonMais)
        var btMenos = findViewById<Button>(R.id.buttonMenos)
        var btMultiplicacao = findViewById<Button>(R.id.buttonMultiplicacao)
        var btDivisao = findViewById<Button>(R.id.buttonDivisao)
        var btPorcentagem = findViewById<Button>(R.id.buttonPercentual)
        var btMaisMenos = findViewById<Button>(R.id.buttonMaisMenos)
        var btCalcula = findViewById<Button>(R.id.buttonCalcular)


        var valorStr = ""
        var sinal = ""
        var fecha = 0
        var resultado = 0.0

        //var dec = DecimalFormat("#,##0.00")
        var dec = DecimalFormat("#,###.#######")





        btCalcula.setOnClickListener {
            //Implementando com o when
            if (!valorStr.isEmpty() && !visor.text.equals("-"))
                when (sinal) {
                    "+" -> resultado += valorStr.toDouble()
                    "-" -> resultado -= valorStr.toDouble()
                    "*" -> resultado *= valorStr.toDouble()
                    ":" -> resultado /= valorStr.toDouble()
                    //  "+-" -> valorStr = ""
                    // "P" -> resultado *= valorStr.toDouble()
                    else -> resultado = valorStr.toDouble()

                }

            // visor.text = resultado.toString()
            visor.text = dec.format(resultado)

            valorStr = ""
            sinal = ""

            Log.i("Analisa c-valorStr: ", valorStr)
            Log.i("Analisa c-visor: ", visor.text.toString())
            Log.i("Analisa c-resultado: ", resultado.toString())

        }

        btMaisMenos.setOnClickListener {

            //  if (!valorStr.isEmpty()) {
            if (!valorStr.equals("") && !visor.text.equals("") && !visor.text.equals("-")) {
                valorStr = (valorStr.toDouble() * -1).toString()
                //  visor.text = valorStr
                visor.text = dec.format(valorStr.toDouble())
                // resultado += valorStr.toDouble()

            } else {
                valorStr = "-"
                visor.text = valorStr

                fecha++
            }
            //valorStr = ""
            // sinal = "+-"

            if (fecha > 3 && fecha < 7) {
                Toast.makeText(this, "Você está a ${7 - fecha} passos de exibir o nome do desenvolvedor", Toast.LENGTH_SHORT).show()
            }

            if (fecha == 7) {
                visor.text = "Márcio"
                valorStr = ""
                fecha = 1
            }
        }

        btMais.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                resultado += valorStr.toDouble()

            }
            valorStr = ""
            sinal = "+"
        }

        btMenos.setOnClickListener {


            Log.i("Analisa a-valorStr: ", valorStr)
            Log.i("Analisa a-visor: ", visor.text.toString())
            Log.i("Analisa a-resultado: ", resultado.toString())


            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                resultado += valorStr.toDouble()

                Log.i("Analisa d-valorStr: ", valorStr)
                Log.i("Analisa d-visor: ", visor.text.toString())
                Log.i("Analisa d-resultado: ", resultado.toString())


            }
            valorStr = ""
            sinal = "-"


            Log.i("Analisa e-valorStr: ", valorStr)
            Log.i("Analisa e-visor: ", visor.text.toString())
            Log.i("Analisa e-resultado: ", resultado.toString())

        }

        btMultiplicacao.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                resultado += valorStr.toDouble()
            }
            valorStr = ""
            sinal = "*"
        }

        btDivisao.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                resultado += valorStr.toDouble()
            }
            valorStr = ""
            sinal = ":"
        }

        btPorcentagem.setOnClickListener {
            if (sinal == "+" || sinal == "-") {
                if (!valorStr.isEmpty()) {

                    valorStr = ((valorStr.toDouble() / 100) * resultado).toString()
                    // valorStr = dec.format((valorStr.toDouble() / 100) * resultado)
                    // visor.text = valorStr
                    visor.text = dec.format(valorStr.toDouble())

                }
            } else {
                if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                    valorStr = ((valorStr.toDouble() / 100)).toString()
                    //visor.text = valorStr
                    visor.text = dec.format(valorStr.toDouble())
                }
            }

        }

        //Função que preenche o algorismo

        fun preenche(algo: String) {
            if (!valorStr.equals("0")) {
                valorStr += algo
            } else {
                valorStr = algo
            }
            visor.text = valorStr
            fecha = 0
        }

        //Preenchendo os algorismos

        bt1.setOnClickListener {
            preenche("1")
        }

        bt2.setOnClickListener {
            preenche("2")
        }

        bt3.setOnClickListener {
            preenche("3")
        }

        bt4.setOnClickListener {
            preenche("4")
        }

        bt5.setOnClickListener {
            preenche("5")
        }

        bt6.setOnClickListener {
            preenche("6")
        }

        bt7.setOnClickListener {
            preenche("7")
        }

        bt8.setOnClickListener {
            preenche("8")
        }

        bt9.setOnClickListener {
            preenche("9")
        }

        bt0.setOnClickListener {
            preenche("0")
        }

        btAC.setOnClickListener {
            visor.text = "0"
            valorStr = ""
            resultado = 0.0
            fecha++

            if (fecha >= 2) {
                visor.text = ""
                fecha = 0

            }

        }

        btAC.setOnLongClickListener {
            Toast.makeText(this, "Ops", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }



        btVirgula.setOnClickListener {

            if (valorStr.isEmpty()) {
                visor.text = "0"
                valorStr += visor.text
                visor.text = valorStr
            }

            if (!visor.text.contains(".")) {

                visor.text = "."
                valorStr += visor.text
                visor.text = valorStr

            }


        }


    }


}