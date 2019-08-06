package com.felipetiberio.aula03atividade01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nextImagem(view: View){
        val intent = Intent(this, Main2Activity::class.java)
        startActivityForResult(intent,19)
    }
}
