package entites.personnages.equipements.armes.distance;

import dice.*;
import entites.Attaques;

public class Fronde extends Distance {
    public Fronde() {
        super("Fronde",new Attaques("Tir de fronde",6,new D4(),1));
    }
}
