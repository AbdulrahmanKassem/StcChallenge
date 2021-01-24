package com.example.stcchallenge.utils

import android.content.Context
import com.example.stcchallenge.models.ResponseListModel
import com.example.stcchallenge.models.Senator
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

object FetchMockData {
    private fun loadJSONFromAssetBy(context: Context): String? {
        val json: String
        try {
            val `is` = context.assets.open("data/Senators.json")

            val size = `is`.available()

            val buffer = ByteArray(size)

            `is`.read(buffer)

            `is`.close()

            json = String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun loadStoreData(context: Context): ArrayList<Senator> {
        val appDataJSON = JSONObject(loadJSONFromAssetBy(context))
        val senators = Gson().fromJson(appDataJSON.toString(), ResponseListModel::class.java)
        return senators.objects?: ArrayList()
    }
}