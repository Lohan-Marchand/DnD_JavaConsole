package entites.personnages.classes;

import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.lourdes.CoteMaille;

public class Guerriers extends Classes{
    public Guerriers(){
        super("Guerrier", 20);
        setInventaire(new ArbaleteLegere());
        setInventaire(new CoteMaille());
        setInventaire(new EpeeLongue());
    }
}
