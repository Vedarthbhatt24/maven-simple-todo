package com.br.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.br.domain.Task;
import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;

public class TaskRepositoryTest {

    TaskRepository repository = new TaskRepositoryImpl();
    Task task;
    Task task2;
    Task task3;
    Task task4;

    @BeforeEach
    void setUp() {
        Task.resetar(); // Zera o contador antes de cada teste

        task = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        task2 = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        task3 = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        task4 = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");

    }


    @Test
    void deveSalvarComSucesso() {

        repository.adicionarTarefa(task);

        assertEquals(1, repository.listarTodasTarefas().size());

    }

    @Test
    void deveListarTarefasComSucesso() {

        repository.adicionarTarefa(task);
        repository.adicionarTarefa(task2);
        repository.adicionarTarefa(task3);
        repository.adicionarTarefa(task4);

        assertEquals(4, repository.listarTodasTarefas().size());

    }

    @Test
    void deveTrazerAtarefa() {

        repository.adicionarTarefa(task);

        Task valor = repository.listarTarefaPorID(1);

        assertEquals(task.getId(), valor.getId());
    }
}
