import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class CurvePanel extends JPanel {
    private final static int PANEL_SIZE = 500;
    private ArrayList<CurvePolygon> polygons = new ArrayList<CurvePolygon>();

    public CurvePanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Color color = g2D.getColor();

        for (CurvePanel.CurvePolygon polygon : polygons) {
            g2D.setColor(polygon.getColor());
            g2D.setStroke(polygon.stroke);
            Polygon pol = polygon.getPolygon();
            g2D.drawPolygon(pol);
        }
    }
    public void drawPoints(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(e.getX(), e.getY(), 5, 5);
    }

    public void addPolygon(Polygon polygon, Color color, BasicStroke stroke) {
        CurvePolygon pol = new CurvePolygon(color, polygon, stroke);
        polygons.add(pol);
        repaint();
    }

    public void clear() {
        polygons.clear();
        repaint();
    }

    class CurvePolygon extends Polygon {
        private Color color;
        private  BasicStroke stroke;
        private Polygon polygon;

        public CurvePolygon(Color color, Polygon polygon, BasicStroke stroke) {
            this.color = color;
            this.stroke = stroke;
            this.polygon = polygon;

        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

}
