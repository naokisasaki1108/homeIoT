package com.fraxinus.homeiot

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.set_date.*
import java.util.Calendar

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_date)

        datePicker.setOnClickListener {
            showDatePicker()
        }
        timePicker.setOnClickListener {
            showTimePicker()
        }
    }

    private fun showDatePicker() {
        val c = Calendar.getInstance()
        val nowYear = c.get(Calendar.YEAR)
        val nowMonth = c.get(Calendar.MONTH)
        val nowDay = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener() {view, year, month, dayOfMonth->
                    dateView.text = "選択した日付は「${year}/${month + 1}/${dayOfMonth}」です"
                },
                nowYear,
                nowMonth,
                nowDay + 1)
        datePickerDialog.show()
    }

    private fun showTimePicker(){
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeView.text = "選択した時間は「${hourOfDay}:${minute}」です"
                },
                0,
                0,
                true)
        timePickerDialog.show()
    }

}