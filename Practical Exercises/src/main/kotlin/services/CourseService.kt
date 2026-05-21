package org.example.services

import org.example.model.Course
import org.example.enums.CourseLevel

class CourseService() {
    private val courses = mutableListOf<Course>()

    fun addCourse(course: Course): Boolean {
        if (courses.any { it.id == course.id }) return false
        courses.add(course)
        return true
    }

    fun searchCourse(id:Int): Course? {
        return courses.find { it.id == id }
    }

    fun orderCourse(): List<Course> {
        return courses.sortedBy { it.title }
    }

    fun levelCourse(level: CourseLevel): List<Course> {
        return courses.filter { it.level == level }
    }

    fun totalWorkload(): Int {
        return courses.sumOf { it.workloadHours }
    }

    fun removeCourse(id: Int): Boolean {
        return courses.removeIf{ it.id == id }
    }
    fun listAll(): List<Course> {
        return courses.toList()
    }
}