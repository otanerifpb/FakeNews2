package com.example.fakenews2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.fakenews2.cadastro.Frase

class JogoActivity : AppCompatActivity() {
    private lateinit var pbTempo: ProgressBar
    private lateinit var tvFrase: TextView
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btResponder: Button
    private lateinit var frase: Frase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        this.frase = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("FRASE", Frase::class.java)
        } else {
            intent.getSerializableExtra("FRASE")
        } as Frase

        this.pbTempo = findViewById(R.id.pbTempoJogo)
        this.tvFrase = findViewById(R.id.tvFraseJogo)
        this.rbVerdade = findViewById(R.id.rbVerdadeJogo)
        this.rbMentira = findViewById(R.id.rbMentiraJogo)
        this.btResponder = findViewById(R.id.btResponderJogo)

        this.tvFrase.text = frase.descricao
        this.btResponder.setOnClickListener({ResponderJogo()})

        contarTempo()

    }

    fun ResponderJogo() {
        if ((this.frase.estado) && (this.rbVerdade.isChecked)){
            setResult(RESULT_OK)
        }else if ((!this.frase.estado) && (this.rbMentira.isChecked)){
            setResult(RESULT_OK)
        }
        finish()
    }

    fun contarTempo(){
        Thread{
            while (this.pbTempo.progress < 100){
                this.pbTempo.progress += 1
                Thread.sleep(100)
            }
            finish()
        }.start()
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Jogo onStart")
        //Toast.makeText(this, "Jogo onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Jogo onResume")
        //Toast.makeText(this, "Jogo onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Jogo onPause")
        //Toast.makeText(this, "Jogo onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Jogo onStop")
        //Toast.makeText(this, "Jogo onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Jogo onDestroy")
        //Toast.makeText(this, "Jogo onDestroy", Toast.LENGTH_SHORT).show()
    }

}