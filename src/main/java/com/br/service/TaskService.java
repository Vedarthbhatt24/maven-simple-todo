package com.br.service;

import java.util.List;
import java.util.Set;
import com.br.domain.Task;

public interface TaskService {

    void adicionarTarefa(Task task);

    List<Task> listarTodasTarefas();

    Task listarTarefaPorID(int id);

    Set<Task> listarTarefasConcluidas();

    void marcarTarefaComoConcluida(int id);

    List<Task> filtrarTarefasPorPrioridade();

    List<Task> listarTarefasPendentes();

    void filtrarTarefasPorCategoria();

    void mostrarEstatisticas();
}
