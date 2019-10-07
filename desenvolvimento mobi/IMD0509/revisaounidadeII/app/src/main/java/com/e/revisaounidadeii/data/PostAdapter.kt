package com.e.revisaounidadeii.data

import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView


class PostAdapter(private val post:  List<Post>, private val callback: (Post)-> Unit)
    : Adapter(){




    class ViewHolder : RecyclerView.ViewHolder(){

    }
}


