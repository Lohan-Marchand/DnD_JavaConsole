package entites.personnages.sorts;

import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;

import java.util.ArrayList;

public class ArmeMagique extends Sorts{
    public ArmeMagique(){
        super("Arme Magique", "Donne un bonus de 1 aux jets d'attaques et aux jets de dégats.");
    }

    public void lancerSort(ArrayList<Equipements> inventaire, Armes arme) {
        //Ajouter vérification que l'arme est dans l'inventaire du joueur
        if (inventaire.contains(arme)) {
            arme.setBonusAttaque(1);
            arme.setBonusDegats(1);
            System.out.println("L'arme " + arme.getNom() + " a reçu un bonus de 1 aux jets d'attaques et de défense.");
        } else {
            System.out.println("L'arme " + arme.getNom() + " n'est pas dans l'inventaire.");
        }


    }
    @Override
    public void lancerSort(){
        System.out.println("Donner une arme à améliorer en paramètre.");
    }
}
