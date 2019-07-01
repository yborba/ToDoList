package com.projeto.todolist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.projeto.todolist.entities.Tarefas;
import com.projeto.todolist.repository.TarefasRepository;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationArguments.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodolistApplicationTests {

	static List<Tarefas> tarefasList;
	static TarefasRepository tarefasRepository;
	static Tarefas tarefa;

	@BeforeClass
	public static void inicialize(){
		tarefa = new Tarefas("teste", "testeDesc","01/01/01");
		tarefasList = new ArrayList<Tarefas>();
		tarefasRepository = new TarefasRepository(tarefasList);
	}
	
	@Test
	public void adicionarTarefasTest(){
		tarefasRepository.adicionarTarefa(tarefa);

		assertTrue(tarefasList.size()>0);
	}

	
	@Test
	public void removerTarefaTest(){
		tarefasRepository.removerTarefa(tarefa.getId());
		
		assertTrue(tarefasList.size()==0);
	}
	
	@Test
	public void listaDeTarefasTest(){
		tarefasList = tarefasRepository.listaDeTarefas();

		assertNotNull(tarefasList);
	}
	
	@Test
	public void detalhesTarefaTest(){
		tarefa = tarefasRepository.detalhesTarefa(tarefa.getId());
				
		assertNotNull(tarefa);
	}

	@Test
	public void realizarTarefaTest(){
		boolean resultadoRealizado = tarefasRepository.realizarTarefa(tarefa.getId());
		boolean testRealizado = true;
		
		assertEquals(testRealizado, resultadoRealizado);
	}

	@Test
	public void editarTarefasTest(){
		tarefa.setTitulo("Editada");
		boolean tarefaEditada = tarefasRepository.editarTarefas(tarefa);

		assertTrue(tarefaEditada);						
	}
}