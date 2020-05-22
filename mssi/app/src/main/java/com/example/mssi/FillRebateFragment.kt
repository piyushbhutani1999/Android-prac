package com.example.mssi

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class FillRebateFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_fill_rebate, container, false)

        val btn_calendar : Button = view.findViewById(R.id.btn_calendar)
        btn_calendar.setOnClickListener {
            displayDatePicker(view)
        }

        return view
    }


    private fun displayDatePicker(view : View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val date = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
                Toast.makeText(requireContext(), "fdfdfd", Toast.LENGTH_SHORT).show()
                 callDashboard(dayOfMonth, month, year)
        }, year, month, date).show()


    }

    private fun callDashboard(dayOfMonth: Int, month1: Int, year: Int) {
       // var bundle : Bundle = Bundle()
        var date : String = "$dayOfMonth/$month1/$year"
       // bundle.putString("Date", date)
       // DashboardFragment().arguments = bundle

        MainActivity().returnToDashBoard()
    }


}
