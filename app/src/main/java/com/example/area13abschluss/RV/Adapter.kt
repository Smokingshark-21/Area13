package com.example.area13abschluss.RV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.databinding.ListItemActiveBinding
import com.example.area13abschluss.ui.feldui.EigenerkalenderFragmentDirections

class Adapter(
) : ListAdapter<Buchung, Adapter.ItemViewHolder>(itemddiv()) {

    inner class ItemViewHolder(val binding: ListItemActiveBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ListItemActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = currentList[position]
        holder.binding.datum.setText("${item.datum} ${item.uhrzeit.subSequence(0, 5)} Uhr")
        holder.binding.wo.setText("${item.ort}")

        holder.binding.detailbutton.setOnClickListener {
            holder.binding.root.findNavController().navigate(EigenerkalenderFragmentDirections.actionEigenerkalenderFragmentToDetailFragment(item.idbuchung))
        }

        if (!item.active) {
            holder.binding.detailbutton.visibility = View.GONE
        }
    }


}


class itemddiv() : DiffUtil.ItemCallback<Buchung>() {
    override fun areItemsTheSame(oldItem: Buchung, newItem: Buchung): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Buchung, newItem: Buchung): Boolean {
        return oldItem.idbuchung == newItem.idbuchung &&
                oldItem.active == newItem.active &&
                oldItem.uhrzeit == newItem.uhrzeit &&
                oldItem.ort == newItem.ort &&
                oldItem.datum == newItem.datum &&
                oldItem.email == newItem.email &&
                oldItem.vorname == newItem.vorname &&
                oldItem.nachname == newItem.nachname &&
                oldItem.telefonnummer == newItem.telefonnummer
    }

}