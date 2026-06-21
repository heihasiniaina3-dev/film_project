import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    private Abonnement abonnement;
    private Film film;

    @BeforeEach
    void setUp() {
        client = new Client(1, "Hasiniaina", "hasiniaina@email.com", "securePass123");
        abonnement = new Abonnement("Premium", 25000.0);
        film = new Film("Inception");
    }

    @Test
    void testSouscrireEtConsulterAbonnement() {
        client.souscrireAbonnement(abonnement);
        assertDoesNotThrow(() -> client.voirAbonnement());
        assertDoesNotThrow(() -> client.payerAbonnement());
    }

    @Test
    void testRegarderFilmIncrementeLesVues() {
        assertEquals(0, film.getNbVues());
        client.regarderFilm(film);
        assertEquals(1, film.getNbVues());
    }

    @Test
    void testHeritageUtilisateur() {
        assertEquals("Hasiniaina", client.getNom());
        client.setNom("Nouveau Nom");
        assertEquals("Nouveau Nom", client.getNom());
    }
    @Test
    void testSuggestionSelonGenrePrefere() {
        client.setGenrePrefere("Animation");

        Film filmAnime = new Film("One Piece Film: Red", "Animation", 115);
        Film filmSciFi = new Film("Interstellar", "Sci-Fi", 169);

        // Le client devrait aimer le film d'animation mais pas la science-fiction
        assertTrue(client.aimeLeGenre(filmAnime), "Le client devrait aimer ce genre");
        assertFalse(client.aimeLeGenre(filmSciFi), "Le client ne devrait pas aimer ce genre");
    }
}