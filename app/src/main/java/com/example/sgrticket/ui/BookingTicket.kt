package com.example.sgrticket.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.sgrticket.MainActivity
import com.example.sgrticket.R
import com.example.sgrticket.databinding.ActivityBookingTicketBinding
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

private lateinit var binding: ActivityBookingTicketBinding

class BookingTicket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_ticket)

        binding = ActivityBookingTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    companion object{
        class SignUpAsyncTask internal constructor(context: Context) : AsyncTask<String, String, String>() {
            lateinit var con: HttpURLConnection
            lateinit var resulta:String
            val builder = Uri.Builder()
            private val cont: Context =context

            override fun onPreExecute() {
                super.onPreExecute()
                val phone: String = binding.txtPhone.text.toString()
                val source: String = binding.txtCurrentLocation.text.toString()
                val destination: String = binding.txtDestination.text.toString()
                val tdatetime: String = binding.txtTravelDate.text.toString()

                val progressBar= ProgressBar(cont)
                progressBar.isIndeterminate=true
                progressBar.visibility= View.VISIBLE
                builder .appendQueryParameter("source", source)
                builder .appendQueryParameter("phone", phone)
                builder .appendQueryParameter("destination", destination)
                builder .appendQueryParameter("tdatetime", tdatetime)
            }

            override fun doInBackground(vararg params: String?):  String? {
                try {

                    var query = builder.build().encodedQuery
                    val url: String = "https://ridiculous-successe.000webhostapp.com/sgrTicket/allTickets.php"
                    val obj = URL(url)
                    con = obj.openConnection() as HttpURLConnection
                    con.setRequestMethod("POST")
                    con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)")
                    con.setRequestProperty("Accept-Language", "UTF-8")
                    con.setDoOutput(true)
                    val outputStreamWriter = OutputStreamWriter(con.getOutputStream())
                    outputStreamWriter.write(query)
                    outputStreamWriter.flush()
                    Log.e("pass 1", "connection success ")
                } catch (e: Exception) {
                    Log.e("Fail 1", e.toString())
                }
                try {
                    resulta = con.inputStream.bufferedReader().readText()
                    Log.e("data", resulta)
                } catch (e: java.lang.Exception) {
                    Log.e("Fail 2", e.toString())
                }
                return resulta;
            }
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)

                var jsonData = JSONObject(resulta)
                val code: Int = jsonData.getInt("code")
                Log.e("data",code.toString())
                if (code == 1) {
                    //val com: JSONArray = json_data.getJSONArray("userdetails")
                    //val comObject = com[0] as JSONObject
                    //Log.e("data",""+comObject.optString("fname"))

                    val toMain = Intent(cont, MainActivity::class.java)
                    toMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    cont.startActivity(toMain)

                }
            }
        }

    }
}



