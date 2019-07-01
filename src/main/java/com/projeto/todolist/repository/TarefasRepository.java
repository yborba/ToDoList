package com.projeto.todolist.repository;

import java.util.List;

import com.projeto.todolist.entities.Tarefas;

public class TarefasRepository {

    List<Tarefas> tarefasList;
    public TarefasRepository(List<Tarefas> tarefasList){
        this.tarefasList = tarefasList;
    }
    
    public void adicionarTarefa(Tarefas tarefas){
        tarefasList.add(tarefas);
    }
    
    public  List<Tarefas> listaDeTarefas(){
        return tarefasList;
    }

    public boolean removerTarefa(String id){
        for(Tarefas item : this.tarefasList){
            if (item.getId().equals(id)){
                this.tarefasList.remove(item);
                return true;
            }
        }
        return false;
    }

    public Tarefas detalhesTarefa(String id){
        for (Tarefas item : this.tarefasList){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public boolean realizarTarefa(String id){
        for (Tarefas item : this.tarefasList){
            if (item.getId().equals(id)){
                int index = this.tarefasList.indexOf(item);
                item.setRealizado(true);
                this.tarefasList.set(index, item);
                return true;
            }
        }
        return false;
    }
    public boolean editarTarefas (Tarefas tarefaEditada){
        for (Tarefas item : this.tarefasList){
            if (item.getId().equals(tarefaEditada.getId())){
                int index = this.tarefasList.indexOf(item);
                this.tarefasList.set(index, tarefaEditada);
                return true;
            }
        }
        return false;
    }
}