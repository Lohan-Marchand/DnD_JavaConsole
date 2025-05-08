package entites.personnages.equipements.armures.lourdes;

import entites.personnages.equipements.armures.Armures;

public class Lourdes extends Armures {
    private static final int m_MalusVitesse = 4;
    private static final String categorie="Armure lourde";

    public Lourdes() {
        super("Armure lourdes sans nom",10,m_MalusVitesse,categorie);
    }
    public Lourdes(String nom,int CA) {
        super(nom,CA,m_MalusVitesse,categorie);
    }
    public Lourdes(String nom) {
        super(nom,10,m_MalusVitesse,categorie);
    }
    public Lourdes(int CA) {
        super("Armure lourdes sans nom",CA,m_MalusVitesse,categorie);
    }

}
