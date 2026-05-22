package org.example.services

import org.example.model.Course
import org.example.model.Trail

class TrailService {

    private val trailList = mutableListOf<Trail>()

    fun addTrail(trail: Trail): Boolean {
        if (trailList.any { it.id == trail.id }) return false
        trailList.add(trail)
        return true
    }

    fun findTrail(id: Int): Trail? = trailList.find { it.id == id }

    fun listTrails(): List<Trail> = trailList.toList()

    fun addCourseToTrail(trailId: Int, course: Course): Boolean {
        val trail = findTrail(trailId) ?: return false
        return trail.addCourseToTrail(course)
    }
}