package com.example.tugasfundamentalandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etemail: EditText
    private lateinit var etpassword: EditText
    private lateinit var history: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
            history.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        history = findViewById(R.id.tv_history)
        etemail = findViewById(R.id.edt_email)
        etpassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if (bundle != null) {
            etemail.setText(bundle.getString("email"))
            etpassword.setText(bundle.getString("password"))
        }

        val buttonlog: Button = findViewById(R.id.btn_login)
        buttonlog.setOnClickListener(this)
    }

    override fun onClick(x: View) {
        when(x.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("user", user(etemail.text.toString(),etpassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}