package jdbc.modelo;

public class Funcionario {

	/*
	 * create table funcionarios ( id BIGINT NOT NULL AUTO_INCREMENT, nome VARCHAR(255),
	 * usuario VARCHAR(255), senha VARCHAR(255), primary key
	 * (id) );
	 */
	
	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
