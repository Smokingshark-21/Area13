package com.example.area13abschluss.ui

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentDetailBinding
import com.example.area13abschluss.databinding.FragmentEigenerkalenderBinding
import com.example.area13abschluss.ui.feldui.DatePickerFragment
import com.example.area13abschluss.ui.feldui.EigenerkalenderFragmentDirections
import java.text.DecimalFormat
import java.util.Calendar
import kotlin.math.log


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel: Viewmodel by activityViewModels()
    private var id: Int = 0
    var darumchanced = MutableLiveData<Boolean>(false)
    var uhrzeitchanced = MutableLiveData<Boolean>(false)
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




        binding.datumTV.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager

            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "REQUEST_KEY") {
                    val date = bundle.getString("SELECTED_DATE")
                    binding.datumTV.setText(date)
                    darumchanced.postValue(true)
                }
            }

            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }


        binding.uhrzeitTV.setOnClickListener {
            timepicker()
        }


        binding.archivierenBTN.setOnClickListener {
            newid.active = false
            Log.wtf("test2","${newid.active}")
        }

        //todo logic archiviren und update list adapter für rv

        var datumnew = binding.datumTV.text.toString()
        var uhrzeitnew = binding.uhrzeitTV.text.toString()


        darumchanced.observe(viewLifecycleOwner){
            binding.updateBTN.visibility = View.VISIBLE
        }
        uhrzeitchanced.observe(viewLifecycleOwner){
            binding.updateBTN.visibility = View.VISIBLE
        }

        binding.updateBTN.setOnClickListener {
            viewModel.instertbuchung(Buchung(newid.idbuchung,datumnew.replace("-","."),uhrzeitnew,newid.ort,newid.active))
            Log.wtf("test1",datumnew)
        }


    }

    fun timepicker() {

        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentTime.get(Calendar.MINUTE)

        val simpleTimePicker = TimePickerDialog(
            requireContext(), R.style.DialogTheme, { _, hourOfDay, min ->
                timeFormat(hourOfDay, min)
            }, hour, minute, true
        )
        simpleTimePicker.show()


    }

    fun timeFormat(hour: Int, minute: Int) {
        val modifiedHour = hour
        val numberFormat = DecimalFormat("00")

        val timeTxt = binding.uhrzeitTV
        timeTxt.setText(
            "${numberFormat.format(modifiedHour)}:${numberFormat.format(minute)}-${
                numberFormat.format(
                    modifiedHour + 4
                )
            }:${numberFormat.format(minute)} Uhr"
        )
        uhrzeitchanced.postValue(true)
    }



}

