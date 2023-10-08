package com.example.tugasfundamentalandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etemail: EditText
    private lateinit var etpassword: EditText
    private lateinit var etconpassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        etemail = findViewById(R.id.edt_email)
        etpassword = findViewById(R.id.edt_password)
        etconpassword = findViewById(R.id.edt_conpassword)

        val buttonreg: Button = findViewById(R.id.btn_regis)
        buttonreg.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_regis -> {

                val bundle = Bundle()
                bundle.putString("email",etemail.text.toString())
                bundle.putString("Password",etpassword.text.toString())
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}