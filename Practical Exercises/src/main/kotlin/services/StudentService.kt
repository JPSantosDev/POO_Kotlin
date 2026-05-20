package org.example.services

import org.example.model.Student

class StudentService {

    private val students = mutableListOf<Student>()

    fun createStudent(id: Int, name: String, email: String): Boolean {
        if (students.any { it.id == id }) return false
        val student = Student(id, name, email)
        students.add(student)
        return true
    }
    fun listStudents():List<Student> = students.toList()
    fun findById(id:Int): Student? = students.find { it.id == id }
}