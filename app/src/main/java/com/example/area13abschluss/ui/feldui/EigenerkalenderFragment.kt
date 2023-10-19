package com.example.area13abschluss.ui.feldui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.area13abschluss.R
import com.example.area13abschluss.RV.Adapter
import com.example.area13abschluss.databinding.FragmentEigenerkalenderBinding
import com.example.area13abschluss.Viewmodel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class EigenerkalenderFragment : Fragment() {
    lateinit var binding: FragmentEigenerkalenderBinding
    private val adapter: Adapter by lazy { Adapter() }
    private  val adapteralt:Adapter by lazy { Adapter() }
    private val viewModel: Viewmodel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEigenerkalenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        var builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
//            .setSmallIcon(R.drawable.area_13)
//            .setContentTitle(textTitle)
//            .setContentText(textContent)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        binding.backBTN2.setOnClickListener {
            findNavController().navigate(EigenerkalenderFragmentDirections.actionEigenerkalenderFragmentToKalenderFragment())
        }

        binding.activeRV.adapter = adapter
        binding.alteRV.adapter = adapteralt

        viewModel.data
            .observe(
                viewLifecycleOwner
            ) {
                adapter.submitList(it.filter { it.active==true})
                adapteralt.submitList(it.filter { it.active==false}.sortedByDescending { it.datum })
//                viewModel.firstdatenotify.postValue(it.filter { it.active==true }.sortedByDescending { it.datum }.first().datum)
            }

//        val datumString =  viewModel.firstdatenotify.value
//        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
//        val datum = LocalDate.parse(datumString, formatter)
//        val neuesDatum = datum.minusDays(1)
//        val neuerDatumString = neuesDatum.format(formatter)
//        if (viewModel.datum() ==  neuerDatumString)
//        {
//            Toast.makeText(requireContext(), "niceDatum", Toast.LENGTH_SHORT).show()
//        }

    }

}




//private fun createNotificationChannel() {
//    // Create the NotificationChannel, but only on API 26+ because
//    // the NotificationChannel class is not in the Support Library.
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        val name = getString(R.string.channel_name)
//        val descriptionText = getString(R.string.channel_description)
//        val importance = NotificationManager.IMPORTANCE_DEFAULT
//        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
//            description = descriptionText
//        }
//        // Register the channel with the system.
//        val notificationManager: NotificationManager =
//            getSystemService(this.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)
//    }
//}