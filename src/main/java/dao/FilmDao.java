package dao;

import config.DatabaseConfig;
import model.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; // Regroupé proprement avec les autres imports

public class FilmDao { // <-- C'est cette ouverture de classe qui manquait !

    // 1. Conservation de ta méthode pour AJOUTER un film
    public void ajouterFilm(Film film) {
        String sql = "INSERT INTO film (titre, genre, duree, nb_vues) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, film.getTitre());
            pstmt.setString(2, film.getGenre());
            pstmt.setInt(3, film.getDuree());
            pstmt.setInt(4, film.getNbVues());

            pstmt.executeUpdate();
            System.out.println("Film '" + film.getTitre() + "' ajouté avec succès dans PostgreSQL !");

        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de l'ajout : " + e.getMessage());
        }
    }

    // 2. Méthode pour voir TOUS les films
    public void afficherTousLesFilms() {
        String sql = "SELECT titre, genre, duree, nb_vues FROM film";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- 🎬 LISTE COMPLÈTE DES FILMS ---");
            boolean aucunFilm = true;
            while (rs.next()) {
                aucunFilm = false;
                System.out.println("- " + rs.getString("titre") + " | Genre: " + rs.getString("genre") + " | Durée: " + rs.getInt("duree") + " min | Vues: " + rs.getInt("nb_vues"));
            }
            if (aucunFilm) {
                System.out.println("Aucun film dans la base de données.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    // 3. Méthode pour chercher avec des critères (par Genre ou par Durée max)
    public void rechercherFilmsParCritere(String genreRecherche, int dureeMax) {
        String sql = "SELECT titre, genre, duree, nb_vues FROM film WHERE LOWER(genre) = LOWER(?) OR duree <= ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, genreRecherche);
            pstmt.setInt(2, dureeMax);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- 🔍 RÉSULTAT DE LA RECHERCHE ---");
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    System.out.println("- " + rs.getString("titre") + " | Genre: " + rs.getString("genre") + " | Durée: " + rs.getInt("duree") + " min");
                }
                if (!trouve) {
                    System.out.println("Aucun film ne correspond à ces critères.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
} // <-- Fermeture finale de la classe FilmDao