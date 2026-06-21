import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    private Film film;

    @BeforeEach
    void setUp() {
        film = new Film("One Piece Film: Red");
    }

    @Test
    void testInitialisationFilm() {
        assertEquals("One Piece Film: Red", film.getTitre());
        assertEquals(0, film.getNbVues());
    }

    @Test
    void testIncrementerVue() {
        film.incrementerVue();
        assertEquals(1, film.getNbVues());
    }
}
