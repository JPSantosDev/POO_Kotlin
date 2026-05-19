package org.example.model

class Course(
    val id:Int,
    val title:String,
    val workloadHours:Int,
    val level: CourseLevel
){
    private val courses = mutableListOf<Course>()

    init {
        require (id>0){
            "ID DEVE SER POSITIVO"
        }
        require (title!=null){
            "CURSO DEVE HAVER UM TÍTULO VÁLIDO"
        }
        require(workloadHours>0){
            "A CARGA HORÁRIA DEVE SER MAIOR QUE 0"
        }
    }

    fun summary(id: Int,title: String,woarkloadHours: Int,level: CourseLevel): String {
        return "O curso de $title com id $id tem $woarkloadHours horas de carga horária, com um nível ${level}"
    }
    fun addCourse(course: Course):Boolean{
        if(courses.any{it.id == course.id}) return false
        courses.add(course)
        return true
    }
    fun searchCourse(course:Course):Course?{
        return courses.find{it.id == course.id}
    }
    fun orderCourse(): List<Course>{
       return courses.sortedBy { it.title }
    }
    fun levelCourse(): List<Course>{
        return courses.filter { it.level == level }
    }
    fun totalWorkload():Int{
        return courses.sumOf { it.workloadHours }
    }
    fun removeCourse(course: Course): Boolean{
        return courses.remove(course)
    }

}