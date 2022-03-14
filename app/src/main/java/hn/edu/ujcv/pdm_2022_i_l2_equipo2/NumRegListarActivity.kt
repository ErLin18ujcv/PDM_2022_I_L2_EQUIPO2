package hn.edu.ujcv.pdm_2022_i_l2_grupo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import hn.edu.ujcv.pdm_2022_i_l2_equipo2.MainActivity
import hn.edu.ujcv.pdm_2022_i_l2_equipo2.R
import kotlinx.android.synthetic.main.activity_num_reg_listar.*

class NumRegListarActivity : AppCompatActivity() {
    var valoresRegClases : HashMap<Int,String> = hashMapOf()
    var num = ""
    var correlativoListaDeClases=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_reg_listar)

        btnRegistrarClases.setOnClickListener { ingresarClases() }
        inicializar1()
        inicializar2()
        LISTAR()
        btnRegresarClases.setOnClickListener { regresar() }

    }

    private fun inicializar2() {
        try {
            val bundle = intent.extras
            val get = bundle?.get("cont")
            num = getString(R.string.registro, get)
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun inicializar1() {
        try {
            val intent = intent
            valoresRegClases= intent.getSerializableExtra("c") as HashMap<Int,String>
            correlativoListaDeClases=intent.getSerializableExtra("crc") as Int
            println("Recibi de Registrar clases: "+ valoresRegClases.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun ingresarClases() {
        val intent = Intent(this, RegistrarActivity::class.java)
        intent.putExtra("c", valoresRegClases)
        intent.putExtra("cont", num.toString())
        intent.putExtra("crc", correlativoListaDeClases)
        startActivity(intent)
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("c",valoresRegClases)
        intent.putExtra("cont", num.toString())
        intent.putExtra("crc", correlativoListaDeClases)
        startActivity(intent)
    }
    fun LISTAR(){
        try{
            val list = findViewById<ListView>(R.id.lstvClases)

            var nombre:String
            var codigo:String
            var seccion:String
            var hora:String
            var edificio:String
            var aula: String
            var fin=""

            var A: java.util.ArrayList<String> = java.util.ArrayList()

            for (lib in valoresRegClases){
                val datos = lib.toString().split("|").toTypedArray()
                nombre=datos[1].toString()
                codigo=datos[2].toString()
                seccion=datos[3].toString()
                hora=datos[4].toString()
                edificio=datos[5].toString()
                aula=datos[6].toString()
                fin= nombre +" "+ codigo + " "+ seccion +" "+ hora +" "+ edificio +" "+aula
                A.add(fin)
            }
            val adaptador = ArrayAdapter(this,R.layout.row,A)

            list.adapter =adaptador
            list.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{ override fun onNothingSelected(parent: AdapterView<*>?) {
            }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position1: Int, id: Long)
                {
                }
            }
        }catch (e: Exception){
            println(e.message)
        }
    }
}