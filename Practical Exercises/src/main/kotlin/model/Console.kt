package org.example.model

import org.example.services.CourseService
import org.example.services.EnrollmentService
import org.example.services.StudentService
import org.example.services.TrailService

class Console (
    val courseService: CourseService = CourseService(),
    val enrollmentService: EnrollmentService = EnrollmentService(),
    val studentService: StudentService = StudentService(),
    val trailService: TrailService = TrailService()
){

    fun run(){
        var running = true
        while(running){
            printMenu()
            when(readLine()?.trim()){
                "1" -> {cadastrarAluno()}
                "2" -> {cadastrarAluno()}
                "3" -> {cadastrarAluno()}
                "4" -> {cadastrarAluno()}
                "5" -> {cadastrarAluno()}
                "6" -> {cadastrarAluno()}
                "7" -> {cadastrarAluno()}
                "8" -> {cadastrarAluno()}
                "9" -> {cadastrarAluno()}
                "10" -> {cadastrarAluno()}
                "11" -> {cadastrarAluno()}
                else -> {println("Opção Inválida")}
            }
        }
    }

    private fun printMenu() {
        println("=== Sistema de Alunos e Trilhas ===")
        println("1 - Cadastrar aluno")
        println("2 - Listar alunos")
        println("3 - Cadastrar curso")
        println("4 - Listar cursos")
        println("5 - Cadastrar trilha")
        println("6 - Listar trilhas")
        println("7 - Adicionar curso a uma trilha")
        println("8 - Matricular aluno em trilha")
        println("9 - Registrar progresso do aluno")
        println("10 - Exibir Relatórios")
        println("0 - Sair do Sistema")
    }

    private fun cadastrarAluno(){
        print("ID:")
        val id = readlnOrNull()?.trim()?.toIntOrNull() ?: run {
            println("ID Inválido")
            return
        }

        print("Nome: ")
        val nome = readlnOrNull()?.trim() ?: run {
            println("Nome Inválido")
            return
        }

        print("E-mail: ")
        val email = readlnOrNull()?.trim() ?: run {
            println("E-mail inválido")
            return
        }

        if (studentService.createStudent(id, nome, email)) {
            println("Aluno cadastrado com sucesso")
        } else{
            println("ID já cadastrado")
        }
    }
}