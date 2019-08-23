package com.example.aulaaposandroid3_5


data class Alimento(var nome: String, var preco : Double) {

    override fun toString(): String {
        return this.nome
    }
}