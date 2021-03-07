package com.fraxinus.homeiot

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.set_date.*
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.Calendar

class TimerActivity : AppCompatActivity() {

    private val c: Calendar = Calendar.getInstance()
    private var setYear = c.get(Calendar.YEAR)
    private var setMonth = c.get(Calendar.MONTH) + 1
    private var setDay = c.get(Calendar.DAY_OF_MONTH)
    private var setHour = 0
    private var setMinute = 0
    private var setTime = FALSE
    var sendCommand: sendTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_date)

        dateView.text = "選択した日付は「${setYear}/${setMonth}/${setDay}」です"

        datePicker.setOnClickListener {
            showDatePicker()
        }
        timePicker.setOnClickListener {
            showTimePicker()
        }
        setTimer.setOnClickListener {
            if (setTime) {
                sendCommand = sendTimer()
                sendCommand!!.execute(setYear.toString(), setMonth.toString(), setDay.toString(), setHour.toString(), "0","on")
                finish()
            }else{
                timeView.text = "ここ入れて"
            }

        }
        cancelTimer.setOnClickListener{
            if (setTime) {
                sendCommand = sendTimer()
                sendCommand!!.execute(setYear.toString(), setMonth.toString(), setDay.toString(), setHour.toString(), "0","off")
                finish()
            }else{
                timeView.text = "ここ入れて"
            }
        }
    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener() {view, year, month, dayOfMonth->
                    dateView.text = "選択した日付は「${year}/${month}/${dayOfMonth}」です"
                    setYear = year
                    setMonth = month + 1
                    setDay = dayOfMonth
                },
                setYear,
                setMonth,
                setDay + 1)
        datePickerDialog.show()
    }

    private fun showTimePicker(){
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeView.text = "選択した時間は「${hourOfDay}:${minute}」です"
                    setHour = hourOfDay
                    setMinute = minute
                    setTime = TRUE
                },
                0,
                0,
                true)
        timePickerDialog.show()
    }

}