package com.example.felipe00.aula03

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    val TAG = "myapp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.d(TAG, "onCreate");

        val txtNome = findViewById<TextView>(R.id.textNome)
        val txtEmail = findViewById<TextView>(R.id.textEmail)

        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")

        txtEmail.text = email
        textNome.text = nome


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart");
    }


    override fun onBackPressed() {
        //super.onBackPressed()

        val i = intent

        i.putExtra("menssagem", "Texto passado por outra activity")
        setResult(Activity.RESULT_OK, i)

        finish()

    }
}
