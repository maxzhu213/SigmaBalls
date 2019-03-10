import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Entity {
    public static double MAX_VEL = 10;
    public static int WIDTH = 200;
    public static int HEIGHT = 400;

    private BufferedImage hofert;

    private HashMap<Color, Integer> ballCount;

    Player(){
        x = 100;
        y = 550;
        velX = 0;
        velY = 0;
        try{
            hofert = ImageIO.read(new File("C:\\Users\\madam\\Desktop\\Programs\\Java\\Sigma Balls\\res\\hofert.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ballCount = new HashMap<>();
        for(Color clr : Ball.getColors()) {
            ballCount.put(clr, 0);
        }
    }

    public void tick() {
        x += velX;
        y += velY;

        if(x > Main.SCREEN_WIDTH) {
            x = -WIDTH;
        }
        if(x < -WIDTH) {
            x = Main.SCREEN_WIDTH;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(hofert, (int)x, (int)y, WIDTH, HEIGHT, null);
    }

    public void addBall(Ball ball) {
        ballCount.put(ball.getColor(), ballCount.get(ball.getColor()) + 1);
    }

    public HashMap<Color, Integer> getBallCount() {
        return ballCount;
    }

    public BufferedImage getHofert() {
        return hofert;
    }
}
