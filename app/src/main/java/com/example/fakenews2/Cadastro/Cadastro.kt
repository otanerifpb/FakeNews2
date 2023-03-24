package com.example.fakenews2.Cadastro

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

    fun adicionar(descricao: String, estado: RadioGroup){

        val frase = Frase(descricao, estado)
        //var frase = Frase
        frases.add(frase)

    }

    fun sortear(): Frase?{
        if (frases.size > 0){
            return frases.random()
        }else
            return null
    }
}