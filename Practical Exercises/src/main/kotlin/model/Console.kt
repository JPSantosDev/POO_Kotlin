package org.example.model

import org.example.enums.CourseLevel
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

                "2" -> {
                    val alunos = studentService.listStudents()
                    if (alunos.isEmpty()) println("Nenhum aluno cadastrado.")
                    else alunos.forEach { println("ID: ${it.id} | Nome: ${it.name} | E-mail: ${it.email} | Status: ${it.status}") }
                }

                "3" -> {cadastrarCurso()}

                "4" -> {
                    val cursos = courseService.listAll()
                    if (cursos.isEmpty()) println("Nenhum curso cadastrado.")
                    else cursos.forEach { println("ID: ${it.id} | Título: ${it.title} | Carga: ${it.workloadHours}h | Nível: ${it.level}") }
                }

                "5" -> {cadastrarAluno()}

                "6" -> {
                    val trilhas = trailService.listTrails()
                    if (trilhas.isEmpty()) println("Nenhuma trilha cadastrada.")
                    else trilhas.forEach { println("ID: ${it.id} | Nome: ${it.name} | Status: ${it.status} | Cursos: ${it.courseCount()} | Carga total: ${it.totalTrailWorkload()}h") }
                }

                "7" -> {}

                "8" -> {}

                "9" -> {}

                "10" -> {cadastrarAluno()}

                "11" -> {running = false; println("Sistema encerrado")}

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
    private fun cadastrarCurso() {
        print("ID: ")
        val id = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }
        print("Título: ")
        val titulo = readlnOrNull()?.trim() ?: return
        print("Carga horária: ")
        val carga = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("Carga horária inválida."); return }
        println("Nível (BASIC, INTERMEDIATE, ADVANCED): ")
        val nivelStr = readlnOrNull()?.trim()?.uppercase() ?: return

        val nivel = try {
            CourseLevel.valueOf(nivelStr)
        } catch (e: IllegalArgumentException) {
            println("Nível inválido.")
            return
        }
        try {
            val curso = Course(id, titulo, carga, nivel)
            if (courseService.addCourse(curso))
                println("Curso cadastrado com sucesso.")
            else
                println("ID já cadastrado.")
        } catch (e: Exception) {
            println("Erro: ${e.message}")
        }
    }
}