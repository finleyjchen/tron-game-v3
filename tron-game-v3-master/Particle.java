import java.awt.*;
import java.util.Observable;

/**
 * Created by Finley on 5/24/2016.
 */public class Particle extends Observable{
    private int x, y, width, height;

    public Particle()
    {
        this(0, 0, 1, 1);

    }
    public Particle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void particleMove()
    {
        x -= 5;
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }


}