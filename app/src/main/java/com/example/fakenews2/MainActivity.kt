package com.example.fakenews2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btJogar: Button
    private lateinit var btCadstrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btJogar = findViewById(R.id.btJogar)
        this.btCadstrar = findViewById(R.id.btCadastrar)

        this.btJogar.setOnClickListener({chamarJogo()})
        this.btCadstrar.setOnClickListener({chamarCadastro()})
    }

    fun chamarJogo(){
        val intent = Intent(this, JogoActivity::class.java)
        startActivity(intent)
    }

    fun chamarCadastro(){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}

