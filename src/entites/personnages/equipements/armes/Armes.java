package entites.personnages.equipements.armes;
import entites.*;
import entites.personnages.equipements.Equipements;

public abstract class Armes extends Equipements {
    private Attaques m_attaques;
    private int m_MalusVitesse;
    private int m_BonusForce;
    private int m_bonusJet;
    private int m_bonusAttaque;
    private int m_bonusDegats;

    public Armes(String nom, Attaques attaques, int MalusVitesse, int BonusForce,String categorie) {
        super(nom,categorie);
        this.m_attaques = attaques;
        this.m_MalusVitesse = MalusVitesse;
        this.m_BonusForce = BonusForce;
        this.m_bonusAttaque = 0;
        this.m_bonusDegats = 0;
    }
    public int calculerDegats(int m_bonusAttaque, int m_bonusDegats) {
        return m_attaques.calculerDegats(m_bonusAttaque, m_bonusDegats);
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
    public void setAttaques(Attaques attaques) {
        this.m_attaques = attaques;
    }
    public void setMalusVitesse(int malusVitesse) {
        this.m_MalusVitesse = malusVitesse;
    }
    public void setBonusForce(int bonusForce) {
        this.m_BonusForce = bonusForce;
    }
    public void setBonusAttaque(int bonusAttaque) {
        this.m_bonusAttaque += bonusAttaque;
    }
    public int getBonusAttaque() {
        return this.m_bonusAttaque;
    }
    public void setBonusDegats(int bonusDegats) {
        this.m_bonusDegats += bonusDegats;
    }
    public int getBonusDegats() {
        return this.m_bonusDegats;
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
