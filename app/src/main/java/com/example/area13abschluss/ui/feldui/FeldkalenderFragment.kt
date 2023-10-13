package com.example.area13abschluss.ui.feldui

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentFeldkalenderBinding



class FeldkalenderFragment : Fragment() {
    lateinit var binding: FragmentFeldkalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeldkalenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBTN.setOnClickListener {
//            findNavController().navigate(FeldkalenderFragmentDirections.actionFeldkalenderFragmentToKalenderFragment())
        }

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

        binding.dbausgabe.setOnClickListener {
            binding.anzahlpersohnoben.animate().apply {

                if (binding.svg.translationX == 0f) {
                    Log.wtf("wert", "${binding.svg.translationX}")
                    duration = 300
                    translationX(-1000f)
                    binding.svg2.animate().translationX(-1000f)
                    binding.anzahlpersohnunten.animate().translationX(-1000f)
                    binding.svg.animate().translationX(-1000f)

                    vonWieViel(true)
                    anzahlKunden(10,true)
                } else {
                    duration = 300
                    translationX(0f)
                    binding.svg2.animate().translationX(0f)
                    binding.anzahlpersohnunten.animate().translationX(0f)
                    binding.svg.animate().translationX(0f)

                    vonWieViel(false)
                    anzahlKunden(5,false)
                }
            }
        }

        binding.datumBTN.setOnClickListener {

            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager

            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "REQUEST_KEY") {
                    val date = bundle.getString("SELECTED_DATE")
                    binding.datumBTN.text = date
                }
            }

            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }


        binding.button.setOnClickListener {
//            findNavController().navigate(FeldkalenderFragmentDirections.actionFeldkalenderFragmentToBuchungFragment())
        }

    }


