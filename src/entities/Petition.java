package src.entities;

import java.util.ArrayList;

public class Petition {

    private String nom;
    private Utilisateur createur;
    private ArrayList<Utilisateur> participants;;

    public Petition(){
        this.participants = new ArrayList<>();
    }

    public String getNom(){
        return this.nom;
    }

    public Utilisateur getCreateur(){
        return this.createur;
    }

    public void setCreateur(Utilisateur createur){
        this.createur = createur;
    }

    public ArrayList<Utilisateur> getParticipants() {
        return this.participants;
    }

    public void addParticipant(Utilisateur participant){
        this.participants.add(participant);
    }

    public void setParticipants(ArrayList<Utilisateur> participants){
        this.participants = participants;
    }

    public void removeAllParticipants(){
        this.participants.clear();
    }

}