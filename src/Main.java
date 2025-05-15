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
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void afficherTitre(){
        System.out.println(
            "DDDDDDDDDDDDD                                                &&&&&&&&&&    DDDDDDDDDDDDD        \n" +
            "D::::::::::::DDD                                            &::::::::::&   D::::::::::::DDD     \n" +
            "D:::::::::::::::DD                                         &::::&&&:::::&  D:::::::::::::::DD   \n" +
            "DDD:::::DDDDD:::::D                                       &::::&   &::::&  DDD:::::DDDDD:::::D  \n" +
            "  D:::::D    D:::::D    ooooooooooo      ooooooooooo      &::::&   &::::&    D:::::D    D:::::D \n" +
            "  D:::::D     D:::::D oo:::::::::::oo  oo:::::::::::oo     &::::&&&::::&     D:::::D     D:::::D\n" +
            "  D:::::D     D:::::Do:::::::::::::::oo:::::::::::::::o    &::::::::::&      D:::::D     D:::::D\n" +
            "  D:::::D     D:::::Do:::::ooooo:::::oo:::::ooooo:::::o     &:::::::&&       D:::::D     D:::::D\n" +
            "  D:::::D     D:::::Do::::o     o::::oo::::o     o::::o   &::::::::&   &&&&  D:::::D     D:::::D\n" +
            "  D:::::D     D:::::Do::::o     o::::oo::::o     o::::o  &:::::&&::&  &:::&  D:::::D     D:::::D\n" +
            "  D:::::D     D:::::Do::::o     o::::oo::::o     o::::o &:::::&  &::&&:::&&  D:::::D     D:::::D\n" +
            "  D:::::D    D:::::D o::::o     o::::oo::::o     o::::o &:::::&   &:::::&    D:::::D    D:::::D \n" +
            "DDD:::::DDDDD:::::D  o:::::ooooo:::::oo:::::ooooo:::::o &:::::&    &::::&  DDD:::::DDDDD:::::D  \n" +
            "D:::::::::::::::DD   o:::::::::::::::oo:::::::::::::::o &::::::&&&&::::::&&D:::::::::::::::DD   \n" +
            "D::::::::::::DDD      oo:::::::::::oo  oo:::::::::::oo   &&::::::::&&&::::&D::::::::::::DDD     \n" +
            "DDDDDDDDDDDDD           ooooooooooo      ooooooooooo       &&&&&&&&   &&&&&DDDDDDDDDDDDD        ");

    }
    public static ArrayList<Personnages> creerPartie(){
        int nbJoueurs=0;
        Scanner sc = new Scanner(System.in);
        while(nbJoueurs>10 || nbJoueurs<1){
            System.out.print("Combien y a-t-il de Joueurs (sans compter le MJ) entre 1 et 10 : ");
            try{
                nbJoueurs = Integer.parseInt(sc.nextLine());
                if(nbJoueurs>10 || nbJoueurs<1){
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            catch(Exception e){
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        ArrayList<Personnages> Joueurs = new ArrayList<>();
        for(int i=1;i<=nbJoueurs;i++){
            System.out.println("Création du personnage du joueur "+i+": ");
            Personnages newPerso=creerPersonnage();
            Joueurs.add(newPerso);
        }
        return Joueurs;
    }
    public static Personnages creerPersonnage(){
        Scanner sc = new Scanner(System.in);
        Personnages build =new Personnages();
        String nom="";
        int force=0;
        int dexterite=0;
        int vitesse=0;
        int initiative=0;
        Classes classe=new Classes();
        Races race=new Races();

        boolean Valide=false;
        while (!Valide) {
            build =new Personnages();
            nom="";
            force=0;
            dexterite=0;
            vitesse=0;
            initiative=0;
            classe=new Classes();
            race=new Races();

            System.out.print("\t\t\t___Nouveau personnage___\nVeuillez Choisir un nom : ");
            nom = sc.nextLine();
            int numRace = 0;
            while (numRace > 4 || numRace < 1) {
                System.out.print("Veuillez Choisir une race parmi :\n1-" + new Elfes().getStats() + "\n2-" + new Halfelins().getStats() + "\n3-" + new Humains().getStats() + "\n4-" + new Nains().getStats() + "\nChoix :");
                try {
                    numRace = Integer.parseInt(sc.nextLine());
                    if (numRace > 4 || numRace < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            switch (numRace) {
                case 1:
                    race = new Elfes();
                    break;
                case 2:
                    race = new Halfelins();
                    break;
                case 3:
                    race = new Humains();
                    break;
                case 4:
                    race = new Nains();
                    break;
            }
            int numClasse = 0;
            while (numClasse > 4 || numClasse < 1) {
                System.out.print("Veuillez Choisir une classe parmi :\n1-" + new Clercs().getStats() + "\n2-" + new Guerriers().getStats() + "\n3-" + new Magiciens().getStats() + "\n4-" + new Roublards().getStats() + "\nChoix :");
                try {
                    numClasse = Integer.parseInt(sc.nextLine());
                    if (numClasse > 4 || numClasse < 1) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            switch (numClasse) {
                case 1:
                    classe = new Clercs();
                    break;
                case 2:
                    classe = new Guerriers();
                    break;
                case 3:
                    classe = new Magiciens();
                    break;
                case 4:
                    classe = new Roublards();
                    break;
            }
            ArrayList<Integer> deroulement = new ArrayList<>();

            System.out.println("Lancez les dés pour les Caractéristiques :");
            System.out.println("Force (appuyez sur entrer):");
            sc.nextLine();
            force = new D4().rollDice(4, deroulement);
            System.out.println("Vous avez fais " + deroulement.get(4) + "([" + deroulement.get(0) + "][" + deroulement.get(1) + "][" + deroulement.get(2) + "][" + deroulement.get(3) + "])");
            System.out.println("Votre force : " + (force + 3 + race.getBonusForce()));

            deroulement.clear();
            System.out.println("Dextérité (appuyez sur entrer):");
            sc.nextLine();
            dexterite = new D4().rollDice(4, deroulement);
            System.out.println("Vous avez fais " + deroulement.get(4) + "([" + deroulement.get(0) + "][" + deroulement.get(1) + "][" + deroulement.get(2) + "][" + deroulement.get(3) + "])");
            System.out.println("Votre dextérité : " + (dexterite + 3 + race.getBonusDexterite()));

            deroulement.clear();
            System.out.println("Initiative (appuyez sur entrer):");
            sc.nextLine();
            initiative = new D4().rollDice(4, deroulement);
            System.out.println("Vous avez fais " + deroulement.get(4) + "([" + deroulement.get(0) + "][" + deroulement.get(1) + "][" + deroulement.get(2) + "][" + deroulement.get(3) + "])");
            System.out.println("Votre bonus d'initiative : " + (initiative + 3 + race.getM_bonusInitiative()));

            deroulement.clear();
            System.out.println("Vitesse (appuyez sur entrer):");
            sc.nextLine();
            vitesse = new D4().rollDice(4, deroulement);
            System.out.println("Vous avez fais " + deroulement.get(4) + "([" + deroulement.get(0) + "][" + deroulement.get(1) + "][" + deroulement.get(2) + "][" + deroulement.get(3) + "])");
            System.out.println("Votre vitesse : " + (vitesse + 3 + race.getBonusVitesse()));


            //Confirmation de Création
            build =new Personnages(nom,race,classe,force,dexterite,initiative,vitesse);

            String answer0 = "InvalidValue";
            while (!answer0.equals("n") && !answer0.equals("y")) {
                System.out.print("Vous allez Créer " +build.getStats() + " Correct ?(y/n)");
                answer0 = sc.nextLine();
                if (!answer0.equals("n") && !answer0.equals("y")) {
                    System.out.println("/!\\Vous devez répondre 'y' ou 'n'/!\\");
                }
                else if(answer0.equals("y")){
                    Valide=true;
                }
                else{
                    Valide=false;
                }
            }
        }
        return build;
    }
    public static Attaques creerAttaque(){
        Scanner sc = new Scanner(System.in);
        String nom = "";
        int portee=0;
        int nbDice=0;
        int valDice=0;

        System.out.print("Veuillez nommer l'attaque : ");
        nom = sc.nextLine();

        while(portee<1){
            System.out.print("Veuillez choisir la portée de l'attaque :");
            try{
                portee = Integer.parseInt(sc.nextLine());
                if(portee<1){
                    System.out.println("/!\\La valeur entrée doit être supérieur à 0/!\\");
                }
            }
            catch(Exception e){
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }

        while(valDice<1){
            System.out.print("Veuillez choisir la valeur du/des dé(s) à lancer par attaque :");
            try{
                valDice = Integer.parseInt(sc.nextLine());
                if(valDice<1){
                    System.out.println("/!\\La valeur entrée doit être supérieur à 0/!\\");
                }
            }
            catch(Exception e){
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }

        while(nbDice<1){
            System.out.print("Veuillez choisir le nombre de dé "+valDice+" à lancer par attaque :");
            try{
                nbDice = Integer.parseInt(sc.nextLine());
                if(nbDice<1){
                    System.out.println("/!\\La valeur entrée doit être supérieur à 0/!\\");
                }
            }
            catch(Exception e){
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        return new Attaques(nom,portee, new Dice(valDice),nbDice);
    }
    public static Monstres creerMonstre(ArrayList<Monstres> bestiaire){
        Scanner sc = new Scanner(System.in);
        Monstres build = new Monstres();
        String espece="";
        String surnom="";
        int num=1;
        int PvMax=0;
        int force=0;
        int dexterite=0;
        int initiative=0;
        int vitesse=0;
        int CA=0;
        Attaques attaque = new Attaques();
        boolean Valide=false;
        while (!Valide){
            build = new Monstres();
            espece="";
            surnom="";
            num=1;
            PvMax=0;
            force=0;
            dexterite=0;
            initiative=0;
            vitesse=0;
            CA=0;
            attaque = new Attaques();


            System.out.print("\t\t\t___Nouveau monstre___\nVeuillez nommer son espèce : ");
            espece = sc.nextLine();
            num=1;
            for(Monstres monstre : bestiaire){
                if(monstre.getEspece().equals(espece)){
                    num++;

                }
            }
            while(surnom.isEmpty() || surnom.length()>3){
                System.out.print("Veuillez choisir un alias pour ce monstre (3 caractères maximum) : ");
                surnom = sc.nextLine();
                if(surnom.isEmpty() || surnom.length()>3){
                    System.out.println("/!\\La valeur entrée contenir entre 1 et 3 caractères/!\\");
                }
            }
            boolean error=true;
            while(error){
                error=false;
                System.out.print("Veuillez choisir les PV maximum :");
                try{
                    PvMax = Integer.parseInt(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                    error=true;
                }
            }

            attaque= creerAttaque();

            if(attaque.getPortee()==1) {
                error = true;
                while (error) {
                    error = false;
                    System.out.print("Veuillez choisir la valeur de force :");
                    try {
                        force = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                        error = true;
                    }
                }
            }
            else {
                error = true;
                while (error) {
                    error = false;
                    System.out.print("Veuillez choisir la valeur de dexterite :");
                    try {
                        dexterite = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                        error = true;
                    }
                }
            }
            error=true;
            while(error){
                error=false;
                System.out.print("Veuillez choisir la valeur de initiative :");
                try{
                    initiative = Integer.parseInt(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                    error=true;
                }
            }
            error=true;
            while(error){
                error=false;
                System.out.print("Veuillez choisir la valeur de vitesse :");
                try{
                    vitesse = Integer.parseInt(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                    error=true;
                }
            }
            error=true;
            while(error){
                error=false;
                System.out.print("Veuillez choisir la classe d'armure :");
                try{
                    CA = Integer.parseInt(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                    error=true;
                }
            }


                                //Confirmation de Création
            build= new Monstres(espece,num,surnom,attaque,PvMax,force,dexterite,initiative,CA,vitesse);

            String answer0="InvalidValue";
            while(!answer0.equals("n") && !answer0.equals("y")){
                System.out.print("Vous allez Créer " +build.getStats() + " Correct ?(y/n)");
                answer0 = sc.nextLine();
                if(!answer0.equals("n") && !answer0.equals("y")){
                    System.out.println("/!\\Vous devez répondre 'y' ou 'n'/!\\");
                }
                else if(answer0.equals("y")){
                    Valide=true;
                }
                else{
                    Valide=false;
                }
            }
        }
        bestiaire.add(build);
        return build;
    }
    public static ArrayList<Monstres> creerBestiaire() {
        boolean ajout = true;
        ArrayList<Monstres> bestiaire = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String answer0 = "InvalidValue";
        while (!answer0.equals("n") && !answer0.equals("y")) {
            System.out.println("Voulez vous générer des monstres ?(y/n)");
            answer0 = sc.nextLine();
            if (!answer0.equals("n") && !answer0.equals("y")) {
                System.out.println("/!\\Vous devez répondre 'y' ou 'n'/!\\");
            } else if (answer0.equals("y")) {
                ajout = true;
            } else {
                ajout = false;
            }
        }
        while (ajout) {
            creerMonstre(bestiaire);
            String answer1 = "InvalidValue";
            while (!answer1.equals("n") && !answer1.equals("y")) {
                System.out.print("Ajouter un monstre ?(y/n)");
                answer1 = sc.nextLine();
                if (!answer1.equals("n") && !answer1.equals("y")) {
                    System.out.println("/!\\Vous devez répondre 'y' ou 'n'/!\\");
                } else if (answer1.equals("y")) {
                    ajout = true;
                } else {
                    ajout = false;
                }
            }
        }
        return bestiaire;
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
            System.out.println("l'attaque inflige "+attaque.get(attaque.get(2)+5)+" dégats");
        }
    }


    public static void main(String args[]) {

        afficherTitre();
        ArrayList<Personnages> Joueurs= creerPartie();
        ArrayList<Monstres> Bestiaire = creerBestiaire();
        System.out.println(Joueurs.get(0));
        System.out.println("-------------------------------------------------------------");
        System.out.println(Bestiaire.get(0));
        System.out.println("-------------------------------------------------------------");
        Joueurs.get(0).equiperArme(new Baton());
        System.out.println(Joueurs.get(0).getNom()+" équipe "+ Joueurs.get(0).getArme());
        Joueurs.get(0).prendre(new ArmureEcaille());
        System.out.println(Joueurs.get(0).getNom()+" possède "+ Joueurs.get(0).getInventaire());
        Joueurs.get(0).equiperArmure(new ArmureEcaille());
        System.out.println(Joueurs.get(0).getNom()+" équipe "+ Joueurs.get(0).getArmure());
        System.out.println("PV de "+Bestiaire.get(0).getNom()+" : "+ Bestiaire.get(0).getPV());
        System.out.println(Joueurs.get(0).getNom()+" attaque "+Bestiaire.get(0).getEspece()+Bestiaire.get(0).getNum());
        ArrayList<Integer> attaque1 = Joueurs.get(0).attaquer(Bestiaire.get(0));
        lireAttaque(attaque1,Joueurs.get(0),Bestiaire.get(0));
        System.out.println("PV de "+Bestiaire.get(0).getNom()+" : "+ Bestiaire.get(0).getPV());
        System.out.println("PV de "+Joueurs.get(0).getNom()+" : "+ Joueurs.get(0).getPV());
        System.out.println(Bestiaire.get(0).getEspece()+Bestiaire.get(0).getNum()+" attaque "+Joueurs.get(0).getNom());
        ArrayList<Integer> attaque2 = Bestiaire.get(0).attaquer(Joueurs.get(0));
        lireAttaque(attaque2,Bestiaire.get(0),Joueurs.get(0));
        System.out.println("PV de "+Joueurs.get(0).getNom()+" : "+ Joueurs.get(0).getPV());
        System.out.println("-------------------------Fin-----------------------------");

    }
}