package com.projeto.todolist.controller;

import java.util.ArrayList;
import java.util.List;

import com.projeto.todolist.entities.Tarefas;
import com.projeto.todolist.entities.TodoModel;
import com.projeto.todolist.repository.TarefasRepository;
import com.projeto.todolist.services.TodoMongoServices;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class TarefasController {

    ArrayList<Tarefas> listaDasTarefas = new ArrayList<Tarefas>();
    TarefasRepository repositorioDeTarefas = new TarefasRepository(listaDasTarefas);
    RestTemplate restTemplate;
    @Autowired
    TodoMongoServices servicosDoMongo;
    
    //Chamadas TODOList
    // @RequestMapping(method = RequestMethod.POST, value = "/adicionar")
    //     public void adicionarTarefas(@RequestBody Tarefas tarefa){
    //         repositorioDeTarefas.adicionarTarefa(tarefa);
    //     }

    @RequestMapping(method = RequestMethod.POST, value = "/adicionar")
        public void adicionarTarefas(@RequestBody Tarefas tarefa){
            servicosDoMongo.salvar(tarefa);
        }
    @RequestMapping(method = RequestMethod.GET, value = "/listar")
        public List<Tarefas> listaTarefas(){
            // return repositorioDeTarefas.listaDeTarefas();
            return servicosDoMongo.listarTarefasServ();
        }

    @RequestMapping(method = RequestMethod.DELETE, value = "/excluir")
        public boolean removerTarefas(@RequestParam String id){
            // return repositorioDeTarefas.removerTarefa(id);
            return servicosDoMongo.removerTarefas(id);
            
        }
    @RequestMapping(method = RequestMethod.GET, value = "/detalhes")
        public Tarefas detalhesTarefas(@RequestParam (value = "id") String id){
            // return repositorioDeTarefas.detalhesTarefa(id);
            return servicosDoMongo.detalhesDaTarefa(id);
        }
    @RequestMapping(method = RequestMethod.PUT, value = "/editar")
        public void editarTarefas(@RequestBody Tarefas tarefa){
        servicosDoMongo.editarTarefa(tarefa);
            //return repositorioDeTarefas.editarTarefas(tarefa);
            
        }
    @RequestMapping(method = RequestMethod.PUT, value = "/concluir")
        public boolean concluirTarefas(@RequestParam (value = "id") String id){
            // return repositorioDeTarefas.realizarTarefa(ediTarefas);
            return servicosDoMongo.concluirTarefa(id);
            
        }
    
    //GETAPI
    @RestController
    @RequestMapping("/todos")
    public class GetAPIController {
        @Autowired
        RestTemplate restTemplate;

        @GetMapping
        public List<TodoModel> getTodos() {
            String theUrl = "https://restcountries.eu/rest/v2/callingcode/372";
            ResponseEntity<List<TodoModel>> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<TodoModel>>() {
            });
            List<TodoModel> todoList = response.getBody();
            return todoList;        
        }
    }
}
