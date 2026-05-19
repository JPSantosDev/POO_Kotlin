package org.example.model

data class Trail(
    val id:Int,
    val name: String,
    val status: TrailStatus,
)
private val courseList = mutableListOf<Course>()

fun addCourseToTrail(course: Course,status: TrailStatus):Boolean{
    if(status != TrailStatus.OPEN)
        return false
    if(courseList.any{it.id == course.id})
        return false
    courseList.add(course)
    return true
}

fun removeCourseFromTrail(id:Int, status: TrailStatus):Boolean{
    if(status != TrailStatus.OPEN)
        return false
    return courseList.removeIf { it.id == id }
}
fun totalTrailWorkload(): Int{
    return courseList.sumOf { it.workloadHours }
}
fun listCourses(): List<Course> = courseList.toList()
