import dice.*;
import donjons.Donjons;
import donjons.Positions;
import entites.Attaques;
import entites.Entites;
import entites.monstres.*;
import entites.personnages.Personnages;
import entites.personnages.classes.*;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.courantes.*;
import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.deGuerre.Rapiere;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armes.distance.ArcCourt;
import entites.personnages.equipements.armes.distance.Fronde;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.legeres.DemiPlate;
import entites.personnages.equipements.armures.lourdes.CoteMaille;
import entites.personnages.equipements.armures.lourdes.Harnois;
import entites.personnages.races.*;

import java.util.ArrayList;
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

            System.out.print("\t\t\t___Nouveau personnage___\nVeuillez choisir un nom : ");
            nom = sc.nextLine();
            int numRace = 0;
            while (numRace > 4 || numRace < 1) {
                System.out.print("Veuillez choisir une race parmi :\n1-" + new Elfes().getStats() + "\n2-" + new Halfelins().getStats() + "\n3-" + new Humains().getStats() + "\n4-" + new Nains().getStats() + "\nChoix :");
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
                System.out.print("Veuillez choisir une classe parmi :\n1-" + new Clercs().getStats() + "\n2-" + new Guerriers().getStats() + "\n3-" + new Magiciens().getStats() + "\n4-" + new Roublards().getStats() + "\nChoix :");
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

            Valide=yesNoQuestion("Vous allez Créer " +build.getStats() + " Correct ?(y/n)");
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

            Valide=yesNoQuestion("Vous allez Créer " +build.getStats() + " Correct ?(y/n)");
        }
        bestiaire.add(build);
        return build;
    }
    public static ArrayList<Monstres> creerBestiaire() {
        boolean ajout = true;
        ArrayList<Monstres> bestiaire = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ajout=yesNoQuestion("Voulez vous générer des monstres ?(y/n)");
        while (ajout) {
            creerMonstre(bestiaire);
            ajout=yesNoQuestion("Ajouter un monstre ?(y/n)");
        }
        return bestiaire;
    }

    public static Donjons creerDonjon(ArrayList<Personnages> joueurs,int num){
        Donjons build = new Donjons();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            String nom="";
            System.out.print("\t\t\t___Nouveau donjon___\nVeuillez choisir un nom pour le donjon: ");
            nom = sc.nextLine();

            int hauteur = -1;
            while (hauteur > 25 || hauteur < 15) {
                System.out.print("Quel est la profondeur du donjon ? (entre 15 et 25) : ");
                try {
                    hauteur = Integer.parseInt(sc.nextLine());
                    if (hauteur > 25 || hauteur < 15) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            int largeur = -1;
            while (largeur > 25 || largeur < 15) {
                System.out.print("Quel est la largeur du donjon ? (entre 15 et 25) : ");
                try {
                    largeur = Integer.parseInt(sc.nextLine());
                    if (largeur > 25 || largeur < 15) {
                        System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                    }
                } catch (Exception e) {
                    System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                }
            }
            //creer et vérifier
            build=new Donjons(nom,hauteur,largeur,num);
            Valide=(yesNoQuestion("Vous allez Créer :\n\t\t\t____" + build.getNom() +"____\n" +build.getMap() + "\n\n ____Correct ?(y/n)____"));
        }


        //Ajout des Obstacles
        Valide=true;
        while(Valide){
            if(yesNoQuestion("Voulez vous ajouter un obstacle ?(y/n)")){
                creerObstacle(build);
            }
            else{
                Valide=false;
            }
        }
        ArrayList<Monstres> Bestiaire = creerBestiaire();
        for(Monstres m:Bestiaire){
            PositionMonstre(build,m);
        }

        System.out.println("Placement des Personnages");
        for(Personnages p:joueurs){
            PositionPersonnage(build,p);
        }

        Valide=true;
        while(Valide){
            if(yesNoQuestion("Voulez vous ajouter un équipement ?(y/n)")){
                PositionEquipement(build);
            }
            else{
                Valide=false;
            }
        }


        Valide=false;
        String description="";
        while (!Valide) {
            System.out.println("Veuillez entrer la description du donjon (entrer la ligne \"Fin description\" pour finir) :");
            boolean endDesc=false;
            description="";
            while(!endDesc){
                String addLine=sc.nextLine();
                if(addLine.equals("Fin description")){
                    endDesc=true;
                }
                else{
                    description+=addLine+"\n";
                }
            }
            Valide=yesNoQuestion("Votre description : \n" + description + "\n Confirmer ?(y/n)");
        }
        build.setDesc(description);

        return build;
    }


    public static void PositionMonstre(Donjons donjon,Monstres monstre){
        int hauteurDonjon= donjon.getHauteur();
        int largeurDonjon= donjon.getLargeur();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            int hauteur = -1;
            while (hauteur > hauteurDonjon || hauteur < 1) {
                System.out.print("Quel est la ligne de "+ monstre.getNom() +" ? : ");
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
                System.out.print("Quel est la colonne de "+ monstre.getNom() +" ? : ");
                String alphaVal=sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur-1))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else {
                donjon.addEnnemi(new Positions(largeur,hauteur-1),monstre);
                Valide = (yesNoQuestion("Vous allez ajouter un monstre tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____"));
            }
            if (!Valide) {
                donjon.removeEnnemi(new Positions(largeur,hauteur-1));
            }
        }
    }
    public static void PositionPersonnage(Donjons donjon,Personnages personnage){
        int hauteurDonjon= donjon.getHauteur();
        int largeurDonjon= donjon.getLargeur();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            int hauteur = -1;
            while (hauteur > hauteurDonjon || hauteur < 1) {
                System.out.print("Quel est la ligne de "+ personnage.getNom() +" ? : ");
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
                System.out.print("Quel est la colonne de " + personnage.getNom() + " ? : ");
                String alphaVal = sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur-1))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else {
                donjon.addJoueur(new Positions(largeur,hauteur-1),personnage);
                Valide = (yesNoQuestion("Vous allez ajouter un personnage tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____"));
            }
            if (!Valide) {
                donjon.removeJoueur(new Positions(largeur,hauteur-1));
            }
        }
    }
    public static void creerObstacle(Donjons donjon){
        int hauteurDonjon= donjon.getHauteur();
        int largeurDonjon= donjon.getLargeur();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            int hauteur = -1;
            while (hauteur > hauteurDonjon || hauteur < 1) {
                System.out.print("Quel est la ligne de l'obstacle ? : ");
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
                System.out.print("Quel est la colonne de l'obstacle ? : ");
                String alphaVal=sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur-1))) {
                System.out.println("Cet obstacle existe déjà");
            } else {
                donjon.addObstacle(new Positions(largeur,hauteur-1));
                if (yesNoQuestion("Vous allez ajouter un obstacle tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____")) {
                    Valide = true;
                } else {
                    donjon.removeObstacle(new Positions(largeur,hauteur-1));
                    Valide = !yesNoQuestion("Voulez vous le recréer ?(y/n)");
                }
            }
        }
    }
    public static int column(String alphaVal){
        try {
            if(!(alphaVal.length()==1)){
                System.out.println("/!\\La valeur entrée n'est pas un correct /!\\");
                return -1;
            }
            if(!(alphaVal.charAt(0)>90) && !(alphaVal.charAt(0)<65)){
                return (alphaVal.charAt(0))-17-'0';
            }
            System.out.println("/!\\La valeur entrée n'est pas un correct /!\\");
        } catch (Exception e) {
            System.out.println("/!\\La valeur entrée n'est pas un correct /!\\");
        }
        return -1;
    }
    public static Equipements selectEquipement(){
        Scanner sc = new Scanner(System.in);
        Equipements loot;
        while (true) {
            boolean type = false;
            int numType = 0;
            while (numType > 2 || numType < 1) {
                System.out.println("Voulez vous créer :\n1-une arme \n2-une armure");
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
                    type = true;
                    while (type) {
                        int numTypeArme = 0;
                        while (numTypeArme > 4 || numTypeArme < 1) {
                            System.out.println("\tVoulez vous créer :\n\t1-une arme de guerre au corps à corps \n\t2-une arme courante au corps à corps \n\t3-une arme courante à distance \n\t4-Retour");
                            try {
                                numTypeArme = Integer.parseInt(sc.nextLine());
                                if (numTypeArme > 4 || numTypeArme < 1) {
                                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                }
                            } catch (Exception e) {
                                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                            }
                        }
                        switch (numTypeArme) {
                            case 1:
                                int numTypeArmeDeGuerre = 0;
                                while (numTypeArmeDeGuerre > 3 || numTypeArmeDeGuerre < 1) {
                                    System.out.println("\t\tVoulez vous créer :\n\t\t1-une épée longue \n\t\t2-une rapière \n\t\t3-Retour");
                                    try {
                                        numTypeArmeDeGuerre = Integer.parseInt(sc.nextLine());
                                        if (numTypeArmeDeGuerre > 3 || numTypeArmeDeGuerre < 1) {
                                            System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                                    }
                                }
                                switch (numTypeArmeDeGuerre) {
                                    case 1:
                                        return new EpeeLongue();
                                    case 2:
                                        return new Rapiere();
                                    case 3:
                                        break;
                                }
                                break;
                            case 2:
                                int numTypeArmeCourante = 0;
                                while (numTypeArmeCourante > 3 || numTypeArmeCourante < 1) {
                                    System.out.println("\t\tVoulez vous créer :\n\t\t1-un bâton \n\t\t2-une masse d'arme \n\t\t3-Retour");
                                    try {
                                        numTypeArmeCourante = Integer.parseInt(sc.nextLine());
                                        if (numTypeArmeCourante > 3 || numTypeArmeCourante < 1) {
                                            System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                                    }
                                }
                                switch (numTypeArmeCourante) {
                                    case 1:
                                        return new Baton();
                                    case 2:
                                        return new MasseArme();
                                    case 3:
                                        break;
                                }
                                break;
                            case 3:
                                int numTypeArmeDistance = 0;
                                while (numTypeArmeDistance > 4 || numTypeArmeDistance < 1) {
                                    System.out.println("\t\tVoulez vous créer :\n\t\t1-une arbalète légère \n\t\t2-un arc court \n\t\t3-une fronde \n\t\t4-Retour");
                                    try {
                                        numTypeArmeDistance = Integer.parseInt(sc.nextLine());
                                        if (numTypeArmeDistance > 4 || numTypeArmeDistance < 1) {
                                            System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                                    }
                                }
                                switch (numTypeArmeDistance) {
                                    case 1:
                                        return new ArbaleteLegere();
                                    case 2:
                                        return new ArcCourt();
                                    case 3:
                                        return new Fronde();
                                    case 4:
                                        break;
                                }
                                break;
                            case 4:
                                type=false;
                                break;
                        }
                    }
                    break;
                case 2:
                    type = true;
                    while (type) {
                        int numTypeArmure = 0;
                        while (numTypeArmure > 3 || numTypeArmure < 1) {
                            System.out.println("\tVoulez vous créer :\n\t1-une armure légère \n\t2-une armure lourde \n\t3-Retour");
                            try {
                                numTypeArmure = Integer.parseInt(sc.nextLine());
                                if (numTypeArmure > 3 || numTypeArmure < 1) {
                                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                }
                            } catch (Exception e) {
                                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                            }
                        }
                        switch (numTypeArmure) {
                            case 1:
                                int numTypeArmureLegere = 0;
                                while (numTypeArmureLegere > 3 || numTypeArmureLegere < 1) {
                                    System.out.println("\t\tVoulez vous créer :\n\t\t1-une armure d'écailles \n\t\t2-une demi-plate \n\t\t3-Retour");
                                    try {
                                        numTypeArmureLegere = Integer.parseInt(sc.nextLine());
                                        if (numTypeArmureLegere > 3 || numTypeArmureLegere < 1) {
                                            System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                                    }
                                }
                                switch (numTypeArmureLegere) {
                                    case 1:
                                        return new ArmureEcaille();
                                    case 2:
                                        return new DemiPlate();
                                    case 3:
                                        break;
                                }
                                break;
                            case 2:
                                int numTypeArmureLourde = 0;
                                while (numTypeArmureLourde > 3 || numTypeArmureLourde < 1) {
                                    System.out.println("\t\tVoulez vous créer :\n\t\t1-une cote de maille \n\t\t2-un harnois \n\t\t3-Retour");
                                    try {
                                        numTypeArmureLourde = Integer.parseInt(sc.nextLine());
                                        if (numTypeArmureLourde > 3 || numTypeArmureLourde < 1) {
                                            System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                                    }
                                }
                                switch (numTypeArmureLourde) {
                                    case 1:
                                        return new CoteMaille();
                                    case 2:
                                        return new Harnois();
                                    case 3:
                                        break;
                                }
                                break;
                            case 3:
                                type=false;
                                break;
                        }
                    }
                    break;
            }
        }
    }
    public static void PositionEquipement(Donjons donjon) {
        Scanner sc = new Scanner(System.in);
        int hauteurDonjon = donjon.getHauteur();
        int largeurDonjon = donjon.getLargeur();
        boolean Valide = false;
        boolean ValideEquipement = false;
        while (!ValideEquipement) {
            Valide=false;
            Equipements build = selectEquipement();
            while (!Valide) {
                int hauteur = -1;
                while (hauteur > hauteurDonjon || hauteur < 1) {
                    System.out.print("Quel est la ligne du loot ? : ");
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
                    System.out.print("Quel est la colonne du loot ? : ");
                    String alphaVal=sc.nextLine();
                    largeur = column(alphaVal);
                    if (largeur > largeurDonjon-1 || largeur < -1) {
                        System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                    }
                }
                if (!donjon.estLibre(new Positions(largeur,hauteur-1))) {
                    System.out.println("Cette case n'est pas disponible");
                } else {
                    donjon.addLoot(new Positions(largeur,hauteur-1), build);
                    if (yesNoQuestion("Vous allez ajouter un(e) " + build.getNom() + " tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____")) {
                        Valide = true;
                        ValideEquipement = true;
                    } else {
                        donjon.removeLoot(new Positions(largeur,hauteur-1));
                        int numChoix = 0;
                        while (numChoix > 3 || numChoix < 1) {
                            System.out.println("Que voulez vous faire ? :\n1-changer la position\n2-changer le loot\n3-annuler la création");
                            try {
                                numChoix = Integer.parseInt(sc.nextLine());
                                if (numChoix > 3 || numChoix < 1) {
                                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                                }
                            } catch (Exception e) {
                                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
                            }
                        }
                        switch (numChoix) {
                            case 1:
                                break;
                            case 2:
                                Valide = true;
                                break;
                            case 3:
                                Valide = true;
                                ValideEquipement = true;
                                break;
                        }
                    }
                }
            }
        }
    }

    public static boolean yesNoQuestion(String question){
        Scanner sc = new Scanner(System.in);
        String answer0="InvalidValue";
        while(true) {
            System.out.print(question);
            answer0 = sc.nextLine();
            if (!answer0.equals("n") && !answer0.equals("y")) {
                System.out.println("/!\\Vous devez répondre 'y' ou 'n'/!\\");
            }
            else {
                return (answer0.equals("y"));
            }
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
            System.out.println("l'attaque inflige "+attaque.get(attaque.get(2)+5)+" dégats");
        }
    }


    public static void main(String args[]) {

        afficherTitre();        //Début du jeu
        ArrayList<Personnages> Joueurs= creerPartie();    //Création des personnages
        creerDonjon(Joueurs,1);


        /*ArrayList<Monstres> Bestiaire = creerBestiaire();
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

        Donjons donjon = new Donjons();

        Personnages personnage1 =new Personnages();
        Monstres monstre1 = new Monstres();
        monstre1.setPseudo("Mst");
        Equipements equipement1 = new ArmureEcaille();
        donjon.addJoueur(new Positions(15, 4), personnage1);
        donjon.addEnnemi(new Positions(2, 12), monstre1);
        donjon.addLoot(new Positions(8, 8), equipement1);
        donjon.addObstacle(new Positions(16, 8));

        donjon.getInfos();
        donjon.updateMap();
        donjon.afficherMap();

        System.out.println("\n\n\n");
        donjon.moveJoueur(personnage1, new Positions(1, 1));
        donjon.updateMap();
        donjon.afficherMap();*/

    }
}