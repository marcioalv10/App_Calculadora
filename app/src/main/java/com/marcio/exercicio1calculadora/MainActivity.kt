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
        val bt0 = findViewById<Button>(R.id.button0)
        val bt1 = findViewById<Button>(R.id.button1)
        val bt2 = findViewById<Button>(R.id.button2)
        val bt3 = findViewById<Button>(R.id.button3)
        val bt4 = findViewById<Button>(R.id.button4)
        val bt5 = findViewById<Button>(R.id.button5)
        val bt6 = findViewById<Button>(R.id.button6)
        val bt7 = findViewById<Button>(R.id.button7)
        val bt8 = findViewById<Button>(R.id.button8)
        val bt9 = findViewById<Button>(R.id.button9)

        //Variavel para a exibição do Visor da Calculadora
        val visor = findViewById<TextView>(R.id.visor)

        //Variaveis para os botões de funções
        val btAC = findViewById<Button>(R.id.button_ac)
        val btVirgula = findViewById<Button>(R.id.buttonVirgula)
        val btMais = findViewById<Button>(R.id.buttonMais)
        val btMenos = findViewById<Button>(R.id.buttonMenos)
        val btMultiplicacao = findViewById<Button>(R.id.buttonMultiplicacao)
        val btDivisao = findViewById<Button>(R.id.buttonDivisao)
        val btPorcentagem = findViewById<Button>(R.id.buttonPercentual)
        val btMaisMenos = findViewById<Button>(R.id.buttonMaisMenos)
        val btCalcular = findViewById<Button>(R.id.buttonCalcular)

        var valorStr = ""
        var sinal = ""
        var fecha = 0
        var resultado = 0.0
        var mode = 1
        var temp = ""

        //Formata a saída do número com separador de milhar e casas decimais
        //var dec = DecimalFormat("#,##0.00")
        var dec = DecimalFormat("#,###.#######")

        fun calcular() {

            //Implementando com o when
            if (!valorStr.isEmpty() && !visor.text.equals("-"))
                when (sinal) {
                    "+" -> resultado += valorStr.replace(",", ".").toDouble()
                    "-" -> resultado -= valorStr.replace(",", ".").toDouble()
                    "*" -> resultado *= valorStr.replace(",", ".").toDouble()
                    ":" -> resultado /= valorStr.replace(",", ".").toDouble()
                    //  "+-" -> valorStr = ""
                    // "P" -> resultado *= valorStr.toDouble()
                    else -> resultado = valorStr.replace(",", ".").toDouble()
                }

            // visor.text = resultado.toString()
            visor.text = dec.format(resultado)

            valorStr = ""
            sinal = ""
        }


        btCalcular.setOnClickListener {
            calcular()
        }

        btMaisMenos.setOnClickListener {

            Log.i("avalia valorStr: ", valorStr)
            Log.i("avalia visor: ", visor.text.toString())
            Log.i("avalia resultado: ", resultado.toString())

            if (!valorStr.equals("") && !valorStr.equals("0") && !visor.text.equals("") && !visor.text.equals("-")) {
                valorStr = (valorStr.replace(",", ".").toDouble() * -1).toString()
                //  visor.text = valorStr

                visor.text = dec.format(valorStr.toDouble())
                // resultado += valorStr.toDouble()

                Log.i("avalia 2 valorStr: ", valorStr)
                Log.i("avalia 2 visor: ", visor.text.toString())
                Log.i("avalia 2 resultado: ", resultado.toString())


            } else {
                valorStr = "-"
                visor.text = valorStr

                Log.i("avalia 3 valorStr: ", valorStr)
                Log.i("avalia 3 visor: ", visor.text.toString())
                Log.i("avalia 3 resultado: ", resultado.toString())
                fecha++
            }
            //valorStr = ""
            // sinal = "+-"

            if (fecha > 6 && fecha < 10) {
                Toast.makeText(this, "Você está a ${10 - fecha} passos de exibir o nome do desenvolvedor", Toast.LENGTH_SHORT).show()
            }

            if (fecha == 10) {
                visor.text = "Márcio"
                valorStr = ""
                fecha = 1
            }
        }

        btMais.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                //resultado += valorStr.toDouble()
                calcular()
            }
            valorStr = ""
            sinal = "+"
        }

        btMenos.setOnClickListener {


            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                // resultado += valorStr.toDouble()
                calcular()

            }

            valorStr = ""
            sinal = "-"

        }

        btMultiplicacao.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                // resultado += valorStr.toDouble()
                calcular()
            }
            valorStr = ""
            sinal = "*"
        }

        btDivisao.setOnClickListener {
            if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                // resultado += valorStr.toDouble()
                calcular()
            }
            valorStr = ""
            sinal = ":"
        }

        btPorcentagem.setOnClickListener {
            if (sinal == "+" || sinal == "-") {
                if (!valorStr.isEmpty()) {

                    valorStr = ((valorStr.replace(",", ".").toDouble() / 100) * resultado).toString()
                    // valorStr = dec.format((valorStr.toDouble() / 100) * resultado)
                    // visor.text = valorStr
                    visor.text = dec.format(valorStr.toDouble())
                }
            } else {
                if (!valorStr.isEmpty() && !visor.text.equals("-")) {
                    valorStr = ((valorStr.replace(",", ".").toDouble() / 100)).toString()
                    //visor.text = valorStr
                    visor.text = dec.format(valorStr.toDouble())
                }
            }
        }

        //Função que preenche o algorismo

        fun preenche(algo: String) {
            if (!valorStr.equals("0") && !valorStr.contains(".")) {
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
            sinal = "AC"

            if (fecha >= 2) {
                visor.text = ""
                fecha = 0
            }

        }

        btAC.setOnLongClickListener {

            when (mode) {
                1 -> {
                    Toast.makeText(this, "modo Calculadora financeira ativado", Toast.LENGTH_SHORT).show()
                    dec = DecimalFormat("#,##0.00")
                    mode = 2
                }
                2 -> {
                    Toast.makeText(this, "modo Calculadora padrão ativado", Toast.LENGTH_SHORT).show()
                    dec = DecimalFormat("#,###.#######")
                    mode = 1
                }

            }
            return@setOnLongClickListener true
        }

        btVirgula.setOnClickListener {

            if (valorStr.isEmpty()) {
                //visor.text = "0"
                temp = "0"
                //valorStr += visor.text
                valorStr += temp
                visor.text = valorStr
            }

            //valorStr -> visor.text
            if (!valorStr.contains(",") && !valorStr.contains(".")) {

                if (!visor.text.equals("-")) {

                    //visor.text = "."
                    temp = ","
                    // valorStr += visor.text
                    valorStr += temp
                    visor.text = valorStr
                }


            }

        }


    }


}