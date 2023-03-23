package com.example.fakenews2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btJogar: Button
    private lateinit var btCadstrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btJogar = findViewById(R.id.btJogarMain)
        this.btCadstrar = findViewById(R.id.btCadastrarMain)

        this.btJogar.setOnClickListener({chamarJogo()})
        this.btCadstrar.setOnClickListener({chamarCadastro()})
    }

    fun chamarJogo() {
        val intent = Intent(this, JogoActivity::class.java)
        startActivity(intent)
    }

    fun chamarCadastro(){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Main onStart")
        Toast.makeText(this, "Main onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Main onResume")
        Toast.makeText(this, "Main onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Main onPause")
        Toast.makeText(this, "Main onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Main onStop")
        Toast.makeText(this, "Main onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Main onDestroy")
        Toast.makeText(this, "Main onDestroy", Toast.LENGTH_SHORT).show()
    }
}

