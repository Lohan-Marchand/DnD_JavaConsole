package utilities;

import dice.D20;
import dice.D4;
import dice.Dice;
import donjons.*;
import donjons.Donjons;
import donjons.Positions;
import entites.Attaques;
import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.classes.*;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.Armes;
import entites.personnages.equipements.armes.courantes.Baton;
import entites.personnages.equipements.armes.courantes.Courante;
import entites.personnages.equipements.armes.courantes.MasseArme;
import entites.personnages.equipements.armes.deGuerre.Epee2Main;
import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.deGuerre.Rapiere;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armes.distance.ArcCourt;
import entites.personnages.equipements.armes.distance.Fronde;
import entites.personnages.equipements.armures.Armures;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.legeres.DemiPlate;
import entites.personnages.equipements.armures.lourdes.CoteMaille;
import entites.personnages.equipements.armures.lourdes.Harnois;
import entites.personnages.equipements.armures.lourdes.Lourdes;
import entites.personnages.races.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public final class Create {
    private Create(){}
    public static ArrayList<Personnages> creerPartie(){
        int nbJoueurs=0;
        Scanner sc = new Scanner(System.in);
        nbJoueurs=selectNombre("Combien y a-t-il de joueurs (sans compter le MJ)",1,10);
        ArrayList<Personnages> Joueurs = new ArrayList<>();
        for(int i=1;i<=nbJoueurs;i++){
            System.out.println("Création du personnage du joueur "+i+": ");
            Personnages newPerso=creerPersonnage(Joueurs);
            Joueurs.add(newPerso);
        }
        return Joueurs;
    }
    public static Personnages creerPersonnage(ArrayList<Personnages> Partie){
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
            boolean nomValide=false;

            System.out.println("\t\t\t___Nouveau personnage___");
            while(!nomValide){
                nomValide=true;
                System.out.print("Veuillez choisir un nom : ");
                nom = sc.nextLine();
                if(nom.contains("n°")){
                    nomValide=false;
                    System.out.println("Un nom ne peut pas contenir \"n°\" ");
                }
                else if(nom.strip().equals("")){
                    nomValide=false;
                    System.out.println("Un nom d'espèce ne peut pas être vide ou fait uniquement d'espace");
                }
                else{
                    Personnages testNom=new Personnages(nom,race,classe,force,dexterite,vitesse,initiative);
                    if(Partie.contains(testNom)){
                        nomValide=false;
                        System.out.println("Ce nom n'est pas disponible !");
                    }
                }
            }



            int numRace = 0;
            numRace=selectNombre("Veuillez choisir une race parmi :\n1-" + new Elfes().getStats() + "\n2-" + new Halfelins().getStats() + "\n3-" + new Humains().getStats() + "\n4-" + new Nains().getStats()+"\n",1,4);
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
            numClasse=selectNombre("Veuillez choisir une classe parmi :\n1-" + new Clercs().getStats() + "\n2-" + new Guerriers().getStats() + "\n3-" + new Magiciens().getStats() + "\n4-" + new Roublards().getStats() + "\n",1,4);
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
            System.out.println("Votre bonus d'initiative : " + (initiative + 3 + race.getBonusInitiative()));

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

        portee=selectNombre("Veuillez choisir la portée de l'attaque",1,20);

        valDice=selectNombre("Veuillez choisir la valeur du/des dé(s) à lancer par attaque",1,100);

        nbDice=selectNombre("Veuillez choisir le nombre de dé \"+valDice+\" à lancer par attaque",1,20);

        return new Attaques(nom,portee, new Dice(valDice),nbDice);
    }
    public static Monstres creerMonstre(ArrayList<Monstres> bestiaire,ArrayList<Personnages> Partie){
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


            System.out.println("\t\t\t___Nouveau monstre___");
            boolean nomValide=false;
            while(!nomValide){
                nomValide=true;
                System.out.print("Veuillez nommer l'espèce du monstre : ");
                espece = sc.nextLine();
                if(espece.contains("n°")){
                    nomValide=false;
                    System.out.println("Un nom d'espèce ne peut pas contenir \"n°\" ");
                }
                else if(espece.strip().equals("")){
                    nomValide=false;
                    System.out.println("Un nom d'espèce ne peut pas être vide ou fait uniquement d'espace");
                }
                else{
                    Personnages testNom=new Personnages(espece,new Races(),new Classes(),0,0,0,0);
                    if(Partie.contains(testNom)){
                        nomValide=false;
                        System.out.println("Ce nom d'espèce n'est pas disponible !");
                    }
                }
            }

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
            PvMax=selectNombre("Veuillez choisir les PV maximum :",1,20);


            attaque= creerAttaque();

            if(attaque.getPortee()==1) {
                force=selectNombre("Veuillez choisir la valeur de force",1,20);
            }
            else {
                dexterite=selectNombre("Veuillez choisir la valeur de dextérité",1,20);

            }
            initiative=selectNombre("Veuillez choisir le bonus d'initiative",1,20);

            vitesse=selectNombre("Veuillez choisir la valeur de vitesse",1,20);

            CA=selectNombre("Veuillez choisir le classe d'armure",1,20);



            //Confirmation de Création
            build= new Monstres(espece,num,surnom,attaque,PvMax,force,dexterite,initiative,CA,vitesse);

            Valide=yesNoQuestion("Vous allez Créer " +build.getStats() + " Correct ?(y/n)");
        }
        bestiaire.add(build);
        return build;
    }
    public static ArrayList<Monstres> creerBestiaire(ArrayList<Personnages> Partie) {
        boolean ajout = true;
        ArrayList<Monstres> bestiaire = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (ajout) {
            creerMonstre(bestiaire,Partie);
            ajout=yesNoQuestion("Ajouter un monstre ?(y/n)");
        }
        return bestiaire;
    }
    public static Equipements selectEquipement(){
        Scanner sc = new Scanner(System.in);
        Equipements loot;
        while (true) {
            boolean type = false;
            int numType = 0;
            numType=selectNombre("Voulez vous créer : \n1-une arme \n2-une armure",1,2);
            switch (numType) {
                case 1:
                    type = true;
                    while (type) {
                        int numTypeArme = 0;
                        numTypeArme=selectNombre("\tVoulez vous créer :\n\t1-une arme de guerre au corps à corps \n\t2-une arme courante au corps à corps \n\t3-une arme courante à distance \n\t4-Retour",1,4);
                        switch (numTypeArme) {
                            case 1:
                                int numTypeArmeDeGuerre = 0;
                                numTypeArmeDeGuerre=selectNombre("\t\tVoulez vous créer :\n\t\t1-une épée longue \n\t\t2-une rapière \n\t\t3-une épée à deux mains \n\t\t4-Retour",1,4);
                                switch (numTypeArmeDeGuerre) {
                                    case 1:
                                        return new EpeeLongue();
                                    case 2:
                                        return new Rapiere();
                                    case 3:
                                        return new Epee2Main();
                                    case 4:
                                        break;
                                }
                                break;
                            case 2:
                                int numTypeArmeCourante = 0;
                                numTypeArmeCourante=selectNombre("\t\tVoulez vous créer :\n\t\t1-un bâton \n\t\t2-une masse d'arme \n\t\t3-Retour",1,3);
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
                                numTypeArmeDistance=selectNombre("\t\tVoulez vous créer :\n\t\t1-une arbalète légère \n\t\t2-un arc court \n\t\t3-une fronde \n\t\t4-Retour",1,4);
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
                        numTypeArmure=selectNombre("\tVoulez vous créer :\n\t1-une armure légère \n\t2-une armure lourde \n\t3-Retour",1,3);
                        switch (numTypeArmure) {
                            case 1:
                                int numTypeArmureLegere = 0;
                                numTypeArmureLegere=selectNombre("\t\tVoulez vous créer :\n\t\t1-une armure d'écailles \n\t\t2-une demi-plate \n\t\t3-Retour",1,3);
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
                                numTypeArmureLourde=selectNombre("\t\tVoulez vous créer :\n\t\t1-une cote de maille \n\t\t2-un harnois \n\t\t3-Retour",1,3);
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
    public static boolean creerObstacle(Donjons donjon){
        int hauteurDonjon= donjon.getHauteur();
        int largeurDonjon= donjon.getLargeur();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int hauteur = -1;
            hauteur=selectNombre("Quel est la ligne de l'obstacle ? : ",1,hauteurDonjon);
            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("Quel est la colonne de l'obstacle ? : ");
                String alphaVal=sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cet obstacle existe déjà");
            } else {
                donjon.addObstacle(new Positions(largeur,hauteur));
                if (yesNoQuestion("Vous allez ajouter un obstacle tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____")) {
                    return true;
                } else {
                    donjon.removeObstacle(new Positions(largeur,hauteur));
                    if(!yesNoQuestion("Voulez vous le recréer ?(y/n)")){
                        return false;
                    }
                }
            }
        }
    }
    public static void PositionMonstre(Donjons donjon,Monstres monstre){
        int hauteurDonjon= donjon.getHauteur();
        int largeurDonjon= donjon.getLargeur();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            int hauteur = -1;
            hauteur=selectNombre("Quel est la ligne de "+ monstre.getNom()+" ? : ",1,hauteurDonjon);

            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("Quel est la colonne de "+ monstre.getNom() +" ? : ");
                String alphaVal=sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else {
                donjon.addEnnemi(new Positions(largeur,hauteur),monstre);
                Valide = (yesNoQuestion("Vous allez ajouter un monstre tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____"));
            }
            if (!Valide) {
                donjon.removeEnnemi(new Positions(largeur,hauteur));
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
            hauteur=selectNombre("Quel est la ligne de "+ personnage.getNom()+" ? : ",1,hauteurDonjon);

            int largeur = -1;
            while (largeur > largeurDonjon-1 || largeur < 0) {
                System.out.print("Quel est la colonne de " + personnage.getNom() + " ? : ");
                String alphaVal = sc.nextLine();
                largeur = column(alphaVal);
                if (largeur > largeurDonjon-1 || largeur < -1) {
                    System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                }
            }
            if (!donjon.estLibre(new Positions(largeur,hauteur))) {
                System.out.println("Cette case n'est pas disponible");
            }
            else {
                donjon.addJoueur(new Positions(largeur,hauteur),personnage);
                Valide = (yesNoQuestion("Vous allez ajouter un personnage tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____"));
            }
            if (!Valide) {
                donjon.removeJoueur(new Positions(largeur,hauteur));
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
                hauteur=selectNombre("Quel est la ligne du loot ? : ",1,hauteurDonjon);

                int largeur = -1;
                while (largeur > largeurDonjon-1 || largeur < 0) {
                    System.out.print("Quel est la colonne du loot ? : ");
                    String alphaVal=sc.nextLine();
                    largeur = column(alphaVal);
                    if (largeur > largeurDonjon-1 || largeur < -1) {
                        System.out.println("/!\\La colonne selectionné n'est pas l'une des possibilités/!\\");
                    }
                }
                if (!donjon.estLibre(new Positions(largeur,hauteur))) {
                    System.out.println("Cette case n'est pas disponible");
                } else {
                    donjon.addLoot(new Positions(largeur,hauteur), build);
                    if (yesNoQuestion("Vous allez ajouter un(e) " + build.getNom() + " tel que :\n" + donjon.getMap() + "\n\n ____Correct ?(y/n)____")) {
                        Valide = true;
                        ValideEquipement = true;
                    } else {
                        donjon.removeLoot(new Positions(largeur,hauteur));
                        int numChoix = 0;
                        numChoix=selectNombre("Que voulez vous faire ? :\n1-changer la position\n2-changer le loot\n3-annuler la création",1,3);
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

    public static Donjons donjonParDefaut(Donjons build,ArrayList<Personnages> joueurs){
        Scanner sc = new Scanner(System.in);
        while(true) {
            int numDonjon = 0;
            numDonjon=selectNombre("Quel donjon voulez vous ? :\n1-Donjon par défaut 1\n2-Donjon par défaut 2\n3-Donjon par défaut 3\n4-Créer mon propre donjon\n",1,4);
            switch (numDonjon) {
                case 1:
                    build = new Donjon1(joueurs);
                    build.afficherMap();
                    if (yesNoQuestion("Voulez vous utiliser ce donjon ? (y/n)")) {
                        return build;
                    }
                    break;
                case 2:
                    build = new Donjon2(joueurs);
                    build.afficherMap();
                    if (yesNoQuestion("Voulez vous utiliser ce donjon ? (y/n)")) {
                        return build;
                    }
                    break;
                case 3:
                    build = new Donjon3(joueurs);
                    build.afficherMap();
                    if (yesNoQuestion("Voulez vous utiliser ce donjon ? (y/n)")) {
                        return build;
                    }
                    break;
                case 4:
                    return null;
            }
        }
    }

    public static Donjons creerDonjon(ArrayList<Personnages> joueurs, int num){
        System.out.println("\n\t\t\t_________Pour le MJ__________\n");
        Donjons build = new Donjons();
        Scanner sc = new Scanner(System.in);
        boolean Valide=false;
        while (!Valide) {
            build =donjonParDefaut(build,joueurs);
            if(build !=null) {
                return build;
            }
            build = new Donjons();
            String nom="";
            System.out.print("\t\t\t___Nouveau donjon___\nVeuillez choisir un nom pour le donjon: ");
            nom = sc.nextLine();

            int hauteur = -1;
            hauteur=selectNombre("Quel est la profondeur du donjon ?",15,25);
            int largeur = -1;
            largeur=selectNombre("Quel est la largeur du donjon ?",15,25);
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
        ArrayList<Monstres> Bestiaire = creerBestiaire(joueurs);
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
            System.out.println("Veuillez entrer la description du donjon (entrer la ligne \"Fin\" pour finir) :");
            boolean endDesc=false;
            description="";
            while(!endDesc){
                String addLine=sc.nextLine();
                if(addLine.equals("Fin")){
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

    public static void choixArme(Personnages p){

        int nbArme=0;
        for(Equipements e :p.getInventaire()){
            if(e.getCategorie().substring(0,4).equals(new Courante().getCategorie().substring(0,4))){
                nbArme++;
            }
        }
        if(nbArme==0){
            System.out.println("Vous n'avez pas d'arme dans votre inventaire");
            return;
        }

        Scanner sc=new Scanner(System.in);
        int numArme = 0;
        int i=1;
        HashMap<Integer, Armes> choixArme= new HashMap<>();
        while (numArme > i || numArme < 1) {
            System.out.println("Quelle arme voulez vous équiper ?");
            i=1;
            choixArme=new HashMap<>();
            for(Equipements e :p.getInventaire()){
                if(e.getCategorie().substring(0,4).equals(new Courante().getCategorie().substring(0,4))){
                    System.out.println(i+"-"+e);
                    choixArme.put(i,(Armes)e);
                    i++;
                }
            }
            System.out.println(i+"-ne pas changer d'arme ("+p.getArme()+")");
            try {
                numArme = Integer.parseInt(sc.nextLine());
                if (numArme > i || numArme < 1) {
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            } catch (Exception e) {
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        if(numArme!=i) {
            p.equiperArme(choixArme.get(numArme));
        }
    }

    public static void choixArmure(Personnages p){

        int nbArmures=0;
        for(Equipements e :p.getInventaire()){
            if(e.getCategorie().substring(0,6).equals(new Lourdes().getCategorie().substring(0,6))){
                nbArmures++;
            }
        }
        if(nbArmures==0){
            System.out.println("Vous n'avez pas d'armure dans votre inventaire");
            return;
        }
        Scanner sc=new Scanner(System.in);
        int numArmure = 0;
        int i=1;
        HashMap<Integer, Armures> choixArmure = new HashMap<>();
        while (numArmure > i || numArmure < 1) {
            System.out.println("Quelle armure voulez vous équiper ?");
            i=1;
            choixArmure =new HashMap<>();
            for(Equipements e :p.getInventaire()){
                if(e.getCategorie().substring(0,6).equals(new Lourdes().getCategorie().substring(0,6))){
                    System.out.println(i+"-"+e);
                    choixArmure.put(i,(Armures)e);
                    i++;
                }
            }
            System.out.println(i+"-ne pas changer d'armure ("+p.getArmure()+")");
            try {
                numArmure = Integer.parseInt(sc.nextLine());
                if (numArmure > i || numArmure < 1) {
                    System.out.println("/!\\Le numéro selectionné n'est pas l'une des possibilités/!\\");
                }
            } catch (Exception e) {
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        if(numArmure!=i) {
            p.equiperArmure(choixArmure.get(numArmure));
        }
    }
    public static void commentaire(Personnages p){
        Scanner sc = new Scanner(System.in);
        if(p!=null && Create.yesNoQuestion("Voulez vous (joueur de "+ p.getNom() +") commenter l'action (y/n):")){
            String commentaireJoueur="";
            System.out.println("Écrivez votre commentaire (entrer la ligne \"Fin\" pour finir) :");
            boolean endCommentaire =false;
            while(!endCommentaire){
                String addLine=sc.nextLine();
                if(addLine.equals("Fin")){
                    endCommentaire =true;
                }
                else{
                    commentaireJoueur+=addLine+"\n";
                }
            }
        }
        if(Create.yesNoQuestion("Le mj veut-il commenter l'action (y/n):")){
            String commentaireMJ="";
            System.out.println("Écrivez votre commentaire (entrer la ligne \"Fin\" pour finir) :");
            boolean endCommentaire =false;
            while(!endCommentaire){
                String addLine=sc.nextLine();
                if(addLine.equals("Fin")){
                    endCommentaire =true;
                }
                else{
                    commentaireMJ+=addLine+"\n";
                }
            }
        }
    }
    public static void debutDonjon(Donjons build){
        Scanner sc=new Scanner(System.in);

        System.out.println("\t\t\t_________Jets d'initiatives__________\n");


        for(Monstres m:build.getEnnemis().values()){
            System.out.print("Lancer un dé 20 pour l'initiative de "+m.getNom()+" (appuyez sur entrer)");
            sc.nextLine();
            int initiativeDice =new D20().rollDice();
            System.out.println("Vous avez fais "+initiativeDice);
            int initiative= initiativeDice+ m.getInitiative();
            System.out.println("Initiative de "+m.getNom() +" : " +initiative+" (" +initiativeDice+"+" +m.getInitiative()+" Bonus d'initiative)");
            build.getInitiatives().put(m,initiative);
        }

        System.out.println("\t\t\t_________Pour les joueurs__________\n");


        for(Personnages p:build.getJoueurs().values()){
            System.out.print("Lancer un dé 20 pour l'initiative de "+p.getNom()+" (appuyez sur entrer)");
            sc.nextLine();
            int initiativeDice =new D20().rollDice();
            System.out.println("Vous avez fais "+initiativeDice);
            int initiative= initiativeDice+ p.getInitiative();
            System.out.println("Initiative de "+p.getNom() +" : " +initiative+" (" +initiativeDice+"+" +p.getInitiative()+" Bonus d'initiative de la race)");
            build.getInitiatives().put(p,initiative);

            choixArme(p);
            choixArmure(p);

        }
        build.calculerOrdre();
    }

    public static int selectNombre(String question,int min,int max){
        int choix=min-1;
        Scanner sc=new Scanner(System.in);
        while(choix<min || choix>max ){
            System.out.print(question+" (entre "+min+" et "+max+"): ");
            try{
                choix = Integer.parseInt(sc.nextLine());
                if(choix<min || choix>max){
                    System.out.println("/!\\La valeur entrée doit être comprises entre "+ min +" et "+ max +"/!\\");
                }
            }
            catch(Exception e){
                System.out.println("/!\\La valeur entrée n'est pas un numéro/!\\");
            }
        }
        return choix;
    }

}
