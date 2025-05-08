package entites.personnages.equipements.armes.distance;

import dice.Dice;
import entites.Attaques;
import entites.personnages.equipements.armes.Armes;

public abstract class Distance extends Armes {
    public Distance(Attaques attaque, String nom) {
        super(nom,attaque);
    }
    public Distance(Attaques attaque) {
        super("Arme à distance sans nom",attaque);
    }
    public Distance() {
        super("Arme à distance",new Attaques("Attaque sans nom",6,new Dice(6),1));
    }
    public Distance(String nom) {
        super(nom,new Attaques("Attaque sans nom",6,new Dice(6),1));

    }
}
