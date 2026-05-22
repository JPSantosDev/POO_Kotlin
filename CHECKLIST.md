# CHECKLIST DE TESTES MANUAIS
## Sistema de Alunos e Trilhas

Legenda: ✅ Passou | ❌ Falhou | ⏳ Não testado

---

## 1. Inicialização e menu

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 1.1 | Sistema inicia sem erro | — | Console exibe o menu principal | ✅ |
| 1.2 | Título exibido | — | "Sistema de Alunos e Trilhas" aparece | ✅ |
| 1.3 | Menu com 11 opções | — | Opções de 1 a 11 visíveis | ✅ |
| 1.4 | Opção inválida | `99` | "Opção inválida. Tente novamente." | ✅ |
| 1.5 | Opção texto | `abc` | "Opção inválida. Tente novamente." | ✅ |
| 1.6 | Sair | `11` | "Sistema encerrado." e programa encerra | ✅ |
| 1.7 | Retorno ao menu | Qualquer opção válida | Menu reexibido após operação | ✅ |

---

## 2. Cadastro de alunos

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 2.1 | Cadastrar aluno válido | id=1, nome=João Silva, email=joao@email.com | "Aluno cadastrado com sucesso." | ✅ |
| 2.2 | ID duplicado | id=1 novamente | "Erro: ID já cadastrado." | ✅ |
| 2.3 | Nome vazio | nome= (enter) | "Erro: Nome não pode estar vazio" | ✅ |
| 2.4 | Nome com menos de 3 chars | nome=Jo | "Erro: Nome deve haver pelo menos 3 letras" | ✅ |
| 2.5 | E-mail sem @ | email=joaoemail.com | "Erro: E-mail inválido" | ✅ |
| 2.6 | E-mail sem ponto | email=joao@emailcom | "Erro: E-mail inválido" | ✅ |
| 2.7 | ID negativo | id=-1 | "Erro: ID deve conter um numero positivo" | ✅ |
| 2.8 | ID texto | id=abc | "ID inválido." | ✅ |
| 2.9 | Listar alunos cadastrados | opção 2 | Lista com id, nome, email e status | ✅ |
| 2.10 | Listar sem alunos | opção 2 sem cadastro | "Nenhum aluno cadastrado." | ✅ |

---

## 3. Cadastro de cursos

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 3.1 | Cadastrar curso válido | id=1, título=Kotlin POO, carga=20, BASIC, KOTLIN | "Curso cadastrado com sucesso." | ✅ |
| 3.2 | ID duplicado | id=1 novamente | "Erro: ID já cadastrado." | ✅ |
| 3.3 | Título vazio | título= (enter) | "Erro: Curso deve haver um título válido" | ✅ |
| 3.4 | Carga horária zero | carga=0 | "Erro: A carga horária deve ser maior que 0" | ✅ |
| 3.5 | Carga horária negativa | carga=-5 | "Erro: A carga horária deve ser maior que 0" | ✅ |
| 3.6 | Carga horária texto | carga=abc | "Carga horária inválida." | ✅ |
| 3.7 | Nível inválido | nível=EXPERT | "Nível inválido." | ✅ |
| 3.8 | Categoria inválida | categoria=JAVA | "Categoria inválida." | ✅ |
| 3.9 | Listar cursos | opção 4 | Lista com id, título, carga, nível e categoria | ✅ |
| 3.10 | Listar sem cursos | opção 4 sem cadastro | "Nenhum curso cadastrado." | ✅ |

---

## 4. Cadastro de trilhas

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 4.1 | Cadastrar trilha válida | id=1, nome=Android Básico, desc=Trilha inicial, ACTIVE | "Trilha cadastrada com sucesso." | ✅ |
| 4.2 | ID duplicado | id=1 novamente | "Erro: ID já cadastrado." | ✅ |
| 4.3 | Nome vazio | nome= (enter) | "Erro: trilha deve haver um nome" | ✅ |
| 4.4 | Status inválido | status=ABERTO | "Status inválido." | ✅ |
| 4.5 | Listar trilhas | opção 6 | Lista com id, nome, status, qtd cursos e carga total | ✅ |
| 4.6 | Listar sem trilhas | opção 6 sem cadastro | "Nenhuma trilha cadastrada." | ✅ |

---

## 5. Associação de curso à trilha

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 5.1 | Adicionar curso válido | trailId=1, courseId=1 | "Curso adicionado à trilha com sucesso." | ✅ |
| 5.2 | Trilha inexistente | trailId=99 | "Trilha não encontrada." | ✅ |
| 5.3 | Curso inexistente | courseId=99 | "Curso não encontrado." | ✅ |
| 5.4 | Curso duplicado na trilha | mesmo curso duas vezes | "Curso já associado a esta trilha." | ✅ |
| 5.5 | Trilha COMPLETED | trilha com status COMPLETED | "Curso já associado a esta trilha." ou bloqueio | ✅ |
| 5.6 | Trilha ARCHIVED | trilha com status ARCHIVED | Adição bloqueada | ✅ |
| 5.7 | Carga total atualizada | após adicionar curso | Listar trilha mostra carga somada | ✅ |
| 5.8 | Quantidade atualizada | após adicionar curso | Listar trilha mostra qtd correta | ✅ |

