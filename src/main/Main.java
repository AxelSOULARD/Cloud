package src.main;

import java.util.ArrayList;
import java.util.Random;

import src.entities.Petition;
import src.entities.Utilisateur;

class Echo {
    
    public static void main(String[] args) {
      
        ArrayList<Utilisateur> mesUtilisateurs  = new ArrayList<>();
        ArrayList<Petition> mesPetitions  = new ArrayList<>();
        int nombreUtilisateur = 1000;
        int nombrePetitions = 500;
        int nombreMaxSignatures = 2000;

        for(int i = 0; i < nombreUtilisateur; i++){
            mesUtilisateurs.add(new Utilisateur("utilisateur" + i)); 
        }

        for(int j = 0; j < nombrePetitions; j++){
            
            Petition petition = new Petition();
            petition.setCreateur(mesUtilisateurs.get(new Random().nextInt(nombreUtilisateur)));

            for(int k = 0; k < new Random().nextInt(nombreMaxSignatures); k++){
                petition.addParticipant(mesUtilisateurs.get(new Random().nextInt(nombreUtilisateur)));
            }

            mesPetitions.add(petition);
        }
        
    }
  }
