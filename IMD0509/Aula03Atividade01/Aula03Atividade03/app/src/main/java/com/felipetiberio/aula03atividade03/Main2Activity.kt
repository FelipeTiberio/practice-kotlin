package com.felipetiberio.aula03atividade03

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }


    fun nextmain (view: View?){
        //val intent = Intent(this, MainActivity::class.java)
        val intent = Intent(this, MainActivity::class.java)

        startActivityForResult(intent, 1)
    }
}