//    funktionen übersicht view

    fun vonWieViel(anzeigen: Boolean) {
        if (anzeigen) {
            binding.von1.visibility = View.VISIBLE
            binding.von2.visibility = View.VISIBLE
            binding.von3.visibility = View.VISIBLE
            binding.von4.visibility = View.VISIBLE
            binding.von5.visibility = View.VISIBLE
            binding.von6.visibility = View.VISIBLE
            binding.von7.visibility = View.VISIBLE
            binding.von8.visibility = View.VISIBLE
        } else {
            binding.von1.visibility = View.INVISIBLE
            binding.von2.visibility = View.INVISIBLE
            binding.von3.visibility = View.INVISIBLE
            binding.von4.visibility = View.INVISIBLE
            binding.von5.visibility = View.INVISIBLE
            binding.von6.visibility = View.INVISIBLE
            binding.von7.visibility = View.INVISIBLE
            binding.von8.visibility = View.INVISIBLE
        }
    }

    fun anzahlKunden(int: Int, on: Boolean) { //toDo logik finden
        if (on) {
            tenuhr(int)
            elevenuhr(15)
            twelvenuhr(int)
            thirdtenuhr(5)
            fourteenuhr(int)
            fivetenuhr(10)
            sixteenuhr(5)
            seventeenuhr(5)

        } else {
        tenuhr(0)
        elevenuhr(0)
        twelvenuhr(0)
        thirdtenuhr(0)
        fourteenuhr(0)
        fivetenuhr(0)
        sixteenuhr(0)
        seventeenuhr(0)
        }
    }


    //10uhr
    fun tenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig1.visibility = View.GONE
                binding.fNfzehn1.visibility = View.GONE
                binding.zehn1.visibility = View.GONE
                binding.funf1.visibility = View.GONE
            }

            5 -> {
                binding.funf1.visibility = View.VISIBLE
                binding.funf1.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf1.visibility = View.VISIBLE
                binding.zehn1.visibility = View.VISIBLE
                binding.zehn1.setTextColor(Color.rgb(239,194,0))
                binding.funf1.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf1.visibility = View.VISIBLE
                binding.zehn1.visibility = View.VISIBLE
                binding.fNfzehn1.visibility = View.VISIBLE
                binding.fNfzehn1.setTextColor(Color.rgb(239,194,0))
                binding.zehn1.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf1.visibility = View.VISIBLE
                binding.zehn1.visibility = View.VISIBLE
                binding.fNfzehn1.visibility = View.VISIBLE
                binding.zwanzig1.visibility = View.VISIBLE
                binding.zwanzig1.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn1.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
    //------

    //11uhr
    fun elevenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig2.visibility = View.GONE
                binding.fNfzehn2.visibility = View.GONE
                binding.zehn2.visibility = View.GONE
                binding.funf2.visibility = View.GONE
            }

            5 -> {
                binding.funf2.visibility = View.VISIBLE
                binding.funf2.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf2.visibility = View.VISIBLE
                binding.zehn2.visibility = View.VISIBLE
                binding.zehn2.setTextColor(Color.rgb(239,194,0))
                binding.funf2.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf2.visibility = View.VISIBLE
                binding.zehn2.visibility = View.VISIBLE
                binding.fNfzehn2.visibility = View.VISIBLE
                binding.fNfzehn2.setTextColor(Color.rgb(239,194,0))
                binding.zehn2.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf2.visibility = View.VISIBLE
                binding.zehn2.visibility = View.VISIBLE
                binding.fNfzehn2.visibility = View.VISIBLE
                binding.zwanzig2.visibility = View.VISIBLE
                binding.zwanzig2.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn2.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
    //------

    //12uhr
    fun twelvenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig3.visibility = View.GONE
                binding.fNfzehn3.visibility = View.GONE
                binding.zehn3.visibility = View.GONE
                binding.funf3.visibility = View.GONE
            }

            5 -> {
                binding.funf3.visibility = View.VISIBLE
                binding.funf3.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf3.visibility = View.VISIBLE
                binding.zehn3.visibility = View.VISIBLE
                binding.zehn3.setTextColor(Color.rgb(239,194,0))
                binding.funf3.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf3.visibility = View.VISIBLE
                binding.zehn3.visibility = View.VISIBLE
                binding.fNfzehn3.visibility = View.VISIBLE
                binding.fNfzehn3.setTextColor(Color.rgb(239,194,0))
                binding.zehn3.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf3.visibility = View.VISIBLE
                binding.zehn3.visibility = View.VISIBLE
                binding.fNfzehn3.visibility = View.VISIBLE
                binding.zwanzig3.visibility = View.VISIBLE
                binding.zwanzig3.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn3.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
    //------

    //13uhr
    fun thirdtenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig4.visibility = View.GONE
                binding.fNfzehn4.visibility = View.GONE
                binding.zehn4.visibility = View.GONE
                binding.funf4.visibility = View.GONE
            }

            5 -> {
                binding.funf4.visibility = View.VISIBLE
                binding.funf4.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf4.visibility = View.VISIBLE
                binding.zehn4.visibility = View.VISIBLE
                binding.zehn4.setTextColor(Color.rgb(239,194,0))
                binding.funf4.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf4.visibility = View.VISIBLE
                binding.zehn4.visibility = View.VISIBLE
                binding.fNfzehn4.visibility = View.VISIBLE
                binding.fNfzehn4.setTextColor(Color.rgb(239,194,0))
                binding.zehn4.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf4.visibility = View.VISIBLE
                binding.zehn4.visibility = View.VISIBLE
                binding.fNfzehn4.visibility = View.VISIBLE
                binding.zwanzig4.visibility = View.VISIBLE
                binding.zwanzig4.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn4.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
    //------

    //14uhr
    fun fourteenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig5.visibility = View.GONE
                binding.fNfzehn5.visibility = View.GONE
                binding.zehn5.visibility = View.GONE
                binding.funf5.visibility = View.GONE
            }

            5 -> {
                binding.funf5.visibility = View.VISIBLE
                binding.funf5.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf5.visibility = View.VISIBLE
                binding.zehn5.visibility = View.VISIBLE
                binding.zehn5.setTextColor(Color.rgb(239,194,0))
                binding.funf5.setTextColor(Color.rgb(0,0,0))
            }
            

            15 -> {
                binding.funf5.visibility = View.VISIBLE
                binding.zehn5.visibility = View.VISIBLE
                binding.fNfzehn5.visibility = View.VISIBLE
                binding.fNfzehn5.setTextColor(Color.rgb(239,194,0))
                binding.zehn5.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf5.visibility = View.VISIBLE
                binding.zehn5.visibility = View.VISIBLE
                binding.fNfzehn5.visibility = View.VISIBLE
                binding.zwanzig5.visibility = View.VISIBLE
                binding.zwanzig5.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn5.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
    //------

    //15uhr
    fun fivetenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig6.visibility = View.GONE
                binding.fNfzehn6.visibility = View.GONE
                binding.zehn6.visibility = View.GONE
                binding.funf6.visibility = View.GONE
            }

            5 -> {
                binding.funf6.visibility = View.VISIBLE
                binding.funf6.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf6.visibility = View.VISIBLE
                binding.zehn6.visibility = View.VISIBLE
                binding.zehn6.setTextColor(Color.rgb(239,194,0))
                binding.funf6.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf6.visibility = View.VISIBLE
                binding.zehn6.visibility = View.VISIBLE
                binding.fNfzehn6.visibility = View.VISIBLE
                binding.fNfzehn6.setTextColor(Color.rgb(239,194,0))
                binding.zehn6.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf6.visibility = View.VISIBLE
                binding.zehn6.visibility = View.VISIBLE
                binding.fNfzehn6.visibility = View.VISIBLE
                binding.zwanzig6.visibility = View.VISIBLE
                binding.zwanzig6.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn6.setTextColor(Color.rgb(0,0,0))
            }
        }
    }

    //------

    //16uhr
    fun sixteenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig7.visibility = View.GONE
                binding.fNfzehn7.visibility = View.GONE
                binding.zehn7.visibility = View.GONE
                binding.funf7.visibility = View.GONE
            }

            5 -> {
                binding.funf7.visibility = View.VISIBLE
                binding.funf7.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf7.visibility = View.VISIBLE
                binding.zehn7.visibility = View.VISIBLE
                binding.zehn7.setTextColor(Color.rgb(239,194,0))
                binding.funf7.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf7.visibility = View.VISIBLE
                binding.zehn7.visibility = View.VISIBLE
                binding.fNfzehn7.visibility = View.VISIBLE
                binding.fNfzehn7.setTextColor(Color.rgb(239,194,0))
                binding.zehn7.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf7.visibility = View.VISIBLE
                binding.zehn7.visibility = View.VISIBLE
                binding.fNfzehn7.visibility = View.VISIBLE
                binding.zwanzig7.visibility = View.VISIBLE
                binding.zwanzig7.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn7.setTextColor(Color.rgb(0,0,0))
            }
        }
    }

    //------

    //17uhr
    fun seventeenuhr(anzahl: Int) {
        when (anzahl) {
            0 -> {
                binding.zwanzig8.visibility = View.GONE
                binding.fNfzehn8.visibility = View.GONE
                binding.zehn8.visibility = View.GONE
                binding.funf8.visibility = View.GONE
            }

            5 -> {
                binding.funf8.visibility = View.VISIBLE
                binding.funf8.setTextColor(Color.rgb(239,194,0))
            }

            10 -> {
                binding.funf8.visibility = View.VISIBLE
                binding.zehn8.visibility = View.VISIBLE
                binding.zehn8.setTextColor(Color.rgb(239,194,0))
                binding.funf8.setTextColor(Color.rgb(0,0,0))
            }

            15 -> {
                binding.funf8.visibility = View.VISIBLE
                binding.zehn8.visibility = View.VISIBLE
                binding.fNfzehn8.visibility = View.VISIBLE
                binding.fNfzehn8.setTextColor(Color.rgb(239,194,0))
                binding.zehn8.setTextColor(Color.rgb(0,0,0))
            }

            20 -> {
                binding.funf8.visibility = View.VISIBLE
                binding.zehn8.visibility = View.VISIBLE
                binding.fNfzehn8.visibility = View.VISIBLE
                binding.zwanzig8.visibility = View.VISIBLE
                binding.zwanzig8.setTextColor(Color.rgb(239,194,0))
                binding.fNfzehn8.setTextColor(Color.rgb(0,0,0))
            }
        }
    }
}



