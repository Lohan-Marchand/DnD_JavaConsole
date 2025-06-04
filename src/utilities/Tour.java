package utilities;

import dice.D20;
import dice.Dice;
import donjons.Donjons;
import donjons.Positions;
import entites.Entites;
import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;
import entites.personnages.equipements.armures.Armures;
import entites.personnages.sorts.Sorts;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tour {
    private Donjons m_donjons;
    private Personnages m_joueur;
    private Monstres m_monstre;
    private int m_actions=3;
    private final int continuDonjon=-1;
    private final int reussiDonjon=0;
    private final int echecDonjon=1;

    public Tour(){}
    public Tour(Entites e,Donjons d) {
        m_donjons=d;
        if(e.estJouable()){
            m_joueur= (Personnages) e;
        }
        else{
            m_monstre = (Monstres) e;
        }
    }

    public static void Attaquer(Entites attaquant,Entites cible) {
        System.out.println("Lancez le dé 20 (appuyez sur entrer)");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        D20 dice = new D20();
        int resultDe = dice.rollDice();
        System.out.print("Vous avez fait " + resultDe);
        if (attaquant.estJouable() && ((Personnages) attaquant).getArme().getBonusAttaque() > 0) {
            resultDe += ((Personnages) attaquant).getArme().getBonusAttaque();
            System.out.print(" +" + ((Personnages) attaquant).getArme().getBonusAttaque() + "(bonus d'Attaque) = " + resultDe);
        }
        System.out.println();
        if (resultDe < cible.getCA()) {
            System.out.println(cible.getCA() + "(CA) >" + resultDe + " : l'attaque ne touche pas");
            return;
        }
        System.out.println(cible.getCA() + "(CA) <" + resultDe + " : l'attaque touche");

        Dice deAttaque = attaquant.getAttaque().getDe();
        int nbLances = attaquant.getAttaque().getNbDe();

        System.out.println("Lancez le(s) " + nbLances + " dé(s) " + deAttaque.getVal() + " de dégâts (appuyez sur entrer)");
        sc.nextLine();

        ArrayList<Integer> deroulement = new ArrayList<Integer>();
        int resultDegats=deAttaque.rollDice(nbLances,deroulement);
        for (int i = 0; i < nbLances; i++) {
            System.out.print("[" + deroulement.get(i) + "]");
        }
        System.out.println();
        System.out.print("Vous avez fait " + resultDegats);
        if (attaquant.estJouable() && ((Personnages) attaquant).getArme().getBonusDegats() > 0) {
            resultDegats += ((Personnages) attaquant).getArme().getBonusDegats();
            System.out.print(" +" + ((Personnages) attaquant).getArme().getBonusDegats() + "(bonus de dégâts) = " + resultDegats);
        }
        System.out.println();

        if(resultDegats >= cible.getPV()){
            cible.setPV(0);
        }
        else{
            cible.setPV(cible.getPV() - resultDegats);
        }

        System.out.println(attaquant.getMatricule() + " inflige " + resultDegats + " dégats à " + cible.getMatricule());
        System.out.println("Il lui reste " + cible.getPV() + " PV.");

    }

    public Monstres choixCibleMonstre(){
        Scanner sc=new Scanner(System.in);
        int numCible = 0;
        int i=1;
        HashMap<Integer, Monstres> choixCible = new HashMap<>();
        while (numCible > i || numCible < 1) {
            System.out.println("Quel monstre voulez vous attaquer ?");
            i=1;
            choixCible =new HashMap<>();
            for(Monstres m : m_donjons.getEnnemis().values() ){
                int distanceX =(m_donjons.getPersonnagePosition(m_joueur).getX())-(m_donjons.getEnnemiPosition(m).getX()) ;
                if(distanceX <0){
                    distanceX *=-1;
                }
                int distanceY =(m_donjons.getPersonnagePosition(m_joueur).getY())-(m_donjons.getEnnemiPosition(m).getY()) ;
                if(distanceY <0){
                    distanceY *=-1;
                }
                int distance= distanceX + distanceY;
                if(distance<= m_joueur.getAttaque().getPortee() ){
                    System.out.println(i+"-"+m.getNom());
                    choixCible.put(i,(Monstres) m);
                    i++;
                }
            }
            if(i==1){
                System.out.println("Il n'y as pas de monstres à porté");
                System.out.print("____Appuyez sur entrer____\n");
                sc.nextLine();
                return null;
            }
            System.out.println(i+"-retour");
            choixCible.put(i,null);
            try {
                numCible = Integer.parseInt(sc.nextLine());
                if (numCible > i || numCible < 1) {
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            } catch (Exception e) {
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        return choixCible.get(numCible);
    }

    public Personnages choixCiblePersonnage(){
        Scanner sc=new Scanner(System.in);
        int numCible = 0;
        int i=1;
        HashMap<Integer, Personnages> choixCible = new HashMap<>();
        while (numCible > i || numCible < 1) {
            System.out.println("Quel personnage voulez vous attaquer ?");
            i=1;
            choixCible =new HashMap<>();
            for(Personnages p : m_donjons.getJoueurs().values() ){
                int distanceX =(m_donjons.getEnnemiPosition(m_monstre).getX()) -(m_donjons.getPersonnagePosition(p).getX()) ;
                if(distanceX <0){
                    distanceX *=-1;
                }
                int distanceY =(m_donjons.getEnnemiPosition(m_monstre).getY()) -(m_donjons.getPersonnagePosition(p).getY()) ;
                if(distanceY <0){
                    distanceY *=-1;
                }
                int distance= distanceX + distanceY;
                if(distance<= m_monstre.getAttaque().getPortee() ){
                    System.out.println(i+"-"+p.getNom());
                    choixCible.put(i,(Personnages) p);
                    i++;
                }
            }
            if(i==1){
                System.out.println("Il n'y as pas de joueur à porté");
                System.out.print("____Appuyez sur entrer____\n");
                sc.nextLine();
                return null;
            }
            System.out.println(i+"-retour");
            choixCible.put(i,null);
            try {
                numCible = Integer.parseInt(sc.nextLine());
                if (numCible > i || numCible < 1) {
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            } catch (Exception e) {
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        return choixCible.get(numCible);
    }

    public int joueTour(){
        int fin=continuDonjon;
        if(m_joueur!=null){
            fin= tourJoueur();
        }
        else if(m_monstre!=null){
            fin =tourMonstre();
        }
        return fin;
    }

    private boolean selectionSort(){
        Scanner sc=new Scanner(System.in);
        int numSort = 0;
        int i=1;
        HashMap<Integer, Sorts> choixSorts = new HashMap<>();
        while (numSort > i || numSort < 1) {
            System.out.println("Quel sort voulez vous lancer ?");
            i=1;
            choixSorts =new HashMap<>();
            for(Sorts s : m_joueur.getSorts() ) {
                System.out.println(i + "-" + s.getNom()+"("+s.getDescription()+")");
                choixSorts.put(i,s);
                i++;
            }
            if(i==1){
                System.out.println("Vous n'avez pas de sorts");
                return false;
            }
            System.out.println(i + "-retour");
            try {
                numSort = Integer.parseInt(sc.nextLine());
                if (numSort > i || numSort < 1) {
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
                else if (numSort == i) {
                    return false;
                }

            } catch (Exception e) {
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        return choixSorts.get(numSort).lancerSort(m_donjons);
    }

    private boolean changeEquipement(){
        Scanner sc=new Scanner(System.in);
        while(true){
            int numType = 0;
            numType=Create.selectNombre("\tVous voulez équiper :\n\t1-une arme \n\t2-une armure\n",1,2);
            switch (numType) {
                case 1:
                    Armes oldArme = m_joueur.getArme();
                    Create.choixArme(m_joueur);
                    if(m_joueur.getArme().equals(oldArme)){
                        if (!Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                            return false;
                        }
                    }
                    else if (Create.yesNoQuestion("Vous allez équiper " + m_joueur.getArme() + ". Correct ?(y/n)")) {
                        return true;
                    } else if (Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                        m_joueur.equiperArme(oldArme);
                    } else {
                        m_joueur.equiperArme(oldArme);
                        return false;
                    }
                    break;
                case 2:
                    Armures oldArmure = m_joueur.getArmure();
                    Create.choixArmure(m_joueur);
                    if(m_joueur.getArmure().equals(oldArmure)){
                        if (!Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                            return false;
                        }
                    }
                    else if (Create.yesNoQuestion("Vous allez équiper " + m_joueur.getArmure() + ". Correct ?(y/n)")) {
                        return true;
                    } else if (Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                        m_joueur.equiperArmure(oldArmure);
                    } else {
                        m_joueur.equiperArmure(oldArmure);
                        return false;
                    }
                    break;
            }
        }
    }

    private boolean deplacerJoueur(){
        int hauteurDonjon=m_donjons.getHauteur();
        int largeurDonjon=m_donjons.getLargeur();
        int distanceMax=m_joueur.getVitesse()/3;
        System.out.println(m_joueur.getNom()+" peut se déplacer de "+distanceMax+" cases.");
        Scanner sc=new Scanner(System.in);
        while(true){
            int hauteur = -1;
            hauteur=Create.selectNombre("À quelle ligne déplacer "+ m_joueur.getNom() +" ? : ",1,hauteurDonjon);
            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("À quelle colonne déplacer " + m_joueur.getNom() + " ? : ");
                String alphaVal = sc.nextLine();
                largeur = Create.column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (m_donjons.getPersonnagePosition(m_joueur).getX() == largeur && m_donjons.getPersonnagePosition(m_joueur).getY() == hauteur) {
                if (Create.yesNoQuestion(m_joueur.getNom() + " restera à la même place (n'utilise pas une action)\n\n ____Correct ?(y/n)____")) {
                    return false;
                }
            }
            else if (!m_donjons.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else{
                int deplaceX=(m_donjons.getPersonnagePosition(m_joueur).getX()) - largeur;
                if(deplaceX<0){
                    deplaceX*=-1;
                }
                int deplaceY=(m_donjons.getPersonnagePosition(m_joueur).getY()) - hauteur;
                if(deplaceY<0){
                    deplaceY*=-1;
                }
                int distance=deplaceX+deplaceY;
                if(distance<=distanceMax){
                    Positions oldPos=m_donjons.getPersonnagePosition(m_joueur);
                    m_donjons.moveJoueur(m_joueur,new Positions(largeur,hauteur));
                    if(Create.yesNoQuestion("Vous allez vous déplacer tel que :\n" + m_donjons.getMap() + "\n\n ____Correct ?(y/n)____")){
                        return true;
                    }
                    else{
                        m_donjons.moveJoueur(m_joueur,oldPos);
                        if(!(Create.yesNoQuestion("Voulez vous changer la position ?(y/n)"))){
                            return false;
                        }
                    }
                }
                else{
                    System.out.println("/!\\La case visée est trop loin/!\\");
                }
            }
        }
    }

    private boolean deplacerMonstre(){
        int hauteurDonjon=m_donjons.getHauteur();
        int largeurDonjon=m_donjons.getLargeur();
        int distanceMax=m_monstre.getVitesse()/3;
        System.out.println(m_monstre.getNom()+" peut se déplacer de "+distanceMax+" cases.");
        Scanner sc=new Scanner(System.in);
        while(true){
            int hauteur = -1;
            hauteur=Create.selectNombre("À quelle ligne déplacer "+ m_monstre.getNom() +" ? : ",1,hauteurDonjon);
            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("À quelle colonne déplacer " + m_monstre.getNom() + " ? : ");
                String alphaVal = sc.nextLine();
                largeur = Create.column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (m_donjons.getEnnemiPosition(m_monstre).getX() == largeur && m_donjons.getEnnemiPosition(m_monstre).getY() == hauteur) {
                if (Create.yesNoQuestion( m_monstre.getNom() + " restera à la même place (n'utilise pas une action) \n\n ____Correct ?(y/n)____")) {
                    return false;
                }
            }
            else if (!m_donjons.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else{
                int deplaceX=(m_donjons.getEnnemiPosition(m_monstre).getX()) - largeur;
                if(deplaceX<0){
                    deplaceX*=-1;
                }
                int deplaceY=(m_donjons.getEnnemiPosition(m_monstre).getY()) - hauteur;
                if(deplaceY<0){
                    deplaceY*=-1;
                }
                int distance=deplaceX+deplaceY;
                if(distance<=distanceMax){
                    Positions oldPos=m_donjons.getEnnemiPosition(m_monstre);
                    m_donjons.moveEnnemi(m_monstre,new Positions(largeur,hauteur));
                    if(Create.yesNoQuestion("Vous allez déplacer "+ m_monstre.getNom() +" tel que :\n" + m_donjons.getMap() + "\n\n ____Correct ?(y/n)____")){
                        return true;
                    }
                    else{
                        m_donjons.moveEnnemi(m_monstre,oldPos);
                        if(!(Create.yesNoQuestion("Voulez vous changer la position ?(y/n)"))){
                            return false;
                        }
                    }
                }
                else{
                    System.out.println("/!\\La case visée est trop loin/!\\");
                }
            }
        }
    }

    private boolean deplacerEntite(){
        String choix="Qui voulez-vous déplacer ?\n";
        Entites entiteSelectionne=null;
        int i=1;
        HashMap<Integer, Entites> entites = new HashMap<>();
        for(Entites e : m_donjons.getOrdre()){
            choix+=i+"-"+e.getMatricule()+"\n";
            entites.put(i,e);
            i++;
        }
        choix+=i+"-Ne déplacer personne\n";
        int numchoix=Create.selectNombre(choix,1,i);
        if(numchoix<i){
            entiteSelectionne=entites.get(numchoix);
        }
        else if(numchoix==i){
            return false;
        }
        if(entiteSelectionne == null){
            System.out.println("Erreur l'entité est null");
            return false;
        }

        int hauteurDonjon=m_donjons.getHauteur();
        int largeurDonjon=m_donjons.getLargeur();
        Scanner sc=new Scanner(System.in);
        while(true){
            int hauteur = -1;
            hauteur=Create.selectNombre("À quelle ligne déplacer "+ entiteSelectionne.getMatricule() +" ? : ",1,hauteurDonjon);
            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("À quelle colonne déplacer " + entiteSelectionne.getMatricule() + " ? : ");
                String alphaVal = sc.nextLine();
                largeur = Create.column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!m_donjons.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else {
                if(entiteSelectionne.estJouable()){
                    Positions oldPos = m_donjons.getPersonnagePosition((Personnages)entiteSelectionne);
                    m_donjons.moveJoueur((Personnages) entiteSelectionne, new Positions(largeur, hauteur));
                    if (Create.yesNoQuestion("Vous allez déplacer " + entiteSelectionne.getMatricule() + " tel que :\n" + m_donjons.getMap() + "\n\n ____Correct ?(y/n)____")) {
                        return true;
                    } else {
                        m_donjons.moveJoueur((Personnages) entiteSelectionne, oldPos);
                        if (!(Create.yesNoQuestion("Voulez vous changer la position ?(y/n)"))) {
                            return false;
                        }
                    }
                }
                else {
                    Positions oldPos = m_donjons.getEnnemiPosition((Monstres)entiteSelectionne);
                    m_donjons.moveEnnemi((Monstres)entiteSelectionne, new Positions(largeur, hauteur));
                    if (Create.yesNoQuestion("Vous allez déplacer " + entiteSelectionne.getMatricule() + " tel que :\n" + m_donjons.getMap() + "\n\n ____Correct ?(y/n)____")) {
                        return true;
                    } else {
                        m_donjons.moveEnnemi((Monstres)entiteSelectionne, oldPos);
                        if (!(Create.yesNoQuestion("Voulez vous changer la position ?(y/n)"))) {
                            return false;
                        }
                    }
                }
            }
        }
    }

    private boolean infligeDegats(){
        String choix="  À qui voulez-vous infliger des dégâts ?\n";
        Entites entiteSelectionne=null;
        int i=1;
        HashMap<Integer, Entites> entites = new HashMap<>();
        for(Entites e : m_donjons.getOrdre()){
            choix+=i+"-"+e.getMatricule()+"\n";
            entites.put(i,e);
            i++;
        }
        choix+=i+"-Ne pas infliger de dégâts\n";
        int numchoix=Create.selectNombre(choix,1,i);
        if(numchoix<i){
            entiteSelectionne=entites.get(numchoix);
        }
        else if(numchoix==i){
            return false;
        }
        if(entiteSelectionne == null){
            System.out.println("Erreur l'entité est null");
            return false;
        }

        int nbDe=0;
        int valDe=0;
        valDe=Create.selectNombre("Quelle est la valeur du/des dé(s) à lancer ?",1,100);
        nbDe=Create.selectNombre("Combien de dés à lancer ?",1,100);
        Dice de= new Dice(valDe);
        ArrayList<Integer> deroulement = new ArrayList<Integer>();
        System.out.print("Lancez "+nbDe+"d"+valDe+" (appuyez sur entrer):");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int degats= de.rollDice(nbDe,deroulement);
        System.out.print("Vous avez fait : ");
        for(int d=0 ;d<nbDe;d++){
            System.out.print("["+deroulement.get(d)+"]");
        }
        System.out.println("\n"+entiteSelectionne.getMatricule()+" subit donc "+degats+" dégâts.");
        entiteSelectionne.setPV(entiteSelectionne.getPV()-degats);
        if(entiteSelectionne.getPV()==0){
            System.out.println(entiteSelectionne.getMatricule() +" est mort(e)");
            if(entiteSelectionne.estJouable()){
                m_donjons.removeJoueur(m_donjons.getPersonnagePosition((Personnages) entiteSelectionne));
            }
            else{
                m_donjons.removeEnnemi(m_donjons.getEnnemiPosition((Monstres) entiteSelectionne));
            }
            m_actions=3;
            return true;
        }
        System.out.println("Il lui reste "+entiteSelectionne.getPV()+" PV.");
        return true;
    }

    private int interventionMJ(){
        if(!Create.yesNoQuestion("Le MJ veut-il intervenir ? (y/n) :")){
            return continuDonjon;
        }
        while (true) {
            int numAction = 0;
            Scanner sc = new Scanner(System.in);
            numAction = Create.selectNombre("Que faire ? \n1-déplacer un monstre ou un personnage \n2-infliger des dégâts à un joueur ou un monstre\n3-ajouter des obstacles dans le donjon\n4-fin des actions\n", 1, 4);
            switch (numAction) {
                case 1:
                    if (deplacerEntite()) {
                        Create.commentaire(null);
                    } else {
                        System.out.println("Déplacement annulé");
                    }
                    break;
                case 2:
                    if (infligeDegats()) {
                        Create.commentaire(null);
                        if (m_donjons.getEnnemis().isEmpty()) {
                            return reussiDonjon;
                        }
                        for (Personnages p :m_donjons.getJoueurs().values()) {
                            if(p.getPV()==0){
                                return echecDonjon;
                            }
                        }
                    } else {
                        System.out.println("Dégâts annulés");
                    }
                    break;
                case 3:
                    if(Create.creerObstacle(m_donjons)){
                        Create.commentaire(null);
                    }
                    else{
                        System.out.println("Création d'obstacle annulée");
                    }
                    break;
                case 4:
                    return continuDonjon;
            }
        }
    }

    private int tourJoueur(){
        Scanner sc=new Scanner(System.in);

        while(m_actions!=0) {
            m_donjons.afficherTour();
            Map<Integer,Integer> equivalence=new HashMap<>();
            equivalence.put(1,1);
            equivalence.put(2,2);
            equivalence.put(3,3);
            int numAction = 0;
            int nbAction = 4;
            String actionPlus="";
            if (m_donjons.getLoot().containsKey(m_donjons.getPersonnagePosition(m_joueur))) {
                actionPlus+=("\n"+nbAction+"-ramasser " + m_donjons.getLoot().get(m_donjons.getPersonnagePosition(m_joueur)).getNom());
                equivalence.put(nbAction,4);
                nbAction ++;
            }
            if (!m_joueur.getSorts().isEmpty()) {
                actionPlus+=("\n"+nbAction+"-utiliser un sort ");
                equivalence.put(nbAction,5);
                nbAction ++;
            }
            actionPlus +="\n"+nbAction +"-passer le reste du tour";
            equivalence.put(nbAction,6);
            numAction =Create.selectNombre("Il vous reste " + this.m_actions + " action(s) \nQue voulez vous faire ? :\n1-changer l'équipement \n2-se déplacer \n3-attaquer un monstre"+actionPlus+"\n",1,nbAction);
            switch (equivalence.get(numAction)) {
                case 1:
                    if (changeEquipement()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 2:
                    if (deplacerJoueur()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 3:
                    Monstres cible = choixCibleMonstre();
                    if(cible!=null){
                        Attaquer(m_joueur, cible);
                        if (cible.getPV() == 0) {
                            System.out.println(cible.getNom() + " est mort(e)");
                            m_donjons.removeEnnemi(m_donjons.getEnnemiPosition(cible));
                            if (m_donjons.getEnnemis().isEmpty()) {
                                return reussiDonjon;
                            }
                        }
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 4:
                        Equipements item = m_donjons.getLoot().get(m_donjons.getPersonnagePosition(m_joueur));
                        if (Create.yesNoQuestion("Voulez vous ramasser " + item + " (y/n) : ")) {
                            m_joueur.getInventaire().add(item);
                            m_donjons.removeLoot(m_donjons.getPersonnagePosition(m_joueur));
                            m_actions--;
                            Create.commentaire(m_joueur);
                            int result =interventionMJ();
                            if (result !=continuDonjon) {
                                return result;
                            }
                        }
                    break;
                case 5:
                    if(selectionSort()){
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 6:
                    if (Create.yesNoQuestion("Voulez vous vraiment passer vos "+ m_actions +" actions restantes (y/n) : ")) {
                        m_actions=0;
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
            }
        }
        return continuDonjon;
    }
    public int tourMonstre(){
        Scanner sc=new Scanner(System.in);

        while(m_actions!=0) {
            m_donjons.afficherTour();
            int numAction = 0;
            int nbAction = 3;
            numAction =Create.selectNombre("Il reste " + this.m_actions + " action(s) \nQue fait "+m_monstre.getNom() +" ? :\n1-se déplacer \n2-attaquer un joueur\n3-passer le reste du tour\n",1,nbAction);
            switch (numAction) {
                case 1:
                    if (deplacerMonstre()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 2:
                    Personnages cible = choixCiblePersonnage();
                    if(cible!=null){
                        Attaquer(m_monstre, cible);
                        if (cible.getPV() == 0) {
                            System.out.println(cible.getNom() + " est mort(e)");
                            return echecDonjon;
                        }
                        m_actions--;
                        Create.commentaire(m_joueur);
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
                case 3:
                    if (Create.yesNoQuestion("Voulez vous vraiment passer vos "+ m_actions +" actions restantes (y/n) : ")) {
                        m_actions=0;
                        int result =interventionMJ();
                        if (result !=continuDonjon){
                            return result;
                        }
                    }
                    break;
            }
        }
        return continuDonjon;
    }
}
