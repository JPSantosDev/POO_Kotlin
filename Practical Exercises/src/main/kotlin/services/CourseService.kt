package org.example.services

import org.example.model.Course
import org.example.model.CourseLevel

class CourseService(
    val level: CourseLevel,
) {
    private val courses = mutableListOf<Course>()

    fun addCourse(course: Course): Boolean {
        if (courses.any { it.id == course.id }) return false
        courses.add(course)
        return true
    }

    fun searchCourse(course: Course): Course? {
        return courses.find { it.id == course.id }
    }

    fun orderCourse(): List<Course> {
        return courses.sortedBy { it.title }
    }

    fun levelCourse(): List<Course> {
        return courses.filter { it.level == level }
    }

    fun totalWorkload(): Int {
        return courses.sumOf { it.workloadHours }
    }

    fun removeCourse(course: Course): Boolean {
        return courses.remove(course)
    }
}