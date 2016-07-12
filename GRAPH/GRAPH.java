import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse GRAPH.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GRAPH
{
    private KNOTEN[] knotenfeld;
    private int[][]  adjazenzmatrix; // im format adjazenzmatrix[start][ziel]
    private int maximaleAnzahlKnoten;
    private int aktuelleAnzahlKnoten;

    public GRAPH(int maximaleAnzahlKnoten) 
    {      
        this.maximaleAnzahlKnoten = maximaleAnzahlKnoten;

        knotenfeld = new KNOTEN[maximaleAnzahlKnoten];

        adjazenzmatrix = new int[maximaleAnzahlKnoten][maximaleAnzahlKnoten];
        // Adjazenzmatrix komplett mit -1 belegen
        for(int i = 0; i < maximaleAnzahlKnoten; i++)
            for(int j = 0; j < maximaleAnzahlKnoten; j++)
                adjazenzmatrix[i][j] = -1;

        aktuelleAnzahlKnoten = 0;
    }

    /**
     * fügt dem Graph einen Knoten hinzu
     * 
     * @param knoten Der Knoten der eingefügt werden soll
     * @return falls der Knoten eingefügt wurde, wird die interne Nummerierung zurückgegeben,
     *         ansonsten -1
     */
    public int addKnoten(KNOTEN knoten) {
        if(aktuelleAnzahlKnoten >= maximaleAnzahlKnoten) {
            return -1;
        }
        if(null == knoten){
            return -1;
        }
        String test = knoten.getBezeichnung();
        for (int i=0; i < aktuelleAnzahlKnoten; i++) {
            if(test.equals(knotenfeld[i].getBezeichnung())){
                return -1;
            }
        }
        knotenfeld[aktuelleAnzahlKnoten] = knoten;
        aktuelleAnzahlKnoten = aktuelleAnzahlKnoten + 1;
        return aktuelleAnzahlKnoten - 1;
    }

    /**
     * fügt dem Graphen einen Kante hinzu
     * 
     * @param start die interne Nummer des Startknotens
     * @param ziel die interne Nummer des Zielknotens
     * @param gewicht das Gewicht der Kante
     */
    void addKante(int start, int ziel, int gewicht) {
        boolean a = !((start>=0) && (ziel>=0) && (gewicht>=0) && (start<aktuelleAnzahlKnoten) && (ziel<aktuelleAnzahlKnoten));
        if(a){
            return;
        }        
        adjazenzmatrix[start][ziel]=gewicht;
    }

    /**
     * fügt dem Graphen einen Kante hinzu
     * 
     * @param start die Bezeichnung des Startknotens
     * @param ziel die Bezeichnung des Zielknotens
     * @param gewicht das Gewicht der Kante
     */
    void addKante(String start, String ziel, int gewicht) {
        int st = getKnotenIndex(start);
        int zi = getKnotenIndex(ziel);// interne Nummern bestimmen und dann
        addKante(st,zi,gewicht);// addKante(int, int, int) verwenden !
    }

    /**
     * gibt die Adjazenzmatrix schön formatiert auf der Konsole aus
     * 
     * es werden die Spalten- und Zeilenbezeichnungen mit ausgegeben (knoten.getBezeichnung())
     * 
     */
    public void printAdjazenzmatrix ( ) {
        int maxlength = 0;
        String abschluss = " | ";
        for(int i=0; i<aktuelleAnzahlKnoten; i++){
            String a = knotenfeld[i].getBezeichnung();
            int b = a.length();
            if (b>maxlength){
                maxlength = b;
            }
        } 
        for(int i2=0; i2<adjazenzmatrix.length; i2++){
            for(int i3=0; i3<adjazenzmatrix[i2].length; i3++){
                int length = String.valueOf(adjazenzmatrix[i2][i3]).length();
                if(length>maxlength){
                    maxlength=length;
                }
            }
        }

        String[][] inhalt = new String[aktuelleAnzahlKnoten+1][aktuelleAnzahlKnoten+1];
        inhalt[0][0]="";
        System.out.println(inhalt[0][0].length());
        for(int i=1; i<inhalt[0].length; i++){
            inhalt[0][i] = knotenfeld[i-1].getBezeichnung();
        }
        for(int i=1; i<inhalt.length; i++){
            inhalt[i][0] = inhalt[0][i];
            for(int i2=1; i2<inhalt[i].length; i2++){
                inhalt[i][i2] = String.valueOf(adjazenzmatrix[i-1][i2-1]);
            }
        }
        printStringarr(inhalt, abschluss, maxlength);
    }

    private void printStringarr(String[][] inhalt, String abschluss, int maxlength){
        for (int i=0; i<inhalt.length; i++){
            int zeilenlaenge = 0;
            for(int i2=0; i2<inhalt[i].length; i2++){
                int leerzeichen = maxlength - inhalt[i][i2].length();
                for(int i3=0; i3<leerzeichen; i3++){
                    System.out.print(" ");
                    zeilenlaenge++;
                }
                System.out.print(inhalt[i][i2]);
                zeilenlaenge = zeilenlaenge + inhalt[i][i2].length();
                System.out.print(abschluss);
                zeilenlaenge = zeilenlaenge + abschluss.length();
            }
            System.out.println();
            for(int i4=0; i4<zeilenlaenge; i4++){
                System.out.print("_");
            }
            System.out.println();
        }
    }

    /**
     * löscht eine Kante aus dem Graphen
     * 
     * @param start die interne Nummer des Startknotens
     * @param ziel die interne Nummer des Zielknotens
     */
    public void deleteKante(int start, int ziel) {
        adjazenzmatrix[start][ziel] = -1;

    }

    /**
     * löscht eine Kante aus dem Graphen
     * 
     * @param start die Bezeichnung des Startknotens
     * @param ziel die Bezeichnung des Zielknotens
     */
    void deleteKante(String start, String ziel) {
        int st = getKnotenIndex(start);
        int zi = getKnotenIndex(ziel);// interne Nummern bestimmen und dann
        deleteKante(st,zi);// addKante(int, int, int) verwenden !
    }

    /**
     * löscht einen Knoten aus dem Graphen
     * 
     * @param nr die interne Nummer des Knotens
     */
    public void deleteKnoten(int nr) {
        if(nr < 0)
            return;

        KNOTEN[] knotenfeldNEU = new KNOTEN[maximaleAnzahlKnoten];
        for(int i = 0, j = 0; i < aktuelleAnzahlKnoten; i++, j++)
        {
            if( nr != i)
                knotenfeldNEU[j] = knotenfeld[i];
            else
                j--;
        }
        knotenfeld = knotenfeldNEU;

        for(int i = 0; i < maximaleAnzahlKnoten; i++)
        {
            adjazenzmatrix[nr][i] = -1;
        }
        for(int i = 0; i < maximaleAnzahlKnoten; i++)
        {
            adjazenzmatrix[i][nr] = -1;
        }
        // schwere Aufgabe
        // es muss eine Zeile aus der Matrix ,,gelöscht" werden
        // die hinteren Knoten müssen ein Feld nach vorne rücken
        // am einfachsten ist es vielleicht, einfach einen neue Adjazenzmatrix und
        // eine neues Knotenfeld anzulegen
    }

    public void deleteKnoten(String bezeichnung)
    {
        deleteKnoten(getKnotenIndex(bezeichnung));
    }

    /**
     * findet den internen Index, der zum Knoten mit der Bezeichnung bezeichnung gehört
     * 
     * @param bezeichnung Die Bezeichung des Knoten, der gesucht werden soll
     * @return falls der Knoten gefunden wurde, wird die interne Nummerierung zurückgegeben,
     *         ansonsten -1
     */
    public int getKnotenIndex(String bezeichnung) {
        for (int i=0; i < aktuelleAnzahlKnoten; i++) {
            if(bezeichnung.equals(knotenfeld[i].getBezeichnung())){
                return i;
            }
        }    
        return -1;
    }

    public int getAktuelleAnzahlKnoten() {
        return aktuelleAnzahlKnoten;
    }

    public int getMaximaleAnzahlKnoten() {
        return maximaleAnzahlKnoten;
    }

    public int getGewicht(int start, int ziel) {
        return adjazenzmatrix[start][ziel];
    }

    /**
     * liefert die Nummern der benachbarten Knoten als ArrayList
     * 
     * @param nr die interne Nummer des Knotens
     */
    public ArrayList<Integer> getAdajacentVertices(int nr) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

        for(int i = 0; i < aktuelleAnzahlKnoten; i++){        
            if(i == nr)
                continue;
            if(getGewicht(nr, i) > 0)
                neighbors.add(i);
        }
        
        return neighbors;
    }
}
