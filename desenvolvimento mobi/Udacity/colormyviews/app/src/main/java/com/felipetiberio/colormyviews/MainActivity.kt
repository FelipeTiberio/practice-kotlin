package com.felipetiberio.colormyviews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListenners()
    }

    private fun setListenners(){
        val clickViews: List<View> =
            listOf(box_one_text,box_two_text,box_three_tex
                ,box_four_text,box_five_text, constrait_layout)

        for (item in clickViews){
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View){
        when (view.id){
            R.id.box_one_text -> view.setBackgroundResource(android.R.color.holo_blue_light)
            R.id.box_two_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_three_tex -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
