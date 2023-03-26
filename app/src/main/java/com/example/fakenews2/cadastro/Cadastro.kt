package com.example.fakenews2.cadastro

import android.util.Log

class Cadastro() {

    private var frases: MutableList<Frase>

    init{
        this.frases = mutableListOf()
    }

//    fun adicionar(descricao: String, estado: Boolean){
//
//        val frase = Frase(descricao, estado)
//        //var frase = Frase
//        frases.add(frase)
//        Log.i("APP_LOG", frases.size.toString())
//
//    }

//    fun sortear(): Frase?{
//        if (frases.size > 0){
//            return frases.random()
//        }else
//            return null
//    }

    fun add(frase: Frase) {
        this.frases.add(frase)
    }

    fun size(): Int {
        return this.frases.size
    }

   fun get(): Frase {
        return this.frases.random()
   }
}