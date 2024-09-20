package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName=findViewById<EditText>(R.id.et_name)
        val btnStart=findViewById<Button>(R.id.btn_start)

        btnStart.setOnClickListener {
            if(etName.text.isEmpty()){
                Toast.makeText(this,"Please enter you name!",Toast.LENGTH_LONG).show()
            }
            else{
                val intent=Intent(this,QuizQuestionAcitivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString()) //passing some extra information with intent to the intended screen
                startActivity(intent)
                finish()
            }
        }
    }
}