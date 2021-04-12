package src.entities;

public class Utilisateur {

    private String nom;
    private String prenom;

    public Utilisateur(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

}