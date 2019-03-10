import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static final int SCREEN_WIDTH = 1800;
    public static final int SCREEN_HEIGHT = 1000;

    public static boolean won = false;

    JFrame frame;
    Gameplay g;

    public Main() {
        g = new Gameplay();
        frame = new JFrame("Sigma Balls");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(g);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Equation.colorStringHashmap.put(Color.BLUE, "blue");
        Equation.colorStringHashmap.put(Color.RED, "red");
        Equation.colorStringHashmap.put(Color.GREEN, "green");
        Equation.colorStringHashmap.put(Color.PINK, "pink");
        Equation.colorStringHashmap.put(Color.ORANGE, "orange");
        Main m = new Main();
    }
}
