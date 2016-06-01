import java.awt.*;

/**
 * Created by root on 5/23/16.
 */
public class Path {
    private int x, y, width, height;
    private Color color;


    public Path()
    {
        this(0, 0, 1, 1);

    }
    public Path(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }


}
