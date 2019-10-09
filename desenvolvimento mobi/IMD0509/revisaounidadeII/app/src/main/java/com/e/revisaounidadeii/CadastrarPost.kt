package com.e.revisaounidadeii

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastrar_post.*

class CadastrarPost : AppCompatActivity() {

    var post : Post = Post("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_post)


        salvar_btn.setOnClickListener {
            post.title = title_txt.text.toString()
            post.text = descricao_txt.text.toString()

            var intentToReturn = Intent()
            intentToReturn.putExtra("post", post)
            intentToReturn.putExtra("title", post.text)
            intentToReturn.putExtra("text", post.text)

            setResult(Activity.RESULT_OK, intentToReturn)
            finish()
        }

        cancelar_btn.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }


    }
}
