package com.br.controller;

import java.util.List;
import com.br.domain.Task;

public interface TaskController {

    void adicionarTarefa(Task task);

    List<Task> listarTodasTarefas();
}
