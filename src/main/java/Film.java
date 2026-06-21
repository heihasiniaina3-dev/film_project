public class Film {

    private String titre;
    private int nbVues;
    private String genre;
    private int duree;

    public Film(String titre) {
        this.titre = titre;
        this.nbVues = 0;
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