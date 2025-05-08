import dice.*;
import entites.Attaques;
import entites.personnages.equipements.*;
import entites.personnages.equipements.armes.*;
import entites.personnages.equipements.armes.courantes.*;
import entites.personnages.equipements.armes.deGuerre.*;
import entites.personnages.equipements.armes.distance.*;
import entites.personnages.equipements.armures.*;
import entites.personnages.equipements.armures.legeres.*;
import entites.personnages.equipements.armures.lourdes.*;
public class Main {
    public static void main(String args[]) {

        Armures Armure1 = new ArmureEcaille();
        System.out.println(Armure1);

        Armures Armure2 = new Legeres("Armure en cuire", 6);
        System.out.println(Armure2);

        Armures Armure3 = new CoteMaille();
        System.out.println(Armure3);

        Armures Armure4 = new Lourdes("Armure en dragon", 20);
        System.out.println(Armure4);

        D12 d12= new D12();
        System.out.println("Jet du dé "+d12+":");
        for(int i=0;i<20;i++){
            System.out.print("["+d12.rollDice()+"]");
        }
        System.out.println("");

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
    }
}