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

    fun searchCourse(id: Int): Course? = courses.find { it.id == id }

    fun listAll(): List<Course> = courses.toList()

    fun orderCourse(): List<Course> = courses.sortedBy { it.title }

    fun levelCourse(level: CourseLevel): List<Course> = courses.filter { it.level == level }

    fun totalWorkload(): Int = courses.sumOf { it.workloadHours }

    fun removeCourse(id: Int): Boolean = courses.removeIf { it.id == id }
}