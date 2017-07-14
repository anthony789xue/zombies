package COm.ZOmdemo;

import java.awt.*;

/**
 * Created by Anthony on 7/13/2017.
 */
public class Zombie {
    int speed;
    Rectangle bounds;
    public Zombie(Rectangle bounds) {
        this.bounds = bounds;
        this.speed = 1;
    }
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }


    public void move(Player player) {
        if(player.isAlive()){
            Rectangle pBounds = player.getBounds();
            if(bounds.x < pBounds.x)
                bounds.x += speed;
            if(bounds.x > pBounds.x)
                bounds.x -= speed;
            if(bounds.y < pBounds.y)
                bounds.y += speed;
            if(bounds.y > pBounds.y)
                bounds.y -= speed;
            act(player);
        }




    }
    private void act(Player player) {
        if(contains(player.bounds))
            player.hit();

    }
    public boolean contains(Rectangle rect) {
        return bounds.intersects(rect);
    }

}
