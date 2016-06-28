
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

    }

    /**
     * fügt dem Graph einen Knoten hinzu
     * 
     * @param knoten Der Knoten der eingefügt werden soll
     * @return falls der Knoten eingefügt wurde, wird die interne Nummerierung zurückgegeben,
     *         ansonsten -1
     */
    public int addKnoten(KNOTEN knoten) {
        return -1;
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
    void deleteKante(String start, String ziel, int gewicht) {
        // interne Nummern bestimmen und dann
        // deleteKante(int, int, int) verwenden !
    }

    /**
     * löscht einen Knoten aus dem Graphen
     * 
     * @param start die interne Nummer des Startknotens
     * @param ziel die interne Nummer des Zielknotens
     */
    public void deleteKnoten(int start, int ziel) {
        // schwere Aufgabe
        // es muss eine Zeile aus der Matrix ,,gelöscht" werden
        // die hinteren Knoten müssen ein Feld nach vorne rücken
        // am einfachsten ist es vielleicht, einfach einen neue Adjazenzmatrix und
        // eine neues Knotenfeld anzulegen
    }
}
