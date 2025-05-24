package entites.personnages.sorts;

import donjons.Donjons;
import entites.personnages.Personnages;

public class BoogieWoogie extends Sorts{
    public BoogieWoogie() {
        super("Boogie Woogie", "Echange la position de deux entités dans le donjon.");
    }

    public void lancerSort(Donjons donjons, Personnages cible1, Personnages cible2) {
        donjons.echangerPositionsEntites(cible1, cible2);
        System.out.println(cible1.getPseudo() + " a échangé sa position avec " + cible2.getPseudo() + ".");
    }
    @Override
    public void lancerSort(){
        System.out.println("Donner le donjon actuel et deux entités à échanger dans le donjon en paramètres.");
    }
}
