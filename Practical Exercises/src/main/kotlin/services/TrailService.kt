package org.example.services

import org.example.model.Course
import org.example.model.Trail
import org.example.model.TrailStatus

class TrailService {

    private val trailList = mutableListOf<Trail>()

    fun addTrail( trail: Trail): Boolean {
        if (trail.status == TrailStatus.ARCHIVED || trail.status == TrailStatus.COMPLETED)
            return false
        if (trailList.any { it.id == trail.id })
            return false

        trailList.add(trail)
        return true
    }

    fun findTrail(id: Int): Trail? = trailList.find { it.id == id }

    fun listTrails(): List<Trail> = trailList.toList()

    fun addCourseToTrail( trailid:Int ,course: Course ): Boolean {
    val trail = findTrail(trailid) ?: return false
        return trail.addCourseToTrail(course)
    }

}

