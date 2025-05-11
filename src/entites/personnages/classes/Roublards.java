package entites.personnages.classes;

import entites.personnages.equipements.armes.deGuerre.Rapiere;
import entites.personnages.equipements.armes.distance.ArcCourt;

public class Roublards extends Classes{
    public Roublards(){
        super("Roublards", 16);
        setInventaire(new Rapiere());
        setInventaire(new ArcCourt());
    }
}
