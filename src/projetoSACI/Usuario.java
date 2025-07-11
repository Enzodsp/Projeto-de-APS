package projetoSACI;

import java.util.UUID;

public abstract class Usuario {
	private UUID id;
	private String nome;
	private String email;
	private String senha;
	private String tipo;

	public Usuario(String nome, String email, String senha, String tipo) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}
}