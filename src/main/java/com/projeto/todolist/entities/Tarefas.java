package com.projeto.todolist.entities;

import java.util.UUID;

public class Tarefas {
    //Atributos
    private String titulo;
    private String descricao;
    private String data;
    private boolean realizado;
    private String id;
    

    //Construtor
    public Tarefas(String titulo, String descricao, String data){
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.realizado = false;
        this.id = UUID.randomUUID().toString();
    }

    //Metodos Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public boolean getRealizado(){
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

	public static void forEach(Object object) {
	}
}
