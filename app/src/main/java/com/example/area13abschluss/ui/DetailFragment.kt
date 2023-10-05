package com.example.area13abschluss.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentDetailBinding
import com.example.area13abschluss.databinding.FragmentEigenerkalenderBinding
import com.example.area13abschluss.ui.feldui.EigenerkalenderFragmentDirections


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel: Viewmodel by activityViewModels()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var newid = viewModel.database.buchungDao.getBuchung(id)

        binding.wodeatilTV.setText("${newid.ort}")
        binding.datumTV.setText("${newid!!.datum}")
        binding.uhrzeitTV.setText("${newid.uhrzeit}")
        binding.backBTN2.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToEigenerkalenderFragment())
        }

        when(newid!!.ort){
            "Area13 Buchung" ->{
                binding.bundeslandTV.setText("Sachsen, Deutschland")
                binding.strasseTV.setText("Riesaer Str. 72")
                binding.postleitzahlortTV.setText("04328 Leipzig")
                binding.telefonnummerTV.setText("+49 1514 6347197")
            }
            "Hangar13 Buchung" ->{
                binding.bundeslandTV.setText("Sachsen, Deutschland")
                binding.strasseTV.setText("Otto-Lilienthal-Straße 23")
                binding.postleitzahlortTV.setText("04758 Oschatz")
                binding.telefonnummerTV.setText("+49 1514 6347197")
            }
            "Megapark Buchung" ->{
                binding.bundeslandTV.setText("Sachsen, Deutschland")
                binding.strasseTV.setText("Reineckestraße 4")
                binding.postleitzahlortTV.setText("04179 Leipzig")
                binding.telefonnummerTV.setText("+49 1520 6254275")
            }
        }
    }



}