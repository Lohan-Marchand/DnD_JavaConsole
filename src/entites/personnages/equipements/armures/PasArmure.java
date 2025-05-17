package entites.personnages.equipements.armures;

import entites.personnages.equipements.armures.Armures;

public class PasArmure extends Armures {
    private static final int m_MalusVitesse = 0;
    private static final String categorie="Pas de protection";


    public PasArmure() {
        super("Pas d'armure",0,m_MalusVitesse,categorie);
    }
}
