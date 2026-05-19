package org.example.model

class ConsoleMenu(
    val course: Course,
    val trail: Trail,
    val student: Student
){
    fun run(){
        var running = true
        while (running) {
            println("1 - Inserir dados de exemplo")
            println("2 - Listar cursos")
            println("3 - Exibir ranking")
            println("0 - Sair")
            print("Opção: ")

            when(readlnOrNull()?.trim()){
                "1" -> insertSamples()
                "2" -> run()
                "3" -> run()
                "0" -> running = false
                else -> println("Opção inválida")
            }
        }
    }
    fun insertSamples(){
        course.addCourse(Course(1, "Kotlin POO", 20,
            CourseLevel.ADVANCED))
        course.addCourse(Course(2, "Compose", 24,
            CourseLevel.INTERMEDIATE))

    }
}