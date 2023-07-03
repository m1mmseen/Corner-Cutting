import javax.swing.*;
import java.awt.*;

public class CurvePanel extends JPanel {

    CurvePanel() {
        this.setPreferredSize(new Dimension(500,500));
    }
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawLine(0,0,500,500);
    }
}
