package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.login.data.User
import com.example.login.data.Appdatabase
import android.widget.Toast
import android.content.Intent
import androidx.room.Room
import java.util.regex.Matcher
import java.util.regex.Pattern



class Signup : AppCompatActivity() {
    private lateinit var signUpUsername: EditText
    private lateinit var signUpPassword: EditText
    private lateinit var signUpBtn: Button
    private lateinit var signUpToLogIn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        supportActionBar?.setTitle("Sign Up")
        signUpUsername = findViewById(R.id.signUpUsername)
        signUpPassword = findViewById(R.id.signUpPassword)
        signUpToLogIn = findViewById(R.id.signUpToLogIn)
        signUpBtn = findViewById(R.id.signUpBtn)

        val db = Room.databaseBuilder(
            applicationContext,
            Appdatabase::class.java, "User"
        ).allowMainThreadQueries().build()
        val userDao = db.userDao()

        signUpBtn.setOnClickListener{
            if(signUpPassword.text.toString().length < 8 &&
                    !isValidPassword(signUpPassword.text.toString())){
                Toast.makeText(baseContext, "Invalid Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val newUser = User(signUpUsername.text.toString(), signUpPassword.text.toString())
                userDao.insert(newUser)
                Toast.makeText(baseContext, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            }
        }

        signUpToLogIn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun isValidPassword(password: String?): Boolean{
        val pattern: Pattern
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&*+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }
}