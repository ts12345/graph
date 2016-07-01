import java.util.Random;
import javax.swing.*;
import java.awt.*; 

/**
 * Beschreiben Sie hier die Klasse VIEW_GRAPH.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class VIEW_GRAPH extends JPanel
{

    GRAPH graph;

    private int width;
    private int height;

    private Color backgroundColor = Color.gray;
    private Color vertexColor = Color.blue;
    private Color edgeColor = Color.red;

    private int   vertexRadius;

    private int   nrVertices;
    private int   maxNrVertices;

    private int[] xCoordinates;
    private int[] yCoordinates;

    public VIEW_GRAPH(GRAPH g) {
        this.graph = g;

        nrVertices    = g.getAktuelleAnzahlKnoten();
        maxNrVertices = g.getMaximaleAnzahlKnoten();

        vertexRadius = 30;
        initialisePanel();

        xCoordinates = new int[maxNrVertices];
        yCoordinates = new int[maxNrVertices];        

        intialisePointsRandomly();

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawEdges(g);
        drawVertices(g);
    }

    private void drawVertices(Graphics g) {
        g.setColor(vertexColor);

        for(int i = 0; i < nrVertices; i++) {
            g.fillOval(xCoordinates[i], yCoordinates[i], 2 * vertexRadius, 2 * vertexRadius);
        }
    }

    private void drawEdges(Graphics g) {
        System.out.println("test1");

        int startX, endX;
        int startY, endY;
        g.setColor(edgeColor);
        for(int i = 0; i < nrVertices; i++) {
            for(int j = 0; j < nrVertices; j++) {
                if(graph.getGewicht(i, j) > 0) {

                    startX = xCoordinates[i] + vertexRadius;
                    endX   = xCoordinates[j] + vertexRadius;
                    startY = yCoordinates[i] + vertexRadius;
                    endY   = yCoordinates[j] + vertexRadius;
                    g.drawLine(startX, startY, endX, endY);
                }

            }
        }
    }

    private void initialisePanel() {
        width = 1000;
        height = 800;

        setBackground(backgroundColor);
        setPreferredSize(new Dimension(width, height));
    }

    private void intialisePointsRandomly() {
        Random r = new Random();
        for(int i = 0; i < nrVertices; i++) {
            xCoordinates[i] = r.nextInt(width);
            yCoordinates[i] = r.nextInt(height);
        }
    }

    public static void main(String s[]) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        TEST t = new TEST();

        VIEW_GRAPH view = new VIEW_GRAPH(t.getGraph());

        f.getContentPane().add("Center", view);
        f.pack();
        f.setVisible(true);

    }
}
