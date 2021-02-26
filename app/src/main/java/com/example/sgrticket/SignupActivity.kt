package com.example.sgrticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sgrticket.databinding.ActivityLoginBinding
import com.example.sgrticket.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignUp.setOnClickListener {
            val signUpPage = Intent(applicationContext, MainActivity:: class.java)
            startActivity(signUpPage)
        }
        binding.txtLogin.setOnClickListener{
            val loginPage = Intent(applicationContext, LoginActivity:: class.java)
            startActivity(loginPage)
        }
    }
}