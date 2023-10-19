package com.example.area13abschluss.ui.feldui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.Viewmodel
import com.example.area13abschluss.databinding.FragmentKalenderBinding

class KalenderFragment : Fragment() {

    lateinit var binding: FragmentKalenderBinding
    private val viewModel: Viewmodel by activityViewModels()

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
            findNavController().navigate(KalenderFragmentDirections.actionKalenderFragmentToEigenerKalenderTestWebFragment())
        }

        viewModel.data.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.verfugbarTV.visibility = View.GONE
                binding.EigenerKalenderBTN.setOnClickListener {
                    findNavController().navigate(KalenderFragmentDirections.actionKalenderFragmentToEigenerkalenderFragment())
                }

            } else {
                binding.verfugbarTV.visibility = View.VISIBLE
            }
        }
    }



}