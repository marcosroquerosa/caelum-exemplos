package tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tarefas.modelo.Tarefa;

public class AtualizarTarefa {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(2L);
		tarefa.setDescricao("Estudar JPA e Hibernate");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalização(null);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa:" + tarefa.getId());
		
		manager.close();
		
	}
	
}
