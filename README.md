# 📚 POO Kotlin - Exercícios Práticos de Programação Orientada a Objetos

## 🔗 Repositório Oficial

GitHub: [https://github.com/JPSantosDev/POO_Kotlin](https://github.com/JPSantosDev/POO_Kotlin)
.
---

# 1. Nome do Projeto

**POO Kotlin - Practical Exercises**

Sistema acadêmico em Kotlin voltado para gerenciamento de:

* Cursos;
* Trilhas de aprendizagem;
* Estudantes;
* Matrículas;
* Relatórios de progresso.

---

# 2. Objetivo

O objetivo do projeto é aplicar conceitos de:

* Programação Orientada a Objetos;
* Encapsulamento;
* Validações;
* Separação de responsabilidades;
* Organização modular;
* Manipulação de coleções;
* Regras de negócio.

O sistema simula um ambiente educacional onde estudantes podem ser cadastrados e associados a trilhas compostas por cursos.

---

# 3. Como Executar

## Pré-requisitos

* Java JDK 17+
* Kotlin
* Gradle
* IntelliJ IDEA (recomendado)

---

## Clonar o projeto

```bash
git clone https://github.com/JPSantosDev/POO_Kotlin.git
```

---

## Entrar na pasta

```bash
cd "Practical Exercises"
```

---

## Executar

Linux/Mac:

```bash
./gradlew run
```

Windows:

```bash
gradlew.bat run
```

---

# 4. Estrutura do Projeto

```text
src/main/kotlin/
│
├── Main.kt
│
├── enums/
│   ├── CourseLevel.kt
│   ├── EnrollmentStatus.kt
│   ├── StudentStatus.kt
│   └── TrailStatus.kt
│
├── model/
│   ├── Console.kt
│   ├── ConsoleMenu.kt
│   ├── Course.kt
│   ├── Enrollment.kt
│   ├── Student.kt
│   ├── StudentReport.kt
│   └── Trail.kt
│
└── services/
    ├── CourseService.kt
    ├── StudentService.kt
    └── TrailService.kt
```

---

# 5. Principais Classes

## 📘 Course

Representa um curso da plataforma.

### Atributos

* `id`
* `title`
* `workloadHours`
* `level`

### Funcionalidades

* Validação automática no construtor;
* Resumo textual do curso;
* Controle de carga horária.

### Regras implementadas

```kotlin
require(id > 0)
require(title.isNotBlank())
require(workloadHours > 0)
```

---

## 👨‍🎓 Student

Representa um aluno cadastrado.

### Atributos

* `id`
* `name`
* `email`
* `status`

### Validações

* Nome obrigatório;
* Nome mínimo de 3 letras;
* Email válido;
* ID positivo.

---

## 🛤️ Trail

Representa uma trilha de aprendizado.

### Responsabilidades

* Adicionar cursos;
* Remover cursos;
* Calcular carga horária total;
* Listar cursos.

### Regras

* Trilhas arquivadas não podem ser alteradas;
* Trilhas concluídas não podem receber cursos;
* Não permite cursos duplicados.

---

## 📝 Enrollment

Representa a matrícula de um estudante em uma trilha.

### Recursos

* Controle de status;
* Percentual de conclusão;
* Integração com relatórios.

---

## 📊 StudentReport

Responsável pelos relatórios.

### Funcionalidades

* Cálculo de percentual;
* Classificação automática;
* Ranking.

### Classificações

| Percentual | Resultado       |
| ---------- | --------------- |
| 0%         | Sem progresso   |
| 1% - 79%   | Em andamento    |
| 80% - 99%  | Quase concluído |
| 100%       | Concluído       |

---

## ⚙️ Services

### CourseService

Responsável por:

* Cadastro de cursos;
* Busca;
* Ordenação;
* Filtro por nível;
* Remoção.

---

### StudentService

Responsável por:

* Cadastro de estudantes;
* Busca por ID;
* Listagem.

---

### TrailService

Responsável por:

* Cadastro de trilhas;
* Associação de cursos;
* Busca de trilhas.

---

# 6. Regras Implementadas

## Cursos

* Não aceita ID duplicado;
* Não aceita carga horária menor ou igual a zero;
* Não aceita título vazio.

---

## Estudantes

* Nome obrigatório;
* Nome mínimo de 3 caracteres;
* Email precisa conter `@` e `.`;
* ID deve ser positivo.

---

## Trilhas

* Trilhas `ARCHIVED` e `COMPLETED` não podem ser alteradas;
* Não permite cursos duplicados.

---

## Matrículas

* Controle de status usando enum;
* Percentual calculado dinamicamente.

---

# 7. Decisões de Modelagem

## Uso de Pacotes

O projeto foi dividido em:

* `model` → entidades;
* `services` → regras operacionais;
* `enums` → estados e níveis;
* `Main.kt` → ponto inicial.

---

## Uso de Enums

Enums foram utilizados para evitar valores inválidos.

### Implementados

* `CourseLevel`
* `EnrollmentStatus`
* `StudentStatus`
* `TrailStatus`

---

## Encapsulamento

Atributos importantes usam:

```kotlin
private set
```

Isso impede alterações externas indevidas.

---

## Validações no init

Todas as entidades possuem validações internas usando `require`.

Isso evita objetos inválidos.

---

# 8. Checklist Resumido de Validação

| Funcionalidade                  | Status     |
| ------------------------------- | ---------- |
| Cadastro de cursos              | ✅          |
| Cadastro de estudantes          | ✅          |
| Cadastro de trilhas             | ✅          |
| Associação de cursos em trilhas | ✅          |
| Cálculo de progresso            | ✅          |
| Validações                      | ✅          |
| Enumeração de status            | ✅          |
| Organização modular             | ✅          |
| Console funcional               | ⚠️ Parcial |
| Testes automatizados            | ❌          |

---

# 9. Limitações Conhecidas

## Problemas atuais

### ConsoleMenu

O método `run()` possui chamadas recursivas:

```kotlin
"2" -> run()
"3" -> run()
```

Isso pode gerar repetição desnecessária.

---

### Ranking

O método `ranking()` cria uma lista vazia:

```kotlin
val lista = mutableListOf<StudentReport>()
```

Ainda não existe integração real com matrículas.

---

### Persistência

O sistema funciona apenas em memória.

---

### Interface

Ainda não existe interface gráfica.

---

# 10. Próximos Ajustes

## Melhorias futuras

* Implementar testes unitários;
* Melhorar menu de console;
* Criar persistência com banco de dados;
* Implementar autenticação;
* Melhorar ranking;
* Adicionar relatórios completos;
* Criar API REST.

---

# 11. Checklist de Testes

## Testes Manuais

| Cenário                   | Entrada         | Resultado Esperado | Status |
| ------------------------- | --------------- | ------------------ | ------ |
| Criar curso válido        | id=1            | Curso criado       | ✅      |
| Criar curso inválido      | workloadHours=0 | Exceção            | ✅      |
| Criar estudante válido    | João            | Estudante criado   | ✅      |
| Criar estudante inválido  | email sem @     | Exceção            | ✅      |
| Adicionar curso na trilha | Curso válido    | TRUE               | ✅      |
| Adicionar curso duplicado | Mesmo ID        | FALSE              | ✅      |
| Criar trilha arquivada    | ARCHIVED        | Não altera         | ✅      |
| Calcular percentual       | 2/4 cursos      | 50%                | ✅      |

---

# 12. Evidências de Execução

## Exemplo de execução

```text
1 - Cadastrar Aluno
2 - Listar Alunos
3 - Cadastrar Curso
4 - Listar Cursos
5 - Cadastrar Trilha
6 - Listar Trilhas
7 - Adicionar Curso a Trilha
8 - Matricular aluno em trilha
9 - Registrar progresso do aluno
10 - Exibir relatórios
0 - Sair
```

---

## Sugestão de evidências

```text
/docs
│
├── terminal-print.png
├── fluxo-console.gif
├── validacoes.png
└── relatorios.png
```

---

# 13. Anotação Técnica

## Decisões importantes

* Separação entre entidades e serviços;
* Uso de enums para estados;
* Uso de validações no construtor;
* Estrutura modular simples.

---

## Problemas encontrados

### Ranking incompleto

O ranking ainda não recebe lista externa de relatórios.

---

### Fluxo do console

O menu ainda não possui integração completa entre os serviços.

---

## Correções realizadas

* Implementação de validações;
* Controle de estados;
* Organização em camadas;
* Métodos de busca e filtros.

---

## Lacunas

* Sem persistência;
* Sem testes automatizados;
* Sem API;
* Sem interface gráfica.

---

# 14. Apresentação Curta

## Demonstração sugerida

1. Executar o sistema;
2. Mostrar cadastro de curso;
3. Mostrar cadastro de aluno;
4. Adicionar curso em trilha;
5. Explicar regras;
6. Explicar arquitetura.

---

## Arquitetura utilizada

O sistema utiliza:

* Camada de modelos;
* Camada de serviços;
* Console para interação.

A estrutura facilita:

* Manutenção;
* Escalabilidade;
* Reutilização de código.

---

# 15. Registro de Commits

## Padrão recomendado

```bash
git commit -m "feat: criação da entidade Course"
git commit -m "feat: implementação do StudentService"
git commit -m "feat: criação de validações"
git commit -m "fix: correção do menu"
git commit -m "refactor: reorganização dos pacotes"
```

---

# 16. Relatório Curto de Entrega

## Implementado

* Entidades principais;
* Enumerações;
* Serviços;
* Validações;
* Relatórios básicos;
* Controle de trilhas.

---

## Validado

* Cadastro de cursos;
* Cadastro de estudantes;
* Associação de cursos;
* Regras de negócio;
* Cálculo de percentual.

---

## Limitações

* Sem persistência;
* Sem testes automatizados;
* Console incompleto.

---

## Melhorias futuras

* Banco de dados;
* API REST;
* Testes automatizados;
* Interface gráfica.

---

# 17. Evidência do Checklist Atualizado Diariamente

## Itens necessários

| Item                        | Evidência  |
| --------------------------- | ---------- |
| Commit diário               | GitHub     |
| Funcionalidade demonstrável | Prints/GIF |
| Checklist atualizado        | README     |
| Anotação técnica            | README     |

---

## Estrutura sugerida

```text
/docs
│
├── checklist-diario.md
├── evidencias/
├── apresentacao/
└── relatorios/
```

---

# ✅ Conclusão

O projeto demonstra a aplicação prática dos conceitos de Programação Orientada a Objetos utilizando Kotlin.

A arquitetura modular, as validações internas e a separação de responsabilidades tornam o sistema organizado e preparado para futuras evoluções.

Mesmo ainda em desenvolvimento, o projeto já apresenta funcionalidades importantes para gerenciamento de cursos, trilhas e estudantes.
