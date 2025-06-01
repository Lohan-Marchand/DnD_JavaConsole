package entites.personnages.sorts;

import donjons.Donjons;
import entites.Entites;
import entites.personnages.Personnages;
import utilities.Create;

import java.util.HashMap;

public class BoogieWoogie extends Sorts{
    public BoogieWoogie() {
        super("Boogie Woogie", "Echange la position de deux entités dans le donjon.");
    }

    public void lancerSort(Donjons donjons, Personnages cible1, Personnages cible2) {
        donjons.echangerPositionsEntites(cible1, cible2);
        System.out.println(cible1.getPseudo() + " a échangé sa position avec " + cible2.getPseudo() + ".");
    }
    @Override
    public boolean lancerSort(Donjons donjons){
        //choix1
        String choix1 ="De quel Personnage/Monstres voulez-vous échanger la place ?\n";
        Entites entiteSelectionne1 =null;
        int i=1;
        HashMap<Integer, Entites> entites1 = new HashMap<>();
        for(Entites e : donjons.getOrdre()){
            choix1 +=i+"-"+e.getMatricule()+"\n";
            entites1.put(i,e);
            i++;
        }
        choix1 +=i+"-retour\n";

        int numchoix1 = Create.selectNombre(choix1,1,i);
        if(numchoix1 <i){
            entiteSelectionne1 = entites1.get(numchoix1);
        }
        else if(numchoix1 ==i){
            return false;
        }
        if(entiteSelectionne1 == null){
            System.out.println("Erreur l'entité1 est null");
            return false;
        }

        //choix2
        String choix2 ="Avec quel Personnage/Monstres voulez-vous échanger la place de "+entiteSelectionne1.getMatricule()+" ?\n";
        Entites entiteSelectionne2 =null;
        int j =1;
        HashMap<Integer, Entites> entites2 = new HashMap<>();
        for(Entites e : donjons.getOrdre()){
            choix2 += j +"-"+e.getMatricule()+"\n";
            entites2.put(j,e);
            j++;
        }
        choix2 += j +"-retour\n";

        int numchoix2 = Create.selectNombre(choix2,1, j);
        if(numchoix2 < j){
            entiteSelectionne2 = entites2.get(numchoix2);
        }
        else if(numchoix2 == j){
            return lancerSort(donjons);
        }
        if(entiteSelectionne1 == entiteSelectionne2){
            System.out.println("Erreur les deux entités sont identiques");
            return false;
        }
        if(entiteSelectionne2 == null){
            System.out.println("Erreur l'entité2 est null");
            return false;
        }
        if(!Create.yesNoQuestion("Voulez-vous vraiment échanger de place " + entiteSelectionne1.getMatricule() + " de " + entiteSelectionne2.getMatricule() + " ? (y/n)")){
            return false;
        }
        donjons.echangerPositionsEntites(entiteSelectionne1, entiteSelectionne2);
        System.out.println(entiteSelectionne1.getPseudo() + " a échangé sa position avec " + entiteSelectionne2.getPseudo() + ".");
        return true;
    }
}
