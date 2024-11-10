package com.example.passwordmanager

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PinCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_code)

        val pinCodeEditText: EditText = findViewById(R.id.pinCodeEditText)
        val enterButton: Button = findViewById(R.id.enterButton)

        enterButton.setOnClickListener {
            val pinCode = pinCodeEditText.text.toString()
            if (pinCode == "1234") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Неверный пин-код", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
