package com.example.passwordmanager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

data class PasswordItem(val title: String, val login: String, val password: String) {

    companion object {
        private const val PREFS_NAME = "password_manager_prefs"
        private const val PASSWORD_LIST_KEY = "password_list"

        fun savePassword(context: Context, passwordItem: PasswordItem) {
            val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val gson = Gson()
            val passwordList = loadPasswords(context).toMutableList()
            passwordList.add(passwordItem)
            val json = gson.toJson(passwordList)
            prefs.edit().putString(PASSWORD_LIST_KEY, json).apply()
        }

        fun loadPasswords(context: Context): List<PasswordItem> {
            val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val gson = Gson()
            val json = prefs.getString(PASSWORD_LIST_KEY, null)
            val type: Type = object : TypeToken<List<PasswordItem>>() {}.type
            return if (json != null) {
                gson.fromJson(json, type)
            } else {
                emptyList()
            }
        }

        fun deletePassword(context: Context, passwordItem: PasswordItem) {
            val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val gson = Gson()
            val passwordList = loadPasswords(context).toMutableList()
            passwordList.remove(passwordItem)
            val json = gson.toJson(passwordList)
            prefs.edit().putString(PASSWORD_LIST_KEY, json).apply()
        }
    }
}
