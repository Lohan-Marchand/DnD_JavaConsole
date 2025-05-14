package entites.personnages.equipements.armes.courantes;

import dice.*;
import entites.Attaques;

public class Poing extends Courante {
    public Poing() {
        super("Poing",new Attaques("Coup de poing",1,new Dice(1),1));
    }
}
