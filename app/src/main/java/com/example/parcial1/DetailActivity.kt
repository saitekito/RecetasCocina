package com.example.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private  lateinit var tvrecetaDetail: TextView
    private lateinit var  tvingredientesDetail:  TextView
    private lateinit var  ivplatoDetail : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val comida = intent.getParcelableExtra<Comida>("comida")

        tvrecetaDetail = findViewById(R.id.tv_recetaDetail)
        tvingredientesDetail = findViewById(R.id.tv_ingredientesDetail)
        ivplatoDetail = findViewById(R.id.iv_platoDetail)

        tvrecetaDetail.text = comida?.receta
        tvingredientesDetail.text = comida?.ingredientes

        Glide.with(this).load(comida?.plato).into(ivplatoDetail)

    }
}