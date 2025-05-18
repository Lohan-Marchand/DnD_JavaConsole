package donjons;

import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.legeres.DemiPlate;

import java.util.ArrayList;

public class Donjon1 extends Donjons {

    public Donjon1() {
        super("Donjon par défaut", 25, 25, 0);
        setDesc("Premier donjon par défaut");

        addObstacle(new Positions(0, 1));
        addObstacle(new Positions(1, 1));
        addObstacle(new Positions(2, 1));
        addObstacle(new Positions(3, 1));
        addObstacle(new Positions(4, 1));
        addObstacle(new Positions(5, 1));
        addObstacle(new Positions(6, 1));
        addObstacle(new Positions(7, 1));
        addObstacle(new Positions(8, 1));
        addObstacle(new Positions(9, 1));
        addObstacle(new Positions(10, 1));
        addObstacle(new Positions(11, 1));
        addObstacle(new Positions(12, 1));
        addObstacle(new Positions(13, 1));
        addObstacle(new Positions(14, 1));
        addObstacle(new Positions(15, 1));
        addObstacle(new Positions(16, 1));
        addObstacle(new Positions(17, 1));
        addObstacle(new Positions(18, 1));
        addObstacle(new Positions(19, 1));
        addObstacle(new Positions(20, 1));
        addObstacle(new Positions(21, 1));
        addObstacle(new Positions(22, 1));
        addObstacle(new Positions(23, 1));
        addObstacle(new Positions(24, 1));

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

        addObstacle(new Positions(0, 2));
        addObstacle(new Positions(0, 3));
        addObstacle(new Positions(0, 4));
        addObstacle(new Positions(0, 5));
        addObstacle(new Positions(0, 6));
        addObstacle(new Positions(0, 7));
        addObstacle(new Positions(0, 8));
        addObstacle(new Positions(0, 9));
        addObstacle(new Positions(0, 10));
        addObstacle(new Positions(0, 11));
        addObstacle(new Positions(0, 12));
        addObstacle(new Positions(0, 13));
        addObstacle(new Positions(0, 14));
        addObstacle(new Positions(0, 15));
        addObstacle(new Positions(0, 16));
        addObstacle(new Positions(0, 17));
        addObstacle(new Positions(0, 18));
        addObstacle(new Positions(0, 19));
        addObstacle(new Positions(0, 20));
        addObstacle(new Positions(0, 21));
        addObstacle(new Positions(0, 22));
        addObstacle(new Positions(0, 23));
        addObstacle(new Positions(0, 24));

        addObstacle(new Positions(24, 2));
        addObstacle(new Positions(24, 3));
        addObstacle(new Positions(24, 4));
        addObstacle(new Positions(24, 5));
        addObstacle(new Positions(24, 6));
        addObstacle(new Positions(24, 7));
        addObstacle(new Positions(24, 8));
        addObstacle(new Positions(24, 9));
        addObstacle(new Positions(24, 10));
        addObstacle(new Positions(24, 11));
        addObstacle(new Positions(24, 12));
        addObstacle(new Positions(24, 13));
        addObstacle(new Positions(24, 14));
        addObstacle(new Positions(24, 15));
        addObstacle(new Positions(24, 16));
        addObstacle(new Positions(24, 17));
        addObstacle(new Positions(24, 18));
        addObstacle(new Positions(24, 19));
        addObstacle(new Positions(24, 20));
        addObstacle(new Positions(24, 21));
        addObstacle(new Positions(24, 22));
        addObstacle(new Positions(24, 23));
        addObstacle(new Positions(24, 24));

        addObstacle(new Positions(1, 3));
        addObstacle(new Positions(1, 4));
        addObstacle(new Positions(1, 23));
        addObstacle(new Positions(2, 23));
        addObstacle(new Positions(3, 23));
        addObstacle(new Positions(4, 23));
        addObstacle(new Positions(5, 23));
        addObstacle(new Positions(6, 23));
        addObstacle(new Positions(2, 11));
        addObstacle(new Positions(2, 12));
        addObstacle(new Positions(2, 13));
        addObstacle(new Positions(2, 14));

        addObstacle(new Positions(8, 4)); addObstacle(new Positions(8, 5)); addObstacle(new Positions(8, 6)); addObstacle(new Positions(8, 7)); addObstacle(new Positions(8, 8));
        addObstacle(new Positions(9, 4)); addObstacle(new Positions(9, 5)); addObstacle(new Positions(9, 6)); addObstacle(new Positions(9, 7)); addObstacle(new Positions(9, 8));
        addObstacle(new Positions(10, 4)); addObstacle(new Positions(10, 5)); addObstacle(new Positions(10, 6)); addObstacle(new Positions(10, 7)); addObstacle(new Positions(10, 8));
        addObstacle(new Positions(11, 4)); addObstacle(new Positions(11, 5)); addObstacle(new Positions(11, 6)); addObstacle(new Positions(11, 7)); addObstacle(new Positions(11, 8));
        addObstacle(new Positions(12, 4)); addObstacle(new Positions(12, 5)); addObstacle(new Positions(12, 6)); addObstacle(new Positions(12, 7)); addObstacle(new Positions(12, 8));
        addObstacle(new Positions(13, 4)); addObstacle(new Positions(13, 5)); addObstacle(new Positions(13, 6)); addObstacle(new Positions(13, 7)); addObstacle(new Positions(13, 8));

        addObstacle(new Positions(7, 10)); addObstacle(new Positions(7, 11)); addObstacle(new Positions(7, 12)); addObstacle(new Positions(7, 13)); addObstacle(new Positions(7, 14)); addObstacle(new Positions(7, 15)); addObstacle(new Positions(7, 16));
        addObstacle(new Positions(8, 10)); addObstacle(new Positions(8, 11)); addObstacle(new Positions(8, 12)); addObstacle(new Positions(8, 13)); addObstacle(new Positions(8, 14)); addObstacle(new Positions(8, 15)); addObstacle(new Positions(8, 16));
        addObstacle(new Positions(9, 10)); addObstacle(new Positions(9, 11)); addObstacle(new Positions(9, 12)); addObstacle(new Positions(9, 13)); addObstacle(new Positions(9, 14)); addObstacle(new Positions(9, 15)); addObstacle(new Positions(9, 16));
        addObstacle(new Positions(10, 10)); addObstacle(new Positions(10, 11)); addObstacle(new Positions(10, 12)); addObstacle(new Positions(10, 13)); addObstacle(new Positions(10, 14)); addObstacle(new Positions(10, 15)); addObstacle(new Positions(10, 16));
        addObstacle(new Positions(11, 10)); addObstacle(new Positions(11, 11)); addObstacle(new Positions(11, 12)); addObstacle(new Positions(11, 13)); addObstacle(new Positions(11, 14)); addObstacle(new Positions(11, 15)); addObstacle(new Positions(11, 16));

        addObstacle(new Positions(12, 19)); addObstacle(new Positions(12, 20));
        addObstacle(new Positions(13, 19)); addObstacle(new Positions(13, 20));
        addObstacle(new Positions(14, 19)); addObstacle(new Positions(14, 20));

        addObstacle(new Positions(15, 16)); addObstacle(new Positions(15, 17));
        addObstacle(new Positions(16, 16)); addObstacle(new Positions(16, 17));
        addObstacle(new Positions(17, 16)); addObstacle(new Positions(17, 17));
        addObstacle(new Positions(18, 16)); addObstacle(new Positions(18, 17));
        addObstacle(new Positions(19, 16)); addObstacle(new Positions(19, 17));

        addObstacle(new Positions(15, 8)); addObstacle(new Positions(15, 9)); addObstacle(new Positions(15, 10));
        addObstacle(new Positions(16, 8)); addObstacle(new Positions(16, 9)); addObstacle(new Positions(16, 10));
        addObstacle(new Positions(17, 8)); addObstacle(new Positions(17, 9)); addObstacle(new Positions(17, 10));
        addObstacle(new Positions(18, 8)); addObstacle(new Positions(18, 9)); addObstacle(new Positions(18, 10));
        addObstacle(new Positions(19, 8)); addObstacle(new Positions(19, 9)); addObstacle(new Positions(19, 10));

        addJoueur(new Positions(10, 24), new Personnages());
        addJoueur(new Positions(11, 24), new Personnages());
        addJoueur(new Positions(12, 24), new Personnages());
        addJoueur(new Positions(13, 24), new Personnages());
        addJoueur(new Positions(14, 24), new Personnages());
        addJoueur(new Positions(10, 25), new Personnages());
        addJoueur(new Positions(11, 25), new Personnages());
        addJoueur(new Positions(12, 25), new Personnages());
        addJoueur(new Positions(13, 25), new Personnages());
        addJoueur(new Positions(14, 25), new Personnages());

        addLoot(new Positions(4, 3), new EpeeLongue());
        addLoot(new Positions(23, 2), new ArbaleteLegere());
        addLoot(new Positions(1, 23), new ArmureEcaille());
        addLoot(new Positions(12, 22), new DemiPlate());

        addEnnemi(new Positions(1, 2), new Monstres());
        addEnnemi(new Positions(16, 2), new Monstres());
        addEnnemi(new Positions(17, 18), new Monstres());
        addEnnemi(new Positions(21, 18), new Monstres());
        addEnnemi(new Positions(1, 24), new Monstres());

        updateMap();
    }

