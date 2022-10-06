package com.example.kotlinnum1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.service.autofill.TextValueSanitizer
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tvCount: TextView? = null
    private var btnPlus: Button? = null
    private var count = 0
    private var boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCount = findViewById(R.id.tv_counter)
        btnPlus = findViewById(R.id.btn_plus)
        initListener()
    }

    private fun initListener() {
        btnPlus?.setOnClickListener {
            if (boolean) {
                count++
                tvCount?.text = count.toString()

            }
            if (count == 11) {
                boolean = false
                btnPlus!!.text = "-1"
            }
            if (!boolean) {
                count--
                tvCount?.text = count.toString()
                if (count == 0) {
                    val intent = Intent(this, Second_Activity::class.java)
                    startActivity(intent)
                }
            }

        }
    }
}