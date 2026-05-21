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

    fun percent():Int{
        val total = trail.courseCount()
        if(total == 0) return 0
        return ((completedCourses*100)/total)
    }
}