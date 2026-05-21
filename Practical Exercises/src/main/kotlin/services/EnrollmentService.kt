package org.example.services

import org.example.enums.StudentStatus
import org.example.enums.TrailStatus
import org.example.model.Enrollment
import org.example.model.Student
import org.example.model.Trail

class EnrollmentService {

    private val matriculas = mutableListOf<Enrollment>()

    fun enroll(student: Student, trail: Trail):Boolean {
        if (student.status != StudentStatus.ACTIVE) return false
        if (trail.status != TrailStatus.ACTIVE) return false
        if(matriculas.any { it.student.id == student.id && it.trail.id == trail.id}) return false

        matriculas.add(Enrollment(trail,student))
        return true
    }

    fun findEnrollment(studentId:Int , trailId:Int): Enrollment? {
        return matriculas.find { it.trail.id == trailId && it.student.id == studentId }
    }

    fun listAllEnrollments():List<Enrollment> {
        return matriculas.toList()
    }
    fun listByTrail(trailId:Int):List<Enrollment> {
        return matriculas.filter { it.trail.id == trailId}
    }
}