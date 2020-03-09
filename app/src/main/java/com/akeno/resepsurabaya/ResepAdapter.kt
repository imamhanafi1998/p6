package com.akeno.resepsurabaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_resep_layout.view.*

class ResepAdapter(val resepItemList: List<ResepData>, val clickListener: (ResepData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_resep_layout, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(resepItemList[position], clickListener)
    }

    override fun getItemCount() = resepItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(resep: ResepData, clickListener: (ResepData) -> Unit) {
            itemView.namaResep.text = resep.namaResep.toString()
            itemView.resepResep.text = resep.resepResep.toString()
            itemView.fotoResep.setImageResource(resep.fotoResep)

            itemView.setOnClickListener{clickListener(resep)}
        }
    }
}