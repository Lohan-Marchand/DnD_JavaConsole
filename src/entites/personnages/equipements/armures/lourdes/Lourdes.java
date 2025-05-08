package entites.personnages.equipements.armures.lourdes;

import entites.personnages.equipements.armures.Armures;

public abstract class Lourdes extends Armures {
    public Lourdes(String nom, int CA) {
        super(nom,CA,4);
    }
    public Lourdes(String nom) {
        super(nom,10,4);
    }
    public Lourdes() {
        super("Armure sans nom",10,4);
    }
    public Lourdes(int CA) {
        super("Armure sans nom",CA,4);
    }
}
