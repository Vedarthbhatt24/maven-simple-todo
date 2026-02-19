package com.br.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.br.domain.Task;
import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;
import com.br.exception.TaskNullResponse;
import com.br.repository.TaskRepository;
import com.br.repository.TaskRepositoryImpl;

public class TaskServiceImplTest {

    TaskRepository repository;
    Task task;
    TaskService service;

    @BeforeEach
    void setUp() {

        repository = new TaskRepositoryImpl();
        Task.resetar();
        task = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        service = new TaskServiceImpl(repository);

    }

    @Test
    public void deveAdicionarComSucesso() {

        service.adicionarTarefa(task);

        assertEquals(1, repository.listarTodasTarefas().size());
    }

    @Test
    public void deveLancarExceptionAdicionarNullo() {

        TaskNullResponse e =
                assertThrows(TaskNullResponse.class, () -> new Task(null, null, null, null, ""));

        assertTrue(e.getMessage().contains("Não e permitido valores nullos"));
    }

    @Test
    public void deveListarTodasTarefas() {

        Task task2 = new Task("tarefa 2", Prioridade.ALTA, "Java", Status.PENDENTE, "");

        service.adicionarTarefa(task);
        service.adicionarTarefa(task2);
        service.listarTodasTarefas();

        assertEquals(2, service.listarTodasTarefas().size());

    }

    @Test
    void listarTarefaPorIdDeveLancarException() {

        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> service.listarTarefaPorID(-1));

        assertTrue(e.getMessage().equals("O ID da tarefa deve ser maior que zero"));
    }

    @Test
    void marcarTarefaComoConcluidaDeveLancarException() {

        TaskNullResponse e = assertThrows(TaskNullResponse.class, () -> service
                .marcarTarefaComoConcluida((int) new Task(null, null, null, null, null).getId()));

        assertTrue(e.getMessage().equals("Não e permitido valores nullos"));
    }

    @Test
    void marcarTarefaComoConcluidaComSucesso() {

        repository.adicionarTarefa(task);

        service.marcarTarefaComoConcluida((int) task.getId());

        assertEquals(Status.CONCLUIDO, task.getStatus());
    }

    @Test
    void listarTarefasConcluidasComSucesso() {

        repository.adicionarTarefa(task);

        service.marcarTarefaComoConcluida((int) task.getId());

        assertEquals(1, repository.listarTarefasConcluidas().size());
    }

    @Test
    void filtrarTarefasPorPrioridadeComSucesso() {

        Task task1 = new Task("tarefa1", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task2 = new Task("tarefa2", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task3 = new Task("tarefa3", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task4 = new Task("tarefa4", Prioridade.BAIXA, "Java", Status.PENDENTE, "");

        repository.adicionarTarefa(task1);
        repository.adicionarTarefa(task2);
        repository.adicionarTarefa(task3);
        repository.adicionarTarefa(task4);

        assertEquals(3, service.filtrarTarefasPorPrioridade().size());

    }

    @Test
    void listarTarefasPendentesComSucesso() {

        Task task1 = new Task("tarefa1", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task2 = new Task("tarefa2", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task3 = new Task("tarefa3", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        Task task4 = new Task("tarefa4", Prioridade.BAIXA, "Java", Status.CONCLUIDO, "");

        repository.adicionarTarefa(task1);
        repository.adicionarTarefa(task2);
        repository.adicionarTarefa(task3);
        repository.adicionarTarefa(task4);

        assertEquals(3, service.listarTarefasPendentes().size());
    }
}
