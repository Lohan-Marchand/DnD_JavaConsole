package entites.monstres;

import dice.Dice;
import entites.Attaques;
import entites.Entites;
import entites.personnages.Personnages;

public class Monstres extends Entites {
    private String m_espece;
    private int m_num;

    public Monstres(){
        super();
        m_espece = "Espèce sans nom";
        m_num = 1;
        this.setPseudo("._.");
    }
    public Monstres(String espece, int num,String pseudo, Attaques attaque, int PVMax, int force, int dexterite, int initiative, int CA, int vitesse){
        super(attaque,PVMax,force,dexterite,initiative,CA,vitesse);
        m_espece = espece;
        m_num = num;
        if (attaque.getPortee()==1){
            super.setDexterite(0);
        }
        else if (attaque.getPortee()>1){
            super.setForce(0);
        }
        else{
            super.setForce(-100);
            super.setDexterite(-100);
        }
        this.setPseudo(pseudo);
    }

    public String getStats(){
        return (this.getPseudo()+" "+ this.getNom()+ " (For= +"+this.getForce()+" | Dex= +"+this.getDexterite()+" | Vit= +"+this.getVitesse()+" | Initiative= +"+this.getInitiative()+")");
    }
    public String getNom(){
        return this.m_espece+" n°"+m_num;
    }

    public String getEspece(){
        return m_espece;
    }
    public int getNum(){
        return m_num;
    }
    @Override
    public String toString(){
        String stats= super.toString();
        return (m_espece+" "+m_num+"\n"+ stats);
    }
}
