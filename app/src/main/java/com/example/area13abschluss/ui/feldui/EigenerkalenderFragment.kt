package com.example.area13abschluss.ui.feldui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentEigenerkalenderBinding
import com.example.area13abschluss.databinding.FragmentFeldkalenderBinding


class EigenerkalenderFragment : Fragment() {
    lateinit var binding: FragmentEigenerkalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEigenerkalenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBTN2.setOnClickListener {
            findNavController().navigate(EigenerkalenderFragmentDirections.actionEigenerkalenderFragmentToKalenderFragment())
        }
    }

}