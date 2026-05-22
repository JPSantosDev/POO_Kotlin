package org.example.model

import org.example.enums.CourseCategory
import org.example.enums.CourseLevel

data class Course(
    val id: Int,
    val title: String,
    val workloadHours: Int,
    val level: CourseLevel,
    val category: CourseCategory,
) {
    init {
        require(id > 0) { "ID deve ser positivo" }
        require(title.isNotBlank()) { "Curso deve haver um título válido" }
        require(workloadHours > 0) { "A carga horária deve ser maior que 0" }
    }

    fun summary(): String {
        return "Curso: $title | ID: $id | Carga: ${workloadHours}h | Nível: $level | Categoria: $category"
    }
}
