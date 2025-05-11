package entites;

import dice.*;

public abstract class Entites {
    private Attaques m_attaque;
    private int m_PV;
    private int m_PVMax;
    private int m_force;
    private int m_dexterite;
    private int m_initiative;
    private int m_CA;
    private int m_vitesse;

    public Entites() {
        m_attaque = new Attaques();
        m_PVMax = 10;
        m_PV = m_PVMax;
        m_force = 10;
        m_dexterite = 10;
        m_initiative = 10;
        m_CA = 10;
        m_vitesse = 10;
    }
    public Entites(Attaques attaque, int PVMax, int force, int dexterite, int initiative, int CA, int vitesse) {
        m_attaque = attaque;
        m_PVMax = PVMax;
        m_PV = PVMax;
        m_force = force;
        m_dexterite = dexterite;
        m_initiative = initiative;
        m_CA = CA;
        m_vitesse = vitesse;
    }
    public int degatsAttaque(){
        Dice deAttaque = this.getAttaque().getDe();
        int nbLances = this.getAttaque().getNbDe();
        return deAttaque.rollDice(nbLances);
    }
    public Boolean attaqueTouche(int CA){
        D20 dice = new D20();
        if(dice.rollDice()<CA){
            return false;
        }
        else{
            return true;
        }
    }

    public void attaquer(Entites cible){
        if(this.attaqueTouche(cible.getCA())){
            cible.estBlesse(this.degatsAttaque());
        }
        else {
            System.out.println("l'attaque ne touche pas");
        }
    }
    public void estBlesse(int degats){
        if(degats >= m_PV){
            m_PV = 0;
        }
        else{
            m_PV = m_PV - degats;
        }
    }

    public int getPVMax(){
        return m_PVMax;
    }
    public int getPV(){
        return m_PV;
    }
    public int getForce(){
        return m_force;
    }
    public int getDexterite(){
        return m_dexterite;
    }
    public int getInitiative(){
        return m_initiative;
    }
    public int getCA() {
        return m_CA;
    }
    public int getVitesse(){
        return m_vitesse;
    }
    public Attaques getAttaque(){
        return m_attaque;
    }
    public void setAttaque(Attaques attaque) {
        m_attaque = attaque;
    }
    public void setForce(int force) {
        m_force = force;
    }
    public void setDexterite(int dexterite) {
        m_dexterite = dexterite;
    }
    @Override
    public String toString() {
        return ("PV Max= "+m_PVMax+"\n PV= "+m_PV+"\n Force= "+m_force+"\n Dexterite= "+m_dexterite+"\n Initiative= "+m_initiative+"\n Vitesse= "+m_vitesse+"\n CA= "+m_CA+"\n Attaque :"+this.getAttaque());
    }
}
