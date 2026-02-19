package com.br.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.br.domain.Task;
import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;
import com.br.repository.TaskRepository;
import com.br.repository.TaskRepositoryImpl;
import com.br.service.TaskService;
import com.br.service.TaskServiceImpl;

public class TaskControllerTest {

    Task task, task1;
    TaskRepository repository;
    TaskService service;
    TaskController controller;


    @BeforeEach
    void setUp() {

        task = new Task("oi", Prioridade.ALTA, "Java", Status.PENDENTE, "");
        task1 = new Task("est", Prioridade.ALTA, "Java", Status.PENDENTE, "");


        repository = new TaskRepositoryImpl();
        service = new TaskServiceImpl(repository);
        controller = new TaskControllerImpl(service);

    }

    @Test
    public void deveAdicionarComSucesso() {

        controller.adicionarTarefa(task);

        assertEquals(1, controller.listarTodasTarefas().size());

    }

    @Test
    public void deveListarTodasTarefas() {

        controller.adicionarTarefa(task);
        controller.adicionarTarefa(task1);

        assertEquals(2, controller.listarTodasTarefas().size());
    }
}
