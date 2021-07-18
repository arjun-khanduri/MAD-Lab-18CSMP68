package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four:TextView
    private lateinit var five:TextView
    private lateinit var six:TextView
    private lateinit var seven:TextView
    private lateinit var eight:TextView
    private lateinit var nine:TextView
    private lateinit var zero:TextView
    private lateinit var result:TextView
    private lateinit var expression:TextView
    private lateinit var mul:TextView
    private lateinit var div:TextView
    private lateinit var add:TextView
    private lateinit var sub:TextView
    private lateinit var dec:TextView
    private lateinit var eval:TextView
    private lateinit var b1:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zero=findViewById(R.id.zero)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        result=findViewById(R.id.result)
        expression=findViewById(R.id.expression)
        b1=findViewById(R.id.b1)
        mul=findViewById(R.id.mul)
        div=findViewById(R.id.div)
        sub=findViewById(R.id.sub)
        add=findViewById(R.id.plus)
        dec=findViewById(R.id.dec)
        eval=findViewById(R.id.eval)

        fun pressButton(string: String){
                expression.append(result.text)
                expression.append(string)
                result.text = ""


        }

        zero.setOnClickListener {
            pressButton("0")
        }
        one.setOnClickListener {
            pressButton("1")
        }
        two.setOnClickListener {
            pressButton("2")
        }
        three.setOnClickListener {
            pressButton("3")
        }

        four.setOnClickListener {
            pressButton("4")
        }

        five.setOnClickListener {
            pressButton("5")
        }

        six.setOnClickListener {
            pressButton("6")
        }

        seven.setOnClickListener {
            pressButton("7")
        }

        eight.setOnClickListener {
            pressButton("8")
        }

        nine.setOnClickListener {
            pressButton("9")
        }

        dec.setOnClickListener {
            pressButton(".")
        }

        div.setOnClickListener {
            pressButton("/")
        }

        mul.setOnClickListener {
            pressButton("*")
        }
        add.setOnClickListener {
            pressButton("+")
        }
        sub.setOnClickListener {
            pressButton("-")
        }

        b1.setOnClickListener{
            result.text = ""
            expression.text = ""
        }

        eval.setOnClickListener {
            val text = expression.text.toString()
            try {
                val expression = ExpressionBuilder(text).build()
                val expResult = expression.evaluate()
                val longResult = expResult.toLong()
                if(expResult == longResult.toDouble())
                    result.text= longResult.toString()
                else
                    result.text = expResult.toString()
            }
            catch (e: Exception){
                Toast.makeText(baseContext,"Invalid expression",Toast.LENGTH_SHORT).show()
            }
        }
    }
}