package org.example.model

class Course(
    val id:Int,
    val title:String,
    val workloadHours:Int,
    val level: CourseLevel,
) {

    init {
        require(id > 0) {
            "ID DEVE SER POSITIVO"
        }
        require(title != null) {
            "CURSO DEVE HAVER UM TÍTULO VÁLIDO"
        }
        require(workloadHours > 0) {
            "A CARGA HORÁRIA DEVE SER MAIOR QUE 0"
        }
    }

    fun summary(): String {
        return "O curso de $title com id $id tem $workloadHours horas de carga horária, com um nível $level"
    }

}
