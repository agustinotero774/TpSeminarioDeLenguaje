package com.example.tp_01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PokeAdapter (var poke: MutableList <Poke>, var context: Context):
        RecyclerView.Adapter<PokeAdapter.PokeViewHolder>() {
        override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
                val item = poke.get(position)
                holder.txNombre.text = item.nombre
                holder.txTipo.text = item.tipo
                holder.itemView.setOnClickListener(View.OnClickListener {
                        Toast.makeText(context, item.nombre, Toast.LENGTH_SHORT).show()
                })

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.itempoke, parent, false)

                return PokeViewHolder(view)
        }

        override fun getItemCount() = poke.size

        class PokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val txNombre: TextView
                val txTipo: TextView

                init {
                        txNombre = view.findViewById(R.id.tvNombre)
                        txTipo = view.findViewById(R.id.tvTipo)
                }
        }

}
