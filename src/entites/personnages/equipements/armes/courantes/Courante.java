package entites.personnages.equipements.armes.courantes;

import dice.Dice;
import entites.Attaques;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;

public abstract class Courante extends Armes {
    public Courante(Attaques attaque,String nom) {
        super(nom,attaque);
    }
    public Courante(Attaques attaque) {
        super("Arme courante sans nom",attaque);
    }
    public Courante() {
        super("Arme courante",new Attaques("Attaque sans nom",1,new Dice(6),1));
    }
    public Courante(String nom) {
        super(nom,new Attaques("Attaque sans nom",1,new Dice(6),1));

    }
}
