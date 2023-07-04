import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class CurvePanel extends JPanel {

    // Panel-Size Konstante
    private final static int PANEL_SIZE = 500;

    // Liste der zu zeichnenden Polygone instanziieren
    private ArrayList<CurvePolygon> polygons = new ArrayList<CurvePolygon>();

    // DrawPanel Konstruktor
    public CurvePanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
    }

    // Komponetnten Methode überschreiben
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Color color = g2D.getColor();

        for (CurvePanel.CurvePolygon polygon : polygons) {
            g2D.setColor(polygon.getColor());
            g2D.setStroke(polygon.getStroke());
            Polygon pol = polygon.getPolygon();
            g2D.drawPolygon(pol);
        }
    }
    // Methode zum zeichnen der ersten drei Punkte
    public void drawPoints(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(e.getX(), e.getY(), 5, 5);
    }

    // Methode zum Hinzufügen der Polygone zur Liste
    public void addPolygon(Polygon polygon, Color color, BasicStroke stroke) {
        CurvePolygon pol = new CurvePolygon(color, polygon, stroke);
        polygons.add(pol);
        repaint();
    }

    // Mehtode zum Löschen des DrawPanels
    public void clear() {
        polygons.clear();
        repaint();
    }

    // Eigene Polygon Klasse zum erstellen der zwei verschiedenen Polygone
    class CurvePolygon extends Polygon {
        private Color color;
        private  BasicStroke stroke;
        private Polygon polygon;

        // Polygon Konstruktor
        public CurvePolygon(Color color, Polygon polygon, BasicStroke stroke) {
            this.color = color;
            this.stroke = stroke;
            this.polygon = polygon;

        }

        // GETTER
        public Color getColor() {
            return color;
        }

        public BasicStroke getStroke() {
            return stroke;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

}
