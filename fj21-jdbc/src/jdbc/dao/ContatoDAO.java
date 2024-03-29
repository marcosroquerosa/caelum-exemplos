package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.modelo.Contato;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "insert into contatos" +
				" (nome, email, endereco, dataNascimento)" +
				" values(?,?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public List<Contato> getLista() {
		
		try {
		
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from contatos");
			
			// executa um select
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
								
				// criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// adicionando o objeto
				contatos.add(contato);
								
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
				
	}
	
	public void altera(Contato contato) {
		
		String sql = "update contatos set nome=?, email=?, endereco=?," +
				"dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
				
	}
	
	public void remove(Contato contato) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete " +
					"from contatos where id=?");
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
						
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Contato buscaPorID (Long id) {
		
		Contato contato = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(					
			        "SELECT * FROM contatos WHERE id=? limit 1");
			stmt.setLong(1, id);
						
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next())
				{
					contato = new Contato();
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					
					// montando a data atraves do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(data);
										
				}
			}
			stmt.close();
			
			return contato;
									
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return contato;
	}
	
	public List<Contato> getLista(String nome) {
		
		try {
		
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.
					prepareStatement("SELECT * FROM contatos WHERE nome like ?");			
		    stmt.setString(1, nome + "%");
			
			// executa um select
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
								
				// criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// adicionando o objeto
				contatos.add(contato);
								
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
				
	}
	
	
}
