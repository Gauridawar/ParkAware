package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VerifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify)

        val nextButton: Button = findViewById(R.id.button3)

        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")

        nextButton.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            intent.putExtra("PHONE_NUMBER", phoneNumber)
            startActivity(intent)
        }
    }
}
