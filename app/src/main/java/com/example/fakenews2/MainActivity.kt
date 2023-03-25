package com.example.fakenews2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.fakenews2.cadastro.Cadastro
import com.example.fakenews2.cadastro.Frase

class MainActivity : AppCompatActivity() {

    private lateinit var btJogar: Button
    private lateinit var btCadastrar: Button
    private lateinit var tvCadastradas: TextView
    private var cadastro: Cadastro

    init{
        this.cadastro = Cadastro()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btJogar = findViewById(R.id.btJogarMain)
        this.btCadastrar = findViewById(R.id.btCadastrarMain)
        this.tvCadastradas = findViewById(R.id.tvCadastradas)

        this.tvCadastradas.text = "${this.cadastro.size()} fofoca(s) cadastrada(s)."

        var cadastroResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val frase = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.data?.getSerializableExtra("FRASE", Frase::class.java)
                } else {
                    it.data?.getSerializableExtra("FRASE")
                } as Frase
                this.cadastro.add(frase)
                this.tvCadastradas.text = "${this.cadastro.size()} frase(s) cadastrada(s)."
                Toast.makeText(this, "Cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
                Log.i("APP_LOG", "Cadastrada com sucesso!")
            }
        }

        var jogoResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                Toast.makeText(this, "Parabéns!/n Você Ganhou!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Que pena!/n Você Perdeu!", Toast.LENGTH_SHORT).show()
            }
        }

        //this.btCadastrar.setOnClickListener({chamarCadastro()})
        //this.btCadastrar.setOnClickListener({chamarJogo()})

        this.btCadastrar.setOnClickListener ({
            val intent = Intent(this, CadastroActivity::class.java)
            cadastroResult.launch(intent)
        })

        this.btJogar.setOnClickListener({
            val frase = this.cadastro.get()
            val intent = Intent(this, JogoActivity::class.java).apply {
                putExtra("FRASE", frase)
            }
            jogoResult.launch(intent)
        })
    }

//    fun chamarCadastro(){
//        val intent = Intent(this, CadastroActivity::class.java) /*Informa qual Tela vai chamar*/
//        startActivity(intent) /*Sinaliza para iniciar a transição*/
//    }
//
//    fun chamarCadastro() {
//        var cadastroResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            if (it.resultCode == RESULT_OK){
//                val frase = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    it.data?.getSerializableExtra("FRASE", Frase::class.java)
//                } else {
//                    it.data?.getSerializableExtra("FRASE")
//                } as Frase
//                this.cadastro.add(frase)
//                this.tvCadastradas.text = "${this.cadastro.size()} frase(s) cadastrada(s)."
//                Toast.makeText(this, "Cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
//                Log.i("APP_LOG", "Cadastrada com sucesso!")
//            }
//        }
//        val intent = Intent(this, CadastroActivity::class.java)
//        cadastroResult.launch(intent)
//    }
//
//    fun chamarJogo(){
//        val intent = Intent(this, JogoActivity::class.java) /*Informa qual Tela vai chamar*/
//        startActivity(intent) /*Sinaliza para iniciar a transição*/
//    }
//
//    fun chamarJogo(){
//        var jogoResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            if (it.resultCode == RESULT_OK){
//                Toast.makeText(this, "Parabéns!/n Você Ganhou!", Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(this, "Que pena!/n Você Perdeu!", Toast.LENGTH_SHORT).show()
//            }
//        }
//        val frase = this.cadastro.get()
//        val intent = Intent(this, JogoActivity::class.java).apply {
//            putExtra("FOFOCA", frase)
//        }
//        jogoResult.launch(intent)
//    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_LOG", "Main onStart")
        //Toast.makeText(this, "Main onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_LOG", "Main onResume")
        //Toast.makeText(this, "Main onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_LOG", "Main onPause")
        //Toast.makeText(this, "Main onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_LOG", "Main onStop")
        //Toast.makeText(this, "Main onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_LOG", "Main onDestroy")
        //Toast.makeText(this, "Main onDestroy", Toast.LENGTH_SHORT).show()
    }
}





