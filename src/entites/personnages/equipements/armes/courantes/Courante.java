package entites.personnages.equipements.armes.courantes;

import dice.*;
import entites.Attaques;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;

public class Courante extends Armes {
    private static final int m_MalusVitesse=0;
    private static final int m_BonusForce=0;
    private static final int portee=1;
    private static final String categorie="Armes courantes au corps à corps";

    public Courante( String nom, Attaques attaques) {
        super(nom,attaques,m_MalusVitesse,m_BonusForce,categorie);
    }
    public Courante(){
        super("Arme courante sans nom",new Attaques("attaque",portee,new D6()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public Courante(String nom){
        super(nom,new Attaques("attaque",portee,new D6()),m_MalusVitesse,m_BonusForce,categorie);
    }
    public Courante(Attaques attaque){
        super("Arme courante sans nom",attaque,m_MalusVitesse,m_BonusForce,categorie);
    }
}
