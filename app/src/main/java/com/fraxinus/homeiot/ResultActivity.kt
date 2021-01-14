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

        var sendCommand: PostAsyncTask? = null

        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
        }


        lightON.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("light","on")
        }
        lightOFF.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("light","off")
        }
        airAUTO.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("air","auto")
        }
        airSTOP.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("air","stop")
        }
        airDRY.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("air","dry")
        }
        airCLOD.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("air","cold")
        }
        airHOT.setOnClickListener {
            sendCommand = PostAsyncTask()
            sendCommand?.execute("air","hot")
        }

        returnButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, ResultActivity::class.java))
    }
}