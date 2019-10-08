package com.e.revisaounidadeii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    private var posts = mutableListOf<Post>()
    private var adapter = PostAdapter(posts, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initReciclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return true
    }

    private  fun initReciclerView(){

        post_recucleView.adapter = adapter
        val linearLayout = LinearLayoutManager(this)
        post_recucleView.layoutManager = linearLayout
        //initSwipeDelete()

    }



    private fun onMessageItemClick(post: Post){
        /*
        var id : Int = notes.indexOf(note)
        var intent : Intent = Intent(this, SecondActivity::class.java)

        intent.putExtra("note", note)
        intent.putExtra("id", id)
        intent.putExtra( "tipoNote", "update")
        startActivityForResult(intent, MAIN_UPDATENOTE)*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val buttonAdd_id = R.id.sairButton

        //var note = Note("", "")

        if(id == buttonAdd_id){
            //var intent = Intent(this, SecondActivity::class.java)
            //intent.putExtra("note",note)
            //intent.putExtra("id", notes.lastIndex +1)
            //intent.putExtra( "tipoNote", "nova")
            //startActivityForResult(intent, MAIN_NEWNOTE)

            finish()
            return true

        }else{
            return super.onOptionsItemSelected(item)
        }

    }
}
