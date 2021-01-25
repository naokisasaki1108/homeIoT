package com.fraxinus.homeiot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var sendCommand: codeSend? = null

        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
        }


        lightON.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("light","on")
        }
        lightOFF.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("light","off")
        }
        airAUTO.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("air","auto")
        }
        airSTOP.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("air","stop")
        }
        airDRY.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("air","dry")
        }
        airCLOD.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("air","cold")
        }
        airHOT.setOnClickListener {
            sendCommand = codeSend()
            sendCommand?.execute("air","hot")
        }

        timer.setOnClickListener {
            startActivity(Intent(this,TimerActivity::class.java))
        }

        returnButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, ResultActivity::class.java))
    }
}