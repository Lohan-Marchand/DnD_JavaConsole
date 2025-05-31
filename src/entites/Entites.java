package entites;

import dice.*;

import java.util.ArrayList;

public abstract class Entites {
    private Attaques m_attaque;
    private int m_PV;
    private int m_PVMax;
    private int m_force;
    private int m_dexterite;
    private int m_initiative;
    private int m_CA;
    private int m_vitesse;
    private String m_pseudo;

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
    public int degatsAttaque(ArrayList<Integer> deroulement){
        Dice deAttaque = this.getAttaque().getDe();
        int nbLances = this.getAttaque().getNbDe();
        deroulement.add(nbLances);
        deroulement.add(deAttaque.getVal());
        return deAttaque.rollDice(nbLances,deroulement);
    }
    public Boolean attaqueTouche(int CA,ArrayList<Integer> deroulement){
        D20 dice = new D20();
        int resultDe =dice.rollDice();
        deroulement.add(resultDe);
        if(resultDe<CA){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<Integer> attaquer(Entites cible){
        ArrayList<Integer> deroulement = new ArrayList<Integer>();
        if(this.attaqueTouche(cible.getCA(),deroulement)){
            deroulement.add(1);
            int degatInflige = this.degatsAttaque(deroulement);
            deroulement.add(degatInflige);
            cible.estBlesse(degatInflige);
            return deroulement;
        }
        else {
            deroulement.add(0);
            return deroulement;
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
    public abstract String getMatricule();
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
    public void setPseudo(String pseudo) {
        m_pseudo = pseudo;
    }
    public String getPseudo() {
        return m_pseudo;
    }
    public void setPV(int pv) {
        if (pv > m_PVMax) {
            m_PV = m_PVMax;
        } else if (pv < 0) {
            m_PV = 0;
        } else {
            m_PV = pv;
        }
    }
    public boolean estJouable(){
        return false;
    }
    @Override
    public String toString() {
        return ("PV Max= "+m_PVMax+"\n PV= "+m_PV+"\n Force= "+m_force+"\n Dexterite= "+m_dexterite+"\n Initiative= "+m_initiative+"\n Vitesse= "+m_vitesse+"\n CA= "+m_CA+"\n Attaque :"+this.getAttaque());
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Entites ){
            Entites e = (Entites) o;
            return e.getMatricule().equals(this.getMatricule());
        }
        return false;
    }


}
