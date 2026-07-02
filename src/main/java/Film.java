import java.util.List;

public class Film {

    private String titre;
    private int nbVues;
    private String genre;
    private int duree;

    // Ancien constructeur préservé
    public Film(String titre) {
        this.titre = titre;
        this.nbVues = 0;
    }

    // Nouveau constructeur plus pratique
    public Film(String titre, String genre, int duree) {
        this.titre = titre;
        this.genre = genre;
        this.duree = duree;
        this.nbVues = 0;
    }

    // Nouvelle fonctionnalité : Trouver le film tendance parmi une liste de films
    public static Film obtenirFilmTendance(List<Film> catalogue) {
        if (catalogue == null || catalogue.isEmpty()) {
            return null;
        }
        Film plusPopulaire = catalogue.get(0);
        for (Film f : catalogue) {
            if (f.getNbVues() > plusPopulaire.getNbVues()) {
                plusPopulaire = f;
            }
        }
        return plusPopulaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void incrementerVue() {
        nbVues++;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}