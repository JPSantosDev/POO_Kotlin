package org.example.model

import org.example.enums.EnrollmentStatus

class Enrollment (
    val student: Student,
    val trail: Trail,
) {
    init {

    }
    var status: EnrollmentStatus = EnrollmentStatus.ACTIVE
        private set
    var completedCourses:Int = 0
        private set

    fun percent(completedCourses:Int,totalCourses:Int):Double{
        val report = StudentReport(student,trail.name,completedCourses,totalCourses,)
        return report.percent()
    }
}