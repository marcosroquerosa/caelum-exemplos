package teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.ContatoDAO;
import jdbc.modelo.Contato;

public class TestaLista {
	
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Email: " + contato.getEmail());
			
			// forma de apresentação da data
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Data de Nascimento: " + 
					fmt.format(contato.getDataNascimento().getTime()) + "\n");
		}
				
		System.out.println("Teste busca por ID");
		Contato contato = dao.buscaPorID(2L);		
		if (contato != null) {
			System.out.println("Nome: " + contato.getNome());
		}
		
	}

}
