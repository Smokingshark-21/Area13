package com.example.area13abschluss.ui

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentDetailBinding
import com.example.area13abschluss.ui.buchungsfunc.util.emaildata
import com.example.area13abschluss.ui.feldui.DatePickerFragment
import java.text.DecimalFormat
import java.util.Calendar
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import kotlin.concurrent.thread


class DetailFragment : Fragment() {


    override fun onResume() {
        super.onResume()

        binding.updateBTN.visibility = View.GONE
    }

    lateinit var binding: FragmentDetailBinding
    private val viewModel: Viewmodel by activityViewModels()

    private var id: Int = 0
    var darumchanced = MutableLiveData<Boolean>(false)
    var uhrzeitchanced = MutableLiveData<Boolean>(false)
    var newide:Buchung = Buchung(0,"","","",true,"","","","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var newid = viewModel.database.buchungDao.getBuchung(id)
        newide = newid
        binding.wodeatilTV.setText(newid.ort)
        binding.datumTV.setText(newid!!.datum)
        binding.uhrzeitTV.setText(newid.uhrzeit)
        binding.backBTN2.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.
            actionDetailFragmentToEigenerkalenderFragment())
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

        binding.strasseplzCV.setOnClickListener {
            val gmmIntentUri =
            Uri.parse("geo:0,0?q=${binding.strasseTV.text},${binding.postleitzahlortTV.text}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.telefonnummerTV.setOnClickListener {
           makePhoneCall(binding.telefonnummerTV.text.toString())
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


        if (viewModel.datum() == newid.datum){
         binding.archivierenBTN.visibility = View.VISIBLE
        }
        Log.wtf("datum",viewModel.datum())
        binding.archivierenBTN.setOnClickListener {
            newid.active = false
            viewModel.instertbuchung(Buchung(newid.idbuchung,binding.datumTV.text.toString()
                .replace("-","."),binding.uhrzeitTV.text.toString(),newid.ort,
                false,newid.vorname,newid.nachname,newid.email,newid.telefonnummer))
        }





        darumchanced.observe(viewLifecycleOwner){
            binding.updateBTN.visibility = View.VISIBLE
        }
        uhrzeitchanced.observe(viewLifecycleOwner){
            binding.updateBTN.visibility = View.VISIBLE
        }

        binding.updateBTN.setOnClickListener {
            viewModel.instertbuchung(Buchung(newid.idbuchung,
                binding.datumTV.text.toString().replace("-","."),
                binding.uhrzeitTV.text.toString()
                ,newid.ort,newid.active,newid.vorname,newid.nachname,newid.email,newid.telefonnummer))
        }

        binding.delBTN.setOnClickListener {
            dialog(newid.idbuchung)
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


    private fun dialog(id:Int) {
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle("Buchung Wirklich Löschen ?")
        alertDialog.setMessage("Die Buchung wird aus Ihrem Kalender endgültig " +
                "gelöscht und eine absage an ${newide.ort.replace("Buchung","")} gesendet  ")

        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "Ja"
        ) { dialog, which ->
            dialog.dismiss()
            viewModel.delbuchung(id)
            sendemail("Absage ${newide.ort}",newide.vorname,newide.nachname,
                newide.telefonnummer,newide.email,newide.datum,newide.uhrzeit)
            findNavController().navigate(DetailFragmentDirections.
            actionDetailFragmentToEigenerkalenderFragment())
        }

        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE, "Nein"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)
        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
    }

    fun makePhoneCall(number: String) : Boolean {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    private fun sendemail(
        headline: String, vorname: String,
        nachname: String,
        telefonnummer: String, email: String, gewunschtesdatum: String,
        uhrzeit: String,
    ) {
        val emaildata = emaildata()
        val properties = System.getProperties()
        properties.put("mail.smtp.host", emaildata.Gmail_Host)
        properties.put("mail.smtp,port", "465")
        properties.put("mail.smtp.ssl.enable", "true")
        properties.put("mail.smtp.auth", "true")

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(
                    emaildata.Sender_Email_Adress,
                    emaildata.Sender_Email_Password
                )
            }
        })
        val message: MimeMessage = MimeMessage(session)

        thread {
            try {
                val recipientEmail = InternetAddress(emaildata.Reciver_Email_Adress)
                message.addRecipient(Message.RecipientType.TO, recipientEmail)
                message.setSubject(headline)
                message.setText(
                            "Buchung:" +" ABGESAGT" +"\n"+
                            "Vorname: " + vorname + "\n" +
                            "Nachname: " + nachname + "\n" +
                            "Telefonnumer: " + telefonnummer + "\n" +
                            "Email: " + email + "\n" +
                            "Datum: " + gewunschtesdatum + "\n" +
                            "Uhrzeit: " + uhrzeit + "\n"

                )
                Transport.send(message)
            } catch (e: java.lang.Exception) {
                Log.wtf("email", e)
            }
        }
    }


}

