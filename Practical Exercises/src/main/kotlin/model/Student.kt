package org.example.model

import org.example.enums.StudentStatus

data class Student(
    val id: Int,
    val name: String,
    val email: String,
    val status: StudentStatus = StudentStatus.ACTIVE
) {
    init {
        require(id > 0) { "ID deve ser um número positivo" }
        require(name.isNotBlank()) { "Nome não pode estar vazio" }
        require(name.length >= 3) { "Nome deve ter pelo menos 3 letras" }
        require(name.matches(Regex("[\\p{L} ]+"))) { "Nome deve conter apenas letras e espaços (sem números ou símbolos)" }
        require(email.isNotBlank()) { "E-mail não pode estar vazio" }
        require(email.matches(Regex("^[\\w.+\\-]+@[\\w\\-]+\\.[a-zA-Z]{2,}$"))) { "E-mail inválido" }
    }
}
