import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircularButton extends JButton {

    public CircularButton(String label) {
        super(label);
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove focus border
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.orange); // Change color when button is pressed
        } else {
            g.setColor(getBackground());
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter = Math.min(getWidth(), getHeight());
        Shape shape = new Ellipse2D.Double(0, 0, diameter, diameter);
        g2d.fill(shape);

        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Remove border
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circular Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        CircularButton circularButton = new CircularButton("Click me");
        frame.add(circularButton);

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

