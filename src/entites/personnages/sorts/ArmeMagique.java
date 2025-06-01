package entites.personnages.sorts;

import donjons.Donjons;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;
import entites.personnages.equipements.armes.courantes.Courante;
import utilities.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmeMagique extends Sorts{
    public ArmeMagique(){
        super("Arme Magique", "Donne un bonus de 1 aux jets d'attaques et aux jets de dégats.");
    }

    public void lancerSort(ArrayList<Equipements> inventaire, Armes arme) {
        //Ajouter vérification que l'arme est dans l'inventaire du joueur
        if (inventaire.contains(arme)) {
            arme.setBonusAttaque(1);
            arme.setBonusDegats(1);
            System.out.println("L'arme " + arme.getNom() + " a reçu un bonus de 1 aux jets d'attaques et de dégats.");
        } else {
            System.out.println("L'arme " + arme.getNom() + " n'est pas dans l'inventaire.");
        }
    }
    @Override
    public boolean lancerSort(Donjons donjons) {
        //choix personnage
        String choix = "De qui voulez-vous enchanter une arme ?\n";
        Personnages joueurSelectionne = null;
        int i = 1;
        HashMap<Integer, Personnages> joueurs = new HashMap<>();
        for (Personnages p : donjons.getJoueurs().values()) {
            choix += i + "-" + p.getMatricule() + "\n";
            joueurs.put(i, p);
            i++;
        }
        choix += i + "-retour\n";
        int numchoix = Create.selectNombre(choix, 1, i);
        if (numchoix < i) {
            joueurSelectionne = joueurs.get(numchoix);
        } else if (numchoix == i) {
            return false;
        }
        if (joueurSelectionne == null) {
            System.out.println("Erreur le personnage est null");
            return false;
        }
        //choix2 arme
        String choix2 = "Quelle arme de" + joueurSelectionne.getMatricule() + " ?\n";
        Armes armeSelectionne = null;
        int j = 1;
        HashMap<Integer, Armes> armes = new HashMap<>();
        for (Equipements e : joueurSelectionne.getInventaire()) {
            if (e.getCategorie().substring(0, 4).equals(new Courante().getCategorie().substring(0, 4))) {
                choix2 += j + "-" + e.getNom() + "\n";
                armes.put(j, (Armes) e);
                j++;
            }
        }
        choix2 += j + "-retour\n";
        int numchoix2 = Create.selectNombre(choix2, 1, j);
        if (numchoix2 < j) {
            armeSelectionne = armes.get(numchoix2);
        } else if (numchoix2 == j) {
            return this.lancerSort(donjons);
        }
        if (armeSelectionne == null) {
            System.out.println("Erreur l'arme est null");
            return false;
        }
        //écrire validation
        armeSelectionne.setBonusAttaque(1);
        armeSelectionne.setBonusDegats(1);
        System.out.println("L'arme " + armeSelectionne.getNom() + " a reçu un bonus de 1 aux jets d'attaques et de dégats.");
        return true;
    }
}
