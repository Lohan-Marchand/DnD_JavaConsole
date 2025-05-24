package entites.personnages.classes;


import entites.personnages.equipements.armes.courantes.Baton;
import entites.personnages.equipements.armes.distance.Fronde;
import entites.personnages.sorts.ArmeMagique;
import entites.personnages.sorts.BoogieWoogie;
import entites.personnages.sorts.Guerison;

public class Magiciens extends Classes{
    public Magiciens(){
        super("Magicien", 12);
        setInventaire(new Baton());
        setInventaire(new Fronde());
        setSortsConnus(new Guerison());
        setSortsConnus(new BoogieWoogie());
        setSortsConnus(new ArmeMagique());
    }
}
