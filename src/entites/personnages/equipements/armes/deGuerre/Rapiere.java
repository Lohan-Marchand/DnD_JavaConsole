package entites.personnages.equipements.armes.deGuerre;

import dice.D8;
import entites.Attaques;

public class Rapiere extends DeGuerre {
    public Rapiere() {
        super("Rapière",new Attaques("Coup de rapière",1,new D8(),1));
    }
}