    public Donjon1(ArrayList<Personnages> personnages) {
        super("Donjon par défaut", 25, 25, 0);
        setDesc("Premier donjon par défaut");

        addObstacle(new Positions(0, 1));
        addObstacle(new Positions(1, 1));
        addObstacle(new Positions(2, 1));
        addObstacle(new Positions(3, 1));
        addObstacle(new Positions(4, 1));
        addObstacle(new Positions(5, 1));
        addObstacle(new Positions(6, 1));
        addObstacle(new Positions(7, 1));
        addObstacle(new Positions(8, 1));
        addObstacle(new Positions(9, 1));
        addObstacle(new Positions(10, 1));
        addObstacle(new Positions(11, 1));
        addObstacle(new Positions(12, 1));
        addObstacle(new Positions(13, 1));
        addObstacle(new Positions(14, 1));
        addObstacle(new Positions(15, 1));
        addObstacle(new Positions(16, 1));
        addObstacle(new Positions(17, 1));
        addObstacle(new Positions(18, 1));
        addObstacle(new Positions(19, 1));
        addObstacle(new Positions(20, 1));
        addObstacle(new Positions(21, 1));
        addObstacle(new Positions(22, 1));
        addObstacle(new Positions(23, 1));
        addObstacle(new Positions(24, 1));

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

        addObstacle(new Positions(0, 2));
        addObstacle(new Positions(0, 3));
        addObstacle(new Positions(0, 4));
        addObstacle(new Positions(0, 5));
        addObstacle(new Positions(0, 6));
        addObstacle(new Positions(0, 7));
        addObstacle(new Positions(0, 8));
        addObstacle(new Positions(0, 9));
        addObstacle(new Positions(0, 10));
        addObstacle(new Positions(0, 11));
        addObstacle(new Positions(0, 12));
        addObstacle(new Positions(0, 13));
        addObstacle(new Positions(0, 14));
        addObstacle(new Positions(0, 15));
        addObstacle(new Positions(0, 16));
        addObstacle(new Positions(0, 17));
        addObstacle(new Positions(0, 18));
        addObstacle(new Positions(0, 19));
        addObstacle(new Positions(0, 20));
        addObstacle(new Positions(0, 21));
        addObstacle(new Positions(0, 22));
        addObstacle(new Positions(0, 23));
        addObstacle(new Positions(0, 24));

        addObstacle(new Positions(24, 2));
        addObstacle(new Positions(24, 3));
        addObstacle(new Positions(24, 4));
        addObstacle(new Positions(24, 5));
        addObstacle(new Positions(24, 6));
        addObstacle(new Positions(24, 7));
        addObstacle(new Positions(24, 8));
        addObstacle(new Positions(24, 9));
        addObstacle(new Positions(24, 10));
        addObstacle(new Positions(24, 11));
        addObstacle(new Positions(24, 12));
        addObstacle(new Positions(24, 13));
        addObstacle(new Positions(24, 14));
        addObstacle(new Positions(24, 15));
        addObstacle(new Positions(24, 16));
        addObstacle(new Positions(24, 17));
        addObstacle(new Positions(24, 18));
        addObstacle(new Positions(24, 19));
        addObstacle(new Positions(24, 20));
        addObstacle(new Positions(24, 21));
        addObstacle(new Positions(24, 22));
        addObstacle(new Positions(24, 23));
        addObstacle(new Positions(24, 24));

        addObstacle(new Positions(1, 3));
        addObstacle(new Positions(1, 4));
        addObstacle(new Positions(1, 23));
        addObstacle(new Positions(2, 23));
        addObstacle(new Positions(3, 23));
        addObstacle(new Positions(4, 23));
        addObstacle(new Positions(5, 23));
        addObstacle(new Positions(6, 23));
        addObstacle(new Positions(2, 11));
        addObstacle(new Positions(2, 12));
        addObstacle(new Positions(2, 13));
        addObstacle(new Positions(2, 14));

        addObstacle(new Positions(8, 4)); addObstacle(new Positions(8, 5)); addObstacle(new Positions(8, 6)); addObstacle(new Positions(8, 7)); addObstacle(new Positions(8, 8));
        addObstacle(new Positions(9, 4)); addObstacle(new Positions(9, 5)); addObstacle(new Positions(9, 6)); addObstacle(new Positions(9, 7)); addObstacle(new Positions(9, 8));
        addObstacle(new Positions(10, 4)); addObstacle(new Positions(10, 5)); addObstacle(new Positions(10, 6)); addObstacle(new Positions(10, 7)); addObstacle(new Positions(10, 8));
        addObstacle(new Positions(11, 4)); addObstacle(new Positions(11, 5)); addObstacle(new Positions(11, 6)); addObstacle(new Positions(11, 7)); addObstacle(new Positions(11, 8));
        addObstacle(new Positions(12, 4)); addObstacle(new Positions(12, 5)); addObstacle(new Positions(12, 6)); addObstacle(new Positions(12, 7)); addObstacle(new Positions(12, 8));
        addObstacle(new Positions(13, 4)); addObstacle(new Positions(13, 5)); addObstacle(new Positions(13, 6)); addObstacle(new Positions(13, 7)); addObstacle(new Positions(13, 8));

        addObstacle(new Positions(7, 10)); addObstacle(new Positions(7, 11)); addObstacle(new Positions(7, 12)); addObstacle(new Positions(7, 13)); addObstacle(new Positions(7, 14)); addObstacle(new Positions(7, 15)); addObstacle(new Positions(7, 16));
        addObstacle(new Positions(8, 10)); addObstacle(new Positions(8, 11)); addObstacle(new Positions(8, 12)); addObstacle(new Positions(8, 13)); addObstacle(new Positions(8, 14)); addObstacle(new Positions(8, 15)); addObstacle(new Positions(8, 16));
        addObstacle(new Positions(9, 10)); addObstacle(new Positions(9, 11)); addObstacle(new Positions(9, 12)); addObstacle(new Positions(9, 13)); addObstacle(new Positions(9, 14)); addObstacle(new Positions(9, 15)); addObstacle(new Positions(9, 16));
        addObstacle(new Positions(10, 10)); addObstacle(new Positions(10, 11)); addObstacle(new Positions(10, 12)); addObstacle(new Positions(10, 13)); addObstacle(new Positions(10, 14)); addObstacle(new Positions(10, 15)); addObstacle(new Positions(10, 16));
        addObstacle(new Positions(11, 10)); addObstacle(new Positions(11, 11)); addObstacle(new Positions(11, 12)); addObstacle(new Positions(11, 13)); addObstacle(new Positions(11, 14)); addObstacle(new Positions(11, 15)); addObstacle(new Positions(11, 16));

        addObstacle(new Positions(12, 19)); addObstacle(new Positions(12, 20));
        addObstacle(new Positions(13, 19)); addObstacle(new Positions(13, 20));
        addObstacle(new Positions(14, 19)); addObstacle(new Positions(14, 20));

        addObstacle(new Positions(15, 16)); addObstacle(new Positions(15, 17));
        addObstacle(new Positions(16, 16)); addObstacle(new Positions(16, 17));
        addObstacle(new Positions(17, 16)); addObstacle(new Positions(17, 17));
        addObstacle(new Positions(18, 16)); addObstacle(new Positions(18, 17));
        addObstacle(new Positions(19, 16)); addObstacle(new Positions(19, 17));

        addObstacle(new Positions(15, 8)); addObstacle(new Positions(15, 9)); addObstacle(new Positions(15, 10));
        addObstacle(new Positions(16, 8)); addObstacle(new Positions(16, 9)); addObstacle(new Positions(16, 10));
        addObstacle(new Positions(17, 8)); addObstacle(new Positions(17, 9)); addObstacle(new Positions(17, 10));
        addObstacle(new Positions(18, 8)); addObstacle(new Positions(18, 9)); addObstacle(new Positions(18, 10));
        addObstacle(new Positions(19, 8)); addObstacle(new Positions(19, 9)); addObstacle(new Positions(19, 10));

        ArrayList<Positions> posJoueurs= new ArrayList<>();
        posJoueurs.add(new Positions(10, 24));
        posJoueurs.add(new Positions(11, 24));
        posJoueurs.add(new Positions(12, 24));
        posJoueurs.add(new Positions(13, 24));
        posJoueurs.add(new Positions(14, 24));
        posJoueurs.add(new Positions(10, 23));
        posJoueurs.add(new Positions(11, 23));
        posJoueurs.add(new Positions(12, 23));
        posJoueurs.add(new Positions(13, 23));
        posJoueurs.add(new Positions(14, 23));


        int i=0;
        for (Personnages p:personnages) {
            addJoueur(posJoueurs.get(i), p);
            i++;
        }

        addLoot(new Positions(4, 3), new EpeeLongue());
        addLoot(new Positions(23, 2), new ArbaleteLegere());
        addLoot(new Positions(1, 23), new ArmureEcaille());
        addLoot(new Positions(12, 22), new DemiPlate());

        addEnnemi(new Positions(1, 2), new Monstres());
        addEnnemi(new Positions(16, 2), new Monstres());
        addEnnemi(new Positions(17, 18), new Monstres());
        addEnnemi(new Positions(21, 18), new Monstres());
        addEnnemi(new Positions(1, 24), new Monstres());

        updateMap();
    }
}
