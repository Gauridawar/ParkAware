package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user)

        val phoneEditText: EditText = findViewById(R.id.editTextPhone)
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val stateEditText: EditText = findViewById(R.id.editTextText3)
        val cityEditText: EditText = findViewById(R.id.editTextText2)
        val nextButton: Button = findViewById(R.id.button4)

        // Retrieve phone number from Intent
        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")

        if (phoneNumber != null && phoneNumber.length == 10) {
            // Autofill phone number
            phoneEditText.setText(phoneNumber)
        } else {
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
        }

        nextButton.setOnClickListener {
            // Retrieve user input
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val state = stateEditText.text.toString().trim()
            val city = cityEditText.text.toString().trim()

            // Validate fields
            if (name.isEmpty() || email.isEmpty() || state.isEmpty() || city.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            } else {
                // Create an Intent to start HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
