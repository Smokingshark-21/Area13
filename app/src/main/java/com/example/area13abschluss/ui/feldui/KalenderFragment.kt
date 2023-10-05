package com.example.area13abschluss.ui.feldui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentKalenderBinding

class KalenderFragment : Fragment() {

    lateinit var binding: FragmentKalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKalenderBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.FeldKalenderBTN.setOnClickListener {
            findNavController().navigate(KalenderFragmentDirections.actionKalenderFragmentToFeldkalenderFragment())
        }

        binding.EigenerKalenderBTN.setOnClickListener {
            findNavController().navigate(KalenderFragmentDirections.actionKalenderFragmentToEigenerkalenderFragment("","",""))
        }
    }



}