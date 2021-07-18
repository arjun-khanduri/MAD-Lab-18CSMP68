package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.login.data.Appdatabase
import android.widget.Toast
import android.content.Intent
import androidx.room.Room


class Login : AppCompatActivity() {
    private lateinit var logInUsername: EditText
    private lateinit var logInPassword: EditText
    private lateinit var logInToSignup: Button
    private lateinit var logInBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        supportActionBar?.setTitle("Log In")

        logInUsername = findViewById(R.id.loginusername)
        logInPassword = findViewById(R.id.loginpassword)
        logInToSignup = findViewById(R.id.signupbutton)
        logInBtn = findViewById(R.id.loginbtn)

        val db = Room.databaseBuilder(
            applicationContext,
            Appdatabase::class.java, "User"
        ).allowMainThreadQueries().build()
        val userDao = db.userDao()

        logInBtn.setOnClickListener {
            val tempUser = userDao.getUser(logInUsername.text.toString())
            if (tempUser.password.equals(logInPassword.text.toString()))
                Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(baseContext, "Invalid Username or Password", Toast.LENGTH_SHORT)
                    .show()
        }

        logInToSignup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }


}