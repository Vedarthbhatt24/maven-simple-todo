package com.br.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;
import com.br.domain.enums.Prioridade;
import com.br.domain.enums.Status;
import com.br.exception.TaskNullResponse;
import com.br.util.DateTimeUtils;

public class Task {

    private long id;

    private String titulo;

    private LocalDateTime criadoAs;

    private Prioridade prioridade;

    private String categoria;

    private Status status;

    private String descricao;

    private static AtomicLong contador = new AtomicLong(0);

    public Task(String titulo, Prioridade prioridade, String categoria, Status status,
            String descricao) {

        if (titulo == null || prioridade == null || categoria == null || status == null) {
            throw new TaskNullResponse("Não e permitido valores nullos");
        }

        if (titulo.trim().isEmpty() || categoria.trim().isEmpty()) {
            throw new TaskNullResponse("Não e permitido valores nullos");
        }

        this.titulo = titulo;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
        this.descricao = descricao;

        this.criadoAs = LocalDateTime.now();
        this.id = contador.incrementAndGet();
    }

    public long getId() {
        return this.id;
    }

    // SEM SETTER PARA ID

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public LocalDateTime getCriadoAs() {
        return this.criadoAs;
    }

    // SEM SETTER PARA DATA E HORA

    public Prioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((criadoAs == null) ? 0 : criadoAs.hashCode());
        result = prime * result + ((prioridade == null) ? 0 : prioridade.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id != other.id)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (criadoAs == null) {
            if (other.criadoAs != null)
                return false;
        } else if (!criadoAs.equals(other.criadoAs))
            return false;
        if (prioridade != other.prioridade)
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", titulo=" + titulo + ", criadoAs="
                + DateTimeUtils.formatar(criadoAs) + ", prioridade=" + prioridade + ", categoria="
                + categoria + ", status=" + status + "]";
    }

    public static void resetar() {
        contador.set(0);
    }

}
