package com.example.area13abschluss.ui.feldui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentFeldKalenderTestWebBinding
import com.example.area13abschluss.databinding.FragmentFeldkalenderBinding


class FeldKalenderTestWebFragment : Fragment() {

    lateinit var binding: FragmentFeldKalenderTestWebBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeldKalenderTestWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val auswahl = MutableLiveData<String>()

        val url = MutableLiveData<String>()

        val area13Btn = binding.area13BTN
        val area13CV = binding.area13CV
        val hangar13Btn = binding.hangar13BTN
        val hangarCV = binding.hangar13CV
        val mpBtn = binding.mpBTN
        val mpCV = binding.mpCV

        area13CV.strokeWidth = 3
        hangarCV.strokeWidth = 0
        mpCV.strokeWidth = 0

        binding.web.settings.javaScriptEnabled = true
        binding.web.loadUrl("https://calendar.google.com/calendar/embed?src=8a50f06d2d37ffcb3ba8285fe7154d5b2a2d3a728a2dacb243e4e927f29551cd%40group.calendar.google.com&ctz=Europe%2FBerlin")

        area13Btn.setOnClickListener {
            area13CV.strokeWidth = 3
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 0
            auswahl.postValue("Area13")
            binding.web.loadUrl("https://calendar.google.com/calendar/embed?src=8a50f06d2d37ffcb3ba8285fe7154d5b2a2d3a728a2dacb243e4e927f29551cd%40group.calendar.google.com&ctz=Europe%2FBerlin")
        }
        hangar13Btn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 3
            mpCV.strokeWidth = 0
            auswahl.postValue("Hangar13")
            binding.web.loadUrl("https://calendar.google.com/calendar/embed?src=863f85f7f6975337196ac01e08fb7324a955e2a9ef018c2634918e7f0d21d705%40group.calendar.google.com&ctz=Europe%2FBerlin")
        }
        mpBtn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 3
            auswahl.postValue("Megapark")
            binding.web.loadUrl("https://calendar.google.com/calendar/embed?src=47ca2038ed772afc779652e7dabcc594b46fabaffa91e3ad3356c8bcd21c4dc9%40group.calendar.google.com&ctz=Europe%2FBerlin")
        }

        binding.backBTN3.setOnClickListener {
            findNavController().navigate(FeldKalenderTestWebFragmentDirections.actionEigenerKalenderTestWebFragmentToKalenderFragment())
        }


    }
}