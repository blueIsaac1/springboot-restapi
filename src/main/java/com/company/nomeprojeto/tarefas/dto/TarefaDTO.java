package com.company.nomeprojeto.tarefas.dto;

public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;

    public Long getId() { // metodo get para obter o ID da tarefa
        return id;
    }
    public void setId(Long id) { // metodo set para definir o ID da tarefa
        this.id = id;
    }
    public String getTitulo() { // metodo get para obter o titulo da tarefa
        return titulo;
    }
    public void setTitulo(String titulo) { // metodo set para definir o titulo da tarefa
        this.titulo = titulo;
    }
    public String getDescricao() { // metodo get para obter a descricao da tarefa
        return descricao;
    }
    public void setDescricao(String descricao) { // metodo set para definir a descricao da tarefa
        this.descricao = descricao;
    }
}
