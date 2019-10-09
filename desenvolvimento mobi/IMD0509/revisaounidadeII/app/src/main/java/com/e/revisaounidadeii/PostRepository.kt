package com.e.revisaounidadeii

interface PostRepository {

    fun save(post : Post)
    fun remove (vararg post: Post)
    fun postById(id:Long, callback: (Post?) -> Unit)
    fun search(term : String , callback: (List<Post>) -> Unit)
}