package com.example.passwordmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PasswordAdapter(private var passwords: List<PasswordItem>, private val onDelete: (PasswordItem) -> Unit) :
    RecyclerView.Adapter<PasswordAdapter.PasswordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_password, parent, false)
        return PasswordViewHolder(view)
    }

    override fun onBindViewHolder(holder: PasswordViewHolder, position: Int) {
        val password = passwords[position]
        holder.titleTextView.text = password.title
        holder.loginTextView.text = password.login
        holder.itemView.setOnLongClickListener {
            onDelete(password)
            true
        }
    }

    override fun getItemCount(): Int = passwords.size

    fun updatePasswords(newPasswords: List<PasswordItem>) {
        passwords = newPasswords
        notifyDataSetChanged()
    }

    class PasswordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val loginTextView: TextView = itemView.findViewById(R.id.loginTextView)
    }
}
