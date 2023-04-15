package com.example.sms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPhoneNo : EditText =findViewById(R.id.pttext1)
        val etMessage : EditText =findViewById(R.id.pttext2)
        val btSend : Button = findViewById(R.id.btbutton)

        //Android 10 and above -needs permission evert time we need to send a message

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 10)

        btSend.setOnClickListener(){

            var phoneNo = etPhoneNo.text.toString()
            var message = etMessage.text.toString()

            val smsManager : SmsManager
            smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo, null, message, null, null )



        }
    }
}