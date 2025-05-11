package entites.personnages;

import java.util.ArrayList;

import entites.Attaques;
import entites.Entites;
import entites.monstres.Monstres;
import entites.personnages.classes.Classes;
import entites.personnages.equipements.*;
import entites.personnages.equipements.armes.courantes.Courante;
import entites.personnages.equipements.armes.courantes.Poing;
import entites.personnages.equipements.armures.*;
import entites.personnages.equipements.armes.*;
import entites.personnages.equipements.armures.legeres.Legeres;
import entites.personnages.races.Races;

public class Personnages extends Entites {
    private final String m_nom;
    private final Races m_race;
    private final Classes m_classe;
    private final ArrayList<Equipements> m_inventaire;
    private Armes m_arme;
    private Armures m_armure;

    public Personnages(){
        super();
        m_nom = "Personnage sans nom";
        m_race = new Races();
        m_classe = new Classes();
        m_arme = new Courante();
        m_armure = new Legeres();
        m_inventaire = m_classe.getInventaire();
    }
    public Personnages(String nom, Races race, Classes classe, int force4d4, int dexterite4d4, int initiative4d4, ArrayList<Equipements> inventaire, Armes arme, Armures armure, int vitesse4d4){
        super(arme.getAttaques(),classe.getPVMax() + race.getBonusPVMax(),force4d4 +3+ race.getBonusForce(),dexterite4d4 + 3+race.getBonusDexterite(),initiative4d4 +3+ race.getM_bonusInitiative(),0,vitesse4d4 +3+ race.getBonusVitesse());
        m_nom = nom;
        m_race = race;
        m_classe = classe;
        m_arme = arme;
        m_armure = armure;
        m_inventaire = inventaire;
    }
    public Personnages(String nom, Races race, Classes classe, int force4d4, int dexterite4d4, int initiative4d4, int vitesse4d4){
        super(new Poing().getAttaques(),classe.getPVMax() + race.getBonusPVMax(),force4d4 +3+ race.getBonusForce(),dexterite4d4 + 3+race.getBonusDexterite(),initiative4d4 +3+ race.getM_bonusInitiative(),0,vitesse4d4 +3+ race.getBonusVitesse());
        m_nom = nom;
        m_race = race;
        m_classe = classe;
        m_arme = new Poing();
        m_inventaire = classe.getInventaire();
    }
    /*public void equiperArme(Armes arme){
        if(m_inventaire.contains(arme)){
            m_inventaire.add(m_arme);
            m_arme = arme;
            m_inventaire.remove(arme);
            super.setAttaque(m_arme.getAttaques());
        }
        else{
            System.out.println("Il faut posséder l'arme dans son inventaire pour l'équiper!");
        }
    }*/
    public void equiperArme(Armes arme){
       for (Equipements equipements : m_inventaire) {
           if(arme.equals(equipements)){
               m_inventaire.add(m_arme);
               m_arme = arme;
               m_inventaire.remove(arme);
               super.setAttaque(m_arme.getAttaques());
               return;
           }
       }
        System.out.println("Il faut posséder l'arme dans son inventaire pour l'équiper!");
    }
    public void equiperArmure(Armures armure){
        if(m_inventaire.contains(armure)){
            m_inventaire.add(m_armure);
            m_armure = armure;
            m_inventaire.remove(armure);
        }
        else{
            System.out.println("Il faut posséder l'armure dans son inventaire pour l'équiper!");
        }
    }
    public void prendre(Equipements equipement){
        //Ajouter une condition vérifiant que l'équipement se trouve à proximité
        m_inventaire.add(equipement);
    }
    public String getNom(){
        return m_nom;
    }
    public Races getRace(){
        return m_race;
    }
    public Classes getClasses(){
        return m_classe;
    }
    @Override
    public int getForce(){
        int force=super.getForce();
        return force+m_arme.getBonusForce();
    }
    @Override
    public int getVitesse(){
        int vitesse=super.getVitesse();
        return vitesse - m_arme.getMalusVitesse() - m_armure.getMalusVitesse();
    }
    @Override
    public int getCA(){
        if (this.m_armure!=null){
            return m_armure.getCA();
        }
        else{
            return 0;
        }
    }
    @Override
    public Attaques getAttaque(){
        return m_arme.getAttaques();
    }

    public ArrayList<Equipements> getInventaire(){
        return m_inventaire;
    }
    public Armes getArme(){
        return m_arme;
    }
    public Armures getArmure(){
        return m_armure;
    }
    @Override
    public String toString(){
        String stats= super.toString();
        return (m_nom+" :\n Race= \n"+m_race+"\n Classe= \n"+m_classe+"\nInventaire= "+m_inventaire+"\n Arme= "+m_arme+"\n Armure= "+m_armure +"\n"+ stats);
    }
}
