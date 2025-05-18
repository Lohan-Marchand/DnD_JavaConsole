package donjons;

import dice.Dice;
import entites.Attaques;
import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.legeres.DemiPlate;

import java.util.ArrayList;

public class Donjon3 extends Donjons {

    public Donjon3() {
        super("Donjon par défaut 3", 25, 25, 0);
        setDesc("Troisième donjon par défaut");

        addObstacle(new Positions(0,1)); addObstacle(new Positions(0,25));
        addObstacle(new Positions(24,1)); addObstacle(new Positions(24,25));
        addObstacle(new Positions(0,2)); addObstacle(new Positions(0,3)); addObstacle(new Positions(0,4));
        addObstacle(new Positions(0,5)); addObstacle(new Positions(0,6)); addObstacle(new Positions(0,7));
        addObstacle(new Positions(0,8)); addObstacle(new Positions(0,9)); addObstacle(new Positions(0,10));
        addObstacle(new Positions(0,11)); addObstacle(new Positions(0,12)); addObstacle(new Positions(0,13));
        addObstacle(new Positions(0,14)); addObstacle(new Positions(0,15)); addObstacle(new Positions(0,16));
        addObstacle(new Positions(0,17)); addObstacle(new Positions(0,18)); addObstacle(new Positions(0,19));
        addObstacle(new Positions(0,20)); addObstacle(new Positions(0,21)); addObstacle(new Positions(0,22));
        addObstacle(new Positions(0,23)); addObstacle(new Positions(0,24));

        addObstacle(new Positions(0, 25));
        addObstacle(new Positions(1, 25));
        addObstacle(new Positions(2, 25));
        addObstacle(new Positions(3, 25));
        addObstacle(new Positions(4, 25));
        addObstacle(new Positions(5, 25));
        addObstacle(new Positions(6, 25));
        addObstacle(new Positions(7, 25));
        addObstacle(new Positions(8, 25));
        addObstacle(new Positions(9, 25));
        addObstacle(new Positions(10, 25));
        addObstacle(new Positions(11, 25));
        addObstacle(new Positions(12, 25));
        addObstacle(new Positions(13, 25));
        addObstacle(new Positions(14, 25));
        addObstacle(new Positions(15, 25));
        addObstacle(new Positions(16, 25));
        addObstacle(new Positions(17, 25));
        addObstacle(new Positions(18, 25));
        addObstacle(new Positions(19, 25));
        addObstacle(new Positions(20, 25));
        addObstacle(new Positions(21, 25));
        addObstacle(new Positions(22, 25));
        addObstacle(new Positions(23, 25));
        addObstacle(new Positions(24, 25));

        addObstacle(new Positions(1,1)); addObstacle(new Positions(2,1)); addObstacle(new Positions(3,1));
        addObstacle(new Positions(4,1)); addObstacle(new Positions(5,1)); addObstacle(new Positions(6,1));
        addObstacle(new Positions(7,1)); addObstacle(new Positions(8,1)); addObstacle(new Positions(9,1));
        addObstacle(new Positions(10,1)); addObstacle(new Positions(11,1)); addObstacle(new Positions(12,1));
        addObstacle(new Positions(13,1)); addObstacle(new Positions(14,1)); addObstacle(new Positions(15,1));
        addObstacle(new Positions(16,1)); addObstacle(new Positions(17,1)); addObstacle(new Positions(18,1));
        addObstacle(new Positions(19,1)); addObstacle(new Positions(20,1)); addObstacle(new Positions(21,1));
        addObstacle(new Positions(22,1)); addObstacle(new Positions(23,1));

        addObstacle(new Positions(1,25)); addObstacle(new Positions(2,25)); addObstacle(new Positions(3,25));
        addObstacle(new Positions(4,25)); addObstacle(new Positions(5,25)); addObstacle(new Positions(6,25));
        addObstacle(new Positions(7,25)); addObstacle(new Positions(8,25)); addObstacle(new Positions(9,25));
        addObstacle(new Positions(10,25)); addObstacle(new Positions(11,25)); addObstacle(new Positions(12,25));
        addObstacle(new Positions(13,25)); addObstacle(new Positions(14,25)); addObstacle(new Positions(15,25));
        addObstacle(new Positions(16,25)); addObstacle(new Positions(17,25)); addObstacle(new Positions(18,25));
        addObstacle(new Positions(19,25)); addObstacle(new Positions(20,25)); addObstacle(new Positions(21,25));
        addObstacle(new Positions(22,25)); addObstacle(new Positions(23,25));

        addObstacle(new Positions(9,10)); addObstacle(new Positions(10,10)); addObstacle(new Positions(11,10));
        addObstacle(new Positions(12,10)); addObstacle(new Positions(13,10)); addObstacle(new Positions(14,10));
        addObstacle(new Positions(9,11)); addObstacle(new Positions(10,11)); addObstacle(new Positions(11,11));
        addObstacle(new Positions(12,11)); addObstacle(new Positions(13,11)); addObstacle(new Positions(14,11));
        addObstacle(new Positions(9,12)); addObstacle(new Positions(10,12)); addObstacle(new Positions(11,12));
        addObstacle(new Positions(12,12)); addObstacle(new Positions(13,12)); addObstacle(new Positions(14,12));
        addObstacle(new Positions(9,13)); addObstacle(new Positions(10,13)); addObstacle(new Positions(11,13));
        addObstacle(new Positions(12,13)); addObstacle(new Positions(13,13)); addObstacle(new Positions(14,13));
        addObstacle(new Positions(9,14)); addObstacle(new Positions(10,14)); addObstacle(new Positions(11,14));
        addObstacle(new Positions(12,14)); addObstacle(new Positions(13,14)); addObstacle(new Positions(14,14));

        addObstacle(new Positions(4,5)); addObstacle(new Positions(5,5)); addObstacle(new Positions(4,6)); addObstacle(new Positions(5,6));
        addObstacle(new Positions(4,19)); addObstacle(new Positions(5,19)); addObstacle(new Positions(4,20)); addObstacle(new Positions(5,20));
        addObstacle(new Positions(18,5)); addObstacle(new Positions(19,5)); addObstacle(new Positions(18,6)); addObstacle(new Positions(19,6));
        addObstacle(new Positions(18,19)); addObstacle(new Positions(19,19)); addObstacle(new Positions(18,20)); addObstacle(new Positions(19,20));

        addJoueur(new Positions(2,3), new Personnages());
        addJoueur(new Positions(2,4), new Personnages());
        addJoueur(new Positions(3,3), new Personnages());
        addJoueur(new Positions(3,4), new Personnages());
        addJoueur(new Positions(2,22), new Personnages());
        addJoueur(new Positions(2,23), new Personnages());
        addJoueur(new Positions(3,22), new Personnages());
        addJoueur(new Positions(3,23), new Personnages());

        addLoot(new Positions(2, 5), new EpeeLongue());
        addLoot(new Positions(1, 24), new ArbaleteLegere());
        addLoot(new Positions(22, 2), new ArmureEcaille());
        addLoot(new Positions(21, 13), new DemiPlate());

        addEnnemi(new Positions(2,12), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(2,13), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(21,12), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(21,13), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(11,3), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(11,22), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(6,7), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(6,18), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(17,7), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(17,18), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));

