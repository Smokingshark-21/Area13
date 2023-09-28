package com.example.area13abschluss.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.area13abschluss.R
import com.example.area13abschluss.databinding.FragmentBuchungBinding
import com.example.area13abschluss.ui.feldui.DatePickerFragment
import com.example.area13abschluss.ui.util.emaildata
import kotlinx.coroutines.Runnable
import java.lang.Exception
import java.util.Objects
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import kotlin.concurrent.thread
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class BuchungFragment : Fragment() {

    lateinit var binding: FragmentBuchungBinding

    val spielart = arrayOf("Paintball","Softair")
    val spieler18 = arrayOf("Ja","nein")
    val anzahl = arrayOf("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20")

    val mutableLiveData = MutableLiveData<String>("Area13 Buchung")
    val spielartval = MutableLiveData<String>()
    val spieler18val = MutableLiveData<String>()
    val spielereigen = MutableLiveData<String>()
    val spielerleih = MutableLiveData<String>()

    override fun onResume() {
        super.onResume()

        val spielartAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spielart)
        binding.spielartAuto.setAdapter(spielartAdapter)
        binding.spielartAuto.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielartval.postValue(spielart[position]!!)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spieler18Adapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spieler18)
        binding.spieler18Auto.setAdapter(spieler18Adapter)
        binding.spieler18Auto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spieler18val.postValue(spieler18[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spielereigenausrustungAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.anzahleigenAuto.setAdapter(spielereigenausrustungAdapter)
        binding.anzahleigenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielereigen.postValue(anzahl[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spielerleihAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.ausrStungleihenAuto.setAdapter(spielerleihAdapter)
        binding.ausrStungleihenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielerleih.postValue(anzahl[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
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

        }
        hangar13Btn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 3
            mpCV.strokeWidth = 0
            mutableLiveData.postValue("Hangar13 Buchung")
        }
        mpBtn.setOnClickListener {
            area13CV.strokeWidth = 0
            hangarCV.strokeWidth = 0
            mpCV.strokeWidth = 3
            mutableLiveData.postValue("Megapark Buchung")
        }


        val spielartAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spielart)
        binding.spielartAuto.setAdapter(spielartAdapter)
        binding.spielartAuto.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielartval.postValue(spielart[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spieler18Adapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,spieler18)
        binding.spieler18Auto.setAdapter(spieler18Adapter)
        binding.spieler18Auto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spieler18val.postValue(spieler18[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spielereigenausrustungAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.anzahleigenAuto.setAdapter(spielereigenausrustungAdapter)
        binding.anzahleigenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielereigen.postValue(anzahl[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        val spielerleihAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.ausrStungleihenAuto.setAdapter(spielerleihAdapter)
        binding.ausrStungleihenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spielerleih.postValue(anzahl[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }


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
            val spielart = spielartval.value.toString()
            val spieleralle18 = spieler18val.value.toString()
            val datumprim = binding.primdDateED.text.toString()
            val altdatum = binding.alterdatumED.text.toString()
            val uhrzeit = binding.uhrzeitED.text.toString()
            val spieleranzahl = binding.spieleranzahlED.text.toString()
            val spielerausrustung = spielereigen.value.toString()
            val spielerausleihen = spielerleih.value.toString()
            val weiterfragen = binding.fragenED.text.toString()

            sendemail(mutableLiveData.value.toString(),vorname,nachname,strhausnmr,postleit,ort,telefonnummer,email,
                spielart,spieleralle18,datumprim,
                altdatum,uhrzeit,spieleranzahl,spielerausrustung,spielerausleihen,weiterfragen)
        }


    }

    private fun sendemail(headline:String,vorname:String,
                          nachname:String,strhausnmr:String,postleit:String,ort:String,
                          telefonnummer:String,email:String,spielart:String,
                          spieleralle18:String,gewunschtesdatum:String,altdatum:String,
                          uhrzeit:String,spieleranzahl:String,
                          spielermit:String,spielerausleihen:String,
                          weiterefragen:String) {
        val emaildata = emaildata()
        val properties = System.getProperties()
        properties.put("mail.smtp.host",emaildata.Gmail_Host)
        properties.put("mail.smtp,port","465")
        properties.put("mail.smtp.ssl.enable","true")
        properties.put("mail.smtp.auth","true")

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(
                    emaildata.Sender_Email_Adress,
                    emaildata.Sender_Email_Password
                )
            }
        })
        val message:MimeMessage = MimeMessage(session)

        thread{
            try {
                val recipientEmail = InternetAddress(emaildata.Reciver_Email_Adress)
                message.addRecipient(Message.RecipientType.TO, recipientEmail)
                message.setSubject(headline)
                message.setText(
                            "Vorname: "+vorname+"\n"+
                            "Nachname: "+nachname+"\n"+
                            "Straße und Hausnummer: "+strhausnmr+"\n"+
                            "Postleitzahl: "+postleit+"\n"+
                            "Ort: "+ort+"\n"+
                            "Telefonnumer: "+telefonnummer+"\n"+
                                    "Email: "+email+"\n"+
                            "Spielart: "+spielart+"\n"+
                            "Spieler alle 18: "+spieleralle18+"\n"+
                            "Gewünschtes Datum: "+gewunschtesdatum+"\n"+
                            "Alternatives Datum: "+altdatum+"\n"+
                            "Uhrzeit: "+uhrzeit+"\n"+
                            "Spieleranzahl: "+spieleranzahl+"\n"+
                            "Spieler mit Eigener Ausrüstung: "+spielermit+"\n"+
                            "Spieler ausleihen: "+spielerausleihen+"\n"+
                            "Weitere Fragen: "+weiterefragen+"\n"
                )
                Transport.send(message)
            }catch (e:Exception){
                    Log.wtf("email",e)
            }
        }
    }


}