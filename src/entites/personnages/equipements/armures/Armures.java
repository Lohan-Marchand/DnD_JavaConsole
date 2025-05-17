package entites.personnages.equipements.armures;

import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;

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
    public boolean equals(Object object){
        if(object instanceof Armures){
            Armures armure = (Armures) object;
            if (armure.getNom().equals(this.getNom())){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return (this.getNom()+" ("+this.getCategorie()+") {CA= +"+this.m_CA+" | Vit= -"+this.m_MalusVitesse+"}");
    }
}