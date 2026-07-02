import java.time.LocalDateTime;

public class HistoriqueVision {

    private Client client;
    private Film film;
    private LocalDateTime dateVisionnage;

    public HistoriqueVision(Client client, Film film) {
        this.client = client;
        this.film = film;
        this.dateVisionnage = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getDateVisionnage() {
        return dateVisionnage;
    }

    public void setDateVisionnage(LocalDateTime dateVisionnage) {
        this.dateVisionnage = dateVisionnage;
    }

    public void afficherHistorique() {
        System.out.println("===== HISTORIQUE =====");
        System.out.println("Client : " + client.getNom());
        System.out.println("Film : " + film.getTitre());
        System.out.println("Date : " + dateVisionnage);
    }
}