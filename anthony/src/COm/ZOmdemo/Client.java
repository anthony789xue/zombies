package COm.ZOmdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Anthony on 7/11/2017.
 */
public class Client extends JApplet implements KeyListener {
    private ArrayList<String> dirs;
    private Graphics bg;
    private Image offscreen;

    private Player Anthony;

    private Zombie Bob;
    ArrayList<Zombie> zeds;


    public void init() {
        Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        offscreen = createImage(screen.width, screen.height);
        bg = offscreen.getGraphics();
        Anthony = new Player();
        dirs = new ArrayList<>();
        addKeyListener(this);
        setFocusable(true);
        Bob = new Zombie(new Rectangle(80,30,10,10));
        zeds = new ArrayList<>();
                for(int i = 0; i < 15; i++)
                    zeds.add(new Zombie(new Rectangle((int)(Math.random()*screen.width),(int)(Math.random()*screen.height), 10, 10)));
        Timer timer = new Timer(30, ae -> {
            for(Zombie zed: zeds) {
                zed.move(Anthony);
            }
            Anthony.move(dirs);
            Bob.move(Anthony);
            repaint();
        });
        timer.start();
    }


    public void paint(Graphics g) {
        bg.clearRect(0, 0, offscreen.getWidth(this), offscreen.getHeight(this));
        //draw here
        Anthony.draw(bg);
        Bob.draw(bg);
        for(Zombie zed: zeds) {
            zed.draw(bg);
        }
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w')
            if (!dirs.contains("up"))
                dirs.add("up");
        if (e.getKeyChar() == 'a')
            if (!dirs.contains("left"))
                dirs.add("left");
        if (e.getKeyChar() == 's')
            if (!dirs.contains("down"))
                dirs.add("down");
        if (e.getKeyChar() == 'd')
            if (!dirs.contains("right"))
                dirs.add("right");



    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w')
           dirs.remove("up");
        if (e.getKeyChar() == 'a')
            dirs.remove("left");
        if (e.getKeyChar() == 's')
            dirs.remove("down");
        if (e.getKeyChar() == 'd')
            dirs.remove("right");

    }
}
