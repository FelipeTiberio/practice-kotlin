package com.imd.ufrn.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.imd.ufrn.aboutme.databinding.ActivityMainBinding

/*
* Uma pequena descrição das coisas que estudei quando estava fazendo esse simples app
* 1: binding
* 2: resouce e iu
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //nickname_edit =  findViewById(R.id.nickname_edit)
        //nickname_text = findViewById(R.id.nickname_text)
        //done_button   = findViewById(R.id.done_button)
        //done_button.setOnClickListener { this.addNickname(done_button) }
        binding.doneButton.setOnClickListener { this.addNickname(it) }

    }

    private fun addNickname(view : View){

        binding.apply {
            nameText.text = nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
        }
        // Código para esconder o teclado que foi usado para escrever o nickname
        val inn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
