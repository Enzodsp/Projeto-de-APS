package projetoSACI;

import java.util.UUID;

public class Familiar extends Usuario {
	private UUID idIdoso; 
	private String nomeIdoso; 
	private String historicoMedico;
	private String restricoes;
	private String alergias;

	public Familiar(String nome, String email, String senha, String nomeIdoso, UUID idIdoso, String historicoMedico,
			String restricoes, String alergias) {
		super(nome, email, senha, "FAMILIAR");
		this.nomeIdoso = nomeIdoso;
		if (idIdoso != null) {
			this.idIdoso = idIdoso;
		} else {
			this.idIdoso = UUID.randomUUID();
		}
		this.historicoMedico = historicoMedico;
		this.restricoes = restricoes;
		this.alergias = alergias;
	}

	public String getNomeIdoso() {
		return nomeIdoso;
	}

	public void setNomeIdoso(String nomeIdoso) {
		this.nomeIdoso = nomeIdoso;
	}

	public UUID getIdIdoso() {
		return idIdoso;
	}

	public void setIdIdoso(UUID idIdoso) {
		this.idIdoso = idIdoso;
	}

	public String getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	//atualiza o histórico Médico
	public void atualizarHistorico(String novoHistorico) {
		this.historicoMedico = novoHistorico;
	}


}