package com.projeto.todolist.services;

import java.util.List;

import com.projeto.todolist.entities.Tarefas;
import com.projeto.todolist.repository.TodoMongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoMongoServices {

    @Autowired
    private TodoMongoRepository tarefasRepository;

    public void salvar(Tarefas tarefa){
        tarefasRepository.save(tarefa);
    }

    public List<Tarefas> listarTarefasServ(){
        return tarefasRepository.listarTarefa();
    }

    public boolean removerTarefas(String id){
        tarefasRepository.removerTarefa(id);
        return true;
    }

    public Tarefas detalhesDaTarefa(String id){
       return tarefasRepository.encontrarTarefa(id);
    }

    public boolean concluirTarefa(String id){
        Tarefas tarefa = tarefasRepository.encontrarTarefa(id);
        return tarefasRepository.alterarRealizadoTarefa(tarefa);
    }

    public Tarefas editarTarefa(Tarefas tarefa){
        return tarefasRepository.editarTarefa(tarefa);
    }
}