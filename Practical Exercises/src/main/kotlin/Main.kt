package org.example

import org.example.model.Console
import org.example.services.CourseService
import org.example.services.EnrollmentService
import org.example.services.StudentService
import org.example.services.TrailService

fun main(){
    val studentService = StudentService()
    val trailService = TrailService()
    val enrollmentService = EnrollmentService()
    val courseService = CourseService()

    Console(courseService,enrollmentService,studentService,trailService).run()
}
