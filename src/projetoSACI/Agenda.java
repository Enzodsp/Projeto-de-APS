package projetoSACI;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

public class Agenda {
	private List<Evento> eventos;
	private Usuario dono;

	public Agenda(Usuario dono) {
		this.dono = dono;
		this.eventos = new ArrayList<>();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	//adiciona o evento na agenda
	public void adicionarEvento(Evento evento) {
		eventos.add(evento);
	}

	//remove o evento
	public boolean removerEvento(UUID id) {
		return eventos.removeIf(e -> e.getId().equals(id));
	}

	//Lista todos os eventos 
	public List<Evento> listarEventos() {
		return new ArrayList<>(eventos); 
	}

	//Edita um evento criado 
	public boolean editarEvento(UUID id, LocalDateTime novaData, String novoTipo, String novaDescricao) {
		for (Evento evento : eventos) {
			if (evento.getId().equals(id)) {
				evento.setDataHora(novaData);
				evento.setTipo(novoTipo);
				evento.setDescricao(novaDescricao);
				return true; 
			}
		}
		return false; 
	}
}