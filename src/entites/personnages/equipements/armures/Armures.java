package entites.personnages.equipements.armures;

import entites.personnages.equipements.Equipements;

public abstract class Armures extends Equipements {
    private int m_CA;
    private int m_MalusVitesse;

    public Armures(String nom,int CA, int MalusVitesse,String categorie) {
        super(nom,categorie);
        this.m_CA = CA;
        this.m_MalusVitesse = MalusVitesse;
    }

    public int getCA() {
        return m_CA;
    }
    public int getMalusVitesse() {
        return m_MalusVitesse;
    }
    @Override
    public String toString() {
        return (this.getNom()+" ("+this.getCategorie()+") :\n CA= +"+this.m_CA+"\n Vit= -"+this.m_MalusVitesse+"\n");
    }
}