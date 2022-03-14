package hn.edu.ujcv.pdm_2022_i_l2_grupo2

import android.os.Parcel
import android.os.Parcelable

class Clases() : Parcelable {
    var Nombre:   String= ""
    var Codigo:     String = ""
    var Seccion:      String = ""
    var Hora:      Int= 0
    var EdificioPiso:  String=""
    var Aula: String= ""

    constructor(parcel: Parcel): this(){
        Nombre = parcel.readString().toString()
        Codigo =parcel.readString().toString()
        Seccion=parcel.readString().toString()
        Hora=parcel.readInt()
        EdificioPiso=parcel.readString().toString()
        Aula=parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Nombre)
        parcel.writeString(Codigo)
        parcel.writeString(Seccion)
        parcel.writeInt(Hora)
        parcel.writeString(EdificioPiso)
        parcel.writeString(Aula)
    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Clases> {
        override fun createFromParcel(parcel: Parcel): Clases {
            return Clases(parcel)
        }
        var Libros: HashMap<Int,Clases> = hashMapOf()

        override fun newArray(size: Int): Array<Clases?> {
            return arrayOfNulls(size)
        }

    }

    override fun toString(): String {
        return "Ingreso de Clases: $Nombre\n de clase: $Codigo\n de la Clase: $Seccion\n: $Hora\n y su Edificio es: $EdificioPiso\n y su Aula es: $Aula "
    }
}