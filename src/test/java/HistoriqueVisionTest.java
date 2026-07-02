import model.Client;
import model.Film;
import model.HistoriqueVision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoriqueVisionTest {

    @Test
    void testCreationHistorique() {
        Client client = new Client(2, "Mihary", "mihary@email.com", "pass");
        Film film = new Film("Interstellar");

        HistoriqueVision historique = new HistoriqueVision(client, film);

        assertNotNull(historique.getDateVisionnage());
        assertEquals(client, historique.getClient());
        assertEquals(film, historique.getFilm());
    }
}