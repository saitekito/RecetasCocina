package com.example.parcial1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(val context: Context) : ListAdapter<Comida, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener:(Comida) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val receta: TextView = view.findViewById(R.id.tv_receta)
        private val nivel: TextView = view.findViewById(R.id.tv_nivel)
        private val pais: TextView = view.findViewById(R.id.tv_pais)
        private val plato: ImageView = view.findViewById(R.id.iv_plato)
        private val ingredientes: TextView = view.findViewById(R.id.tv_ingredientes)
        private val bandera: ImageView = view.findViewById(R.id.iv_bandera)

        fun bind (comida: Comida) {

            receta.text = comida.receta
            nivel.text = comida.nivel
            pais.text = comida.pais.toString()
            ingredientes.text = comida.ingredientes

            val imagen = when (comida.pais) {
                Pais.ARGENTINA -> R.drawable.arg
                Pais.BRASIL -> R.drawable.br
                Pais.CHILE -> R.drawable.chi
                Pais.COLOMBIA -> R.drawable.col
                Pais.PARAGUAY -> R.drawable.par
                Pais.URUGUAY -> R.drawable.uru
            }

            bandera.setImageResource(imagen)
           Glide.with(context).load(comida.plato).into(plato)

            view.setOnClickListener{
                onItemClickListener(comida)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val comida = getItem(position)
        holder.bind(comida)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Comida>() {
        override fun areItemsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return oldItem == newItem
        }
    }
}
