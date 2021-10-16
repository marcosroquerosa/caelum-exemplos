package tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tarefas.modelo.Tarefa;

public class BuscaTarefas {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		// Tarefa foi mapeada - type
		// tarefas é o nome da tabela no banco - table
		
		Query query = manager.
				createQuery("SELECT t FROM Tarefa as t " +
						"WHERE t.finalizado = :paramFinalizado");
		
		query.setParameter("paramFinalizado", true);
		
		List<Tarefa> lista = query.getResultList();
		
		for (Tarefa tarefa : lista) {
			System.out.println(tarefa.getDescricao());
		}
	
		manager.close();
	}
	
}
