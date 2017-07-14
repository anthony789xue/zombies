package COm.ZOmdemo;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anthony on 7/11/2017.
 */
public class Player {
    double vx, vy;
    double speed;
    int maxSpeed;
    Rectangle bounds;
    private boolean alive;

    public Player() {
        bounds = new Rectangle(20, 20, 10, 10);
        vx = 0;
        vy = 0;
        speed = .5;
        maxSpeed = 4;
        alive = true;


    }

    public void hit() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void draw(Graphics g) {
        if(alive) {
            g.setColor(Color.BLUE);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    public void move(ArrayList<String> dirs) {


        for (int i = 0; i < dirs.size(); i++) {


            if (dirs.get(i).equals("up"))
                vy -= speed;
            if (dirs.get(i).equals("down"))
                vy += speed;
            if (dirs.get(i).equals("left"))
                vx -= speed;
            if (dirs.get(i).equals("right"))
                vx += speed;


        }
        if (vx > maxSpeed)
            vx = maxSpeed;
        if (vx < -maxSpeed)
            vx = -maxSpeed;
        if (vy > maxSpeed)
            vy = maxSpeed;
        if (vy < -maxSpeed)
            vy = -maxSpeed;

        bounds.x += (int) vx;
        bounds.y += (int) vy;
        vx *= .9;
        vy *= .9;
    }
    public Rectangle getBounds() {
        return bounds;
    }

}

