package projetoSACI;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {

	public static void main(String[] args) {

		//Criar familiar
		UUID carlosId = UUID.randomUUID();
		Familiar familiar = new Familiar("João Silva", "joao@exemplo.com", "senha123", "Carlos Souza", carlosId,
				"Hipertenso", "Dieta sem sal", "Penicilina");

		//Criar cuidador
		Cuidador cuidador = new Cuidador("Maria Souza", "maria@exemplo.com", "cuidador123", carlosId, "Manhã e Tarde",
				"5 anos de experiência");

		//Criar evento
		LocalDateTime dataHora = LocalDateTime.of(2024, 11, 21, 10, 30);
		Evento consulta = new Evento(dataHora, "Consulta", "Cardiologista - Hospital Santa Maria", cuidador, familiar);

		//Criar agenda
		Agenda agendaCuidador = new Agenda(cuidador);
		//Evento adicionado na Agenda
		agendaCuidador.adicionarEvento(consulta);

		//Listar eventos
		List<Evento> eventos = agendaCuidador.listarEventos();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		eventos.forEach(e -> System.out.printf("Data e Hora: %s | Tipo: %s | Descrição: %s | Cuidador: %s | Idoso: %s%n",
						e.getDataHora().format(formatter), e.getTipo(), e.getDescricao(), e.getNomeResponsavel(),
						e.getNomeEnvolvido()));

		//Editar evento
		UUID eventoId = consulta.getId();
		boolean editado = agendaCuidador.editarEvento(eventoId, dataHora.plusDays(1), "Consulta-Urgente",
				"Cardiologista - Hospital Santa Maria - Consulta remarcada");

		if (editado) {
			eventos.forEach(e -> System.out.printf(
					"%nATUALIZADA| Data e Hora: %s | Tipo: %s | Descrição: %s | Cuidador: %s | Idoso: %s%n",
					e.getDataHora().format(formatter), e.getTipo(), e.getDescricao(), e.getNomeResponsavel(),
					e.getNomeEnvolvido()));
		} else {
			System.out.println("Erro: Evento não encontrado!");
		}

		//Usar repositórios Singleton
		RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance();
		repositorio.adicionarUsuario(familiar);
		repositorio.adicionarUsuario(cuidador);

		RepositorioDadosIdoso repo = RepositorioDadosIdoso.getInstance();
		repo.adicionar(familiar);
		
		//Autenticar usuário
		Usuario usuario = repositorio.buscarPorEmail("maria@exemplo.com");
		if (usuario != null && usuario.autenticar("cuidador123")) {
			System.out.println("Autenticação bem-sucedida!");
		} else {
			System.out.println("Erro: Autenticação inválida!");
		}
		
		//Método atualizar histórico
		familiar.atualizarHistorico("Hipertenso, Diabéte tipo A");
		
		//Informações sobre o idoso vinculado ao cuidador
		String infoIdoso = cuidador.infoIdoso(repo);
		System.out.println("--- INFORMAÇÕES DO IDOSO ---");
		System.out.println(infoIdoso);

	}
}
