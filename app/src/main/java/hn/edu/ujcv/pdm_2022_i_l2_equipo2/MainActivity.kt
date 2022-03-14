package hn.edu.ujcv.pdm_2022_i_l2_equipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var valoresAlumno: HashMap <Int, String> = hashMapOf()
    var num=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAlumno.setOnClickListener { alumno() }
        inicializar1()
        inicializar2()
    }

    private fun alumno() {
        val intent = Intent(this, ListaAlumno::class.java)
        intent.putExtra("c", valoresAlumno)
        intent.putExtra("cont", num.toString())
        startActivity(intent)

    }

    private fun inicializar1() {
        try{
            val intent = intent
            valoresAlumno= intent.getSerializableExtra("nl") as HashMap<Int, String>
            println("se registro el libro"+ valoresAlumno.toString())
        }catch (e: Exception){
            println(e.message)
        }
    }

    private fun inicializar2() {
        try{
            val bundle = intent.extras
            val get = bundle?.get("cont")
            num = getString(R.string.registro, get)
        }catch (e: Exception){
            println(e.message)
        }
    }
}
