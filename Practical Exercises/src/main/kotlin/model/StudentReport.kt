package org.example.model

data class StudentReport(
    val student: Student,
    val trailName: String,
    val completedCourses: Int,
    val totalCourses: Int,
) {
    init {
        require(completedCourses >= 0) { "Cursos completados deve ser um valor positivo" }
        require(totalCourses > 0) { "Cursos totais deve ser maior que 0" }
        require(completedCourses <= totalCourses) { "Cursos completados não pode ser maior que o total" }
    }

    fun percent(): Double {
        if (totalCourses == 0) return 0.0
        return (completedCourses * 100.0) / totalCourses
    }

    fun classification(): String {
        return when (percent()) {
            0.0              -> "Sem progresso"
            in 1.0..79.9     -> "Em andamento"
            in 80.0..99.9    -> "Quase concluído"
            else             -> "Concluído"
        }
    }
        fun ranking(reports: List<StudentReport>): List<StudentReport> {
            return reports.sortedWith(
                compareByDescending<StudentReport> { it.percent() }
                    .thenBy { it.student.name }
            )
        }
    }

