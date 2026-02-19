package com.br.repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import com.br.domain.Task;
import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;

public class TaskRepositoryImpl implements TaskRepository {

    // Uma **lista ordenada** para armazenar todas as tarefas na ordem de criação
    private List<Task> historicoTarefas = new ArrayList<>();

    // Um **conjunto** para armazenar tarefas concluídas (garantindo que não haja duplicatas)
    private Set<Task> tarefasConcluidas = new HashSet<>();

    // Um **map** para agrupar tarefas por prioridade
    private Map<Prioridade, List<Task>> tarefasPorPrioridade = new HashMap<>();

    // Um **map** para agrupar tarefas por categoria
    private Map<String, List<Task>> tarefasPorCategoria = new HashMap<>();

    // Uma **fila** para representar as tarefas pendentes na ordem em que foram adicionadas (FIFO)
    private Queue<Task> tarefasPendentes = new ArrayDeque<>();

    @Override
    public void adicionarTarefa(Task task) {

        historicoTarefas.add(task);
    }

    @Override
    public List<Task> listarTodasTarefas() {

        return historicoTarefas;
    }

    @Override
    public Task listarTarefaPorID(int id) {

        return historicoTarefas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void marcarTarefaComoConcluida(Task tarefa) {
        tarefasConcluidas.add(tarefa);

    }

    @Override
    public Set<Task> listarTarefasConcluidas() {
        return tarefasConcluidas;
    }

    @Override
    public List<Task> filtrarTarefasPorPrioridade() {

        return historicoTarefas.stream().filter(t -> t.getPrioridade() == Prioridade.ALTA)
                .sorted(Comparator.comparing(Task::getCriadoAs).reversed()).toList();
    }

    public List<Task> listarTarefasPendentes() {
        return historicoTarefas.stream().filter(t -> t.getStatus() == Status.PENDENTE).toList();
    }



}
