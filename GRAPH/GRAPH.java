
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
    private boolean[] istBesucht;

    public GRAPH(int maximaleAnzahlKnoten) 
    {      
        this.maximaleAnzahlKnoten = maximaleAnzahlKnoten;

        knotenfeld = new KNOTEN[maximaleAnzahlKnoten];
        istBesucht = new boolean[maximaleAnzahlKnoten];

        adjazenzmatrix = new int[maximaleAnzahlKnoten][maximaleAnzahlKnoten];
        // Adjazenzmatrix komplett mit -1 belegen
        for(int i = 0; i < maximaleAnzahlKnoten; i++)
            for(int j = 0; j < maximaleAnzahlKnoten; j++)
                adjazenzmatrix[i][j] = -1;

        aktuelleAnzahlKnoten = 0;
    }

    /**
     * fuegt dem Graph einen Knoten hinzu
     * 
     * @param knoten Der Knoten der eingefuegt werden soll
     * @return falls der Knoten eingefuegt wurde, wird die interne Nummerierung zurueckgegeben,
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
     * fuegt dem Graphen einen Kante hinzu
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
     * fuegt dem Graphen einen Kante hinzu
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
     * gibt die Adjazenzmatrix schoen formatiert auf der Konsole aus
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
     * loescht eine Kante aus dem Graphen
     * 
     * @param start die interne Nummer des Startknotens
     * @param ziel die interne Nummer des Zielknotens
     */
    public void deleteKante(int start, int ziel) {
        adjazenzmatrix[start][ziel] = -1;

    }

    /**
     * loescht eine Kante aus dem Graphen
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
     * loescht einen Knoten aus dem Graphen
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
        // es muss eine Zeile aus der Matrix ,,geloescht" werden
        // die hinteren Knoten muessen ein Feld nach vorne ruecken
        // am einfachsten ist es vielleicht, einfach einen neue Adjazenzmatrix und
        // eine neues Knotenfeld anzulegen
    }

    public void deleteKnoten(String bezeichnung)
    {
        deleteKnoten(getKnotenIndex(bezeichnung));
    }

    /**
     * findet den internen Index, der zum Knoten mit der Bezeichnung bezeichnung gehoert
     * 
     * @param bezeichnung Die Bezeichung des Knoten, der gesucht werden soll
     * @return falls der Knoten gefunden wurde, wird die interne Nummerierung zurueckgegeben,
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

    public ArrayList<Integer> getAdajacentUnvisitedVertices(int nr) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

        for(int i = 0; i < aktuelleAnzahlKnoten; i++){        
            if(i == nr)
                continue;
            if(getGewicht(nr, i) > 0 && !istBesucht[i])
                neighbors.add(i);
        }

        return neighbors;
    }

    public void markiereAllesAlsUnbesucht() {
        for(int i = 0; i < aktuelleAnzahlKnoten; i++)
            istBesucht[i] = false;
    }

    public void tiefensucheRekursiv(int startknoten) {
        //
        markiereAllesAlsUnbesucht();
        tiefensucheKnoten(startknoten);
    }

    private void tiefensucheKnoten(int nr) {       
        ArrayList<Integer> neighbors = getAdajacentVertices(nr);
        istBesucht[nr] = true;
        System.out.println(knotenfeld[nr].getBezeichnung());

        for(Integer v: neighbors) {
            if(!istBesucht[v])
                tiefensucheKnoten(v);
        }        
    }

    public void tiefensucheMitStack(int startknoten) {        
        markiereAllesAlsUnbesucht();
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(knotenfeld[startknoten].getBezeichnung());
        istBesucht[startknoten] = true;

        stack.push(startknoten);

        while(! stack.empty()) {
            Integer v = stack.peek();
            ArrayList<Integer> neighbors = getAdajacentVertices(v);
            boolean hatUnbesuchteNachbarn = false;
            for(Integer w: neighbors) {
                if(!istBesucht[w]) {
                    hatUnbesuchteNachbarn = true;
                    System.out.println(knotenfeld[w].getBezeichnung());
                    istBesucht[w] = true;                   
                    stack.push(w);
                    break;
                }       
            }
            if(!hatUnbesuchteNachbarn)
                stack.pop();
        }       
    }


    /**
     * fuehrt die Breitensuche durch
     *
     * @param startknoten die interne Nummer des Startknotens
     * @return in feld[0][x] steckt die Distanz zu Knoten x <br>
     * in feld[1][x] steckt der Vorgaenger zu Knoten x
     */
    public int[][] breitensuche(int startknoten) {
        markiereAllesAlsUnbesucht();
        Queue<Integer> queue = new LinkedList<Integer>();
        System.out.println(startknoten);
        queue.add(startknoten);
        istBesucht[startknoten] = true;

        int[] vorgaenger = new int[aktuelleAnzahlKnoten];
        int[] distanz = new int[aktuelleAnzahlKnoten];

        for(int i = 0; i < aktuelleAnzahlKnoten; i++) {
            vorgaenger[i] = -1;
            distanz[i] = -1;
        }

        distanz[startknoten] = 0;

        int v;
        while( !queue.isEmpty() ) {
            v = queue.remove();
            ArrayList<Integer> neighbors = getAdajacentUnvisitedVertices(v);
            for(Integer w: neighbors) {
                System.out.println(w);
                istBesucht[w] = true;
                queue.add(w);
                vorgaenger[w] = v;
                distanz[w] = distanz[v] + 1;
            }
        }
        int[][] rueckgabe = new int[2][aktuelleAnzahlKnoten];
        rueckgabe[0] = distanz;
        rueckgabe[1] = vorgaenger;
        return rueckgabe;
    }
}
