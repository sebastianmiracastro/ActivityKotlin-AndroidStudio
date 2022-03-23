package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class NewStudentToList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student_to_list)
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Aqui puedes añadir un nuevo estudiante!", Toast.LENGTH_SHORT).show()
    }
}