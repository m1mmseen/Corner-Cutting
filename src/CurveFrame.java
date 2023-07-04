import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class CurveFrame extends JFrame implements MouseListener {

    CurvePanel panel;

    Polygon polygon;

    Polygon cutPolygon;
    int mouseClicked = 0;
    CurveFrame() {

        this.setTitle("Kurve");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new CurvePanel();
        panel.addMouseListener(this);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.polygon = new Polygon();
        this.cutPolygon = new Polygon();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked++;
        polygon.addPoint(e.getX(), e.getY());
        panel.drawPoints(e);

        if (mouseClicked >= 3) {
            panel.clear();
            panel.addPolygon(polygon, Color.BLACK, new BasicStroke(1));
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
