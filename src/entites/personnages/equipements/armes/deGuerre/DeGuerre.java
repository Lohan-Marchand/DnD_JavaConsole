package entites.personnages.equipements.armes.deGuerre;

import dice.*;
import entites.Attaques;
import entites.personnages.equipements.armes.Armes;

public class DeGuerre extends Armes {
    private static final int m_MalusVitesse=2;
    private static final int m_BonusForce=4;
    private static final int portee=1;
    private static final String categorie="Armes de guerre au corps à corps";


    public DeGuerre( String nom, Attaques attaques) {
        super(nom,attaques,m_MalusVitesse,m_BonusForce,categorie);
    }
    public DeGuerre(){
        super("Arme de guerre sans nom",new Attaques("attaque",portee,new D8()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public DeGuerre(String nom){
        super(nom,new Attaques("attaque",portee,new D8()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public DeGuerre(Attaques attaque){
        super("Arme de guerre sans nom",attaque,m_MalusVitesse,m_BonusForce,categorie);
    }
}
