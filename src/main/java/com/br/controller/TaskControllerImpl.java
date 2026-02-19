package com.br.controller;

import java.util.List;
import com.br.domain.Task;
import com.br.service.TaskService;

public class TaskControllerImpl implements TaskController {

    private TaskService service;

    public TaskControllerImpl(TaskService service) {
        this.service = service;
    }

    @Override
    public void adicionarTarefa(Task task) {

        service.adicionarTarefa(task);

    }

    @Override
    public List<Task> listarTodasTarefas() {

        return service.listarTodasTarefas();
    }
}
