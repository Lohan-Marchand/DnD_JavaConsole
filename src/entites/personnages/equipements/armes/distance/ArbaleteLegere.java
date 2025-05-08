package entites.personnages.equipements.armes.distance;

import dice.*;
import entites.Attaques;

public class ArbaleteLegere extends Distance {
    public ArbaleteLegere() {
        super("Arbalète légere",new Attaques("Tir d'arbalète légère",16,new D8(),1));
    }
}
