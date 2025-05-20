package entites.personnages.equipements.armes.deGuerre;

import dice.*;
import entites.Attaques;

public class Epee2Main extends DeGuerre {
    public Epee2Main() {
        super("Épée à deux mains",new Attaques("Coup d'Épée à deux mains",1,new D6(),2));
    }
}
