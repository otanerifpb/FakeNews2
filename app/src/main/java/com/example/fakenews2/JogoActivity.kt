package com.example.fakenews2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class JogoActivity : AppCompatActivity() {
    private lateinit var pbTempo: ProgressBar
    private lateinit var tvFrase: TextView
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btResponder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        this.pbTempo = findViewById(R.id.pbTempoJogo)
        this.tvFrase = findViewById(R.id.tvFraseJogo)
        this.rbVerdade = findViewById(R.id.rbVerdadeJogo)
        this.rbMentira = findViewById(R.id.rbMentiraJogo)
        this.btResponder = findViewById(R.id.btResponderJogo)

        this.btResponder.setOnClickListener({ResponderJogo()})

    }

    fun ResponderJogo() {
        val intent = Intent(this, MainActivity::class.java) /*Informa quem vai controlar a transição*/
        startActivity(intent) /*Sinaliza para iniciar a transição*/
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Jogo onStart")
        Toast.makeText(this, "Jogo onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Jogo onResume")
        Toast.makeText(this, "Jogo onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Jogo onPause")
        Toast.makeText(this, "Jogo onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Jogo onStop")
        Toast.makeText(this, "Jogo onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Jogo onDestroy")
        Toast.makeText(this, "Jogo onDestroy", Toast.LENGTH_SHORT).show()
    }

}