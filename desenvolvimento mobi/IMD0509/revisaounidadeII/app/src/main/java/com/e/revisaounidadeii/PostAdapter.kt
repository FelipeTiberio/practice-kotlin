package com.e.revisaounidadeii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter (private  val posts: List<Post>, private val callback: (Post)->Unit)
    :RecyclerView.Adapter<PostAdapter.LocalViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return LocalViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
       holder.bindView(posts[position])

        holder.itemView.setOnClickListener {
            var post = posts[holder.adapterPosition]
            callback(post)
        }
    }

    override fun getItemCount(): Int {
       // body of created functions use File | Settings | File Templates.
        return  this.posts.size
    }

    class  LocalViewHolder(itemView:View ) : RecyclerView.ViewHolder(itemView){

        fun bindView(post : Post){
          this.itemView.title_textview.text = post.title
            //this.itemView.id_textview.text = post.id.toString()
            this.itemView.descricao_textview.text = post.text
        }

    }
}


