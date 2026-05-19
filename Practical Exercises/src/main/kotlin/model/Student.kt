package org.example.model

class Student(
    val id: Int,
    val name: String,
    val email: String,
){
    init {
        require(name.isNotEmpty()) { "Nome não pode estar vazio" }
        require(name.length <=3){"Nome deve haver pelo menos 3 letras" }
        require(email.isNotEmpty()){"Email não pode estar vazio"}
        require(email.contains('@')) { "Email deve conter '@'" }
        require(email.contains("gmail.com")) { "Email deve conter 'gmail.com' "}
        require(id>0){"ID deve conter um numero positivo"}
    }
}