        updateMap();
    }

    public Donjon3(ArrayList<Personnages> personnages) {
        super("Donjon par défaut 3", 25, 25, 0);
        setDesc("Troisième donjon par défaut");

        addObstacle(new Positions(0,1)); addObstacle(new Positions(0,25));
        addObstacle(new Positions(24,1)); addObstacle(new Positions(24,25));
        addObstacle(new Positions(0,2)); addObstacle(new Positions(0,3)); addObstacle(new Positions(0,4));
        addObstacle(new Positions(0,5)); addObstacle(new Positions(0,6)); addObstacle(new Positions(0,7));
        addObstacle(new Positions(0,8)); addObstacle(new Positions(0,9)); addObstacle(new Positions(0,10));
        addObstacle(new Positions(0,11)); addObstacle(new Positions(0,12)); addObstacle(new Positions(0,13));
        addObstacle(new Positions(0,14)); addObstacle(new Positions(0,15)); addObstacle(new Positions(0,16));
        addObstacle(new Positions(0,17)); addObstacle(new Positions(0,18)); addObstacle(new Positions(0,19));
        addObstacle(new Positions(0,20)); addObstacle(new Positions(0,21)); addObstacle(new Positions(0,22));
        addObstacle(new Positions(0,23)); addObstacle(new Positions(0,24));

        addObstacle(new Positions(0, 25));
        addObstacle(new Positions(1, 25));
        addObstacle(new Positions(2, 25));
        addObstacle(new Positions(3, 25));
        addObstacle(new Positions(4, 25));
        addObstacle(new Positions(5, 25));
        addObstacle(new Positions(6, 25));
        addObstacle(new Positions(7, 25));
        addObstacle(new Positions(8, 25));
        addObstacle(new Positions(9, 25));
        addObstacle(new Positions(10, 25));
        addObstacle(new Positions(11, 25));
        addObstacle(new Positions(12, 25));
        addObstacle(new Positions(13, 25));
        addObstacle(new Positions(14, 25));
        addObstacle(new Positions(15, 25));
        addObstacle(new Positions(16, 25));
        addObstacle(new Positions(17, 25));
        addObstacle(new Positions(18, 25));
        addObstacle(new Positions(19, 25));
        addObstacle(new Positions(20, 25));
        addObstacle(new Positions(21, 25));
        addObstacle(new Positions(22, 25));
        addObstacle(new Positions(23, 25));
        addObstacle(new Positions(24, 25));

        addObstacle(new Positions(1,1)); addObstacle(new Positions(2,1)); addObstacle(new Positions(3,1));
        addObstacle(new Positions(4,1)); addObstacle(new Positions(5,1)); addObstacle(new Positions(6,1));
        addObstacle(new Positions(7,1)); addObstacle(new Positions(8,1)); addObstacle(new Positions(9,1));
        addObstacle(new Positions(10,1)); addObstacle(new Positions(11,1)); addObstacle(new Positions(12,1));
        addObstacle(new Positions(13,1)); addObstacle(new Positions(14,1)); addObstacle(new Positions(15,1));
        addObstacle(new Positions(16,1)); addObstacle(new Positions(17,1)); addObstacle(new Positions(18,1));
        addObstacle(new Positions(19,1)); addObstacle(new Positions(20,1)); addObstacle(new Positions(21,1));
        addObstacle(new Positions(22,1)); addObstacle(new Positions(23,1));

        addObstacle(new Positions(1,25)); addObstacle(new Positions(2,25)); addObstacle(new Positions(3,25));
        addObstacle(new Positions(4,25)); addObstacle(new Positions(5,25)); addObstacle(new Positions(6,25));
        addObstacle(new Positions(7,25)); addObstacle(new Positions(8,25)); addObstacle(new Positions(9,25));
        addObstacle(new Positions(10,25)); addObstacle(new Positions(11,25)); addObstacle(new Positions(12,25));
        addObstacle(new Positions(13,25)); addObstacle(new Positions(14,25)); addObstacle(new Positions(15,25));
        addObstacle(new Positions(16,25)); addObstacle(new Positions(17,25)); addObstacle(new Positions(18,25));
        addObstacle(new Positions(19,25)); addObstacle(new Positions(20,25)); addObstacle(new Positions(21,25));
        addObstacle(new Positions(22,25)); addObstacle(new Positions(23,25));

        addObstacle(new Positions(9,10)); addObstacle(new Positions(10,10)); addObstacle(new Positions(11,10));
        addObstacle(new Positions(12,10)); addObstacle(new Positions(13,10)); addObstacle(new Positions(14,10));
        addObstacle(new Positions(9,11)); addObstacle(new Positions(10,11)); addObstacle(new Positions(11,11));
        addObstacle(new Positions(12,11)); addObstacle(new Positions(13,11)); addObstacle(new Positions(14,11));
        addObstacle(new Positions(9,12)); addObstacle(new Positions(10,12)); addObstacle(new Positions(11,12));
        addObstacle(new Positions(12,12)); addObstacle(new Positions(13,12)); addObstacle(new Positions(14,12));
        addObstacle(new Positions(9,13)); addObstacle(new Positions(10,13)); addObstacle(new Positions(11,13));
        addObstacle(new Positions(12,13)); addObstacle(new Positions(13,13)); addObstacle(new Positions(14,13));
        addObstacle(new Positions(9,14)); addObstacle(new Positions(10,14)); addObstacle(new Positions(11,14));
        addObstacle(new Positions(12,14)); addObstacle(new Positions(13,14)); addObstacle(new Positions(14,14));

        addObstacle(new Positions(4,5)); addObstacle(new Positions(5,5)); addObstacle(new Positions(4,6)); addObstacle(new Positions(5,6));
        addObstacle(new Positions(4,19)); addObstacle(new Positions(5,19)); addObstacle(new Positions(4,20)); addObstacle(new Positions(5,20));
        addObstacle(new Positions(18,5)); addObstacle(new Positions(19,5)); addObstacle(new Positions(18,6)); addObstacle(new Positions(19,6));
        addObstacle(new Positions(18,19)); addObstacle(new Positions(19,19)); addObstacle(new Positions(18,20)); addObstacle(new Positions(19,20));

        ArrayList<Positions> posJoueurs= new ArrayList<>();
        posJoueurs.add(new Positions(2, 3));
        posJoueurs.add(new Positions(2, 4));
        posJoueurs.add(new Positions(3, 3));
        posJoueurs.add(new Positions(3, 4));
        posJoueurs.add(new Positions(2, 22));
        posJoueurs.add(new Positions(2, 23));
        posJoueurs.add(new Positions(3, 22));
        posJoueurs.add(new Positions(3, 23));
        posJoueurs.add(new Positions(4, 3));
        posJoueurs.add(new Positions(4, 23));


        int i=0;
        for (Personnages p:personnages) {
            addJoueur(posJoueurs.get(i), p);
            i++;
        }

        addLoot(new Positions(2, 5), new EpeeLongue());
        addLoot(new Positions(1, 24), new ArbaleteLegere());
        addLoot(new Positions(22, 2), new ArmureEcaille());
        addLoot(new Positions(21, 13), new DemiPlate());

        addEnnemi(new Positions(2,12), new Monstres("Serpent de feu", 1,"~1~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(2,13), new Monstres("Serpent de feu", 2,"~2~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(21,12), new Monstres("Serpent de feu", 3,"~3~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(21,13), new Monstres("Serpent de feu", 4,"~4~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(11,3), new Monstres("Serpent de feu", 5,"~5~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(11,22), new Monstres("Serpent de feu", 6,"~6~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(6,7), new Monstres("Serpent de feu", 7,"~7~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(6,18), new Monstres("Serpent de feu", 8,"~8~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(17,7), new Monstres("Serpent de feu", 9,"~9~", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));
        addEnnemi(new Positions(17,18), new Monstres("Serpent de feu", 10,"~10", new Attaques("Brûlure",1,new Dice(8),1), 12, 12, 0, 10, 6, 16));

        updateMap();
    }
}
