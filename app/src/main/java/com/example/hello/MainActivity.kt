package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etComfirmPassword: TextInputEditText
    lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            clearErrors()
            validateSignUp()

        }
    }

    fun castViews() {
        tvLogin = findViewById(R.id.tvLogin)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etComfirmPassword = findViewById(R.id.etComfirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)


    }

    fun validateSignUp() {
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmation = etComfirmPassword.text.toString()
        var error = false

        if (firstName.isBlank()) {

            tilFirstName.error = "First name is required"
            error = true
        }
        if (lastName.isBlank()) {
            tilLastName.error = "Last name is required"
            error = true


        }
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error = true


        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
            error = true


        }
        if (confirmation.isBlank()) {
            tilConfirmPassword.error = "Confirmation of email is required"
            error = true


        }
        if (password != confirmation) {
            tilConfirmPassword.error = "Password and confirmation do not match"
            error = true


        }
        if (!error) {
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG).show()

        }
    }

    private fun clearErrors() {
        tilFirstName.error = null
        tilLastName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null

    }

}