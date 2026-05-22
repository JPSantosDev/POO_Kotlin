package org.example.model

import org.example.enums.CourseCategory
import org.example.enums.CourseLevel
import org.example.enums.TrailStatus
import org.example.services.CourseService
import org.example.services.EnrollmentService
import org.example.services.StudentService
import org.example.services.TrailService

class Console(
    val courseService: CourseService = CourseService(),
    val enrollmentService: EnrollmentService = EnrollmentService(),
    val studentService: StudentService = StudentService(),
    val trailService: TrailService = TrailService()
) {

    fun run() {
        var running = true
        while (running) {
            printMenu()
            when (readLine()?.trim()) {
                "1"  -> cadastrarAluno()
                "2"  -> listarAlunos()
                "3"  -> cadastrarCurso()
                "4"  -> listarCursos()
                "5"  -> cadastrarTrilha()
                "6"  -> listarTrilhas()
                "7"  -> adicionarCursoATrilha()
                "8"  -> matricularAluno()
                "9"  -> registrarProgresso()
                "10" -> menuRelatorios()
                "11" -> { running = false; println("Sistema encerrado.") }
                else -> println("Opção inválida. Tente novamente.")
            }
        }
    }

    private fun printMenu() {
        println("\n=== Sistema de Alunos e Trilhas ===")
        println("1  - Cadastrar aluno")
        println("2  - Listar alunos")
        println("3  - Cadastrar curso")
        println("4  - Listar cursos")
        println("5  - Cadastrar trilha")
        println("6  - Listar trilhas")
        println("7  - Adicionar curso a uma trilha")
        println("8  - Matricular aluno em trilha")
        println("9  - Registrar progresso do aluno")
        println("10 - Exibir relatórios")
        println("11 - Sair")
        print("Opção: ")
    }

    private fun cadastrarAluno() {
        print("ID: ")
        val id = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }
        print("Nome: ")
        val nome = readlnOrNull()?.trim() ?: return
        print("E-mail: ")
        val email = readlnOrNull()?.trim() ?: return

        try {
            if (studentService.createStudent(id, nome, email))
                println("Aluno cadastrado com sucesso.")
            else
                println("Erro: ID já cadastrado.")
        } catch (e: Exception) {
            println("Erro: ${e.message}")
        }
    }

    private fun listarAlunos() {
        val alunos = studentService.listStudents()
        if (alunos.isEmpty()) {
            println("Nenhum aluno cadastrado.")
            return
        }
        println("\n--- Alunos ---")
        alunos.forEach {
            println("ID: ${it.id} | Nome: ${it.name} | E-mail: ${it.email} | Status: ${it.status}")
        }
    }

    private fun cadastrarCurso() {
        print("ID: ")
        val id = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }

        print("Título: ")
        val titulo = readlnOrNull()?.trim() ?: return

        print("Carga horária (horas): ")
        val carga = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("Carga horária inválida."); return }

        println("Nível (BASIC, INTERMEDIATE, ADVANCED): ")
        val nivelStr = readlnOrNull()?.trim()?.uppercase() ?: return
        val nivel = try {
            CourseLevel.valueOf(nivelStr)
        } catch (e: IllegalArgumentException) {
            println("Nível inválido.")
            return
        }

        println("Categoria (KOTLIN, ANDROID, ARCHITECTURE, TESTS, DESIGN): ")
        val categoriaStr = readlnOrNull()?.trim()?.uppercase() ?: return
        val categoria = try {
            CourseCategory.valueOf(categoriaStr)
        } catch (e: IllegalArgumentException) {
            println("Categoria inválida.")
            return
        }

        try {
            if (courseService.addCourse(Course(id, titulo, carga, nivel, categoria)))
                println("Curso cadastrado com sucesso.")
            else
                println("Erro: ID já cadastrado.")
        } catch (e: Exception) {
            println("Erro: ${e.message}")
        }
    }

    private fun listarCursos() {
        val cursos = courseService.listAll()
        if (cursos.isEmpty()) {
            println("Nenhum curso cadastrado.")
            return
        }
        println("\n--- Cursos ---")
        cursos.forEach {
            println("ID: ${it.id} | Título: ${it.title} | Carga: ${it.workloadHours}h | Nível: ${it.level} | Categoria: ${it.category}")
        }
    }

    private fun cadastrarTrilha() {
        print("ID: ")
        val id = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }

        print("Nome: ")
        val nome = readlnOrNull()?.trim() ?: return

        print("Descrição: ")
        val descricao = readlnOrNull()?.trim() ?: return

        println("Status (PLANNED, ACTIVE, COMPLETED, ARCHIVED): ")
        val statusStr = readlnOrNull()?.trim()?.uppercase() ?: return
        val status = try {
            TrailStatus.valueOf(statusStr)
        } catch (e: IllegalArgumentException) {
            println("Status inválido.")
            return
        }

        try {
            if (trailService.addTrail(Trail(id, nome, status, descricao)))
                println("Trilha cadastrada com sucesso.")
            else
                println("Erro: ID já cadastrado.")
        } catch (e: Exception) {
            println("Erro: ${e.message}")
        }
    }

    private fun listarTrilhas() {
        val trilhas = trailService.listTrails()
        if (trilhas.isEmpty()) {
            println("Nenhuma trilha cadastrada.")
            return
        }
        println("\n--- Trilhas ---")
        trilhas.forEach {
            println("ID: ${it.id} | Nome: ${it.name} | Status: ${it.status} | Cursos: ${it.courseCount()} | Carga total: ${it.totalTrailWorkload()}h")
        }
    }

    private fun adicionarCursoATrilha() {
        print("ID da trilha: ")
        val trailId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }
        print("ID do curso: ")
        val courseId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }

        trailService.findTrail(trailId) ?: run { println("Trilha não encontrada."); return }
        val curso = courseService.searchCourse(courseId) ?: run { println("Curso não encontrado."); return }

        if (trailService.addCourseToTrail(trailId, curso))
            println("Curso adicionado à trilha com sucesso.")
        else
            println("Curso já associado a esta trilha.")
    }

    private fun matricularAluno() {
        print("ID do aluno: ")
        val studentId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }
        print("ID da trilha: ")
        val trailId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }

        val aluno = studentService.findById(studentId) ?: run { println("Aluno não encontrado."); return }
        val trilha = trailService.findTrail(trailId) ?: run { println("Trilha não encontrada."); return }

        if (enrollmentService.enroll(aluno, trilha))
            println("Matrícula realizada com sucesso.")
        else
            println("Não foi possível matricular. Verifique status do aluno, da trilha ou matrícula duplicada.")
    }

    private fun registrarProgresso() {
        print("ID do aluno: ")
        val studentId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }
        print("ID da trilha: ")
        val trailId = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("ID inválido."); return }

        val matricula = enrollmentService.findEnrollment(studentId, trailId)
            ?: run { println("Matrícula ativa não encontrada."); return }

        if (matricula.trail.courseCount() == 0) {
            println("A trilha não possui cursos cadastrados.")
            return
        }

        print("Cursos concluídos (total da trilha: ${matricula.trail.courseCount()}): ")
        val concluidos = readlnOrNull()?.trim()?.toIntOrNull() ?: run { println("Valor inválido."); return }

        if (matricula.registerProgress(concluidos))
            println("Progresso registrado com sucesso.")
        else
            println("Erro: quantidade inválida de cursos concluídos.")
    }

    private fun menuRelatorios() {
        var running = true
        while (running) {
            println("\n--- Relatórios ---")
            println("1 - Alunos cadastrados")
            println("2 - Cursos cadastrados")
            println("3 - Trilhas com carga horária total")
            println("4 - Alunos matriculados por trilha")
            println("5 - Ranking de progresso")
            println("6 - Alunos sem matrícula")
            println("7 - Voltar ao menu principal")
            print("Opção: ")

            when (readLine()?.trim()) {
                "1" -> listarAlunos()
                "2" -> listarCursos()
                "3" -> listarTrilhas()
                "4" -> relatorioAlunosPorTrilha()
                "5" -> relatorioRanking()
                "6" -> relatorioSemMatricula()
                "7" -> running = false
                else -> println("Opção inválida. Tente novamente.")
            }
        }
    }

    private fun relatorioAlunosPorTrilha() {
        val trilhas = trailService.listTrails()
        if (trilhas.isEmpty()) { println("Nenhuma trilha cadastrada."); return }
        println("\n--- Alunos por Trilha ---")
        trilhas.forEach { trilha ->
            println("\nTrilha: ${trilha.name} (${trilha.status})")
            val matriculas = enrollmentService.listByTrail(trilha.id)
            if (matriculas.isEmpty())
                println("  Nenhum aluno matriculado nesta trilha.")
            else
                matriculas.forEach {
                    println("  - ${it.student.name} | Progresso: ${it.percent()}% | Status: ${it.status}")
                }
        }
    }

    private fun relatorioRanking() {
        val ranking = enrollmentService.progressRanking()
        if (ranking.isEmpty()) { println("Nenhuma matrícula registrada."); return }
        println("\n--- Ranking de Progresso ---")
        ranking.forEachIndexed { index, it ->
            println("${index + 1}. ${it.student.name} | Trilha: ${it.trail.name} | Progresso: ${it.percent()}% | Status: ${it.status}")
        }
    }

    private fun relatorioSemMatricula() {
        val semMatricula = enrollmentService.studentsWithoutEnrollments(studentService.listStudents())
        if (semMatricula.isEmpty()) {
            println("Todos os alunos possuem matrícula.")
            return
        }
        println("\n--- Alunos sem Matrícula ---")
        semMatricula.forEach { println("ID: ${it.id} | Nome: ${it.name}") }
    }
}