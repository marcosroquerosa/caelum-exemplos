package teste;

import jdbc.dao.FuncionarioDAO;
import jdbc.modelo.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Teste");
		funcionario.setUsuario("teste");
		funcionario.setSenha("1234");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adiciona(funcionario);
		
		System.out.println("Gravado!");
		
	}
}
