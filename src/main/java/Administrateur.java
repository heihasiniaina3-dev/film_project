public class Administrateur extends Utilisateur {

    public Administrateur(int id, String nom, String email, String motDePasse) {
        super(id, nom, email, motDePasse);
    }

    public void voirStatistiques() {
        System.out.println("Affichage des statistiques.");
    }

    public void voirAbonnements() {
        System.out.println("Affichage des abonnements.");
    }

    public void voirRevenus(double montant) {
        System.out.println("Revenus totaux : " + montant + " Ar");
    }
}