---

## 6. Matrícula

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 6.1 | Matricular aluno ativo em trilha ativa | ids válidos | "Matrícula realizada com sucesso." | ✅ |
| 6.2 | Aluno inexistente | studentId=99 | "Aluno não encontrado." | ✅ |
| 6.3 | Trilha inexistente | trailId=99 | "Trilha não encontrada." | ✅ |
| 6.4 | Aluno INACTIVE | aluno com status INACTIVE | Matrícula bloqueada | ✅ |
| 6.5 | Aluno BLOCKED | aluno com status BLOCKED | Matrícula bloqueada | ✅ |
| 6.6 | Trilha PLANNED | trilha com status PLANNED | Matrícula bloqueada | ✅ |
| 6.7 | Trilha COMPLETED | trilha com status COMPLETED | Matrícula bloqueada | ✅ |
| 6.8 | Trilha ARCHIVED | trilha com status ARCHIVED | Matrícula bloqueada | ✅ |
| 6.9 | Matrícula duplicada | mesmo aluno e trilha duas vezes | Matrícula bloqueada | ✅ |

---

## 7. Registro de progresso

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 7.1 | Registrar progresso válido | concluidos=2 (trilha com 3 cursos) | "Progresso registrado com sucesso." | ✅ |
| 7.2 | Sem matrícula ativa | aluno não matriculado | "Matrícula ativa não encontrada." | ✅ |
| 7.3 | Trilha sem cursos | trilha vazia | "A trilha não possui cursos cadastrados." | ✅ |
| 7.4 | Quantidade negativa | concluidos=-1 | "Erro: quantidade inválida de cursos concluídos." | ✅ |
| 7.5 | Maior que total | concluidos=99 (trilha com 3 cursos) | "Erro: quantidade inválida de cursos concluídos." | ✅ |
| 7.6 | Percentual correto | 2 de 4 cursos | Relatório mostra 50% | ✅ |
| 7.7 | 100% muda status | concluidos = total da trilha | Status da matrícula vira FINISHED | ✅ |
| 7.8 | Entrada texto | concluidos=abc | "Valor inválido." | ✅ |

---

## 8. Relatórios

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 8.1 | Submenu de relatórios | opção 10 | Submenu com 7 opções exibido | ✅ |
| 8.2 | Relatório de alunos | opção 1 no submenu | Lista de alunos cadastrados | ✅ |
| 8.3 | Relatório de cursos | opção 2 no submenu | Lista de cursos cadastrados | ✅ |
| 8.4 | Trilhas com carga total | opção 3 no submenu | Trilhas com carga horária somada | ✅ |
| 8.5 | Alunos por trilha | opção 4 no submenu | Cada trilha com seus alunos e progresso | ✅ |
| 8.6 | Trilha sem alunos | trilha sem matrícula | "Nenhum aluno matriculado nesta trilha." | ✅ |
| 8.7 | Ranking de progresso | opção 5 no submenu | Ordenado por % decrescente | ✅ |
| 8.8 | Desempate no ranking | dois alunos com mesmo % | Ordenado por nome alfabético | ✅ |
| 8.9 | Alunos sem matrícula | opção 6 no submenu | Lista de alunos sem vínculo | ✅ |
| 8.10 | Todos têm matrícula | todos matriculados | "Todos os alunos possuem matrícula." | ✅ |
| 8.11 | Voltar ao menu | opção 7 no submenu | Retorna ao menu principal | ✅ |

---

## 9. Estabilidade

| # | Teste | Entrada | Resultado esperado | Status |
|---|---|---|---|---|
| 9.1 | Texto onde espera número | `abc` no menu | "Opção inválida. Tente novamente." sem crash | ✅ |
| 9.2 | Enter vazio no menu | `` (enter) | "Opção inválida. Tente novamente." | ✅ |
| 9.3 | ID inexistente em busca | id=999 | Mensagem adequada sem crash | ✅ |
| 9.4 | Listar com listas vazias | opções 2,4,6 sem dados | Mensagens de estado vazio | ✅ |
| 9.5 | Operações repetidas | cadastrar mesmo id várias vezes | Bloqueado a partir da segunda vez | ✅ |
| 9.6 | Encerrar após várias operações | opção 11 | "Sistema encerrado." sem crash | ✅ |
| 9.7 | Sem uso de !! | inspeção de código | Nenhum !! em fluxo normal | ✅ |

---

## Resumo

| Categoria | Total | Passou | Falhou |
|---|---|---|---|
| Menu | 7 | 7 | 0 |
| Alunos | 10 | 10 | 0 |
| Cursos | 10 | 10 | 0 |
| Trilhas | 6 | 6 | 0 |
| Associação curso/trilha | 8 | 8 | 0 |
| Matrícula | 9 | 9 | 0 |
| Progresso | 8 | 8 | 0 |
| Relatórios | 11 | 11 | 0 |
| Estabilidade | 7 | 7 | 0 |
| **Total** | **76** | **76** | **0** |
