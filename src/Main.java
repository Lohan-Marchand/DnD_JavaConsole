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

            System.out.println("Donjon n°1 : \n"+donjon.getDesc());
            donjon.afficherMap();
            System.out.print("____Appuyez sur entrer pour débuter le donjon____\n");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

            int enCours=continuDonjon;
            while(enCours==continuDonjon){
                Tour tour=new Tour(donjon.getOrdre().getFirst() ,donjon);
                enCours=tour.joueTour();
                //à modifier!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                donjon.tourSuivant();
                donjon.afficherTour();
            }
            if(enCours==echecDonjon){
                i=4;
                System.out.println("____________________________________________________________________\n\t\tL'un des membres de l'équipe est mort.\n\t\t\t\tVous avez échoué!!!\n____________________________________________________________________");
            } else if (enCours==reussiDonjon) {
                if(i==3){
                    System.out.println("____________________________________________________________________\n\t\tTous les monstres du donjon ont été éliminés\n____________________________________________________________________");
                    System.out.println("_______________________________________________________________\n\t\tVous avez terminé la partie\n\t\t\t\tMerci d'avoir joué!\n____________________________________________________________________");
                    //On n'afficherait pas le titre du jeu comme au début ou un autre truc du genre pour que ce soit bien visible ?
                }
                System.out.println("____________________________________________________________________\n\t\tTous les monstres du donjon ont été éliminés\n\t\t\t\tVous atteignez le donjon suivant\n____________________________________________________________________");
            }
        }
        System.out.println("Fin de partie");
    }
}