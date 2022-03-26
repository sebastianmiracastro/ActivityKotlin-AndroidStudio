package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnNewStudent:Button = findViewById(R.id.MoreStudent)

        BtnNewStudent.setOnClickListener { AddNewStudentToList() }

        val BtnSeeStadistic:Button = findViewById(R.id.SeeStudents)

        BtnSeeStadistic.setOnClickListener { SeeStudentToList() }

        val BtnSeeInfoApp: Button = findViewById(R.id.AppInfo)

        BtnSeeInfoApp.setOnClickListener { SeeInfoApp() }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Bienvenido a la pagina principal!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Aplicación Cerrada, Adios!", Toast.LENGTH_SHORT).show()
    }

    private fun AddNewStudentToList() {
        val intent = Intent(this, NewStudentToList::class.java)
        startActivity(intent)
    }

    private fun SeeStudentToList() {
        val intent = Intent(this, StatisticsInformationStudents::class.java)
        startActivity(intent)
    }

    private fun SeeInfoApp() {
        val intent = Intent(this, InfoApp::class.java)
        startActivity(intent)
    }
}
