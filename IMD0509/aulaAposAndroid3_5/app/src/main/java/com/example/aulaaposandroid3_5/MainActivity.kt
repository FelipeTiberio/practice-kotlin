package com.example.aulaaposandroid3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , AlimentoListFragment.onItemClickAlimento{

    var textFragment: TextFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment =  supportFragmentManager.findFragmentById( R.id.frag_text) as TextFragment
    }

    override fun onClick(alimento: Alimento) {
        textFragment?.setMsgText(
            "O preço do ${alimento} é R$ ${alimento.preco}"
        )
    }
}
