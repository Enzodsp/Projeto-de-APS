package projetoSACI;

import java.time.LocalDateTime;
import java.util.UUID;

public class Evento {
	private UUID id;
	private LocalDateTime dataHora;
	private String tipo;
	private String descricao;
	private String nomeResponsavel;
	private String nomeEnvolvido;

	public Evento(LocalDateTime dataHora, String tipo, String descricao, Usuario responsavel, Usuario envolvido) {
		this.id = UUID.randomUUID();
		this.dataHora = dataHora;
		this.tipo = tipo;
		this.descricao = descricao;
		this.nomeResponsavel = responsavel.getNome();
		if (envolvido instanceof Familiar) {
			this.nomeEnvolvido = ((Familiar) envolvido).getNomeIdoso();
		} else {
			this.nomeEnvolvido = envolvido.getNome();
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getNomeEnvolvido() {
		return nomeEnvolvido;
	}

	public void setNomeEnvolvido(String nomeEnvolvido) {
		this.nomeEnvolvido = nomeEnvolvido;
	}

}