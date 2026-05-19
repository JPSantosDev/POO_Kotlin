package org.example.model

data class Trail(
    val id:Int,
    val name: String,
    val status: TrailStatus,
)
private val courseList = mutableListOf<Course>()

fun addCourseToTrail(course: Course,status: TrailStatus):Boolean{
    if(status == TrailStatus.ARCHIVED || status == TrailStatus.COMPLETED)
        return false
    courseList.add(course)
    return true
}

fun removeCourseFromTrail(id:Int, status: TrailStatus):Boolean{
    if(status == TrailStatus.ARCHIVED || status == TrailStatus.COMPLETED)
        return false
    courseList.removeIf { it.id == id }
    return true
}
fun totalTrailWorkload(): Int{
    return courseList.sumOf { it.workloadHours }
}