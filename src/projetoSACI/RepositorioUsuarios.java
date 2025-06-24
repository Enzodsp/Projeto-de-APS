package projetoSACI;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
	private static RepositorioUsuarios instance;
	private List<Usuario> usuarios = new ArrayList<>();

	private RepositorioUsuarios() {
	}

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