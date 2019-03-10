import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Ball extends Entity{
    private boolean drawMe = true;
    private final double grav = .1;
    public static final int BALL_SIZE = 40;
    private static Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.ORANGE};
    private Color color;
    public static BufferedImage hofertFace;

    public Ball(int x, int y, int velX, int c) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.color = colors[c];
        try {
            hofertFace = ImageIO.read(new File("C:\\Users\\madam\\Desktop\\Programs\\Java\\Sigma Balls\\res\\hofertface.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        if (drawMe) {
            g.setColor(color);
            g.fillOval((int) x, (int) y, BALL_SIZE, BALL_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval((int) x, (int) y, BALL_SIZE, BALL_SIZE);
            g.drawImage(hofertFace, (int)x, (int)y, BALL_SIZE, BALL_SIZE, null);
        }
    }

    public void tick(Gameplay gameplay) {
        x += velX;

        y += velY;
        velY += grav;

        if (this.y > Main.SCREEN_HEIGHT - Player.HEIGHT / 2) {
            this.drawMe = false;
        }

        if (gameplay.getPlayer().getX()<= this.x && this.x <= gameplay.getPlayer().getX() + gameplay.getPlayer().WIDTH &&
                this.y > gameplay.getPlayer().getY() && drawMe) {
            this.drawMe = false;
            gameplay.getPlayer().addBall(this);
            if (gameplay.getEq().winner(gameplay.getPlayer().getBallCount())){
                Main.won = true;
            }
        }
    }

    public static Color[] getColors() {
        return colors;
    }

    public boolean isDrawMe() {
        return drawMe;
    }

    public void setDrawMe(boolean drawMe) {
        this.drawMe = drawMe;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
