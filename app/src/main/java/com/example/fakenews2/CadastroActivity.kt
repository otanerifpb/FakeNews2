package com.example.fakenews2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.fakenews2.cadastro.Cadastro
import com.example.fakenews2.cadastro.Frase

class CadastroActivity : AppCompatActivity() {
    private lateinit var etFrase: EditText
    private lateinit var rgEscolher: RadioGroup
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private var frases: MutableList<Frase>

    init{
        this.frases = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        this.etFrase = findViewById(R.id.etFraseCadastro)
        this.rgEscolher = findViewById(R.id.rgEscolher)
        this.rbVerdade = findViewById(R.id.rbVerdadeCadastro)
        this.rbMentira = findViewById(R.id.rbMentiraCadastro)

        this.btSalvar = findViewById(R.id.btSalvarCadastro)
        this.btCancelar = findViewById(R.id.btCancelarCadastro)

        this.btSalvar.setOnClickListener({salvarCadastro()})
        this.btCancelar.setOnClickListener({cancelarCadastro()})

        rbVerdade.isChecked = true
    }

//    inner class ChangeRadioGroup: RadioGroup.OnCheckedChangeListener{
//        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
//           // Log.i("APP_LOG", checkedId.toString())
//           // Log.i("APP_LOG", rbVerdade.id.toString())
//           // Log.i("APP_LOG", rbMentira.id.toString())
//
//            if (rbVerdade.id.equals(checkedId) ) {
//                escolha = rbVerdade.text.toString()
//                Log.i("APP_LOG", rbVerdade.text.toString())
//            }else {
//                escolha = rbMentira.text.toString()
//                Log.i("APP_LOG", rbMentira.text.toString())
//            }
//
//
//        }
//    }

    fun salvarCadastro() {
        val descricao = this.etFrase.text.toString()
        val estato = this.rbVerdade.isChecked
        val frase = Frase(descricao, estato)
        frases.add(frase)

        val intent = Intent().apply {
            putExtra("FRASE", frase)
           // putExtras("FRASE", frases)
        }
        setResult(RESULT_OK, intent)
        this.etFrase.text.clear()
        Log.i("APP_LOG", "Cadastro salvo com sucesso")
        Toast.makeText(this, "Cadastro salvarCadastro", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun cancelarCadastro() {
//        val intent = Intent(this, MainActivity::class.java) /*Informa quem vai controlar a transição*/
//        startActivity(intent) /*Sinaliza para iniciar a transição*/
        Log.i("APP_LOG", "Cadastro Cancelado")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Cadastro onStart")
        //Toast.makeText(this, "Cadastro onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Cadastro onResume")
        //Toast.makeText(this, "Cadastro onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Cadastro onPause")
        //Toast.makeText(this, "Cadastro onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Cadastro onStop")
        //Toast.makeText(this, "Cadastro onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Cadastro onDestroy")
        //Toast.makeText(this, "Cadastro onDestroy", Toast.LENGTH_SHORT).show()
    }
}