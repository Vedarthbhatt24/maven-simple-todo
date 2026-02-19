package com.br.domain;

import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskTest {

    @Test
    void deveCriarTaskComValoresCorretos() {

        String tituloEsperado = "Aprender Java";
        Prioridade prioridadeEsperada = Prioridade.ALTA;
        String categoriaEsperada = "Estudos";
        Status statusEsperado = Status.PENDENTE;

        Task task = new Task(tituloEsperado, prioridadeEsperada, categoriaEsperada, statusEsperado, "");

        assertEquals(tituloEsperado, task.getTitulo());
        assertEquals(prioridadeEsperada, task.getPrioridade());
        assertEquals(categoriaEsperada, task.getCategoria());
        assertEquals(statusEsperado, task.getStatus());

        assertTrue(task.getId() > 0);

        assertNotNull(task.getCriadoAs());
    }

    @Test
    void deveGerarIdsDiferentesParaTasksDiferentes() {
        Task task1 = new Task("Tarefa 1", Prioridade.MEDIA, "Casa", Status.PENDENTE, "");
        Task task2 = new Task("Tarefa 2", Prioridade.BAIXA, "Trabalho", Status.PENDENTE, "");

        assertNotEquals(task1.getId(), task2.getId());
        // task2 deve ter ID maior que task1
        assertTrue(task2.getId() > task1.getId());
    }


    @Test
    void devePermitirAlterarTituloPrioridadeCategoriaEStatus() {
        Task task = new Task("Título antigo", Prioridade.BAIXA, "Antiga", Status.PENDENTE, "");

        task.setTitulo("Título novo");
        task.setPrioridade(Prioridade.ALTA);
        task.setCategoria("Nova categoria");
        task.setStatus(Status.CONCLUIDO);

        assertEquals("Título novo", task.getTitulo());
        assertEquals(Prioridade.ALTA, task.getPrioridade());
        assertEquals("Nova categoria", task.getCategoria());
        assertEquals(Status.CONCLUIDO, task.getStatus());
    }

    @Test
    void toStringDeveMostrarInformacoesDaTask() {
        Task task = new Task("Fazer exercícios", Prioridade.ALTA, "Saúde", Status.PENDENTE, "");

        String texto = task.toString();


        assertTrue(texto.contains("Fazer exercícios"));
        assertTrue(texto.contains("ALTA"));
        assertTrue(texto.contains("Saúde"));
        assertTrue(texto.contains("PENDENTE"));
        assertTrue(texto.contains("id=" + task.getId()));
    }
}
