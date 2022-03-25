package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class InfoStudentData : AppCompatActivity() {

    /*Information Student*/
    var nameStudent: TextView?= null

    /*Subject and Gradle Student*/
    var sject1Student: TextView?= null
    var sject2Student: TextView?= null
    var sject3Student: TextView?= null
    var sject4Student: TextView?= null
    var sject5Student: TextView?= null

    var grade1Student: TextView?= null
    var grade2Student: TextView?= null
    var grade3Student: TextView?= null
    var grade4Student: TextView?= null
    var grade5Student: TextView?= null

    /*Status and Average*/
    var averageStudent: TextView?= null

    var statusStudent: TextView?= null

    /*Operation*/
    var operations:OperationsAverage?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_student_data)

        getData()
    }
    private fun getData(){
        operations = OperationsAverage()

        /*Name Student*/
        nameStudent = findViewById(R.id.txtNameSt)

        /*Subject and Grade*/
        sject1Student = findViewById(R.id.txtSBS1)
        sject2Student = findViewById(R.id.txtSBS2)
        sject3Student = findViewById(R.id.txtSBS3)
        sject4Student = findViewById(R.id.txtSBS4)
        sject5Student = findViewById(R.id.txtSBS5)

        grade1Student = findViewById(R.id.txtGDSt1)
        grade2Student = findViewById(R.id.txtGDSt2)
        grade3Student = findViewById(R.id.txtGDSt3)
        grade4Student = findViewById(R.id.txtGDSt4)
        grade5Student = findViewById(R.id.txtGDSt5)

        /*Average And Status*/
        averageStudent = findViewById(R.id.txtAverageSt)

        statusStudent = findViewById(R.id.txtStatusSt)

        showData()

        val btnCloseWindows:Button = findViewById(R.id.btnCloseWindows)
        btnCloseWindows.setOnClickListener { CloseWindows() }
    }
    private fun CloseWindows() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun showData(){
        var bundleGet:Bundle? = this.intent.extras

        if (bundleGet!=null){
            /*Get Name*/
            nameStudent!!.text = "${bundleGet.get("name")}"

            /*Get Subject and Grade*/
            sject1Student!!.text = "${bundleGet.get("suject1")}"
            sject2Student!!.text = "${bundleGet.get("suject2")}"
            sject3Student!!.text = "${bundleGet.get("suject3")}"
            sject4Student!!.text = "${bundleGet.get("suject4")}"
            sject5Student!!.text = "${bundleGet.get("suject5")}"

            grade1Student!!.text = "${bundleGet.get("grade1")}"
            grade2Student!!.text = "${bundleGet.get("grade2")}"
            grade3Student!!.text = "${bundleGet.get("grade3")}"
            grade4Student!!.text = "${bundleGet.get("grade4")}"
            grade5Student!!.text = "${bundleGet.get("grade5")}"

            /*Average and Status*/
            averageStudent!!.text = "${bundleGet.get("average")}"
            statusStudent!!.text = "${bundleGet.get("statusInfo")}"
        }
    }
}