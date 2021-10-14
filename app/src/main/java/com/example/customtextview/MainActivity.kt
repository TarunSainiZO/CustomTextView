package com.example.customtextview

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import com.example.customtextview.ui.CustomTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<CustomTextView>(R.id.customTextView)
        val header = findViewById<CustomTextView>(R.id.normal)
        val text2 = findViewById<TextView>(R.id.textView2)
        val normal = findViewById<TextView>(R.id.textView)
        val text1 = findViewById<CustomTextView>(R.id.customTextView1)
        var item = 0
        text.setOnClickListener {
            if (item % 2 == 0) {
                text.gravity = Gravity.END
            } else {
                text.gravity = Gravity.START
            }
            item += 1
        }
        var item3 = 0
        text2.setOnClickListener {
            if (item3 % 2 == 0) {
                text2.gravity = Gravity.END
            } else {
                text2.gravity = Gravity.START
            }
            item3 += 1
        }
        var item1 = 0
        normal.setOnClickListener {
            if (item1 % 2 == 0) {
                normal.gravity = Gravity.END
            } else {
                normal.gravity = Gravity.START
            }
            item1 += 1
        }
        var item2 = 0
        text1.setOnClickListener {
            if (item2 % 2 == 0) {
                text1.gravity = Gravity.END
            } else {
                text1.gravity = Gravity.START
            }
            item2 += 1
        }
        var headerItem = 0
        header.setOnClickListener {
            if (headerItem % 2 == 0) {
                text1.setTypeface(text1.typeface, Typeface.NORMAL)
            } else {
                text1.setTypeface(text1.typeface, Typeface.BOLD_ITALIC)
            }
            headerItem += 1
        }

    }
}