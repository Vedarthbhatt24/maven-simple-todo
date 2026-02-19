# Gerenciador de Tarefas (Todo List) 📝

![CI](https://github.com/CodeWithEdgard/todo-collections/actions/workflows/ci.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-JaCoCo-blue)

**Projeto de estudo em Java focado no domínio prático das Collections.**

Um gerenciador de tarefas simples no console que utiliza diferentes tipos de Collections do Java para organizar, filtrar e manipular tarefas de forma eficiente.

### Objetivo do Projeto

Praticar e consolidar o uso das principais **Collections do Java**:

- `ArrayList` – lista principal de tarefas
- `HashSet` – tarefas concluídas (sem duplicatas)
- `HashMap` – agrupamento por prioridade e categoria
- `Queue` – fila de tarefas pendentes (FIFO)
- Streams e `Collections.sort()` – ordenação e filtros avançados

Além disso, reforçar boas práticas:

- Arquitetura limpa
- Testes unitários com JUnit 5
- Logging profissional com SLF4J
- Maven para build e dependências
- Cobertura de testes com JaCoCo

### Funcionalidades Implementadas

- Adicionar tarefa (título obrigatório, descrição, prioridade, categoria)
- Listar todas, pendentes e concluídas
- Marcar tarefa como concluída
- Filtrar por prioridade (ALTA, MÉDIA, BAIXA)
- Filtrar por categoria (ex: trabalho, estudos, pessoal)
- Fila de tarefas pendentes (ordem de chegada)
- Ordenar tarefas por data de criação
- Estatísticas (total, pendentes, concluídas, por prioridade/categoria)
- Validação de título único

### Tecnologias e Boas Práticas

- **Java 17**
- **Maven** (build e dependências)
- **SLF4J + simple** (logging)
- **JUnit 5** (testes unitários)
- **JaCoCo** (cobertura de testes)
- Injeção de dependências manual
- Exceções personalizadas
- Constantes organizadas

### Como Executar

```bash
# Rodar testes
mvn clean test

# Executar demo no console
mvn exec:java -Dexec.mainClass="br.com.zpx.todo.presentation.Application"
```

### Exemplo de Uso (logs no console)

```
[main] INFO  br.com.zpx.todo.service.TodoManager - Tarefa adicionada: Estudar Collections
[main] INFO  br.com.zpx.todo.service.TodoManager - Tarefa "Estudar Collections" marcada como concluída
[main] INFO  br.com.zpx.todo.service.TodoManager - Estatísticas: Total: 5 | Pendentes: 3 | Concluídas: 2
```

---
