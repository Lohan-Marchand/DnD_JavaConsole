package entites.personnages.classes;

import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;

public class Guerriers extends Classes{
    public Guerriers(){
        super("Guerrier", 20);
        setInventaire(new ArbaleteLegere());
        setInventaire(new ArmureEcaille());
    }
}
