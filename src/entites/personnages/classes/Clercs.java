package entites.personnages.classes;

import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;

public class Clercs extends Classes{
    public Clercs(){
        super("Clercs");
        setInventaire(new ArbaleteLegere());
        setInventaire(new ArmureEcaille());
    }
}
