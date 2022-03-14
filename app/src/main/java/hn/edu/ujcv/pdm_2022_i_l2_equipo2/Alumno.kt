package hn.edu.ujcv.pdm_2022_i_l2_equipo2

import android.os.Parcel
import android.os.Parcelable

class Alumno():Parcelable {
    var Cuenta : Int=0
    var Nombre : String= ""
    var CorreoAlumno : String= ""

    constructor(parcel: Parcel) : this() {
        Cuenta = parcel.readInt()
        Nombre = parcel.readString().toString()
        CorreoAlumno = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel,flags: Int) {
        parcel.writeInt(Cuenta)
        parcel.writeString(Nombre)
        parcel.writeString(CorreoAlumno)
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alumno> {
        override fun createFromParcel(parcel: Parcel): Alumno {
            return Alumno(parcel)
        }

        var Alumno: HashMap<Int,Alumno> = hashMapOf()


        override fun newArray(size: Int): Array<Alumno?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString (): String {
        return "Ingresar numero de cuenta: $Cuenta\n del Alumno : $Nombre\n su correo es : $CorreoAlumno\n"
    }
}