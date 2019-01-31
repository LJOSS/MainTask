package com.example.maintask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AlertDialog

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val mAlertDialog = AlertDialog.Builder(this)
        mAlertDialog.setTitle("Back?")
        mAlertDialog.setMessage("Do you want get out?!")
        mAlertDialog.setPositiveButton("Yes") { dialog, id -> finish() }
        mAlertDialog.setNegativeButton("NO") { dialog, id -> }
        mAlertDialog.show()
    }
}
