package entites.personnages.equipements.armes.deGuerre;

import dice.Dice;
import entites.Attaques;
import entites.personnages.equipements.armes.Armes;

public abstract class DeGuerre extends Armes {
    public DeGuerre(Attaques attaque, String nom) {
        super(nom,attaque);
    }
    public DeGuerre(Attaques attaque) {
        super("Arme de guerre sans nom",attaque,2,4);
    }
    public DeGuerre() {
        super("Arme de guerre",new Attaques("Attaque sans nom",1,new Dice(8),1),2,4);
    }
    public DeGuerre(String nom) {
        super(nom,new Attaques("Attaque sans nom",1,new Dice(8),1),2,4);

    }
}
