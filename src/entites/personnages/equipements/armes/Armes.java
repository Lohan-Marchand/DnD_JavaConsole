package entites.personnages.equipements.armes;
import entites.*;
import entites.personnages.equipements.Equipements;

public abstract class Armes extends Equipements {
    private Attaques m_attaques;
    private int m_MalusVitesse;
    private int m_BonusForce;
    private String m_nom;

    public Armes(String nom, Attaques attaques, int MalusVitesse, int BonusForce) {
        this.m_nom = nom;
        this.m_attaques = attaques;
        this.m_MalusVitesse = MalusVitesse;
        this.m_BonusForce = BonusForce;
    }
    public Armes( String nom, Attaques attaques) {
        this.m_nom = nom;
        this.m_attaques = attaques;
        this.m_MalusVitesse = 0;
        this.m_BonusForce = 0;
    }
    public Armes(){
        this.m_MalusVitesse = 0;
        this.m_BonusForce = 0;
        this.m_nom = "";
        this.m_attaques = new Attaques();
    }
    public Armes(String nom){
        this.m_MalusVitesse = 0;
        this.m_BonusForce = 0;
        this.m_nom = nom;
        this.m_attaques = new Attaques();
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
    public String getNom() {
        return m_nom;
    }
    @Override
    public String toString() {
        return (this.m_nom+" :\n For= +"+this.m_BonusForce+"\n Vit= -"+this.m_MalusVitesse+"\n Attaque= "+this.m_attaques);
    }
}
