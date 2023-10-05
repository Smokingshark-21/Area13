package com.example.area13abschluss.RV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.databinding.ListItemActiveBinding
import com.example.area13abschluss.ui.feldui.EigenerkalenderFragmentDirections

class Adapter(
    val dataset:List<Buchung>
): RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemActiveBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemActiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        if (item.active) {
            holder.binding.datum.setText("${item.datum} ${item.uhrzeit.subSequence(0,5)}:UHr")
            holder.binding.wo.setText("${item.ort}")

            holder.binding.detailbutton.setOnClickListener {
                holder.binding.root.findNavController().navigate(EigenerkalenderFragmentDirections.actionEigenerkalenderFragmentToDetailFragment(item.idbuchung))
            }
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }

}