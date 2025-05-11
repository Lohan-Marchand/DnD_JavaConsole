import dice.*;
import entites.Attaques;
import entites.monstres.*;
import entites.monstres.especes.*;
import entites.personnages.Personnages;
import entites.personnages.classes.Magiciens;
import entites.personnages.equipements.*;
import entites.personnages.equipements.armes.*;
import entites.personnages.equipements.armes.courantes.*;
import entites.personnages.equipements.armes.deGuerre.*;
import entites.personnages.equipements.armes.distance.*;
import entites.personnages.equipements.armures.*;
import entites.personnages.equipements.armures.legeres.*;
import entites.personnages.equipements.armures.lourdes.*;
import entites.personnages.races.Elfes;
import entites.personnages.races.Nains;

import java.util.ArrayList;

public class Main {
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
        System.out.println(Personnage1.degatsAttaque());*/

        System.out.println("--------------------------Début du Test---------------------------");
        System.out.println("Dés pour les stats de Jules :");
        System.out.println("Force :");
        int Force =new D4().rollDice(4);
        System.out.println("Dextérité :");
        int Dexterite =new D4().rollDice(4);
        System.out.println("Initiative :");
        int Initiative =new D4().rollDice(4);
        System.out.println("Vitesse :");
        int Vitesse =new D4().rollDice(4);

        Personnages Jules = new Personnages("Jules",new Elfes(),new Magiciens(),Force,Dexterite,Initiative,Vitesse);
        Monstres Lohan = new Monstres("Tieffelin",0,new Attaques("Désintégration",25,new D8(),2),50,15,15,20,8,12);
        System.out.println(Jules);
        System.out.println("-------------------------------------------------------------");
        System.out.println(Lohan);
        System.out.println("-------------------------------------------------------------");
        Jules.equiperArme(new Baton());
        System.out.println("Jules équipe "+Jules.getArme());
        System.out.println("PV de Lohan : "+Lohan.getPV());
        System.out.println("Jules attaque Lohan d20: ");
        Jules.attaquer(Lohan);
        System.out.println("PV de Lohan : "+Lohan.getPV());
        System.out.println("PV de Jules : "+Jules.getPV());
        System.out.println("Lohan attaque Jules d20: ");
        Lohan.attaquer(Jules);
        System.out.println("PV de Jules : "+Jules.getPV());
        System.out.println("-------------------------Fin-----------------------------");
    }
}