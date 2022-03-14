package hn.edu.ujcv.pdm_2022_i_l2_equipo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alumno.*
import java.lang.Exception

class AlumnoActivity : AppCompatActivity() {
    var valoresAlumno: HashMap<Int,String> = hashMapOf()
    var num=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)
        btnGuardar.setOnClickListener { guardar() }
        iniciarList1()
        inicializar2()
    }

    private fun guardar() {
        if (txtNumCuenta.text.isEmpty()){
            Toast.makeText(applicationContext,"El campo no debe estar vacio",Toast.LENGTH_LONG).show()
        }else if(txtNombre.text.isEmpty()){
            Toast.makeText(applicationContext,"El campo no debe estar vacio",Toast.LENGTH_LONG).show()
        }else if (txtCorreo.text.isEmpty()){
            Toast.makeText(applicationContext,"El campo no debe estar vacio",Toast.LENGTH_LONG).show()
        }else {
            val dato: Alumno = Alumno()
            dato.Cuenta = txtNumCuenta.text.toString().toInt()
            dato.Nombre = txtNombre.text.toString()
            dato.CorreoAlumno = txtCorreo.text.toString()

            val parametro = StringBuilder()
            parametro.append("Datos Del Alumno").append("|")
            parametro.append(dato.Cuenta.toString().trim()).append("|")
            parametro.append(dato.Nombre.toString().trim()).append("|")
            parametro.append(dato.CorreoAlumno.toString().trim()).append("|")

            valoresAlumno.put(dato.Cuenta, parametro.toString())
            Toast.makeText(applicationContext, "Alumno Registrado Con Exito", Toast.LENGTH_LONG).show()

            val intent= Intent(this,ListaAlumno::class.java)
            intent.putExtra("c",valoresAlumno)
            intent.putExtra("cont",num)
            startActivity(intent)

        }
    }
    private fun iniciarList1() {
        try {
            val intent= intent
            valoresAlumno=intent.getSerializableExtra("c") as HashMap<Int, String>
            println("Se registro el Alumno"+valoresAlumno.toString())

        }catch (e: Exception){
            println(e.message)
        }
    }
    private fun inicializar2(){
        try {
            val bundle=intent.extras
            val get= bundle?.get("cont")
            num="{get}"
        }catch (e:Exception){
            println(e.message)
        }
    }


}