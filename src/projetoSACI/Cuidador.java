package projetoSACI;

import java.util.UUID;

public class Cuidador extends Usuario {
	private UUID idIdoso;
	private String disponibilidade;
	private String experiencia;

	public Cuidador(String nome, String email, String senha, UUID idIdoso, String disponibilidade, String experiencia) {
		super(nome, email, senha, "CUIDADOR");
		this.idIdoso = idIdoso;
		this.disponibilidade = disponibilidade;
		this.experiencia = experiencia;
	}

	public UUID getIdIdoso() {
		return idIdoso;
	}

	public void setIdIdoso(UUID idIdoso) {
		this.idIdoso = idIdoso;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String infoIdoso(RepositorioDadosIdoso repo) {
		Familiar idoso = repo.buscarPorId(this.idIdoso);

		if (idoso != null) {
			return "Nome do Idoso: " + idoso.getNomeIdoso() + "\n" + "Histórico Médico: " + idoso.getHistoricoMedico()
					+ "\n" + "Restrições: " + idoso.getRestricoes() + "\n" + "Alergias: " + idoso.getAlergias();
		}
		return "Idoso não encontrado (ID: " + idIdoso + ")";
	}

}