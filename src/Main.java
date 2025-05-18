import donjons.Donjon1;
import donjons.Donjon2;
import donjons.Donjon3;
import donjons.Donjons;
import entites.personnages.Personnages;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static String titre(){
        return(
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

    public static String gameOver(){
        return( "                                                                                                                                                                            \n" +
                "        GGGGGGGGGGGGG                                                                        OOOOOOOOO                                                                      \n" +
                "     GGG::::::::::::G                                                                      OO:::::::::OO                                                                    \n" +
                "   GG:::::::::::::::G                                                                    OO:::::::::::::OO                                                                  \n" +
                "  G:::::GGGGGGGG::::G                                                                   O:::::::OOO:::::::O                                                                 \n" +
                " G:::::G       GGGGGG  aaaaaaaaaaaaa      mmmmmmm    mmmmmmm       eeeeeeeeeeee         O::::::O   O::::::Ovvvvvvv           vvvvvvv    eeeeeeeeeeee    rrrrr   rrrrrrrrr   \n" +
                "G:::::G                a::::::::::::a   mm:::::::m  m:::::::mm   ee::::::::::::ee       O:::::O     O:::::O v:::::v         v:::::v   ee::::::::::::ee  r::::rrr:::::::::r  \n" +
                "G:::::G                aaaaaaaaa:::::a m::::::::::mm::::::::::m e::::::eeeee:::::ee     O:::::O     O:::::O  v:::::v       v:::::v   e::::::eeeee:::::eer:::::::::::::::::r \n" +
                "G:::::G    GGGGGGGGGG           a::::a m::::::::::::::::::::::me::::::e     e:::::e     O:::::O     O:::::O   v:::::v     v:::::v   e::::::e     e:::::err::::::rrrrr::::::r\n" +
                "G:::::G    G::::::::G    aaaaaaa:::::a m:::::mmm::::::mmm:::::me:::::::eeeee::::::e     O:::::O     O:::::O    v:::::v   v:::::v    e:::::::eeeee::::::e r:::::r     r:::::r\n" +
                "G:::::G    GGGGG::::G  aa::::::::::::a m::::m   m::::m   m::::me:::::::::::::::::e      O:::::O     O:::::O     v:::::v v:::::v     e:::::::::::::::::e  r:::::r     rrrrrrr\n" +
                "G:::::G        G::::G a::::aaaa::::::a m::::m   m::::m   m::::me::::::eeeeeeeeeee       O:::::O     O:::::O      v:::::v:::::v      e::::::eeeeeeeeeee   r:::::r            \n" +
                " G:::::G       G::::Ga::::a    a:::::a m::::m   m::::m   m::::me:::::::e                O::::::O   O::::::O       v:::::::::v       e:::::::e            r:::::r            \n" +
                "  G:::::GGGGGGGG::::Ga::::a    a:::::a m::::m   m::::m   m::::me::::::::e               O:::::::OOO:::::::O        v:::::::v        e::::::::e           r:::::r            \n" +
                "   GG:::::::::::::::Ga:::::aaaa::::::a m::::m   m::::m   m::::m e::::::::eeeeeeee        OO:::::::::::::OO          v:::::v          e::::::::eeeeeeee   r:::::r            \n" +
                "     GGG::::::GGG:::G a::::::::::aa:::am::::m   m::::m   m::::m  ee:::::::::::::e          OO:::::::::OO             v:::v            ee:::::::::::::e   r:::::r            \n" +
                "        GGGGGG   GGGG  aaaaaaaaaa  aaaammmmmm   mmmmmm   mmmmmm    eeeeeeeeeeeeee            OOOOOOOOO                vvv               eeeeeeeeeeeeee   rrrrrrr            \n");
    }

    public static String donjon(int nbDonjon){
        switch (nbDonjon){
            case 1:
                return  "                                                                                                                              \n" +
                        "DDDDDDDDDDDDD                                                        jjjj                                           1111111   \n" +
                        "D::::::::::::DDD                                                    j::::j                                         1::::::1   \n" +
                        "D:::::::::::::::DD                                                   jjjj                                         1:::::::1   \n" +
                        "DDD:::::DDDDD:::::D                                                                                               111:::::1   \n" +
                        "  D:::::D    D:::::D    ooooooooooo   nnnn  nnnnnnnn               jjjjjjj   ooooooooooo   nnnn  nnnnnnnn            1::::1   \n" +
                        "  D:::::D     D:::::D oo:::::::::::oo n:::nn::::::::nn             j:::::j oo:::::::::::oo n:::nn::::::::nn          1::::1   \n" +
                        "  D:::::D     D:::::Do:::::::::::::::on::::::::::::::nn             j::::jo:::::::::::::::on::::::::::::::nn         1::::1   \n" +
                        "  D:::::D     D:::::Do:::::ooooo:::::onn:::::::::::::::n            j::::jo:::::ooooo:::::onn:::::::::::::::n        1::::l   \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n:::::nnnn:::::n            j::::jo::::o     o::::o  n:::::nnnn:::::n        1::::l   \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n        1::::l   \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n        1::::l   \n" +
                        "  D:::::D    D:::::D o::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n        1::::l   \n" +
                        "DDD:::::DDDDD:::::D  o:::::ooooo:::::o  n::::n    n::::n            j::::jo:::::ooooo:::::o  n::::n    n::::n     111::::::111\n" +
                        "D:::::::::::::::DD   o:::::::::::::::o  n::::n    n::::n            j::::jo:::::::::::::::o  n::::n    n::::n     1::::::::::1\n" +
                        "D::::::::::::DDD      oo:::::::::::oo   n::::n    n::::n            j::::j oo:::::::::::oo   n::::n    n::::n     1::::::::::1\n" +
                        "DDDDDDDDDDDDD           ooooooooooo     nnnnnn    nnnnnn            j::::j   ooooooooooo     nnnnnn    nnnnnn     111111111111\n" +
                        "                                                                    j::::j                                                    \n" +
                        "                                                          jjjj      j::::j                                                    \n" +
                        "                                                         j::::jj   j:::::j                                                    \n" +
                        "                                                         j::::::jjj::::::j                                                    \n" +
                        "                                                          jj::::::::::::j                                                     \n" +
                        "                                                            jjj::::::jjj                                                      \n" +
                        "                                                               jjjjjj                                                         \n" +
                        "\n";
            case 2:
                return  "                                                                                                                                      \n" +
                        "                                                                                                                                      \n" +
                        "DDDDDDDDDDDDD                                                        jjjj                                          222222222222222    \n" +
                        "D::::::::::::DDD                                                    j::::j                                        2:::::::::::::::22  \n" +
                        "D:::::::::::::::DD                                                   jjjj                                         2::::::222222:::::2 \n" +
                        "DDD:::::DDDDD:::::D                                                                                               2222222     2:::::2 \n" +
                        "  D:::::D    D:::::D    ooooooooooo   nnnn  nnnnnnnn               jjjjjjj   ooooooooooo   nnnn  nnnnnnnn                     2:::::2 \n" +
                        "  D:::::D     D:::::D oo:::::::::::oo n:::nn::::::::nn             j:::::j oo:::::::::::oo n:::nn::::::::nn                   2:::::2 \n" +
                        "  D:::::D     D:::::Do:::::::::::::::on::::::::::::::nn             j::::jo:::::::::::::::on::::::::::::::nn               2222::::2  \n" +
                        "  D:::::D     D:::::Do:::::ooooo:::::onn:::::::::::::::n            j::::jo:::::ooooo:::::onn:::::::::::::::n         22222::::::22   \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n:::::nnnn:::::n            j::::jo::::o     o::::o  n:::::nnnn:::::n       22::::::::222     \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n      2:::::22222        \n" +
                        "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n     2:::::2             \n" +
                        "  D:::::D    D:::::D o::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n     2:::::2             \n" +
                        "DDD:::::DDDDD:::::D  o:::::ooooo:::::o  n::::n    n::::n            j::::jo:::::ooooo:::::o  n::::n    n::::n     2:::::2       222222\n" +
                        "D:::::::::::::::DD   o:::::::::::::::o  n::::n    n::::n            j::::jo:::::::::::::::o  n::::n    n::::n     2::::::2222222:::::2\n" +
                        "D::::::::::::DDD      oo:::::::::::oo   n::::n    n::::n            j::::j oo:::::::::::oo   n::::n    n::::n     2::::::::::::::::::2\n" +
                        "DDDDDDDDDDDDD           ooooooooooo     nnnnnn    nnnnnn            j::::j   ooooooooooo     nnnnnn    nnnnnn     22222222222222222222\n" +
                        "                                                                    j::::j                                                            \n" +
                        "                                                          jjjj      j::::j                                                            \n" +
                        "                                                         j::::jj   j:::::j                                                            \n" +
                        "                                                         j::::::jjj::::::j                                                            \n" +
                        "                                                          jj::::::::::::j                                                             \n" +
                        "                                                            jjj::::::jjj                                                              \n" +
                        "                                                               jjjjjj                                                                 \n" +
                        "\n";
            case 3:
                    return  "                                                                                                                                     \n" +
                            "DDDDDDDDDDDDD                                                        jjjj                                          333333333333333   \n" +
                            "D::::::::::::DDD                                                    j::::j                                        3:::::::::::::::33 \n" +
                            "D:::::::::::::::DD                                                   jjjj                                         3::::::33333::::::3\n" +
                            "DDD:::::DDDDD:::::D                                                                                               3333333     3:::::3\n" +
                            "  D:::::D    D:::::D    ooooooooooo   nnnn  nnnnnnnn               jjjjjjj   ooooooooooo   nnnn  nnnnnnnn                     3:::::3\n" +
                            "  D:::::D     D:::::D oo:::::::::::oo n:::nn::::::::nn             j:::::j oo:::::::::::oo n:::nn::::::::nn                   3:::::3\n" +
                            "  D:::::D     D:::::Do:::::::::::::::on::::::::::::::nn             j::::jo:::::::::::::::on::::::::::::::nn          33333333:::::3 \n" +
                            "  D:::::D     D:::::Do:::::ooooo:::::onn:::::::::::::::n            j::::jo:::::ooooo:::::onn:::::::::::::::n         3:::::::::::3  \n" +
                            "  D:::::D     D:::::Do::::o     o::::o  n:::::nnnn:::::n            j::::jo::::o     o::::o  n:::::nnnn:::::n         33333333:::::3 \n" +
                            "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n                 3:::::3\n" +
                            "  D:::::D     D:::::Do::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n                 3:::::3\n" +
                            "  D:::::D    D:::::D o::::o     o::::o  n::::n    n::::n            j::::jo::::o     o::::o  n::::n    n::::n                 3:::::3\n" +
                            "DDD:::::DDDDD:::::D  o:::::ooooo:::::o  n::::n    n::::n            j::::jo:::::ooooo:::::o  n::::n    n::::n     3333333     3:::::3\n" +
                            "D:::::::::::::::DD   o:::::::::::::::o  n::::n    n::::n            j::::jo:::::::::::::::o  n::::n    n::::n     3::::::33333::::::3\n" +
                            "D::::::::::::DDD      oo:::::::::::oo   n::::n    n::::n            j::::j oo:::::::::::oo   n::::n    n::::n     3:::::::::::::::33 \n" +
                            "DDDDDDDDDDDDD           ooooooooooo     nnnnnn    nnnnnn            j::::j   ooooooooooo     nnnnnn    nnnnnn      333333333333333   \n" +
                            "                                                                    j::::j                                                           \n" +
                            "                                                          jjjj      j::::j                                                           \n" +
                            "                                                         j::::jj   j:::::j                                                           \n" +
                            "                                                         j::::::jjj::::::j                                                           \n" +
                            "                                                          jj::::::::::::j                                                            \n" +
                            "                                                            jjj::::::jjj                                                             \n" +
                            "                                                               jjjjjj                                                                \n" +
                            "\n";
        }
        return null;
    }

    public static void main(String args[]) {
        final int continuDonjon=-1;
        final int reussiDonjon=0;
        final int echecDonjon=1;
        System.out.println(titre());        //Début du jeu
        ArrayList<Personnages> Joueurs= Create.creerPartie();    //Création des personnages
        for(int i=1; i<4; i++){
            Donjons donjon= Create.creerDonjon(Joueurs,i);
            System.out.println( donjon(i)+donjon.getDesc());
            donjon.afficherMap();
            Create.debutDonjon(donjon);
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
                System.out.println("____________________________________________________________________\n\t\tL'un des membres de l'équipe est mort.\n\t\t\t\tVous avez échoué!!!"+ gameOver() +"\n____________________________________________________________________");
            } else if (enCours==reussiDonjon) {
                if(i==3){

                    System.out.println("____________________________________________________________________\n\t\tTous les monstres du donjon ont été éliminés\n____________________________________________________________________");
                    System.out.println("_______________________________________________________________\n\t\tVous avez terminé la partie\n\t\t\t\tMerci d'avoir joué à"+ titre() +"\n____________________________________________________________________");
                    //On n'afficherait pas le titre du jeu comme au début ou un autre truc du genre pour que ce soit bien visible ?
                }
                else{
                    System.out.println("____________________________________________________________________\n\t\tTous les monstres du donjon ont été éliminés\n\t\t\t\tVous atteignez le donjon suivant\n____________________________________________________________________");
                }
            }

        }
    }
}