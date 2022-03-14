package hn.edu.ujcv.pdm_2022_i_l2_equipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_lista_alumno.*
import java.lang.Exception

class ListaAlumno : AppCompatActivity() {
    var valoresAlumno: HashMap<Int, String> = hashMapOf()
    var num = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alumno)
        btnRegistrarAlumno.setOnClickListener { ingresarAlumno() }
        inicializar1()
        inicializar2()
        LISTAR()
        btnRegresar.setOnClickListener { regresar() }
    }

    private fun inicializar2() {
        try {
            val bundle=intent.extras
            val get= bundle?.get("cont")
            num="{get}"

        }catch (e:Exception){
            println(e.message)
        }

    }

    private fun inicializar1() {
        try {
            val intent=intent
            valoresAlumno=intent.getSerializableExtra("c") as HashMap<Int, String>
            println("Resultado de Registro Alumno:"+valoresAlumno.toString())
        }catch (e:Exception){
            println(e.message)
        }
    }

    private fun ingresarAlumno(){
        val intent=Intent(this,AlumnoActivity::class.java)
        intent.putExtra("c",valoresAlumno)
        intent.putExtra("cont",num.toString())
        startActivity(intent)
    }

    private fun regresar() {
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("c",valoresAlumno)
        intent.putExtra("cont",num.toString())
        startActivity(intent)
    }

    private fun LISTAR() {
        try {
            val list = findViewById<ListView>(R.id.lstvAlumno)
            var cuenta:String
            var nombre:String
            var correo:String
            var fin=""

            var A:java.util.ArrayList<String> = java.util.ArrayList()
            for (lib in valoresAlumno){
                val datos= lib.toString().split("|").toTypedArray()
                cuenta=datos[1].toString()
                nombre=datos[2].toString()
                correo=datos[3].toString()
                fin=cuenta+"\b"+nombre+"\b"+correo
                A.add(fin)
            }
            val adaptador=ArrayAdapter(this,R.layout.row,A)
            list.adapter =adaptador
            list.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{ override fun onNothingSelected(parent: AdapterView<*>?) {
            }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position1: Int, id: Long)
                {
                }
            }
        }catch (e:Exception){
            println(e.message)
        }
    }


}