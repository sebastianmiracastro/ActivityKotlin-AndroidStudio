package com.example.myapplication

import java.sql.ClientInfoStatus

class OperationsAverage {
    companion object{ var MutableListStudent =arrayListOf<StudentsData>() }

    fun registerStudents(SDS: StudentsData){ MutableListStudent.add(SDS) }

    fun calculateAverage(SDS: StudentsData): Double {
        return (SDS.gradeSt1 + SDS.gradeSt2 + SDS.gradeSt3 + SDS.gradeSt4 + SDS.gradeSt5) / 5
    }

    fun statusStudent(SDS: StudentsData):String{
        var StudentStatus= ""
        if(SDS.averageSubGraStudent > 3.5){
            StudentStatus = "El Estudiante Gano El Año"
        }
        else if(SDS.averageSubGraStudent > 2.5){
            StudentStatus="El Estudiante Puede Recuperar"
        }
        else{
            StudentStatus="El Estudiante Perdio, Pailas Hermano"
        }
        return StudentStatus
    }

    fun ValidateGradeStudent(Number:Double):Boolean{ return Number in 0.0..5.0 }

    fun VGS(SDS: StudentsData):Boolean{
        return ValidateGradeStudent(SDS.gradeSt1) === true && ValidateGradeStudent(SDS.gradeSt2) === true && ValidateGradeStudent(SDS.gradeSt3) === true && ValidateGradeStudent(SDS.gradeSt4) === true && ValidateGradeStudent(SDS.gradeSt5) === true
    }

    fun CountStudentsLists():Int{ return MutableListStudent.count()}

    fun statusGStudents(status:String):Int{
        var countStatus:Int=0
        for (student in MutableListStudent){
            if(student.statusStudent === status){
                countStatus += 1
            }
        }
        return countStatus
    }



}