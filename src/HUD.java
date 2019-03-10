import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class HUD {

    HUD() {
        ArrayList<Color> colors = new ArrayList<>();
    }

    public void tick() {

    }

    public void draw(Graphics g, Gameplay gameplay) {
        for (int i = 0; i < Ball.getColors().length; i++) {
            g.setFont(new Font("Comic Sans", Font.BOLD, 40));
            g.setColor(Ball.getColors()[i]);
            g.fillOval(0, 2 * i * Ball.BALL_SIZE, Ball.BALL_SIZE, Ball.BALL_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(0, 2 * i * Ball.BALL_SIZE, Ball.BALL_SIZE, Ball.BALL_SIZE);
            g.drawImage(Ball.hofertFace, 0, 2 * i * Ball.BALL_SIZE, Ball.BALL_SIZE, Ball.BALL_SIZE, null);
            g.drawString(Integer.toString(gameplay.getPlayer().getBallCount().get(Ball.getColors()[i])), Ball.BALL_SIZE, 2 * i * Ball.BALL_SIZE + Ball.BALL_SIZE);
            gameplay.getEq().draw(g);
        }
    }
}
