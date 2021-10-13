package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionFactory;
import jdbc.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;
	
	public FuncionarioDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
public void adiciona(Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionarios" +
				" (nome, usuario, senha)" +
				" VALUES(?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
					
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	
}
