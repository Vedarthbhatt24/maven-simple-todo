package com.br.repository;

import java.util.List;
import java.util.Set;
import com.br.domain.Task;

public interface TaskRepository {

    void adicionarTarefa(Task task);

    List<Task> listarTodasTarefas();

    Task listarTarefaPorID(int id);

    void marcarTarefaComoConcluida(Task tarefa);

    Set<Task> listarTarefasConcluidas();

    List<Task> filtrarTarefasPorPrioridade();

    List<Task> listarTarefasPendentes();

}
