package com.br.service;

import java.util.List;
import java.util.Set;
import com.br.domain.Task;
import com.br.domain.enums.Status;
import com.br.exception.TaskNullResponse;
import com.br.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {

        this.repository = repository;
    }

    @Override
    public void adicionarTarefa(Task task) {

        if (task.equals(null)) {
            throw new TaskNullResponse("Valor de entrada não pode ser nullo");
        }

        repository.adicionarTarefa(task);
    }

    @Override
    public Task listarTarefaPorID(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O ID da tarefa deve ser maior que zero");
        }

        return repository.listarTarefaPorID(id);
    }

    @Override
    public List<Task> listarTodasTarefas() {

        return repository.listarTodasTarefas();
    }

    @Override
    public void marcarTarefaComoConcluida(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O ID da tarefa deve ser maior que zero");
        }

        Task tarefa = listarTarefaPorID(id);

        if (tarefa == null) {
            throw new TaskNullResponse("Tarefa não encontrada");
        }

        if (tarefa.getStatus() == Status.CONCLUIDO) {
            throw new IllegalStateException("A tarefa já está concluída");
        }

        tarefa.setStatus(Status.CONCLUIDO);
        repository.marcarTarefaComoConcluida(tarefa);
    }

    @Override
    public Set<Task> listarTarefasConcluidas() {

        return repository.listarTarefasConcluidas();
    }

    @Override
    public List<Task> filtrarTarefasPorPrioridade() {

        return repository.filtrarTarefasPorPrioridade();

    }

    @Override
    public List<Task> listarTarefasPendentes() {
        return repository.listarTarefasPendentes();

    }

    @Override
    public void filtrarTarefasPorCategoria() {}

    @Override
    public void mostrarEstatisticas() {}


}
