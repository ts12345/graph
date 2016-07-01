public class TEST
{
    GRAPH g;

    public TEST()
    {
        g = new GRAPH(15);

        ORT[] daten = new ORT[12];
        KNOTEN[] knoten = new KNOTEN[12];
        int[] knotenNr = new int[12];

        daten[0]  = new ORT("Hamburg",   1734000);
        daten[1]  = new ORT("Berlin",    3502000);
	daten[2]  = new ORT("Koeln",     1046680);
	daten[3]  = new ORT("Hannover",   523642);
	daten[4]  = new ORT("Kassel",     194747);
	daten[5]  = new ORT("Leipzig",    544479);
	daten[6]  = new ORT("Frankfurt",  717624);
	daten[7]  = new ORT("Wuerzburg",  124219);
	daten[8]  = new ORT("Nuernberg",  501072);
	daten[9]  = new ORT("Stuttgart",  612441);
	daten[10] = new ORT("Ulm",        120714);
	daten[11] = new ORT("Muenchen",  1429584);

        for(int i = 0; i < 12; i++) {
            knoten[i] = new KNOTEN(daten[i]);
        }

        for(int i = 0; i < 12; i++) {
            knotenNr[i] = g.addKnoten(knoten[i]);
        }

        g.addKante(knotenNr[0],  knotenNr[1],  280);
        g.addKante(knotenNr[1],  knotenNr[0],  280);
	g.addKante(knotenNr[0],  knotenNr[3],  150);
	g.addKante(knotenNr[3],  knotenNr[0],  150);
	g.addKante(knotenNr[0],  knotenNr[2],  420);
	g.addKante(knotenNr[2],  knotenNr[0],  420);
	g.addKante(knotenNr[1],  knotenNr[3],  285);
	g.addKante(knotenNr[3],  knotenNr[1],  285);
	g.addKante(knotenNr[1],  knotenNr[5],  190);
	g.addKante(knotenNr[5],  knotenNr[1],  190);
	g.addKante(knotenNr[2],  knotenNr[3],  290);
	g.addKante(knotenNr[3],  knotenNr[2],  290);
	g.addKante(knotenNr[2],  knotenNr[4],  250);
	g.addKante(knotenNr[4],  knotenNr[2],  250);
	g.addKante(knotenNr[2],  knotenNr[6],  190);
	g.addKante(knotenNr[6],  knotenNr[2],  190);
	g.addKante(knotenNr[3],  knotenNr[5],  260);
	g.addKante(knotenNr[5],  knotenNr[3],  260);
	g.addKante(knotenNr[3],  knotenNr[4],  160);
	g.addKante(knotenNr[4],  knotenNr[3],  160);
	g.addKante(knotenNr[4],  knotenNr[5],  250);
	g.addKante(knotenNr[5],  knotenNr[4],  250);
	g.addKante(knotenNr[4],  knotenNr[7],  210);
	g.addKante(knotenNr[7],  knotenNr[4],  210);
	g.addKante(knotenNr[4],  knotenNr[6],  185);
	g.addKante(knotenNr[6],  knotenNr[4],  185);
	g.addKante(knotenNr[5],  knotenNr[8],  280);
	g.addKante(knotenNr[8],  knotenNr[5],  280);
	g.addKante(knotenNr[5],  knotenNr[7],  325);
	g.addKante(knotenNr[7],  knotenNr[5],  325);
	g.addKante(knotenNr[5],  knotenNr[6],  390);
	g.addKante(knotenNr[6],  knotenNr[5],  390);
	g.addKante(knotenNr[6],  knotenNr[7],  120);
	g.addKante(knotenNr[7],  knotenNr[6],  120);
	g.addKante(knotenNr[6],  knotenNr[9],  210);
	g.addKante(knotenNr[9],  knotenNr[6],  210);
	g.addKante(knotenNr[7],  knotenNr[8],  120);
	g.addKante(knotenNr[8],  knotenNr[7],  120);
	g.addKante(knotenNr[7],  knotenNr[10], 200);
	g.addKante(knotenNr[10], knotenNr[7],  200);
	g.addKante(knotenNr[7],  knotenNr[9],  150);
	g.addKante(knotenNr[9],  knotenNr[7],  150);
	g.addKante(knotenNr[8],  knotenNr[11], 170);
	g.addKante(knotenNr[11], knotenNr[8],  170);
	g.addKante(knotenNr[9],  knotenNr[10],  90);
	g.addKante(knotenNr[10], knotenNr[9],   90);
	g.addKante(knotenNr[10], knotenNr[11], 160);
	g.addKante(knotenNr[11], knotenNr[10], 160);

    }
}
