package org.example.services

import org.example.enums.EnrollmentStatus
import org.example.enums.StudentStatus
import org.example.enums.TrailStatus
import org.example.model.Enrollment
import org.example.model.Student
import org.example.model.Trail

class EnrollmentService {

    private val matriculas = mutableListOf<Enrollment>()

    fun enroll(student: Student, trail: Trail): Boolean {
        if (student.status != StudentStatus.ACTIVE) return false
        if (trail.status != TrailStatus.ACTIVE) return false
        if (matriculas.any { it.student.id == student.id && it.trail.id == trail.id }) return false

        matriculas.add(Enrollment(trail, student))
        return true
    }
    fun findEnrollment(studentId: Int, trailId: Int): Enrollment? {
        return matriculas.find {
            it.trail.id == trailId &&
            it.student.id == studentId &&
            it.status == EnrollmentStatus.ACTIVE
        }
    }

    fun listAllEnrollments(): List<Enrollment> = matriculas.toList()

    fun listByTrail(trailId: Int): List<Enrollment> =
        matriculas.filter { it.trail.id == trailId }

    fun progressRanking(): List<Enrollment> =
        matriculas.sortedWith(
            compareByDescending<Enrollment> { it.percent() }
                .thenBy { it.student.name }
        )

    fun studentsWithoutEnrollments(allStudents: List<Student>): List<Student> =
        allStudents.filter { aluno -> matriculas.none { it.student.id == aluno.id } }
}
