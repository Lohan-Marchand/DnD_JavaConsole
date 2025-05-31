package entites.personnages.sorts;

import dice.D10;
import entites.personnages.Personnages;

public class Guerison extends Sorts{
    public Guerison(){
        super("Guérison", "Soigne un personnage de 1d10 PVs.");
    }

    public void lancerSort(Personnages personnage) {
        int soins = new D10().rollDice();
        personnage.setPV(personnage.getPV() + soins);
        System.out.println(personnage.getPseudo()+" a été soigné de "+soins+" PVs.");
    }
    @Override
    public void lancerSort(){
        System.out.println("Donner une entité à guérir en paramètre.");
    }
}
