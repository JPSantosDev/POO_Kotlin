package org.example.model

class Course(
    val id:Int,
    val title:String,
    val woarkloadHours:Int,
    val level: CourseLevel
){
    private val courses = mutableListOf<Course>()

    fun summary(id: Int,title: String,woarkloadHours: Int,level: CourseLevel): String {
        return "O curso de $title com id $id tem $woarkloadHours horas de carga horária, com um nível $level"
    }
    fun addCourse(curso: Course):Boolean{
        if(courses.any{it.id == curso.id}) return false
        courses.add(curso)
        return true
    }

    init {
        require (id>0){
            "ID DEVE SER POSITIVO"
        }
        require (title!=null){
            "CURSO DEVE HAVER UM TÍTULO VÁLIDO"
        }
        require(woarkloadHours>0){
            "A CARGA HORÁRIA DEVE SER MAIOR QUE 0"
        }
    }
}