package com.example.projetosqlite.repository.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/** Define um classe que herde de SQLiteOpenHelper, responsável por criar o
banco de dados **/

class TarefaSqlHelper(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {

        sqLiteDatabase.execSQL(
            "CREATE TABLE $TABLE_NAME("+
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "$COLUMN_COMPLETED INTEGER NOT NULL, "+
                    "$COLUMN_TITLE TEXT NOT NULL, "+
                    "$COLUMN_DESCRIPTION TEXT)")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Próximas versões
    }
}






