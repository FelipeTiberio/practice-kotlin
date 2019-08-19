package com.felipetiberio.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager

        val fragmentLeft : FragmentLeft = FragmentLeft()
        val fragmentRight: FragmentRight = FragmentRight()

        val ft : FragmentTransaction = fm.beginTransaction()
        ft.add(R.id.fragment_left  , fragmentLeft)
        ft.add(R.id.fragment_right ,fragmentRight)
        ft.commit()
    }
}
