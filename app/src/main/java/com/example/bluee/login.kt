package com.example.bluee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    lateinit var Txt_gotosignup:TextView
    lateinit var Edt_email:EditText
    lateinit var Edt_pass:EditText
    lateinit var Btn_login:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Txt_gotosignup=findViewById(R.id.blueeTextView)
        Edt_email=findViewById(R.id.emailEditText)
        Edt_pass=findViewById(R.id.passwordEditText)
        Btn_login=findViewById(R.id.loginButton)

        Txt_gotosignup.setOnClickListener {
            val intent=Intent(this,signup::class.java)
            startActivity(intent)
        }

    }
}