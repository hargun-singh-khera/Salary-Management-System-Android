package com.example.salarymanagementsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity8 : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var pass: EditText
    lateinit var save: Button
    lateinit var signIn:Button
    lateinit var get:Button
    lateinit var sharedPreferences: SharedPreferences
    val Name = "nameKey"
    val Pass = "passKey"
    var is_login = "login"
    val myFile = "myProfile"
    var username = ""
    var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        name = findViewById(R.id.etName)
        pass = findViewById(R.id.etPass)

        signIn = findViewById(R.id.SignIn)
        get = findViewById(R.id.btnGet)


        val n = name.text.toString()
//        val e = pass.text.toString()
        sharedPreferences = getSharedPreferences(myFile , Context.MODE_PRIVATE)
        username = sharedPreferences.getString(Name,"").toString()
        password = sharedPreferences.getString(Pass , "" ).toString()
//        Toast.makeText(this, username + password, Toast.LENGTH_SHORT).show()

        val is_loggedin = sharedPreferences.getString(is_login , "" )
        if(is_loggedin == "true"){
            Toast.makeText(this, "already logged in", Toast.LENGTH_SHORT).show()
//            var int = Intent(this,Main_screen::class.java);
//            startActivity(int);
        }
    }

    fun SignUp(v:View){
//
//        val l = "true";
//        val editor = sharedPreferences.edit()
//        editor.putString(Name , n)
//        editor.putString(Pass , e)
//        editor.putString(is_login, l)
//
//        editor.apply()
//        Toast.makeText(this , "Logged in successfull" , Toast.LENGTH_SHORT).show()
//signup
        var int = Intent(this,MainActivity9::class.java);
        startActivity(int);
    }

    fun Login(v:View){
//        mainscreen
        var int = Intent(this,MainActivity2::class.java);

        val n = name.text.toString()
        val e = pass.text.toString()

        if(username == n && password == e){
            val editor = sharedPreferences.edit()
            editor.putString(is_login , "true")
            editor.apply()
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            startActivity(int)
        }
        else{
            Toast.makeText(this, "Incorrect Id or Password", Toast.LENGTH_SHORT).show()
        }


    }

    fun get(v: View){
        sharedPreferences = getSharedPreferences(myFile , Context.MODE_PRIVATE)
        name.setText(sharedPreferences.getString(Name,""))
        pass.setText(sharedPreferences.getString(Pass , "" ))
    }

}