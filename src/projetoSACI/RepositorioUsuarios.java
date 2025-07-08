package projetoSACI;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
	//  Instância Estática: Guarda a única cópia do objeto na memória durante toda a execução do programa
	private static RepositorioUsuarios instance;
	
	private List<Usuario> usuarios = new ArrayList<>();

	// Construtor Privado: Trava a criação manual
	private RepositorioUsuarios() {}

	// Método de Acesso: Porta de entrada global: sempre devolve o mesmo objeto
	public static RepositorioUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuarios();
		}
		return instance;
	}

	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public Usuario buscarPorEmail(String email) {
		return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
	}
}
