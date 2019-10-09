package com.e.revisaounidadeii

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    private var posts = mutableListOf<Post>()
    private var adapter = PostAdapter(posts, this::onMessageItemClick)
    private lateinit var noteSqlHelper: SQLiteRepositoryPost


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        noteSqlHelper = SQLiteRepositoryPost(this)
        var notesInDB = this.getNotesFromDB()

        for( note in notesInDB){
            this.posts.add(note)
        }

        initReciclerView()
    }

    private  fun getNotesFromDB() : ArrayList<Post> {
        return noteSqlHelper.notesArray()
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
       //@TODO
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val buttonLogout_id = R.id.sairButton
        val buttonCadastrar_id = R.id.cadastrar_button

        if(id == buttonLogout_id){
            //var intent = Intent(this, SecondActivity::class.java)
            //intent.putExtra("note",note)
            //intent.putExtra("id", notes.lastIndex +1)
            //intent.putExtra( "tipoNote", "nova")
            //startActivityForResult(intent, MAIN_NEWNOTE)

            finish()
            return true

        }
        else if(id == buttonCadastrar_id){
            var intent : Intent = Intent(this, CadastrarPost::class.java)
            startActivityForResult(intent, 66)
            return true
        }

        else{
            return super.onOptionsItemSelected(item)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data != null) {
            if (requestCode == 66 && resultCode == Activity.RESULT_OK)
            {

                //var returnPost: Post = data.getSerializableExtra("newPost") as Post
                //var post : Post = data.getSerializableExtra("post") as Post
                var post = Post(data.getStringExtra("title"), data.getStringExtra("text"))
                // id de returnNote no banco
                 var id : Long? = noteSqlHelper.insert(post)
                post.id = id
               posts.add(post)
                adapter.notifyItemInserted(posts.lastIndex)

                Toast.makeText(this, "Novo post salvo", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(
                    this, "Algum erro ocorreu, saõ foi possivel salva a nota", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
