package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class StatisticsInformationStudents : AppCompatActivity() {

    var seeRegistersStudents: TextView?= null
    var seeWinnerStudents: TextView?= null
    var seeLostStudents: TextView?= null
    var seeRecoverStudents: TextView?= null
    var operations:OperationsAverage?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_information_students)
        getDatas()
    }
    private fun getDatas() {
        val btnClose:Button = findViewById(R.id.btnClose)
        operations = OperationsAverage()

        seeRegistersStudents = findViewById(R.id.txtStudentsRegisers)
        seeWinnerStudents = findViewById(R.id.txtStudentsWin)
        seeLostStudents = findViewById(R.id.txtStudentsLost)
        seeRecoverStudents = findViewById(R.id.txtStudentsRecovery)
        btnClose.setOnClickListener { closeWindows() }

        showAndGetData()
    }
    private fun closeWindows() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun showAndGetData() {
        seeRegistersStudents!!.text = operations!!.CountStudentsLists().toString()
        seeWinnerStudents!!.text = operations!!.statusGStudents("El Estudiante Gano El Año").toString()
        var totalLostSt:Int = operations!!.statusGStudents("El Estudiante Perdio, Pailas Hermano")
        seeLostStudents!!.text = totalLostSt.toString()
        seeRecoverStudents!!.text = operations!!.statusGStudents("El Estudiante Puede Recuperar").toString()
    }
}