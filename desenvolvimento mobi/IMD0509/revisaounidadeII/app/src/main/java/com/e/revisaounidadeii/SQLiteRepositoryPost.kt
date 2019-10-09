package com.e.revisaounidadeii

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import kotlin.Unit as Unit1

class SQLiteRepositoryPost(context: Context): PostRepository {

    private  val helper : PostSqlHelper = PostSqlHelper(context)

    fun insert(post: Post): Long{
        val db = helper.writableDatabase

        val contentValuesToDB = ContentValues().apply {
            put(COLUMN_TITLE, post.title)
            put(COLUMN_DESCRIPTION, post.text)
        }

        val id = db.insert(TABBLE_NAME, null, contentValuesToDB)

        if (id != -1L){
            post.id = id
        }

        db.close()

        return  id
    }


    fun update( post: Post ){
        val db = helper.writableDatabase

        val contentValues = ContentValues().apply {
            put(COLUMN_TITLE, post.title)
            put(COLUMN_DESCRIPTION, post.text)
        }

        //@TODO não entendi direito esse código sql de update
        db.update(
            TABBLE_NAME,
            contentValues,
            "$COLIMN_ID= ?",
            arrayOf((post.id.toString()))
        )

        db.close()
    }



    override fun save(post: Post) {
        if(post.id == 0L){
            insert(post)
        }else{
            update(post)
        }
    }

    override fun remove(vararg posts: Post) {

        val db = helper.writableDatabase

        for (note in posts){
            db.delete(
                TABBLE_NAME,
                "$COLIMN_ID = ? ",
                arrayOf(note.id.toString())
            )
        }
        db.close()
    }

    override fun  postById(id:Long, callback: (Post?) -> kotlin.Unit) {

        val sql = "SELECT * FROM $TABBLE_NAME WHERE $COLIMN_ID = ?"
        val db = helper.writableDatabase
        val cursor = db.rawQuery(sql, arrayOf(id.toString()))
        val post = if (cursor.moveToNext())noteFromCursor(cursor) else null

        callback(post)
    }

    override fun search(term: String, callback: (List<Post>) -> Unit1) {
        var sql = "SELECT * FROM $TABBLE_NAME"
        var args : Array<String>? =null

        if(term.isNotEmpty()){
            sql += "WHERE $COLUMN_TITLE LIKE ?"
            args = arrayOf("$term")
        }

        sql += " ORDER BY $COLUMN_TITLE"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)
        val notes = ArrayList<Post>()

        while (cursor.moveToNext()){
            val note = noteFromCursor(cursor)
            notes.add(note)
        }

        cursor.close()
        db.close()
        callback(notes)
    }

    private fun noteFromCursor(cursor: Cursor) : Post{
        val id = cursor.getLong(cursor.getColumnIndex(COLIMN_ID))
        val title  = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
        val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))

        var note = Post(title,description)
        note.id = id
        return note
    }

    fun notesArray() : ArrayList<Post>{
        var sql = "SELECT * FROM $TABBLE_NAME"
        var args : Array<String>? =null

        sql += " ORDER BY $COLUMN_TITLE"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)
        val notes = ArrayList<Post>()

        while (cursor.moveToNext()){
            val note = noteFromCursor(cursor)
            notes.add(note)
        }

        cursor.close()
        db.close()
        return  notes
    }
}