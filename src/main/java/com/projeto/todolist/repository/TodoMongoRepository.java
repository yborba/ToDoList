package com.projeto.todolist.repository;

import java.util.List;

import com.projeto.todolist.entities.Tarefas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoMongoRepository extends MongoRepository<Tarefas, String> {

    public default boolean criarTarefa(Tarefas tarefa) {
        try {
            save(tarefa);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public default List<Tarefas> listarTarefa() {
        List<Tarefas> tarefasService = findAll();
        return tarefasService;
    }

    public default boolean removerTarefa(String id) {
        deleteById(id);
        return true;
    }

    public default Tarefas encontrarTarefa(String id) {
        try {
            return findById(id).get();
        } catch (Exception e) {
            //TODO: handle exception
            return null;
        }
    }

    public default boolean alterarRealizadoTarefa(Tarefas tarefa) {
        
        try {
            if (tarefa.getRealizado() == false){
                tarefa.setRealizado(true);
                save(tarefa);
                return true;
            }return false;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
        
    }

    public default Tarefas editarTarefa(Tarefas tarefa){
        try {
            boolean existe = existsById(tarefa.getId());
            if (existe == true) {
                save(tarefa);
                return tarefa;
            }return null;
        } catch (Exception e) {
            //TODO: handle exception
            return null;
        }
        
    }
}