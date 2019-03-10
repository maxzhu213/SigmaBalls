import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Equation {

    public static HashMap<Color, String> colorStringHashmap = new HashMap<>();

    public Equation(boolean replacement, ArrayList<Color> colors, Fraction result) {
        this.replacement = replacement;
        this.colors = colors;
        this.result = result;
    }

    private boolean replacement;
    private ArrayList<Color> colors;
    private Fraction result;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("P(");
        for(int i = 0; i < colors.size(); i++) {
            sb.append("    ");
        }
        sb.append(") = ");
        sb.append(result.toString());
        sb.append(" with" + (replacement ? "" : "out") + " replacement");

        return sb.toString();
    }

    public void draw(Graphics g) {
        g.drawString(this.toString(), 200, 100);
        for (int i = 0; i < colors.size(); i++) {
            int x = 240 + i * Ball.BALL_SIZE;
            int y = 110 - Ball.BALL_SIZE;
            g.setColor(Ball.getColors()[i]);
            g.fillOval(x, y, Ball.BALL_SIZE, Ball.BALL_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, Ball.BALL_SIZE, Ball.BALL_SIZE);
        }
    }

    public boolean winner(HashMap<Color, Integer> ballCount) {
        int totalBalls = 0;
        for (Integer i : ballCount.values()) {
            totalBalls += i;
        }
        return this.result.equals(new Fraction(ballCount.get(this.colors.get(0)), totalBalls));
    }

    public ArrayList<Color> getColors() {
        return colors;
    }
}