package entites.personnages.sorts;

import dice.D10;
import donjons.Donjons;
import entites.personnages.Personnages;
import utilities.Create;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Guerison extends Sorts{
    public Guerison(){
        super("Guérison", "Soigne un personnage de 1d10 PVs.");
    }

    public void soins(Personnages personnage) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lancez 1d10 pour le nombre de PV à guérir  (appuyez sur entrer)");
        sc.nextLine();
        int soins = new D10().rollDice();
        System.out.print("Vous avez fait " + soins);

        personnage.setPV(personnage.getPV() + soins);
        System.out.println(personnage.getPseudo()+" a été soigné de "+soins+" PVs. ("+personnage.getPV() +"/"+personnage.getPVMax()+")");
    }
    @Override
    public boolean lancerSort(Donjons donjons){
        //choix personnage
        String choix = "Qui voulez-vous soigner ?\n";
        Personnages joueurSelectionne = null;
        int i = 1;
        HashMap<Integer, Personnages> joueurs = new HashMap<>();
        for (Personnages p : donjons.getJoueurs().values()) {
            if(p.getPV() != p.getPVMax()) {
                choix += i + "-" + p.getMatricule() + " (" + p.getPV() + "/" + p.getPVMax() + " PV)\n";
                joueurs.put(i, p);
                i++;
            }
        }
        choix += i + "-retour\n";
        if(i >= 1){
            System.out.println("Il n'y a personne à soigner (appuyer sur entrer)");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            return false;
        }
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
        if(!Create.yesNoQuestion("Voulez-vous vraiment soigner " + joueurSelectionne.getNom() + " ? (y/n)")){
            return false;
        }
        //Soins
        this.soins(joueurSelectionne);
        return true;
    }
}
