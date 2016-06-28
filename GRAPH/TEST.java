public class TEST
{
    GRAPH g;

    public TEST()
    {
        g = new GRAPH(15);

        ORT[] daten = new ORT[12];
        KNOTEN[] knoten = new KNOTEN[12];
        int[] knotenNr = new int[12];

        daten[0] = new ORT("Hamburg",   1734000);
        daten[1] = new ORT("Berlin",    3502000);

        for(int i = 0; i < 2; i++) {
            knoten[i] = new KNOTEN(daten[i]);
        }

        for(int i = 0; i < 2; i++) {
            knotenNr[i] = g.addKnoten(knoten[i]);
        }

        g.addKante(knotenNr[0], knotenNr[1], 280);
        g.addKante(knotenNr[1], knotenNr[0], 280);
    }
}
