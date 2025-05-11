import dice.*;
import entites.Attaques;
import entites.monstres.*;
import entites.personnages.Personnages;
import entites.personnages.classes.Magiciens;
import entites.personnages.equipements.armes.courantes.*;
import entites.personnages.races.Elfes;

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
        int force =new D4().rollDice(4);
        System.out.println("Dextérité :");
        int dexterite =new D4().rollDice(4);
        System.out.println("Initiative :");
        int initiative =new D4().rollDice(4);
        System.out.println("Vitesse :");
        int vitesse =new D4().rollDice(4);

        Personnages jules = new Personnages("Jules",new Elfes(),new Magiciens(), force,dexterite,initiative,vitesse);
        Monstres lohan = new Monstres("Tieffelin",0,new Attaques("Désintégration",25,new D8(),2),50,15,15,20,8,12);
        System.out.println(jules);
        System.out.println("-------------------------------------------------------------");
        System.out.println(lohan);
        System.out.println("-------------------------------------------------------------");
        jules.equiperArme(new Baton());
        System.out.println("Jules équipe "+ jules.getArme());
        System.out.println("PV de Lohan : "+ lohan.getPV());
        System.out.println("Jules attaque Lohan d20: ");
        jules.attaquer(lohan);
        System.out.println("PV de Lohan : "+ lohan.getPV());
        System.out.println("PV de Jules : "+ jules.getPV());
        System.out.println("Lohan attaque Jules d20: ");
        lohan.attaquer(jules);
        System.out.println("PV de Jules : "+ jules.getPV());
        System.out.println("-------------------------Fin-----------------------------");
    }
}