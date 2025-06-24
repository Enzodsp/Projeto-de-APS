package projetoSACI;

import java.util.*;

public class RepositorioDadosIdoso {
	private static RepositorioDadosIdoso instance;

	//Tipo um "Banco de dados" 
	private Map<UUID, Familiar> familiares = new HashMap<>();

	private RepositorioDadosIdoso() {} 

	public static RepositorioDadosIdoso getInstance() {
		if (instance == null) {
			instance = new RepositorioDadosIdoso();
		}
		return instance;
	}

	//Adiciona um familiar(Dados do Idoso) ao repositório
	public void adicionar(Familiar familiar) {
		familiares.put(familiar.getIdIdoso(), familiar);
	}

	//Busca por ID do idoso(Para o método getInfoIdoso)
	public Familiar buscarPorId(UUID idIdoso) {
		return familiares.get(idIdoso);
	}

}
