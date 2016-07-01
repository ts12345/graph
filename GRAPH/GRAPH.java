/**
 * Beschreiben Sie hier die Klasse GRAPH.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GRAPH
{
    private KNOTEN[] knotenfeld;
    private int[][]  adjazenzmatrix;
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

    }

    /**
     * fügt dem Graphen einen Kante hinzu
     * 
     * @param start die Bezeichnung des Startknotens
     * @param ziel die Bezeichnung des Zielknotens
     * @param gewicht das Gewicht der Kante
     */
    void addKante(String start, String ziel, int gewicht) {
        // interne Nummern bestimmen und dann
        // addKante(int, int, int) verwenden !
    }

    /**
     * gibt die Adjazenzmatrix schön formatiert auf der Konsole aus
     * 
     * es werden die Spalten- und Zeilenbezeichnungen mit ausgegeben (knoten.getBezeichnung())
     * 
     */
    public void printAdjazenzmatrix ( ) {

    }

    /**
     * löscht eine Kante aus dem Graphen
     * 
     * @param start die interne Nummer des Startknotens
     * @param ziel die interne Nummer des Zielknotens
     */
    public void deleteKante(int start, int ziel) {

    }

    /**
     * löscht eine Kante aus dem Graphen
     * 
     * @param start die Bezeichnung des Startknotens
     * @param ziel die Bezeichnung des Zielknotens
     */
    void deleteKante(String start, String ziel) {
        // interne Nummern bestimmen und dann
        // deleteKante(int, int) verwenden !
    }

    /**
     * löscht einen Knoten aus dem Graphen
     * 
     * @param nr die interne Nummer des Knotens
     */
    public void deleteKnoten(int nr) {
        // schwere Aufgabe
        // es muss eine Zeile aus der Matrix ,,gelöscht" werden
        // die hinteren Knoten müssen ein Feld nach vorne rücken
        // am einfachsten ist es vielleicht, einfach einen neue Adjazenzmatrix und
        // eine neues Knotenfeld anzulegen
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

}
