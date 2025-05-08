package entites.personnages.equipements.armes.deGuerre;

import dice.*;
import entites.Attaques;

public class EpeeLongue extends DeGuerre {
    public EpeeLongue() {
        super("Épée longue",new Attaques("Coup d'Épée longue",1,new D8(),1));
    }
}
