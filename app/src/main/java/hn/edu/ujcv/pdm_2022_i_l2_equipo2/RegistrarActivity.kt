package hn.edu.ujcv.pdm_2022_i_l2_grupo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2022_i_l2_equipo2.R
import kotlinx.android.synthetic.main.activity_registrar.*
import java.lang.Exception
import java.lang.StringBuilder

class RegistrarActivity : AppCompatActivity() {
    var valoresRegClases : HashMap<Int,String> = hashMapOf()
    var num = ""
    var correlativoListaDeClases=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        btnGuardar.setOnClickListener { guardar() }
        iniciarList1()
        iniciarList2()
    }

    private fun guardar(){
        if(txtNombre.text.isEmpty()){
            Toast.makeText(applicationContext, "Debe ingresar un valor", Toast.LENGTH_LONG).show()
        }else if(txtCodigo.text.isEmpty()) {
            Toast.makeText(applicationContext, "Debe ingresar un valor", Toast.LENGTH_LONG).show()
        }else if(txtSeccion.text.isEmpty()){
            Toast.makeText(applicationContext, "Debe ingresar un valor", Toast.LENGTH_LONG).show()
        }else if(txtHora.text.isEmpty()){
            Toast.makeText(applicationContext,"Debe ingresar un valor", Toast.LENGTH_SHORT).show()
        }else if (txtEdificioPiso.text.isEmpty()){
            Toast.makeText(applicationContext,"Debe ingresar un valor", Toast.LENGTH_SHORT).show()
        }else{ if (txtAula.text.isEmpty()) {
            Toast.makeText(applicationContext, "Debe ingresar un valor", Toast.LENGTH_LONG).show()
        } else{
            val dato : Clases = Clases()
            dato.Nombre      = txtNombre.text.toString()
            dato.Codigo         = txtCodigo.text.toString()
            dato.Seccion          = txtSeccion.text.toString()
            dato.Hora          = txtHora.text.toString().toInt()
            dato.EdificioPiso      = txtEdificioPiso.text.toString()
            dato.Aula = txtAula.text.toString()

            val parametro = StringBuilder()
            parametro.append("DATOS CLASES").append("|")
            parametro.append(dato.Nombre.toString().trim()).append("|")
            parametro.append(dato.Codigo.toString().trim()).append("|")
            parametro.append(dato.Seccion.toString().trim()).append("|")
            parametro.append(dato.Hora.toString().trim()).append("|")
            parametro.append(dato.EdificioPiso.toString().trim()).append("|")
            parametro.append(dato.Aula.toString().trim()).append("|")


            correlativoListaDeClases=correlativoListaDeClases+1

            valoresRegClases.put(correlativoListaDeClases, parametro.toString())
            Toast.makeText(applicationContext, "Clase Registrada", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, NumRegListarActivity::class.java)
            intent.putExtra("c", valoresRegClases)
            intent.putExtra("cont", num)
            intent.putExtra("crc", correlativoListaDeClases)
            startActivity(intent)

        }
    }
         }
    private fun iniciarList1(){
        try {
            val intent = intent
            valoresRegClases= intent.getSerializableExtra("c") as HashMap<Int,String>
            correlativoListaDeClases=intent.getSerializableExtra("crc") as Int
            println("Se Registro Clase: "+ valoresRegClases.toString())
        }catch (e: Exception){
            println(e.message)

        }


    }
    private fun iniciarList2(){
        try {
            val bundle = intent.extras
            val get = bundle?.get("cont")
            num = getString(R.string.registro, get)
        }catch (e: Exception){
            println(e.message)

        }
}


        }



