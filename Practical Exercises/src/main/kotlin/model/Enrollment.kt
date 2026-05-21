package org.example.model

import org.example.enums.EnrollmentStatus

class Enrollment (
    val trail: Trail,
    val student: Student
) {
    var status: EnrollmentStatus = EnrollmentStatus.ACTIVE
        private set
    var completedCourses:Int = 0
        private set

    fun percent():Int{
        val total = trail.courseCount()
        if(total == 0) return 0
        return ((completedCourses*100)/total)
    }
    fun registerProgress(completed: Int): Boolean{
        if(completed < 0) return false
        if (completed>trail.courseCount()) return false
        completedCourses = completed
        if(percent() == 100) status = EnrollmentStatus.FINISHED
        return true
    }
}