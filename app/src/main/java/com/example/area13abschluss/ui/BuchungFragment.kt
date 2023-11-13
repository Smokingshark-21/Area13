package com.example.area13abschluss.ui

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.R
import com.example.area13abschluss.Viewmodel
import com.example.area13abschluss.databinding.FragmentBuchungBinding
import com.example.area13abschluss.ui.feldui.DatePickerFragment
import com.example.area13abschluss.ui.buchungsfunc.util.emaildata
import java.lang.Exception
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

class BuchungFragment : Fragment() {

    lateinit var binding: FragmentBuchungBinding
    private val viewModel: Viewmodel by activityViewModels()

    private var spielart = mutableListOf<String>("Softair")
    private val spieler18 = arrayOf("Ja", "nein")
    private val anzahl = arrayOf(
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20"
    )

    private val mutableLiveData = MutableLiveData<String>("Area13 Buchung")
    private val emailversand = MutableLiveData<Boolean>(false)
    private val spielartval = MutableLiveData<String>()
    private val spieler18val = MutableLiveData<String>()
    private val spielereigen = MutableLiveData<String>()
    private val spielerleih = MutableLiveData<String>()

    override fun onResume() {
        super.onResume()

        val spielartAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, spielart)
        binding.spielartAuto.setAdapter(spielartAdapter)
        binding.spielartAuto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielartval.postValue(spielart[position]!!)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }

        val spieler18Adapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, spieler18)
        binding.spieler18Auto.setAdapter(spieler18Adapter)
        binding.spieler18Auto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spieler18val.postValue(spieler18[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }

        val spielereigenausrustungAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, anzahl)
        binding.anzahleigenAuto.setAdapter(spielereigenausrustungAdapter)
        binding.anzahleigenAuto.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    spielereigen.postValue(anzahl[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }


            }

        val spielerleihAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, anzahl)
        binding.ausrStungleihenAuto.setAdapter(spielerleihAdapter)
        binding.ausrStungleihenAuto.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    spielerleih.postValue(anzahl[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }


            }
    }

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
            mutableLiveData.postValue("Area13 Buchung")
            spielart.clear()
            spielart.add("Softair")


        }
        hangar13Btn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 3
            mpCV.strokeWidth = 0
            mutableLiveData.postValue("Hangar13 Buchung")
            spielart.clear()
            spielart.add("Paintball")
            spielart.add("Softair")
        }
        mpBtn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 3
            mutableLiveData.postValue("Megapark Buchung")
            spielart.clear()
            spielart.add("Paintball")

        }


        val spielartAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, spielart)
        binding.spielartAuto.setAdapter(spielartAdapter)
        binding.spielartAuto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielartval.postValue(spielart[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }


        }

        val spieler18Adapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, spieler18)
        binding.spieler18Auto.setAdapter(spieler18Adapter)
        binding.spieler18Auto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spieler18val.postValue(spieler18[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }


        }

        val spielereigenausrustungAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, anzahl)
        binding.anzahleigenAuto.setAdapter(spielereigenausrustungAdapter)
        binding.anzahleigenAuto.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    spielereigen.postValue(anzahl[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }


            }

        val spielerleihAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.spinner_text, anzahl)
        binding.ausrStungleihenAuto.setAdapter(spielerleihAdapter)
        binding.ausrStungleihenAuto.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    spielerleih.postValue(anzahl[position])
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }


            }

        binding.primdDateED.setText(viewModel.datum())
        binding.primdDateED.setOnClickListener {

            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager

            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "REQUEST_KEY") {
                    val date = bundle.getString("SELECTED_DATE")
                    binding.primdDateED.setText(date)
                }
            }

            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }

        binding.alterdatumED.setText(viewModel.datum())
        binding.alterdatumED.setOnClickListener {

            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager

            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "REQUEST_KEY") {
                    val date = bundle.getString("SELECTED_DATE")
                    binding.alterdatumED.setText(date)
                }
            }

            // show
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }


        binding.button.setOnClickListener {
            val vorname = binding.vornameED.text.toString()
            val nachname = binding.nachnameED.text.toString()
            val strhausnmr = binding.strasehausnmrED.text.toString()
            val postleit = binding.postED.text.toString()
            val ort = binding.ortED.text.toString()
            val telefonnummer = binding.telED.text.toString()
            val email = binding.emailED.text.toString()
            val spielart = binding.spielartAuto.text.toString()
            val spieleralle18 = binding.spieler18Auto.text.toString()
            val datumprim = binding.primdDateED.text.toString()
            val altdatum = binding.alterdatumED.text.toString()
            val uhrzeit = binding.uhrzeitED.text.toString()
            val spieleranzahl = binding.spieleranzahlED.text.toString()
            val spielerausrustung = binding.anzahleigenAuto.text.toString()
            val spielerausleihen = binding.ausrStungleihenAuto.text.toString()
            val weiterfragen = binding.fragenED.text.toString()

            if (vorname.isNotEmpty()&&nachname.isNotEmpty()&&email.isNotEmpty()&&telefonnummer.isNotEmpty()) {
                sendemail(
                mutableLiveData.value.toString(),
                vorname,
                nachname,
                strhausnmr,
                postleit,
                ort,
                telefonnummer,
                email,
                spielart,
                spieleralle18,
                datumprim,
                altdatum,
                uhrzeit,
                spieleranzahl,
                spielerausrustung,
                spielerausleihen,
                weiterfragen
            )
            } else{
                dialogepty()
            }
        }

        emailversand.observe(viewLifecycleOwner) {
            if (emailversand.value!!) {
                dialog()
                emailversand.postValue(false)
            }
        }


        binding.uhrzeitED.setOnClickListener {
            timepicker()
        }

    }

    private fun dialog() {
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle("Email wurde Versand")
        alertDialog.setMessage("Möchten sie die Buchung in ihrem eigenen kalender speichern inerhalb der app?")

        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "Ja"
        ) { dialog, which ->
            dialog.dismiss()
            findNavController().navigate(
                BuchungFragmentDirections.actionBuchungFragmentToEigenerkalenderFragment()
            )
            viewModel.instertbuchung(Buchung(0,"${binding.primdDateED.text.toString().replace("-",".")}","${binding.uhrzeitED.text.toString()}","${mutableLiveData.value.toString()}",true,"${binding.vornameED.text.toString()}","${binding.nachnameED.text.toString()}","${binding.emailED.text.toString()}","${binding.telED.text.toString()}"))
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

    private fun dialogepty() {
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle("Es Fehlen daten")
        alertDialog.setMessage("Überprüfen sie ob sie ihren Vornamen,Nachnamen,Email-Adresse und ihre Telefonnumer angegeben haben")

        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "okay"
        ) { dialog, which ->
            dialog.dismiss()
        }
        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
    }

