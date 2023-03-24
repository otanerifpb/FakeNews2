package com.example.fakenews2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.fakenews2.Cadastro.Cadastro

class CadastroActivity : AppCompatActivity() {
    private lateinit var etFrase: EditText
    private lateinit var rgEscolher: RadioGroup
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var cadastro: Cadastro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        this.etFrase = findViewById(R.id.etFraseCadastro)

        //this.rgEscolher = findViewById(R.id.rgEscolher)
        //val valEscolhido = findViewById<RadioGroup>(R.id.rgEscolher)
        this.rgEscolher = findViewById(R.id.rgEscolher)
        this.rbVerdade = findViewById(R.id.rbVerdadeCadastro)
        this.rbMentira = findViewById(R.id.rbMentiraCadastro)

        this.btSalvar = findViewById(R.id.btSalvarCadastro)
        this.btCancelar = findViewById(R.id.btCancelarCadastro)

        this.btSalvar.setOnClickListener({salvarCadastro()})
        this.btCancelar.setOnClickListener({cancelarCadastro()})

        this.cadastro = Cadastro()

        this.rgEscolher.setOnCheckedChangeListener(ChangeRadioGroup())
    }

    inner class ChangeRadioGroup: RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            Log.i("LOG", checkedId.toString())
            Log.i("LOG", rbVerdade.id.toString())
            Log.i("LOG", rbMentira.id.toString())
        }
    }

    fun salvarCadastro() {
        //val intent = Intent(this, JogoActivity::class.java) /*Informa quem vai controlar a transição*/
        //startActivity(intent) /*Sinaliza para iniciar a transição*/
        //val frase =
        //val valorEscolhido = selec
        this.cadastro.adicionar(this.etFrase.text.toString(),this.rgEscolher)
       // Log.i("APP_LOG", this.etFrase.toString())
        Log.i("APP_LOG", "Cadastro salvarCadastro")
        Toast.makeText(this, "Cadastro salvarCadastro", Toast.LENGTH_SHORT).show()
    }

    fun cancelarCadastro() {
        val intent = Intent(this, MainActivity::class.java) /*Informa quem vai controlar a transição*/
        startActivity(intent) /*Sinaliza para iniciar a transição*/
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Cadastro onStart")
        Toast.makeText(this, "Cadastro onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Cadastro onResume")
        Toast.makeText(this, "Cadastro onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Cadastro onPause")
        Toast.makeText(this, "Cadastro onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Cadastro onStop")
        Toast.makeText(this, "Cadastro onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Cadastro onDestroy")
        Toast.makeText(this, "Cadastro onDestroy", Toast.LENGTH_SHORT).show()
    }
}