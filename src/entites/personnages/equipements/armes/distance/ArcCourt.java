package entites.personnages.equipements.armes.distance;

import dice.*;
import entites.Attaques;

public class ArcCourt extends Distance {
    public ArcCourt() {
        super("Arc court",new Attaques("Tir d'arc court'",16,new D6(),1));
    }
}
