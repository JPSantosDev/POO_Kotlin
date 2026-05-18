package org.example.model

data class Course(
    val id:Int,
    val title:String,
    val woarkloadHours:Int,
    val level: CourseLevel
){

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