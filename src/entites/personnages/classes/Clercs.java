package entites.personnages.classes;

import entites.personnages.equipements.armes.courantes.MasseArme;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;

public class Clercs extends Classes{
    public Clercs(){
        super("Clercs",16);
        setInventaire(new MasseArme());
        setInventaire(new ArbaleteLegere());
        setInventaire(new ArmureEcaille());
    }
}
