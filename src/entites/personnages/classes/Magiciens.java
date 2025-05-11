package entites.personnages.classes;


import entites.personnages.equipements.armes.courantes.Baton;
import entites.personnages.equipements.armes.distance.Fronde;

public class Magiciens extends Classes{
    public Magiciens(){
        super("Magicien", 12);
        setInventaire(new Baton());
        setInventaire(new Fronde());
    }
}
