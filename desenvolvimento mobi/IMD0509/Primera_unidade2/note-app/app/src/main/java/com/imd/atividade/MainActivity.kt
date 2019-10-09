package com.imd.atividade

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

const val MAIN_NEWNOTE = 10
const val MAIN_UPDATENOTE = 15

class MainActivity : AppCompatActivity() {

    private var notes = mutableListOf<Note>()
    private var adapter = NoteAdapter(notes, this::onMessageItemClick)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initReciclerView()
    }

    private  fun initReciclerView(){

        mainRecyclerView.adapter = adapter
        val linearLayout = LinearLayoutManager(this)
        mainRecyclerView.layoutManager = linearLayout
        initSwipeDelete()

    }

    private fun onMessageItemClick(note: Note){
        var id : Int = notes.indexOf(note)
        var intent : Intent = Intent(this, SecondActivity::class.java)

        intent.putExtra("note", note)
        intent.putExtra("id", id)
        startActivityForResult(intent, MAIN_UPDATENOTE)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notes,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val buttonAdd_id = R.id.addNotebutton


        var note = Note("", "")

        if(id == buttonAdd_id){
            var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("note",note)
                intent.putExtra("id", notes.lastIndex +1)
                startActivityForResult(intent, MAIN_NEWNOTE)

            return true

        }else{
            return super.onOptionsItemSelected(item)
        }

    }

    private fun initSwipeDelete(){
        val swipe = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                notes.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(mainRecyclerView)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data != null) {
            if (requestCode == MAIN_NEWNOTE && resultCode == Activity.RESULT_OK)
            {
                var returnNote: Note = data.getSerializableExtra("newNote") as Note
                notes.add(returnNote)
                adapter.notifyItemInserted(notes.lastIndex)

                Toast.makeText(this, "Nova nota salva", Toast.LENGTH_SHORT).show()
            }
            else if ( requestCode == MAIN_UPDATENOTE &&  resultCode == Activity.RESULT_OK){
                var returnNote: Note = data.getSerializableExtra("newNote") as Note
                var id : Int = data.getSerializableExtra("id") as Int
                notes[id] = returnNote
                adapter.notifyItemChanged(id)
                Toast.makeText(this, "Update salvo", Toast.LENGTH_SHORT).show()

            }

            else {
                Toast.makeText(
                    this, "Algum erro ocorreu, saõ foi possivel salva a nota", Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}
