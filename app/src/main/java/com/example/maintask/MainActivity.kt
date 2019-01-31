package com.example.maintask

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    final val PASS = "saved_pass"
    final val LOGIN = "saved_login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSignIn -> {
                if (etLogin.getText().toString().length == 0) {
                    toast("Login is empty")

                } else if (etPass.getText().toString().length == 0) {
                    toast("Pass is empty")
                } else {
                    toast("Button")
                    if (chbRemember.isChecked) {
                        val login: String = etLogin.text.toString()
                        val pass: String = etPass.text.toString()
                        saveInfo(LOGIN, login)
                        saveInfo(PASS, pass)
                    }
                    val ibtnSignIn: Intent = Intent(this, Second::class.java)
                    startActivity(ibtnSignIn)
                }
            }
            else -> toast("asdasd")
        }
    }

    private fun saveInfo(key: String, value: String) {
        when (key) {
            LOGIN -> {
                val sPref = applicationContext.getSharedPreferences(key, Context.MODE_PRIVATE)
                sPref.edit().putString(key, value).apply()
            }
            PASS -> {
                val sPref = applicationContext.getSharedPreferences(key, Context.MODE_PRIVATE)
                sPref.edit().putString(key, value).apply()
            }
        }
    }

    fun toast(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    private fun loadInfo(key: String): String {
        when (key) {
            LOGIN -> {
                val sPref = applicationContext.getSharedPreferences(key, Context.MODE_PRIVATE)
                return sPref.getString(key, " ")
            }
            PASS -> {
                val sPref = applicationContext.getSharedPreferences(key, Context.MODE_PRIVATE)
                return sPref.getString(key, " ")
            }
        }
        return " "
    }

    override fun onPause() {
        super.onPause()
        etPass.setText(" ")
        etLogin.setText(" ")
    }

    override fun onRestart() {
        super.onRestart()
        etLogin.setText(loadInfo(LOGIN))
        etPass.setText(loadInfo(PASS))
    }

}
