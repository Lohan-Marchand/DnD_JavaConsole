package entites.personnages.equipements.armes;
import entites.*;
import entites.personnages.equipements.Equipements;

public abstract class Armes extends Equipements {
    private Attaques m_attaques;
    private int m_MalusVitesse;
    private int m_BonusForce;

    public Armes(String nom, Attaques attaques, int MalusVitesse, int BonusForce,String categorie) {
        super(nom,categorie);
        this.m_attaques = attaques;
        this.m_MalusVitesse = MalusVitesse;
        this.m_BonusForce = BonusForce;
    }
    public int calculerDegats(){
        return m_attaques.calculerDegats();
    }
    public Attaques getAttaques() {
        return m_attaques;
    }
    public int getMalusVitesse() {
        return m_MalusVitesse;
    }
    public int getBonusForce() {
        return m_BonusForce;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Armes){
            Armes arme = (Armes) object;
            if (arme.getNom().equals(this.getNom())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (this.getNom()+" ("+this.getCategorie()+"){For= +"+this.m_BonusForce+" | Vit= -"+this.m_MalusVitesse+" | Attaque: "+this.m_attaques+"}");
    }
}
