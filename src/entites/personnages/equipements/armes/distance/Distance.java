package entites.personnages.equipements.armes.distance;

import dice.*;
import entites.Attaques;
import entites.personnages.equipements.armes.Armes;

public class Distance extends Armes {
    private static final int m_MalusVitesse=0;
    private static final int m_BonusForce=0;
    private static final int portee=10;
    private static final String categorie="Armes à distance";


    public Distance( String nom, Attaques attaques) {
        super(nom,attaques,m_MalusVitesse,m_BonusForce,categorie);
    }
    public Distance(){
        super("Arme à distance sans nom",new Attaques("attaque",portee,new D6()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public Distance(String nom){
        super(nom,new Attaques("attaque",portee,new D6()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public Distance(Attaques attaque){
        super("Arme à distance sans nom",attaque,m_MalusVitesse,m_BonusForce,categorie);
    }
}
