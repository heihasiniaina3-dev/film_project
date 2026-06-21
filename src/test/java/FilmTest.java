import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    void testObtenirFilmTendance() {
        Film film1 = new Film("Film A", "Action", 120);
        Film film2 = new Film("Film B", "Drame", 140);
        Film film3 = new Film("Film C", "Comédie", 90);

        // On simule des visionnages (Le Film B sera le plus vu)
        film1.incrementerVue();

        film2.incrementerVue();
        film2.incrementerVue(); // 2 vues

        film3.incrementerVue();

        List<Film> catalogue = new ArrayList<>();
        catalogue.add(film1);
        catalogue.add(film2);
        catalogue.add(film3);

        Film tendance = Film.obtenirFilmTendance(catalogue);

        assertNotNull(tendance);
        assertEquals("Film B", tendance.getTitre(), "Le film tendance devrait être le Film B");
    }
}
