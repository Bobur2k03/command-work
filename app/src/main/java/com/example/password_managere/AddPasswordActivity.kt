package com.example.passwordmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddPasswordActivity : AppCompatActivity() {

    @Override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_password)

        val titleEditText: EditText = findViewById(R.id.titleEditText)
        val loginEditText: EditText = findViewById(R.id.loginEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (title.isNotEmpty() && login.isNotEmpty() && password.isNotEmpty()) {
                val passwordItem = PasswordItem(title, login, password)
                PasswordItem.savePassword(this, passwordItem)
                Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
