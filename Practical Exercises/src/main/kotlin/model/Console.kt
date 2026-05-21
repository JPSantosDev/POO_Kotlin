package org.example.model

import org.example.services.StudentService

class Console {
}

fun principalMenu(){

    val trail: Trail
    val studentService: StudentService = StudentService()
    println("1 - Cadastrar Aluno")
    println("2 - Listar Alunos")
    println("3 - Cadastrar Curso")
    println("4 - Listar Cursos")
    println("5 - Cadastrar Trilha")
    println("6 - Listar Trilhas")
    println("7 - Adicionar Curso a Trilha")
    println("8 - Matricular aluno em trilha")
    println("9 - Registrar progresso do aluno")
    println("10 - Exibir relatórios")
    println("0 - Sair")

    val escolha : Int? = readlnOrNull()?.trim()?.toInt()
    if (escolha != null){
        when (escolha) {
            1 ->{
                println("Digite o ID do aluno")
                val studentID = Student(readln())
                println("Digite o nome do aluno")
                val name = readln().trim()
                println("Digite o e-mail do aluno")
                val email = readln().trim()
                studentService.createStudent(id,name,email)
            }
            2 ->{
                studentService.listStudents()
            }
            else -> {
                println("Opção inválida")
            }
        }
    }


}