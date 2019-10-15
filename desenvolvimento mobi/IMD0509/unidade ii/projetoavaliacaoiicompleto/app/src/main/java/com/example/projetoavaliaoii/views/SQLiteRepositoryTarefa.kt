package com.example.projetoavaliaoii.views

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import com.example.projetoavaliaoii.views.model.Tarefa
import com.example.projetosqlite.repository.sqlite.COLUMN_DESCRIPTION
import com.example.projetosqlite.repository.sqlite.COLUMN_ID
import com.example.projetosqlite.repository.sqlite.COLUMN_TITLE
import com.example.projetosqlite.repository.sqlite.TarefaSqlHelper

/*
class SQLiteRepositoryTarefa (context: Context, override val TABBLE_NAME: String?): TarefaRepository  {

    private  val helper : TarefaSqlHelper = TarefaSqlHelper(context)

    fun insert(note: Tarefa): Long{
        val db = helper.writableDatabase

        val contentValuesToDB = ContentValues().apply {
            put(COLUMN_TITLE, note.title)
            put(COLUMN_DESCRIPTION, note.text)
        }

        val id = db.insert(TABBLE_NAME, null, contentValuesToDB)

        if (id != -1L){
            note.id = id
        }

        db.close()

        return  id
    }


    fun update( note : Tarefa){
        val db = helper.writableDatabase

        val contentValues = ContentValues().apply {
            put(COLUMN_TITLE, note.title)
            put(COLUMN_DESCRIPTION, note.text)
        }

        db.update(
            TABBLE_NAME,
            contentValues,
            "$COLUMN_ID= ?",
            arrayOf((note.id.toString()))
        )

        db.close()
    }



    override fun save(note: Tarefa) {
        if(note.id == 0L){
            insert(note)
        }else{
            update(note)
        }
    }

    override fun remove(vararg notes: Tarefa) {

        val db = helper.writableDatabase

        for (note in notes){
            db.delete(
                TABBLE_NAME,
                "$COLUMN_ID = ? ",
                arrayOf(note.id.toString())
            )
        }
        db.close()
    }
    /*
    override fun noteById(id: Long, callback: (Tarefa?) -> Unit) {

        val sql = "SELECT * FROM $TABBLE_NAME WHERE $COLUMN_ID = ?"
        val db = helper.writableDatabase
        val cursor = db.rawQuery(sql, arrayOf(id.toString()))
        val note = if (cursor.moveToNext())noteFromCursor(cursor) else null

        callback(note)
    }*/
    /*
    override fun search(term: String, callback: (List<Tarefa>) -> Unit) {
        var sql = "SELECT * FROM $TABBLE_NAME"
        var args : Array<String>? =null

        if(term.isNotEmpty()){
            sql += "WHERE $COLUMN_TITLE LIKE ?"
            args = arrayOf("$term")
        }

        sql += " ORDER BY $COLUMN_TITLE"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)
        val notes = ArrayList<Tarefa>()

        while (cursor.moveToNext()){
            val note = noteFromCursor(cursor)
            notes.add(note)
        }

        cursor.close()
        db.close()
        callback(notes)
    }*/
    /*
    private fun noteFromCursor(cursor: Cursor) : Tarefa{
        val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
        val title  = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
        val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))

        var note = ContactsContract.CommonDataKind.Tarefa(title, description)
        note.id = id
        return note
    }*/
    /*
    fun notesArray() : ArrayList<Tarefa>{
        var sql = "SELECT * FROM $TABBLE_NAME"
        var args : Array<String>? =null

        sql += " ORDER BY $COLUMN_TITLE"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)
        val notes = ArrayList<Tarefa>()

        while (cursor.moveToNext()){
            val note = noteFromCursor(cursor)
            notes.add(note)
        }

        cursor.close()
        db.close()
        return  notes
    }*/
}*/