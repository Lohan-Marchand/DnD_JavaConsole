package donjons;
import entites.Entites;
import entites.monstres.Monstres;
import entites.personnages.Personnages;
import entites.personnages.equipements.Equipements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Donjons{
    private int m_num;
    private String m_nom;
    private String m_desc;
    private int m_hauteur;
    private int m_largeur;
    private Map<Positions, Personnages> m_joueurs;
    private Map<Positions, Monstres> m_ennemis;
    private Map<Positions, Equipements> m_loot;
    private ArrayList<Positions> m_obstacles;
    public String[] m_map;
    private Map<Entites, Integer> m_initiatives;
    private ArrayList<Entites> m_ordre;

    public Donjons(){
        m_num = 1;
        m_nom = "Donjon sans nom";
        m_desc = "Description vide";
        m_hauteur = 20;
        m_largeur = 20;
        m_joueurs = new HashMap<Positions, Personnages>();
        m_ennemis = new HashMap<Positions, Monstres>();
        m_loot = new HashMap<Positions, Equipements>();
        m_obstacles = new ArrayList<Positions>();
        m_initiatives = new HashMap<Entites, Integer>();
        m_ordre = new ArrayList<Entites>();
        m_map = new String[m_hauteur];
        m_map[0] = " . ";
        for(int i = 0; i<m_largeur; i++){
            m_map[0] = m_map[0]+" . ";
        }
        for (int i = 1; i<m_hauteur; i++){
            m_map[i] = m_map[0];
        }

    }
    public Donjons(String nom, int hauteur, int largeur,int num){
        m_num = num;
        m_nom = nom;
        m_desc = "Description vide";
        m_hauteur = hauteur;
        m_largeur = largeur;
        m_joueurs = new HashMap<Positions, Personnages>();
        m_ennemis = new HashMap<Positions, Monstres>();
        m_loot = new HashMap<Positions, Equipements>();
        m_obstacles = new ArrayList<Positions>();
        m_initiatives = new HashMap<Entites, Integer>();
        m_ordre = new ArrayList<Entites>();

        m_map = new String[m_hauteur];
        m_map[0] = "";   //Lohan: j'ai enlevé le " . "
        for(int i = 0; i<m_largeur; i++){
            m_map[0] = m_map[0]+" . ";
        }
        for (int i = 1; i<m_hauteur; i++){
            m_map[i] = m_map[0];
        }
    }

    public Donjons(int num, String nom, String desc, int haut, int larg, Map<Positions, Equipements> loot, ArrayList<Positions> obstacles, Map<Entites, Integer> initiatives, ArrayList<Entites> ordre){
        m_nom = nom;
        m_desc = desc;
        m_hauteur = haut;
        m_largeur = larg;
        m_joueurs = new HashMap<Positions, Personnages>();
        m_ennemis = new HashMap<Positions, Monstres>();
        m_loot = new HashMap<Positions, Equipements>();
        m_obstacles = new ArrayList<Positions>();
        m_initiatives = new HashMap<Entites, Integer>();
        m_ordre = new ArrayList<Entites>();
        m_loot = loot;
        m_map = new String[m_hauteur];
        m_map[0] = " . ";
        for(int i = 0; i<m_largeur; i++){
            m_map[0] = m_map[0]+" . ";
        }
        for (int i = 1; i<m_hauteur; i++){
            m_map[i] = m_map[0];
        }
        m_obstacles = obstacles;
        m_initiatives = initiatives;
        m_ordre = ordre;
    }
    public void addJoueur(Positions pos, Personnages joueur){
        m_joueurs.put(pos, joueur);
        updateMap();
    }
    public void addJoueur(Personnages joueur){
        m_joueurs.put(new Positions(0,0), joueur);
        updateMap();
    }
    public void moveJoueur(Personnages personnage, Positions pos){
        Positions oldPos = this.getPersonnagePosition(personnage);
        m_joueurs.remove(oldPos, personnage);
        m_joueurs.put(pos, personnage);
        updateMap();
    }
    public void removeJoueur(Positions pos){
        m_joueurs.remove(pos, m_joueurs.get(pos));
        updateMap();
    }
    public void addEnnemi(Positions pos, Monstres ennemi){
        m_ennemis.put(pos, ennemi);
        updateMap();
    }
    public void addEnnemi(Monstres ennemi){
        m_ennemis.put(new Positions(0,0), ennemi);
        updateMap();
    }
    public void moveEnnemi(Monstres ennemi, Positions pos){
        Positions oldPos = this.getEnnemiPosition(ennemi);
        m_ennemis.remove(oldPos, ennemi);
        m_ennemis.put(pos, ennemi);
        updateMap();
    }
    public void removeEnnemi(Positions pos){
        m_ennemis.remove(pos, m_ennemis.get(pos));
        updateMap();
    }
    public void addLoot(Positions pos, Equipements loot){
        m_loot.put(pos, loot);
        updateMap();
    }
    public void addLoot(Equipements loot){
        m_loot.put(new Positions(0,0), loot);
        updateMap();
    }
    public void removeLoot(Positions pos){
        m_loot.remove(pos, m_loot.get(pos));
        updateMap();
    }
    public void addObstacle(Positions pos){
        m_obstacles.add(pos);
        updateMap();
    }
    public void addObstacle(){
        m_obstacles.add(new Positions(0,0));
        updateMap();
    }
    public void removeObstacle(Positions pos){
        m_obstacles.remove(pos);
        updateMap();
    }
    public ArrayList<Entites> calculerOrdre() {
        if (m_initiatives.isEmpty()) {
            return null;
        }
        ArrayList<Entites> ordre = new ArrayList<>(m_initiatives.keySet());
        ordre.sort((a, b) -> Integer.compare(m_initiatives.get(b), m_initiatives.get(a)));
        m_ordre = ordre;
        return ordre;
    }
    public ArrayList<Entites> tourSuivant(){
        Entites entite = m_ordre.getFirst();
        m_ordre.removeFirst();
        m_ordre.add(entite);
        return m_ordre;
    }
    public void afficherTour(){
        afficherMap();
        Entites joueur = m_ordre.getFirst();
        System.out.println("\n---Tour de "+joueur.getMatricule()+"---");
        if(joueur.estJouable() && lootPresent(getPersonnagePosition((Personnages) joueur))) {
            System.out.println("Information : Un équipement est à proximité. Vous pouvez le ramasser.");
        }
    }
    public boolean estLibre(Positions pos){
        for(Map.Entry<Positions, Personnages> entry : m_joueurs.entrySet()){
            if(entry.getKey().getX() == pos.getX() && entry.getKey().getY() == pos.getY()){
                return false;
            }
        }
        for(Map.Entry<Positions, Monstres> entry : m_ennemis.entrySet()){
            if(entry.getKey().getX() == pos.getX() && entry.getKey().getY() == pos.getY()){
                return false;
            }
        }
        for(Positions posObstacle : m_obstacles){
            if(posObstacle.getX() == pos.getX() && posObstacle.getY() == pos.getY()){
                return false;
            }
        }
        return true;
    }
    public Boolean lootPresent(Positions p){
        if(m_loot.isEmpty()){
            return false;
        }
        else{
            for(Map.Entry<Positions, Equipements> entry : m_loot.entrySet()){
                if(entry.getKey().getX() == p.getX() && entry.getKey().getY() == p.getY()){
                    return true;
                }
            }
            return false;
        }

    }
    public void afficherMap(){
        System.out.println(getMap());
    }
    public void updateMap(){
        for(int i = 0; i < m_hauteur; i++){
            m_map[i] = "";
            for(int j = 0; j < m_largeur; j++){
                m_map[i] = m_map[i]+" . ";
            }
        }
        for(Map.Entry<Positions, Equipements> entry : m_loot.entrySet()){
            m_map[entry.getKey().getY()-1] = m_map[entry.getKey().getY()-1].substring(0,entry.getKey().getX()*3)+" * "+m_map[entry.getKey().getY()-1].substring(entry.getKey().getX()*3+3);
        }
        for(Map.Entry<Positions, Personnages> entry : m_joueurs.entrySet()){
            String pseudo = "";
            switch(entry.getValue().getPseudo().length()){

                case 1:
                    pseudo = " "+entry.getValue().getPseudo()+" ";
                    break;
                case 2:
                    pseudo = " "+entry.getValue().getPseudo();
                    break;
                case 3:
                    pseudo = entry.getValue().getPseudo();
                    break;
            }
            m_map[entry.getKey().getY()-1] = m_map[entry.getKey().getY()-1].substring(0,entry.getKey().getX()*3)+pseudo+m_map[entry.getKey().getY()-1].substring(entry.getKey().getX()*3+3);
        }
        for(Map.Entry<Positions, Monstres> entry : m_ennemis.entrySet()){
            String pseudo = "";
            switch(entry.getValue().getPseudo().length()){

                case 1:
                    pseudo = " "+entry.getValue().getPseudo()+" ";
                    break;
                case 2:
                    pseudo = " "+entry.getValue().getPseudo();
                    break;
                case 3:
                    pseudo = entry.getValue().getPseudo();
                    break;
            }
            m_map[entry.getKey().getY()-1] = m_map[entry.getKey().getY()-1].substring(0,entry.getKey().getX()*3)+pseudo+m_map[entry.getKey().getY()-1].substring(entry.getKey().getX()*3+3);
        }
        for(Positions pos : m_obstacles){
            m_map[pos.getY()-1] = m_map[pos.getY()-1].substring(0,pos.getX()*3)+"[X]"+m_map[pos.getY()-1].substring(pos.getX()*3+3);
        }
    }
    public String getNom(){
        return m_nom;
    }
    public String getDesc(){
        return m_desc;
    }
    public void setDesc(String newDesc){
        m_desc = newDesc;
    }
    public int getHauteur(){
        return m_hauteur;
    }
    public int getLargeur(){
        return m_largeur;
    }
    public Map<Positions, Personnages> getJoueurs(){
        return m_joueurs;
    }
    public Positions getPersonnagePosition(Personnages personnage){
        for(Map.Entry<Positions, Personnages> entry : m_joueurs.entrySet()){
            if(entry.getValue().equals(personnage)){
                return entry.getKey();
            }
        }
        return null;
    }
    public Positions getEnnemiPosition(Monstres ennemi){
        for(Map.Entry<Positions, Monstres> entry : m_ennemis.entrySet()){
            if(entry.getValue().equals(ennemi)){
                return entry.getKey();
            }
        }
        return null;
    }
    public Map<Positions, Monstres> getEnnemis(){
        return m_ennemis;
    }
    public Map<Positions, Equipements> getLoot(){
        return m_loot;
    }
    public ArrayList<Positions> getObstacles(){
        return m_obstacles;
    }
    public String getMap(){//Lohan : j'ai modifié plein de trucs


        String[] displayedMap = new String[m_hauteur+3];

        displayedMap[0] = "     "+" A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z ".substring(0, m_largeur*3 );
        displayedMap[1] = "   "+"+------------------------------------------------------------------------------- ".substring(0, m_largeur*3 + 2)+"+"+" ";
        for(int i = 0; i < m_hauteur; i++){
            if(i<9){
                displayedMap[i+2] = " "+ (i+1) +" | "+m_map[i]+ "|";
            }
            else{
                displayedMap[i+2] = (i+1) + " | "+m_map[i]+ "|";
            }
        }

        displayedMap[m_hauteur+2] = "   "+"+------------------------------------------------------------------------------- ".substring(0, m_largeur*3 + 2)+"+"+" ";

        String mapString ="";
        for(int i = 0; i < displayedMap.length; i++){
            mapString +=(displayedMap[i] +"\n");
        }
        mapString +=("Obstacles: [X], Loot: *");
        return mapString;
    }
    public Map<Entites, Integer> getInitiatives(){
        return m_initiatives;
    }
    public ArrayList<Entites> getOrdre(){
        return m_ordre;
    }
    public String getInfos(){
        String joueurs = "";
        if(m_joueurs != null){
            for(Map.Entry<Positions, Personnages> entry : m_joueurs.entrySet()){
                joueurs = joueurs+entry.getValue().getNom();
            }
        }
        else{
            joueurs = "Aucun joueur";
        }
        String ennemis = "";
        if(m_ennemis != null){
            for(Map.Entry<Positions, Monstres> entry : m_ennemis.entrySet()){
                ennemis = ennemis+entry.getValue().getEspece();
            }
        }
        else {
            ennemis = "Aucun ennemi";
        }
        String loot = "";
        if (m_loot != null){
            for(Map.Entry<Positions, Equipements> entry : m_loot.entrySet()){
                loot = loot+entry.getValue().getNom();
            }
        }
        else {
            loot = "Aucun loot";
        }
        String ordre = "";
        for(int i = 0; i < m_ordre.size(); i++){
            ordre = ordre+m_ordre.get(i).getMatricule();
            if(i != m_ordre.size()-1){
                ordre = ordre+" ; ";
            }
        }
        return m_nom+"(\n Joueurs= "+joueurs+"\n Ennemis= "+ennemis+"\n Loot= "+loot+"\n Ordre= "+ordre+")";
    }
    @Override
    public String toString(){
        return m_nom+"(\n Description= "+m_desc+"\n Hauteur= "+m_hauteur+"\n Largeur= "+m_largeur+"\n Joueurs= "+m_joueurs+"\n Ennemis= "+m_ennemis+"\n Loot= "+m_loot+"\n Obstacles= "+m_obstacles+"\n Initiatives= "+m_initiatives+"\n Ordre= "+m_ordre+")";
    }
}

