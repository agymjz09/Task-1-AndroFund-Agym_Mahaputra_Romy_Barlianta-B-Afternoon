package com.example.tugasfundamentalandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView2)
        val email= intent.getParcelableExtra<user>("user")?.email
        val password = intent.getParcelableExtra<user>("user")?.password
        tv.text = "email : $email dan password : $password"

        val buttonimplicit : Button = findViewById(R.id.btn_implicit)
        buttonimplicit.setOnClickListener(this)

        val btnfragment : Button = findViewById(R.id.btn_fragment)
        btnfragment.setOnClickListener(this)
    }

    override fun onClick(z: View) {
        when (z.id) {
            R.id.btn_implicit -> {
//                val message = "Halo Agym"
////                val intent = Intent()
////                intent.action = Intent.ACTION_SEND
////                intent.putExtra(Intent.EXTRA_TEXT, message)
////                intent.type = "text/plain"
////                startActivity(intent)
                val intent = Intent()
                intent.putExtra("history", "Anda sudah Login")
                setResult(RESULT_OK,intent)
                finish()
            }
        }
        when (z.id) {
            R.id.btn_fragment -> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}