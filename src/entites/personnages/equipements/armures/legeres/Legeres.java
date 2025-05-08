package entites.personnages.equipements.armures.legeres;

import entites.personnages.equipements.armures.Armures;

public class Legeres extends Armures {
    private static final int m_MalusVitesse = 0;
    private static final String categorie="Armure légère";


    public Legeres() {
        super("Armure légère sans nom",5,m_MalusVitesse,categorie);
    }

    public Legeres(String nom,int CA) {
        super(nom,CA,m_MalusVitesse,categorie);
    }
    public Legeres(String nom) {
        super(nom,5,m_MalusVitesse,categorie);
    }
    public Legeres(int CA) {
        super("Armure légère sans nom",CA,m_MalusVitesse,categorie);
    }

}
