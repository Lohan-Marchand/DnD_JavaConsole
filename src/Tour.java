import donjons.Donjons;
import donjons.Positions;
import entites.Entites;
import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;
import entites.personnages.equipements.armures.Armures;


import java.util.ArrayList;
import java.util.HashMap;
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


    public static void lireAttaque(ArrayList<Integer> attaque, Entites attaquant,Entites cible){
        System.out.println("Lancez le dé 20 (appuyez sur entrer)");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Vous avez fait "+attaque.get(0));
        if (attaque.get(1)==0){
            System.out.println(cible.getCA()+"(CA) >"+attaque.get(0)+" : l'attaque ne touche pas");
        }
        else {
            System.out.println(cible.getCA()+"(CA) <"+attaque.get(0)+" : l'attaque touche");
            System.out.println("Lancez le(s) "+attaque.get(2) +" dé(s) "+attaque.get(3)+" de dégâts (appuyez sur entrer)");
            sc.nextLine();
            if(attaque.get(2)>1){
                for (int i = 0; i < attaque.get(2); i++){
                    System.out.print("["+attaque.get(i+4)+"]");
                }
                System.out.println();
            }
            System.out.println("Vous avez fait "+attaque.get(attaque.get(2)+5));
            System.out.println( attaquant.getMatricule()+" inflige "+attaque.get(attaque.get(2)+5)+" dégats à "+cible.getMatricule());
            System.out.println("Il lui reste "+cible.getPV()+" PV.");
        }
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
            i--;
            if(i==0){
                return null;
            }
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
            i--;
            if(i==0){
                return null;
            }
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

    private boolean changeEquipement(){
        Scanner sc=new Scanner(System.in);
        while(true){
            int numType = 0;
            while (numType > 2 || numType < 1) {
                System.out.println("\tVous voulez équiper :\n\t1-une arme \n\t2-une armure");
                try {
                    numType = Integer.parseInt(sc.nextLine());
                    if (numType > 2 || numType < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            switch (numType) {
                case 1:
                    Armes oldArme = m_joueur.getArme();
                    Create.choixArme(m_joueur);
                    if (Create.yesNoQuestion("Vous allez équiper " + m_joueur.getArme() + ". Correct ?(y/n)")) {
                        return true;
                    } else if (Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                        m_joueur.equiperArme(oldArme);
                    } else {
                        m_joueur.equiperArme(oldArme);
                        return false;
                    }
                case 2:
                    Armures oldArmure = m_joueur.getArmure();
                    Create.choixArmure(m_joueur);
                    if (Create.yesNoQuestion("Vous allez équiper " + m_joueur.getArmure() + ". Correct ?(y/n)")) {
                        return true;
                    } else if (Create.yesNoQuestion("Voulez vous équiper autre chose ?(y/n)")) {
                        m_joueur.equiperArmure(oldArmure);
                    } else {
                        m_joueur.equiperArmure(oldArmure);
                        return false;
                    }
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
            while (hauteur > hauteurDonjon || hauteur < 1) {
                System.out.print("À quelle ligne déplacer "+ m_joueur.getNom() +" ? : ");
                try {
                    hauteur = Integer.parseInt(sc.nextLine());
                    if (hauteur > hauteurDonjon || hauteur < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
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
            while (hauteur > hauteurDonjon || hauteur < 1) {
                System.out.print("À quelle ligne déplacer "+ m_monstre.getNom() +" ? : ");
                try {
                    hauteur = Integer.parseInt(sc.nextLine());
                    if (hauteur > hauteurDonjon || hauteur < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
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
                    if(Create.yesNoQuestion("Vous allez déplacer"+ m_monstre.getNom() +"tel que :\n" + m_donjons.getMap() + "\n\n ____Correct ?(y/n)____")){
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

    private int tourJoueur(){
        Scanner sc=new Scanner(System.in);

        while(m_actions!=0) {
            m_donjons.afficherTour();

            int numAction = 0;
            int nbAction = 3;
            while (numAction > nbAction || numAction < 1) {
                System.out.println("Il vous reste " + this.m_actions + " action(s) \nQue voulez vous faire ? :\n1-changer l'équipement \n2-se déplacer \n3-attaquer un monstre");
                if (m_donjons.getLoot().containsKey(m_donjons.getPersonnagePosition(m_joueur))) {
                    System.out.println("4-ramasser " + m_donjons.getLoot().get(m_donjons.getPersonnagePosition(m_joueur)).getNom());
                    nbAction = 4;
                } else {
                    nbAction = 3;
                }
                try {
                    numAction = Integer.parseInt(sc.nextLine());
                    if (numAction > nbAction || numAction < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            switch (numAction) {
                case 1:
                    if (changeEquipement()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
                    break;
                case 2:
                    if (deplacerJoueur()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
                    break;
                case 3:
                    Monstres cible = choixCibleMonstre();
                    if(cible!=null){
                        ArrayList<Integer> attaque = m_joueur.attaquer(cible);
                        lireAttaque(attaque, m_joueur, cible);
                        if (cible.getPV() == 0) {
                            System.out.println(cible.getNom() + " est mort");
                            m_donjons.removeEnnemi(m_donjons.getEnnemiPosition(cible));
                            if (m_donjons.getEnnemis().isEmpty()) {
                                ;
                                return reussiDonjon;
                            }
                        }
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
                    else{
                        System.out.println("Il n'y as pas de monstres à porté");
                        System.out.print("____Appuyez sur entrer____\n");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    Equipements item = m_donjons.getLoot().get(m_donjons.getPersonnagePosition(m_joueur));
                    if (Create.yesNoQuestion("Voulez vous ramasser " + item+" (y/n) : ")) {
                        m_joueur.getInventaire().add(item);
                        m_donjons.removeLoot(m_donjons.getPersonnagePosition(m_joueur));
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
            }
        }
        return continuDonjon;
    }
    public int tourMonstre(){
        Scanner sc=new Scanner(System.in);

        while(m_actions!=0) {
            m_donjons.afficherTour();
            int numAction = 0;
            int nbAction = 2;
            while (numAction > nbAction || numAction < 1) {
                System.out.println("Il reste " + this.m_actions + " action(s) \nQue fait "+m_monstre.getNom() +" ? :\n1-se déplacer \n2-attaquer un joueur");
                try {
                    numAction = Integer.parseInt(sc.nextLine());
                    if (numAction > nbAction || numAction < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            switch (numAction) {
                case 1:
                    if (deplacerMonstre()) {
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
                    break;
                case 2:
                    Personnages cible = choixCiblePersonnage();
                    if(cible!=null){
                        ArrayList<Integer> attaque = m_monstre.attaquer(cible);
                        lireAttaque(attaque, m_monstre, cible);
                        if (cible.getPV() == 0) {
                            System.out.println(cible.getNom() + " est mort");
                            return echecDonjon;
                        }
                        m_actions--;
                        Create.commentaire(m_joueur);
                    }
                    else{
                        System.out.println("Il n'y as pas de joueurs à porté");
                        System.out.print("____Appuyez sur entrer____\n");
                        sc.nextLine();
                    }
                    break;
            }
        }
        return continuDonjon;
    }
}
