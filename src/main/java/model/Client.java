package model;

public class Client extends Utilisateur {

    private Abonnement abonnement;
    private String genrePrefere; // Nouveau : ex "Action", "Animation"

    public Client(int id, String nom, String email, String motDePasse) {
        super(id, nom, email, motDePasse);
    }

    // Nouvelle méthode : Suggérer un film selon le genre préféré du client
    public boolean aimeLeGenre(Film film) {
        return film.getGenre() != null && film.getGenre().equalsIgnoreCase(this.genrePrefere);
    }

    public void rechercherFilm(String titre) {
        System.out.println("Recherche du film : " + titre);
    }

    public void regarderFilm(Film film) {
        film.incrementerVue();
        System.out.println("Lecture du film : " + film.getTitre());
    }

    public void ajouterFavori(Film film) {
        System.out.println(film.getTitre() + " ajouté aux favoris.");
    }

    public void voirDetailsFilm(Film film) {
        System.out.println("Titre : " + film.getTitre());
        System.out.println("Genre : " + film.getGenre());
        System.out.println("Durée : " + film.getDuree() + " min");
    }

    public void souscrireAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
        System.out.println("model.Abonnement " + abonnement.getType() + " activé.");
    }

    public void payerAbonnement() {
        if(abonnement != null){
            System.out.println("Paiement de " + abonnement.getPrix() + " Ar effectué.");
        }
    }

    public void voirAbonnement() {
        if(abonnement != null){
            System.out.println("Type : " + abonnement.getType());
            System.out.println("Prix : " + abonnement.getPrix() + " Ar");
        }
    }

    @Override
    public void seDeconnecter() {
        System.out.println("model.Client déconnecté.");
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public String getGenrePrefere() {
        return genrePrefere;
    }

    public void setGenrePrefere(String genrePrefere) {
        this.genrePrefere = genrePrefere;
    }
}