package com.felipetiberio.aula03atividade03

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import com.felipetiberio.aula03atividade03.R.id.button1 as button1

class MainActivity : AppCompatActivity() {

    var i = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var clicou = false
        var button = findViewById<Button>(button1)


        button.text = i.toString()
    }


    fun next (view: View){
       val intent = Intent(this, Main2Activity::class.java)

        i++
        startActivityForResult(intent, 1)


    }


}
