package com.felipetiberio.aula03atividade02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG = "Atividade2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "O App está no estado onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, " App está no estado onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "  App está no estado onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "  App está no estado onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, " App está no estado onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, " App está no estado onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, " App está no estado onRestart");
    }

}