//  Email funktion sendet eine mail an ein veknüpftes email konto
    private fun sendemail(
        headline: String, vorname: String,
        nachname: String, strhausnmr: String, postleit: String, ort: String,
        telefonnummer: String, email: String, spielart: String,
        spieleralle18: String, gewunschtesdatum: String, altdatum: String,
        uhrzeit: String, spieleranzahl: String,
        spielermit: String, spielerausleihen: String,
        weiterefragen: String
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
                    "Vorname: " + vorname + "\n" +
                            "Nachname: " + nachname + "\n" +
                            "Straße und Hausnummer: " + strhausnmr + "\n" +
                            "Postleitzahl: " + postleit + "\n" +
                            "Ort: " + ort + "\n" +
                            "Telefonnumer: " + telefonnummer + "\n" +
                            "Email: " + email + "\n" +
                            "Spielart: " + spielart + "\n" +
                            "Spieler alle 18: " + spieleralle18 + "\n" +
                            "Gewünschtes Datum: " + gewunschtesdatum + "\n" +
                            "Alternatives Datum: " + altdatum + "\n" +
                            "Uhrzeit: " + uhrzeit + "\n" +
                            "Spieleranzahl: " + spieleranzahl + "\n" +
                            "Spieler mit Eigener Ausrüstung: " + spielermit + "\n" +
                            "Spieler ausleihen: " + spielerausleihen + "\n" +
                            "Weitere Fragen: " + weiterefragen + "\n"
                )
                Transport.send(message)
                emailversand.postValue(true)
            } catch (e: Exception) {
                Log.wtf("email", e)
            }
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

        val timeTxt = binding.uhrzeitED
        timeTxt.setText(
            "${numberFormat.format(modifiedHour)}:${numberFormat.format(minute)}-${
                numberFormat.format(
                    modifiedHour + 4
                )
            }:${numberFormat.format(minute)} Uhr"
        )
    }

}
