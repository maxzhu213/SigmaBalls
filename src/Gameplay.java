import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener, MouseListener {

    private int delay = 10;
    private long time = System.currentTimeMillis();

    private Timer timer;
    private Random rand;

    private Player player;
    private ArrayList<Ball> balls;
    private HUD hud;
    private Equation eq;

    public Gameplay(){
        timer = new Timer(delay, this);
        timer.start();

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        addKeyListener(this);
        addMouseListener(this);

        rand = new Random();

        player = new Player();
        balls = new ArrayList<>();
        hud = new HUD();
        eq = new Equation(true, new ArrayList<>(), new Fraction(1, new Random().nextInt(4) + 1));
        eq.getColors().add(Color.BLUE);
    }

    @Override
    public void paintComponent(Graphics g){
        if (!Main.won) {
            if (System.currentTimeMillis() - time > 1000) {
                balls.add(new Ball(rand.nextInt(Main.SCREEN_WIDTH), 20, rand.nextInt(2) - 1, rand.nextInt(Ball.getColors().length)));
                time = System.currentTimeMillis();
            }

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            g.drawImage(Ball.hofertFace, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);

            player.draw(g);
            for (Ball ball : balls) {
                ball.draw(g);
            }
            hud.draw(g, this);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            g.setColor(Color.BLACK);
            g.drawString("WINNER", 100, 100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            player.tick();
            hud.tick();
            for (Ball ball : balls) {
                ball.tick(this);
            }
        } catch (NullPointerException ex) {
            // lolnope
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setVelX(-Player.MAX_VEL);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setVelX(Player.MAX_VEL);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setVelX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setVelX(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public HUD getHud() {
        return hud;
    }

    public Equation getEq() {
        return eq;
    }
}
