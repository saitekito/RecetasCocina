package com.example.parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvComidas: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvComidas= findViewById(R.id.rv_comidas)
        rvComidas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvComidas.adapter = adapter
        adapter.submitList(getListadoComidas())

        adapter.onItemClickListener = {
            navegarDetalle(it)
        }

    }

    private fun navegarDetalle(comida: Comida) {
        val intent= Intent(this, DetailActivity::class.java )
        intent.putExtra("comida", comida)
        startActivity(intent)

    }


    private fun getListadoComidas(): MutableList<Comida>? {
        return mutableListOf(
            Comida(1,
                "Empanadas",
                "facil",
                Pais.ARGENTINA,
                "https://media.todojujuy.com/p/534d687c1d154c44205e5643b9091a31/adjuntos/227/imagenes/003/221/0003221167/770x0/smart/imagepng.png",
                "Tapas para Empanadas, " +
                        "Carne Picada, " +
                        "Cebollas, " +
                        "Ajo, " +
                        "Morron," +
                        " Tomate," +
                        "Aceitunas," +
                        "Pimenton, Comino," +
                        "Sal y Pimienta."
                ),
            Comida(2,
                "Feijoada",
                "Medio",
                Pais.BRASIL,
                "https://st2.depositphotos.com/1672917/9973/i/450/depositphotos_99734952-stock-photo-purple-bean-feijoada.jpg",
                "Frijoles, Chorizo Criollo, Lomo de Cerdo, Panceta, " +
                        "Costilla de Cerdo, Ajo," +
                        "Cebolla, Morron Rojo, Morron verde," +
                        "Tomate, Aceite Oliva,  Sal y Pimienta."
            ),
            Comida(3,
                "Barros Luco",
                "Facil",
                Pais.CHILE,
                "https://www.midiariodecocina.com/wp-content/uploads/2015/06/Barros-luco01.jpg",
                "Pan de Sandwich, " + "Carne tipo Milanesa," +
                        " Sal a Gusto, " +
                        "Queso, " +
                        "Manteca."

        ),
            Comida(4,
                "Arepas",
                "Facil",
                Pais.COLOMBIA,
                "https://www.annarecetasfaciles.com/files/arepas-colombianas-815x458.jpg",
                "Agua Tibia, " +
                        "Harina pre-cocida de Maiz, " +
                        " manteca, " +
                        "Sal."
            ),
            Comida(5,
                "Sopa Paraguaya ",
                "Facil",
                Pais.PARAGUAY,
                "https://2trendies.com/hero/2023/01/Sopa-paraguaya.jpg?width=768&aspect_ratio=16:9&format=nowebp",
                "Leche, " +
                        "Aceite, Huevos, " +
                        "Harina de Maiz," +
                        " Queso Cremoso, " +
                        "Sal, " +
                        "Cebolla."
            ),
            Comida(6,
                "Chivito Uruguayo",
                "Medio",
                Pais.URUGUAY,
                "https://saborargento.com.ar/wp-content/uploads/2023/08/Receta-de-Chivito-Uruguayo.jpg",
                "Carne de Milanesa, " +
                        "Tomates," +
                        " Hojas de Lechuga, " +
                        "Aceitunas," +
                        " Jamon, " +
                        "Queso Mozzarella," +
                        " Pan de Barra, " +
                        "Huevo Duro, " +
                        "Mayonesa, " +
                        "Papas Fritas. "
            ),

            )
    }
}