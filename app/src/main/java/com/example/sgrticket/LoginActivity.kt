package com.example.sgrticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sgrticket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            val drawerNavigator = Intent(applicationContext, MainActivity:: class.java)
            startActivity(drawerNavigator)
        }

        binding.txtSignUp.setOnClickListener{
            val signUpNavigator = Intent(applicationContext,SignupActivity::class.java)
            startActivity(signUpNavigator)
        }
    }
}