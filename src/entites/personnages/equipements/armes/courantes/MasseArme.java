package entites.personnages.equipements.armes.courantes;

import entites.Attaques;
import dice.*;

public class MasseArme extends Courante {
    public MasseArme() {
        super("Masse d'armes",new Attaques("Coup de masse d'armes",1,new D6(),1));
    }
}
