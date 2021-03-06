package com.fraxinus.homeiot

import android.os.AsyncTask
import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONObject


class codeSend : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg p0: String?): String? {
        val url = "https://ns-bifrost.ml:50351/commandExecute/"
        //val url = "https://192.168.1.210:50351/commandExecute/"
        val client: OkHttpClient = OkHttpClient()

        // create json
        val json = JSONObject()
        json.put("target", p0[0])
        json.put("cmd", p0[1])
        json.put("key", "authkey")

        var response: Response? = null

        try {
            // post
            val postBody = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json.toString())
            val request: Request = Request.Builder().url(url).post(postBody).build()
            response = client.newCall(request).execute()

            // getResult
            val result: String? = response.body?.string()
            response.close()
        } catch (e: Exception) {
            Log.d("exeption", "not connection")
            Log.d("err", e.toString())
            response?.close()
        } finally {
            response?.close()
        }

        return "complete"
    }

}

class sendTimer : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg p0: String?): String? {
        val url = "https://ns-bifrost.ml:50351/alarmConfig/"
        //val url = "https://192.168.1.210:50351/commandExecute/"
        val client: OkHttpClient = OkHttpClient()

        // create json
        val target = JSONObject()
        target.put("year", p0[0])
        target.put("month", p0[1])
        target.put("day", p0[2])
        target.put("hour", p0[3])
        target.put("minute",p0[4])
        val json = JSONObject()
        json.put("state", p0[5])
        json.put("target", target.toString())
        json.put("key", "authkey")

        var response: Response? = null

        try {
            // post
            val postBody = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json.toString())
            val request: Request = Request.Builder().url(url).post(postBody).build()
            response = client.newCall(request).execute()

            // getResult
            val result: String? = response.body?.string()
            response.close()
        } catch (e: Exception) {
            Log.d("exeption", "not connection")
            Log.d("err", e.toString())
            response?.close()
        } finally {
            response?.close()
        }

        Log.d("sendTimer", json.toString())

        return "complete"
    }
}