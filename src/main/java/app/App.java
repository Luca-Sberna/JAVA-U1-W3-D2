package app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EventoDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class App {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaUnit1Week3Day2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EventoDAO eventoDAO = new EventoDAO(entityManagerFactory);

		Evento evento1 = new Evento("PoretCast con Aldo e Giovanni", new Date(), "Descrizione dell'evento",
				Evento.TipoEvento.PUBBLICO, 100);

		eventoDAO.save(evento1);
		log.info(evento1.getTitolo());

		evento1 = eventoDAO.getById(evento1.getId());
		System.out.println("titolo: " + evento1.getTitolo() + " id: " + evento1.getId());

		evento1.setTitolo("Nuovo nomeeeee");
		eventoDAO.refresh(evento1);
		log.info(evento1.getTitolo());

		// eventoDAO.delete(evento1);

		entityManager.close();
		entityManagerFactory.close();

	}

}
