package donjons;

import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import entites.personnages.equipements.armes.deGuerre.EpeeLongue;
import entites.personnages.equipements.armes.distance.ArbaleteLegere;
import entites.personnages.equipements.armures.legeres.ArmureEcaille;
import entites.personnages.equipements.armures.legeres.DemiPlate;

public class Donjon2 extends Donjons {

    public Donjon2() {
        super("Donjon par défaut 2", 25, 25, 0);
        setDesc("Deuxième donjon par défaut");

        addObstacle(new Positions(0, 1));
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
        addObstacle(new Positions(0, 25));

        addObstacle(new Positions(24, 1));
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
        addObstacle(new Positions(24, 25));

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

        addObstacle(new Positions(9, 10)); addObstacle(new Positions(10, 10)); addObstacle(new Positions(11, 10));
        addObstacle(new Positions(12, 10)); addObstacle(new Positions(13, 10)); addObstacle(new Positions(14, 10));
        addObstacle(new Positions(15, 10));
        addObstacle(new Positions(9, 11)); addObstacle(new Positions(10, 11)); addObstacle(new Positions(11, 11));
        addObstacle(new Positions(12, 11)); addObstacle(new Positions(13, 11)); addObstacle(new Positions(14, 11));
        addObstacle(new Positions(15, 11));
        addObstacle(new Positions(9, 12)); addObstacle(new Positions(10, 12)); addObstacle(new Positions(11, 12));
        addObstacle(new Positions(12, 12)); addObstacle(new Positions(13, 12)); addObstacle(new Positions(14, 12));
        addObstacle(new Positions(15, 12));
        addObstacle(new Positions(9, 13)); addObstacle(new Positions(10, 13)); addObstacle(new Positions(11, 13));
        addObstacle(new Positions(12, 13)); addObstacle(new Positions(13, 13)); addObstacle(new Positions(14, 13));
        addObstacle(new Positions(15, 13));
        addObstacle(new Positions(9, 14)); addObstacle(new Positions(10, 14)); addObstacle(new Positions(11, 14));
        addObstacle(new Positions(12, 14)); addObstacle(new Positions(13, 14)); addObstacle(new Positions(14, 14));
        addObstacle(new Positions(15, 14));
        addObstacle(new Positions(9, 15)); addObstacle(new Positions(10, 15)); addObstacle(new Positions(11, 15));
        addObstacle(new Positions(12, 15)); addObstacle(new Positions(13, 15)); addObstacle(new Positions(14, 15));
        addObstacle(new Positions(15, 15));
        addObstacle(new Positions(9, 16)); addObstacle(new Positions(10, 16)); addObstacle(new Positions(11, 16));
        addObstacle(new Positions(12, 16)); addObstacle(new Positions(13, 16)); addObstacle(new Positions(14, 16));
        addObstacle(new Positions(15, 16));

        addObstacle(new Positions(12, 2));
        addObstacle(new Positions(12, 3));
        addObstacle(new Positions(12, 4));
        addObstacle(new Positions(12, 5));
        addObstacle(new Positions(12, 6));
        addObstacle(new Positions(12, 7));
        addObstacle(new Positions(12, 8));

        addObstacle(new Positions(2, 3)); addObstacle(new Positions(3, 3)); addObstacle(new Positions(4, 3));
        addObstacle(new Positions(2, 4)); addObstacle(new Positions(3, 4)); addObstacle(new Positions(4, 4));
        addObstacle(new Positions(2, 5)); addObstacle(new Positions(3, 5)); addObstacle(new Positions(4, 5));

        addEnnemi(new Positions(1, 6), new Monstres());
        addEnnemi(new Positions(11, 12), new Monstres());
        addEnnemi(new Positions(19, 20), new Monstres());
        addEnnemi(new Positions(19, 2), new Monstres());
        addEnnemi(new Positions(23, 24), new Monstres());

        addJoueur(new Positions(22, 3), new Personnages());
        addJoueur(new Positions(22, 4), new Personnages());
        addJoueur(new Positions(22, 5), new Personnages());
        addJoueur(new Positions(23, 3), new Personnages());
        addJoueur(new Positions(23, 4), new Personnages());

        addLoot(new Positions(2, 5), new EpeeLongue());
        addLoot(new Positions(1, 24), new ArbaleteLegere());
        addLoot(new Positions(22, 2), new ArmureEcaille());
        addLoot(new Positions(21, 13), new DemiPlate());

        updateMap();
    }
}
