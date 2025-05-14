import dice.*;
import entites.Attaques;
import entites.Entites;
import entites.monstres.*;
import entites.personnages.Personnages;
import entites.personnages.classes.*;
import entites.personnages.equipements.armes.courantes.*;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.races.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
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
            System.out.println("l'attaque inflige "+attaque.get(attaque.get(2)+5)+" dégats");
        }
    }

    public static Personnages CreerPersonnage(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t___Nouveau personnage___ :\nVeuillez Choisir un nom : ");
        String nom = sc.nextLine();
        int numRace=0;
        while(numRace>4 || numRace<1){
            System.out.print("Veuillez Choisir une race parmi :\n1-"+new Elfes().getStats()+"\n2-"+new Halfelins().getStats()+"\n3-"+new Humains().getStats()+"\n4-"+new Nains().getStats()+"\nChoix :");
            try{
                numRace = Integer.parseInt(sc.nextLine());
                if(numRace>4 || numRace<1){
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            catch(Exception e){System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");}
        }
        Races race=new Races();
        switch (numRace){
            case 1: race = new Elfes(); break;
            case 2: race = new Halfelins(); break;
            case 3: race = new Humains(); break;
            case 4: race = new Nains(); break;
        }
        int numClasse=0;
        while(numClasse>4 || numClasse<1){
            System.out.print("Veuillez Choisir une race parmi :\n1-"+new Clercs().getStats()+"\n2-"+new Guerriers().getStats()+"\n3-"+new Magiciens().getStats()+"\n4-"+new Roublards().getStats()+"\nChoix :");
            try{
                numClasse = Integer.parseInt(sc.nextLine());
                if(numClasse>4 || numClasse<1){
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            catch(Exception e){System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");}
        }
        Classes classe=new Classes();
        switch (numClasse){
            case 1: classe = new Clercs(); break;
            case 2: classe = new Guerriers(); break;
            case 3: classe = new Magiciens(); break;
            case 4: classe = new Roublards(); break;
        }
        ArrayList<Integer> deroulement =new ArrayList<>();

        System.out.println("Lancez les dés pour les Caractéristiques :");
        System.out.println("Force (appuyez sur entrer):");
        sc.nextLine();
        int force =new D4().rollDice(4,deroulement);
        System.out.println("Vous avez fais "+deroulement.get(4)+"(["+deroulement.get(0)+"]["+deroulement.get(1)+"]["+deroulement.get(2)+"]["+deroulement.get(3)+"])");
        System.out.println("Votre force : "+(force+3+race.getBonusForce()));

        deroulement.clear();
        System.out.println("Dextérité (appuyez sur entrer):");
        sc.nextLine();
        int dexterite =new D4().rollDice(4,deroulement);
        System.out.println("Vous avez fais "+deroulement.get(4)+"(["+deroulement.get(0)+"]["+deroulement.get(1)+"]["+deroulement.get(2)+"]["+deroulement.get(3)+"])");
        System.out.println("Votre dextérité : "+(dexterite+3+race.getBonusDexterite()));

        deroulement.clear();
        System.out.println("Initiative (appuyez sur entrer):");
        sc.nextLine();
        int initiative =new D4().rollDice(4,deroulement);
        System.out.println("Vous avez fais "+deroulement.get(4)+"(["+deroulement.get(0)+"]["+deroulement.get(1)+"]["+deroulement.get(2)+"]["+deroulement.get(3)+"])");
        System.out.println("Votre bonus d'initiative : "+(initiative+3+race.getM_bonusInitiative()));

        deroulement.clear();
        System.out.println("Vitesse (appuyez sur entrer):");
        sc.nextLine();
        int vitesse =new D4().rollDice(4,deroulement);
        System.out.println("Vous avez fais "+deroulement.get(4)+"(["+deroulement.get(0)+"]["+deroulement.get(1)+"]["+deroulement.get(2)+"]["+deroulement.get(3)+"])");
        System.out.println("Votre vitesse : "+(vitesse+3+race.getBonusVitesse()));



        return new Personnages(nom,race,classe,force,dexterite,initiative,vitesse);
    }


    public static void main(String args[]) {
       /* Armures Armure1 = new ArmureEcaille();
        System.out.println(Armure1);

        Armures Armure2 = new Legeres("Armure en cuire", 6);
        System.out.println(Armure2);

        Armures Armure3 = new CoteMaille();
        System.out.println(Armure3);

        Armures Armure4 = new Lourdes("Armure en dragon", 20);
        System.out.println(Armure4);

        D12 d12= new D12();
        System.out.println("Jet du dé "+d12+":");
        d12.rollDice(20);

        Armes Arme1 = new Courante("Dague");
        System.out.println(Arme1);

        Armes Arme2 = new DeGuerre(new Attaques("mort imminante",1,d12,3));
        System.out.println(Arme2);

        Armes Arme3 = new Fronde();
        System.out.println(Arme3);

        Armes Arme4 = new Baton();
        System.out.println(Arme4);

        Armes Arme5= new Rapiere();
        System.out.println(Arme5);

        Personnages Personnage1 = new Personnages();
        System.out.println(Personnage1);

        Nains Nain1 = new Nains();
        System.out.println(Nain1);
        System.out.println(Personnage1.degatsAttaque());
        */

        System.out.println("--------------------------Début du Test---------------------------");
        Personnages jules=CreerPersonnage();

        Monstres lohan = new Monstres("Tieffelin",0,"7L",new Attaques("Désintégration",25,new D8(),2),50,15,15,20,8,12);
        System.out.println(jules);
        System.out.println("-------------------------------------------------------------");
        System.out.println(lohan);
        System.out.println("-------------------------------------------------------------");
        jules.equiperArme(new Baton());
        System.out.println("Jules équipe "+ jules.getArme());
        jules.prendre(new ArmureEcaille());
        System.out.println("Jules possède "+ jules.getInventaire());
        jules.equiperArmure(new ArmureEcaille());
        System.out.println("Jules équipe "+ jules.getArmure());
        System.out.println("PV de Lohan : "+ lohan.getPV());
        System.out.println(jules.getNom()+" attaque "+lohan.getEspece()+lohan.getNum());
        ArrayList<Integer> attaque1 = jules.attaquer(lohan);
        lireAttaque(attaque1,jules,lohan);
        System.out.println("PV de Lohan : "+ lohan.getPV());
        System.out.println("PV de Jules : "+ jules.getPV());
        System.out.println(lohan.getEspece()+lohan.getNum()+" attaque "+jules.getNom());
        ArrayList<Integer> attaque2 = lohan.attaquer(jules);
        lireAttaque(attaque2,lohan,jules);
        System.out.println("PV de Jules : "+ jules.getPV());
        System.out.println("-------------------------Fin-----------------------------");

    }
}