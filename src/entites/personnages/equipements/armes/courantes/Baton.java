package entites.personnages.equipements.armes.courantes;

import dice.*;
import entites.Attaques;

public class Baton extends Courante {
    public Baton() {
        super("Baton",new Attaques("Coup de baton",1,new D6(),1));
    }
}
