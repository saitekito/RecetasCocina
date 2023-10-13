package com.example.parcial1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comida (
   val id: Int,
   val receta : String,
   val  nivel : String,
   val  pais : Pais,
   val  plato :String,
   val ingredientes : String
): Parcelable

enum class Pais {
    ARGENTINA,
    BRASIL,
    CHILE,
    URUGUAY,
    PARAGUAY,
    COLOMBIA
}

