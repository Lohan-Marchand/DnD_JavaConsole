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
