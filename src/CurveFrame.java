import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CurveFrame extends JFrame implements MouseListener {

    CurvePanel panel;

    Polygon polygon;

    int mouseClicked = 0;
    // Konstruktor des FRAMES
    CurveFrame() {

        this.setTitle("Kurve");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon imgIcon = new ImageIcon("polygon.png");
        this.setIconImage(imgIcon.getImage());

        // DrawPanel instanziieren und dem Frame zuweisen
        panel = new CurvePanel();
        panel.addMouseListener(this);
        this.add(panel);

        // Frame packen und sichtbar machen
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Polygon-Objekte instanziieren
        this.polygon = new Polygon();
    }

    private Polygon subdivide(Polygon polygon) {
        int[] curPoint = new int[2];
        Polygon cutPolygon = new Polygon();

        for (int i = 0; i < polygon.npoints; i++) {
            int sec = i + 1;
            if (i == polygon.npoints - 1) {
                sec = 0;
            }
            curPoint[0] = (int) ((int) (0.75 * polygon.xpoints[i]) + 0.25 * polygon.xpoints[sec]);
            curPoint[1] = (int) ((int) (0.75 * polygon.ypoints[i]) + 0.25 * polygon.ypoints[sec]);
            cutPolygon.addPoint(curPoint[0], curPoint[1]);

            curPoint[0] = (int) ((int) (0.25 * polygon.xpoints[i]) + 0.75 * polygon.xpoints[sec]);
            curPoint[1] = (int) ((int) (0.25 * polygon.ypoints[i]) + 0.75 * polygon.ypoints[sec]);
            cutPolygon.addPoint(curPoint[0], curPoint[1]);
        }
        return cutPolygon;
    }

    private Polygon subdivide(Polygon polygon, int steps) {

        int stepsDone = 0;
        Polygon cutPolygon = polygon;
        while (stepsDone != steps) {
            stepsDone++;
            cutPolygon = subdivide(cutPolygon);
        }
        return cutPolygon;
    }

    // MouseListener-Methoden
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked++;
        polygon.addPoint(e.getX(), e.getY());
        panel.drawPoints(e);

        if (mouseClicked >= 3) {
            panel.clear();
            panel.addPolygon(polygon, Color.BLACK, new BasicStroke(1));
            Polygon cutPolygon = subdivide(polygon, 5);
            panel.addPolygon(cutPolygon, Color.RED, new BasicStroke(2));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
