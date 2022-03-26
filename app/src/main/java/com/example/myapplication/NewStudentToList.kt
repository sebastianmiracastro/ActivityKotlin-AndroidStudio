package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewStudentToList : AppCompatActivity() {

    /*Information Student*/
    var documentStudent: EditText?= null
    var nameStudent: EditText?= null
    var ageStudent: EditText?= null
    var addressStudent: EditText?= null
    var phoneStudent: EditText?= null

    /*Subject and Gradle Student*/
    var sject1Student: EditText?= null
    var sject2Student: EditText?= null
    var sject3Student: EditText?= null
    var sject4Student: EditText?= null
    var sject5Student: EditText?= null

    var grade1Student: EditText?= null
    var grade2Student: EditText?= null
    var grade3Student: EditText?= null
    var grade4Student: EditText?= null
    var grade5Student: EditText?= null

    var operation: OperationsAverage?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student_to_list)

        getDataSt()
    }
    private fun getDataSt() {
        operation= OperationsAverage()

        /*Get Perosnal Information Student Layout*/
        documentStudent = findViewById(R.id.txtDocumentStudent)
        nameStudent = findViewById(R.id.txtNameStudent)
        ageStudent = findViewById(R.id.txtAgeStudent)
        phoneStudent = findViewById(R.id.txtPhoneStudent)
        addressStudent = findViewById(R.id.txtAddressStudent)

        /*Get Grade and Subject Information Student*/
        sject1Student = findViewById(R.id.subjet1)
        sject2Student = findViewById(R.id.subjet2)
        sject3Student = findViewById(R.id.subjet3)
        sject4Student = findViewById(R.id.subjet4)
        sject5Student = findViewById(R.id.subjet5)

        grade1Student = findViewById(R.id.grade1)
        grade2Student = findViewById(R.id.grade2)
        grade3Student = findViewById(R.id.grade3)
        grade4Student = findViewById(R.id.grade4)
        grade5Student = findViewById(R.id.grade5)

        val btnCalculateAverage:Button = findViewById(R.id.btnCalculateAverage)

        btnCalculateAverage.setOnClickListener { NewStudentRegister() }

    }
    private fun NewStudentRegister() {
        var SDS:StudentsData = StudentsData()

        if (documentStudent?.text.toString() == "" || nameStudent?.text.toString() == "" || ageStudent?.text.toString() == "" || addressStudent?.text.toString() == "" || phoneStudent?.text.toString() == "" || sject1Student?.text.toString() == "" || sject2Student?.text.toString() == "" || sject3Student?.text.toString() == "" || sject4Student?.text.toString() == "" || sject5Student?.text.toString() == "" || grade1Student?.text.toString() == "" || grade2Student?.text.toString() == "" || grade3Student?.text.toString() == "" || grade4Student?.text.toString() == "" || grade5Student?.text.toString() == "") {
            Toast.makeText(this, "Es Necesario Que LLene Todo Los Campos, Hagalo", Toast.LENGTH_LONG).show()
        } else{
            /*Personal Information Student*/
            SDS.documentSt = documentStudent?.text.toString()
            SDS.nameSt = nameStudent?.text.toString()
            SDS.ageSt = ageStudent?.text.toString().toInt()
            SDS.addressSt = addressStudent?.text.toString()
            SDS.phoneSt = phoneStudent?.text.toString()

            /*Subject And Grade Student*/
            SDS.subjectSt1 = sject1Student?.text.toString()
            SDS.subjectSt2 = sject2Student?.text.toString()
            SDS.subjectSt3 = sject3Student?.text.toString()
            SDS.subjectSt4 = sject4Student?.text.toString()
            SDS.subjectSt5 = sject5Student?.text.toString()

            SDS.gradeSt1 = grade1Student?.text.toString().toDouble()
            SDS.gradeSt2 = grade2Student?.text.toString().toDouble()
            SDS.gradeSt3 = grade3Student?.text.toString().toDouble()
            SDS.gradeSt4 = grade4Student?.text.toString().toDouble()
            SDS.gradeSt5 = grade5Student?.text.toString().toDouble()

            /*Average And Status*/
            SDS.averageSubGraStudent = operation!!.calculateAverage(SDS)

            SDS.statusStudent = operation!!.statusStudent(SDS)

            if (operation?.VGS(SDS) === true) {
                operation?.registerStudents(SDS)
                sendObjOtherActivity(SDS)

                Toast.makeText(this, "Datos Ingresador Con Exito", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese Las Notas Con Un Total De 0 a 5", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun sendObjOtherActivity(SDS:StudentsData){
        val intent = Intent(this, InfoStudentData::class.java)
        val bundleInfoUser: Bundle = Bundle()

        bundleInfoUser.putString("name", SDS.nameSt)
        bundleInfoUser.putString("suject1", SDS.subjectSt1)
        bundleInfoUser.putString("suject2", SDS.subjectSt2)
        bundleInfoUser.putString("suject3", SDS.subjectSt3)
        bundleInfoUser.putString("suject4", SDS.subjectSt4)
        bundleInfoUser.putString("suject5", SDS.subjectSt5)

        bundleInfoUser.putDouble("grade1", SDS.gradeSt1)
        bundleInfoUser.putDouble("grade2", SDS.gradeSt2)
        bundleInfoUser.putDouble("grade3", SDS.gradeSt3)
        bundleInfoUser.putDouble("grade4", SDS.gradeSt4)
        bundleInfoUser.putDouble("grade5", SDS.gradeSt5)

        bundleInfoUser.putDouble("average", SDS.averageSubGraStudent)
        bundleInfoUser.putString("statusInfo", SDS.statusStudent)

        intent.putExtras(bundleInfoUser)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Aqui puedes añadir un nuevo estudiante!", Toast.LENGTH_SHORT).show()
    }


}