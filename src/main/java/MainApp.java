import dao.FilmDao;
import model.Film; //
import java.util.Scanner;

public class MainApp { //
    public static void main(String[] args) {
        FilmDao filmDao = new FilmDao();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("🎵 Bienvenue dans la plateforme de gestion de films 🎵");

        while (continuer) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Ajouter un nouveau film");
            System.out.println("2. Afficher tous les films");
            System.out.println("3. Rechercher un film (par genre ou durée)");
            System.out.println("4. Quitter l'application");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Nettoyage de la ligne après un entier

            switch (choix) {
                case 1:
                    System.out.print("\nEntrez le titre du film : ");
                    String titre = scanner.nextLine();
                    System.out.print("Entrez le genre (ex: Action, Animation) : ");
                    String genre = scanner.nextLine();
                    System.out.print("Entrez la durée (en minutes) : ");
                    int duree = scanner.nextInt();
                    scanner.nextLine();

                    Film nouveauFilm = new Film(titre, genre, duree); //
                    filmDao.ajouterFilm(nouveauFilm);
                    break;

                case 2:
                    // Appel de la méthode pour tout afficher
                    filmDao.afficherTousLesFilms();
                    break;

                case 3:
                    // --- NOUVELLE FONCTIONNALITÉ DE RECHERCHE ---
                    System.out.print("\nEntrez un genre à rechercher (ou tapez 'aucun') : ");
                    String genreSaisi = scanner.nextLine();
                    System.out.print("Entrez une durée maximale en minutes (ou 0 si indifférent) : ");
                    int dureeSaisie = scanner.nextInt();
                    scanner.nextLine();

                    // Appel de la méthode de recherche dans le DAO
                    filmDao.rechercherFilmsParCritere(genreSaisi, dureeSaisie);
                    break;

                case 4:
                    System.out.println("👋 Fermeture de l'application. Veloma !");
                    continuer = false;
                    break;

                default:
                    System.out.println("❌ Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}