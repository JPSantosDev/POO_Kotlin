package org.example.model

class StudentReport (

    val student: Student,
    val trailName:String,
    val completedCourses:Int,
    val totalCourses:Int,

){
    init {
        require(completedCourses >= 0) { "Cursos completados deve ser um valor positivo" }
        require(totalCourses > 0) { "Cursos totais deve ser maior que 0" }
    }
    fun percent():Int{
        if(totalCourses == 0) return 0
        return (completedCourses*100)/totalCourses
    }
    fun classification(): String{
       return when(percent()){
           0 -> "Sem progresso"
           in 1..79 -> "Em andamento"
           in 80..99 -> "Quase concluido"
           else -> "Concluido"
       }
    }
    fun ranking(): List<StudentReport> {
    val lista = mutableListOf<StudentReport>()
        return lista.sortedWith(
            compareByDescending<StudentReport> { it.percent() }
                .thenBy { it.student.name })

    }
}
