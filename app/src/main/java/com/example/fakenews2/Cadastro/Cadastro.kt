package com.example.fakenews2.Cadastro

import android.util.Log
import android.widget.RadioGroup

class Cadastro() {

    var frases: MutableList<Frase>

    init{
        this.frases = mutableListOf()
    }

//    object Frase{
//        var descricao: String = ""
//        var estado: Boolean = false
//    }

    fun adicionar(descricao: String, estado: String){

        val frase = Frase(descricao, estado)
        //var frase = Frase
        frases.add(frase)
        Log.i("APP_LOG", frases.size.toString())

    }

    fun sortear(): Frase?{
        if (frases.size > 0){
            return frases.random()
        }else
            return null
    }
}