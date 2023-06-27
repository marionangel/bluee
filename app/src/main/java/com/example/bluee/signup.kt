package com.example.bluee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class signup : AppCompatActivity() {
    lateinit var Txt_login:TextView
    lateinit var Edt_name:EditText
    lateinit var Edt_mail:EditText
    lateinit var Edt_pass:EditText
    lateinit var Edt_confirm:EditText
    lateinit var Btn_reg:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        Txt_login=findViewById(R.id.T_join)
        Edt_name=findViewById(R.id.username_edittext)
        Edt_mail=findViewById(R.id.email_edittext)
        Edt_pass=findViewById(R.id.password_edittext)
        Edt_confirm=findViewById(R.id.Edt_conpass)
        Btn_reg=findViewById(R.id.btnReg)
        auth = Firebase.auth
        Txt_login.setOnClickListener {
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }
        Btn_reg.setOnClickListener {
            signupuser()
        }
    }
    private fun signupuser(){
        val email=Edt_mail.text.toString()
        val pass=Edt_pass.text.toString()
        val conpass=Edt_confirm.text.toString()
        if (email.isBlank()||pass.isBlank()||conpass.isBlank()){
            Toast.makeText(this,"Password and email can't be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass !=conpass){
            Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show()

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up successfully",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }
        }
    }
}