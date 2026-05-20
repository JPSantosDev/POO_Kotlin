package org.example.model

import org.example.enums.StudentStatus

class Student(
    val id: Int,
    val name: String,
    val email: String,
    val status: StudentStatus = StudentStatus.ACTIVE
){
    init {
        require(name.isNotEmpty()) { "Nome não pode estar vazio" }
        require(name.length >=3){"Nome deve haver pelo menos 3 letras" }
        require(email.isNotEmpty()){"Email não pode estar vazio"}
        require(email.contains('@') && email.contains('.')) { "E-mail inválido"}
        require(id>0){"ID deve conter um numero positivo"}
    }
}
