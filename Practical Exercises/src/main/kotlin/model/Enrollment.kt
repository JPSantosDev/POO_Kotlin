package org.example.model

class Enrollment (
    val student: Student,
    val trail: Trail,
    status: EnrollmentStatus = EnrollmentStatus.ACTIVE
){
    var status: EnrollmentStatus = status
        private set

    fun finish():Boolean{
        if(status == EnrollmentStatus.CANCELLED)
            return false
        status = EnrollmentStatus.FINISHED
        return true
    }
}