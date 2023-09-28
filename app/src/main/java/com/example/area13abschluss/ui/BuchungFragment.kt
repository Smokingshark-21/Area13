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
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(),"selected player is= "+spielart[position],Toast.LENGTH_SHORT).show()
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
        binding.spielartAuto.setAdapter(spielartAdapter)
        binding.spielartAuto.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
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
        binding.spieler18Auto.setAdapter(spieler18Adapter)
        binding.spieler18Auto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
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

        val spielereigenausrustungAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.anzahleigenAuto.setAdapter(spielereigenausrustungAdapter)
        binding.anzahleigenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
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

        val spielerleihAdapter = ArrayAdapter<String>(requireContext(), R.layout.spinner_text,anzahl)
        binding.ausrStungleihenAuto.setAdapter(spielerleihAdapter)
        binding.ausrStungleihenAuto.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
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

        val sendrpass = "idws socj pcmm ixdb"

        binding.button.setOnClickListener {

            sendemail("test1","test2","test3")
        }


    }

    private fun sendemail(n_:String,t_:String,tt_:String) {
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
                message.setSubject(t_)
                message.setText("From: "+n_+"\n"+"Text: "+tt_)
                Transport.send(message)
            }catch (e:Exception){
                    Log.wtf("email",e)
            }
        }
    }


}