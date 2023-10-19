package com.example.area13abschluss.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentFeldinfosBinding
import com.example.area13abschluss.databinding.FragmentKalenderBinding


class FeldinfosFragment : Fragment() {

    lateinit var binding: FragmentFeldinfosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeldinfosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val area13Btn = binding.area13BTN
        val area13CV = binding.area13CV
        val hangar13Btn = binding.hangar13BTN
        val hangarCV = binding.hangar13CV
        val mpBtn = binding.mpBTN
        val mpCV = binding.mpCV

        area13CV.strokeWidth = 3
        hangarCV.strokeWidth = 0
        mpCV.strokeWidth = 0

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl("https://area13-leipzig.de/softair-spielen-leipzig/#4")


        area13Btn.setOnClickListener {
            area13CV.strokeWidth = 3
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 0
            binding.webview.loadUrl("https://area13-leipzig.de/softair-spielen-leipzig/#4")
        }
        hangar13Btn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 3
            mpCV.strokeWidth = 0
            binding.webview.loadUrl("https://hngr13.de")
        }
        mpBtn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 3
            binding.webview.loadUrl("https://paintball-megapark.de")
        }
    }
}