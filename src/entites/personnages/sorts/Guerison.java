package entites.personnages.sorts;

import dice.D10;
import entites.personnages.Personnages;

import java.util.ArrayList;
import java.util.Scanner;

public class Guerison extends Sorts{
    public Guerison(){
        super("Guérison", "Soigne un personnage de 1d10 PVs.");
    }

    public void lancerSort(Personnages personnage) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lancez 1d10 pour le nombre de PV à guérir  (appuyez sur entrer)");
        sc.nextLine();
        int soins = new D10().rollDice();
        System.out.print("Vous avez fait " + soins);

        personnage.setPV(personnage.getPV() + soins);
        System.out.println(personnage.getPseudo()+" a été soigné de "+soins+" PVs. ("+personnage.getPV() +"/"+personnage.getPVMax()+")");
    }
    @Override
    public void lancerSort(){
        System.out.println("Donner une entité à guérir en paramètre.");
    }
}
