package com.example.area13abschluss.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.area13abschluss.MainActivity
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentBuchungBinding
import com.example.area13abschluss.databinding.FragmentFeldkalenderBinding
import java.text.FieldPosition

class BuchungFragment : Fragment() {

    lateinit var binding: FragmentBuchungBinding

    val spielart = arrayOf("Spielart*","Paintball","Softair")
    val spieler18 = arrayOf("alle Spieler 18 ?","Ja","nein")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuchungBinding.inflate(inflater, container, false)
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

        area13Btn.setOnClickListener {
            area13CV.strokeWidth = 3
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 0
        }
        hangar13Btn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 3
            mpCV.strokeWidth = 0
        }
        mpBtn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 3
        }


        val spielartAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spielart)
        binding.spielartSPI.adapter = spielartAdapter
        binding.spielartSPI.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spieler18Adapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spieler18)
        binding.spieler18SPI.adapter = spieler18Adapter
        binding.spieler18SPI.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }



}