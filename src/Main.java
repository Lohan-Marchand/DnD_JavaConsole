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


    public static void main(String args[]) {
        final int continuDonjon=-1;
        final int reussiDonjon=0;
        final int echecDonjon=1;
        afficherTitre();        //Début du jeu
        ArrayList<Personnages> Joueurs= Create.creerPartie();    //Création des personnages
        for(int i=1; i<4; i++){
            Donjons donjon= Create.creerDonjon(Joueurs,i);
            int enCours=continuDonjon;
            while(enCours==continuDonjon){
                Tour tour=new Tour(donjon.getOrdre().getFirst() ,donjon);
                enCours=tour.joueTour();
                donjon.next();
            }
        }


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