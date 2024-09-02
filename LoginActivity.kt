package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val numberEditText: EditText = findViewById(R.id.editTextNumber2)
        val nextButton: Button = findViewById(R.id.button2)

        nextButton.setOnClickListener {
            val enteredNumber = numberEditText.text.toString()
            if (enteredNumber.length != 10) {
                Toast.makeText(this, "Please enter a valid 10-digit number", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, VerifyActivity::class.java)
                intent.putExtra("PHONE_NUMBER", enteredNumber)
                startActivity(intent)
            }
        }
    }
}
