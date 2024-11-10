package com.example.passwordmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var passwordAdapter: PasswordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pinCodeTextView: TextView = findViewById(R.id.pinCodeTextView)
        pinCodeTextView.setOnClickListener {
            startActivity(Intent(this, PinCodeActivity::class.java))
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val passwords = PasswordItem.loadPasswords(this)
        passwordAdapter = PasswordAdapter(passwords) { passwordItem ->
            PasswordItem.deletePassword(this, passwordItem)
            passwordAdapter.updatePasswords(PasswordItem.loadPasswords(this))
        }

        recyclerView.adapter = passwordAdapter

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            startActivity(Intent(this, AddPasswordActivity::class.java))
        }
    }
}
