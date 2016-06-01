import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by root on 5/23/16.
 */
public class RacerView extends JPanel implements Observer {
    private Racer racer1, racer2;
    private int[][] field;
    private ArrayList<Path> trailList1, trailList2;
    private final int trailSize = 5;


    public RacerView(Racer a, Racer b)
    {
        field = new int[WIDTH][HEIGHT];
        racer1 = a;
        racer2 = b;
        setBackground(Color.DARK_GRAY);

        trailList1 = new ArrayList<Path>();
        trailList2 = new ArrayList<Path>();
    }
    public void update(Observable o, Object obj)
    {
        setBackground(Color.DARK_GRAY);
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(racer1.getColor());

        if(racer1.getDirection().equals("up")){
            g.fillRect(racer1.getX(), racer1.getY(), 20, 20);
            trailList1.add(new Path(racer1.getX() + 8, racer1.getY() + 20, trailSize, trailSize));
        }
        if(racer1.getDirection().equals("down")){
        g.fillRect(racer1.getX(), racer1.getY(), 20, 20);
        trailList1.add(new Path(racer1.getX() + 8, racer1.getY() - trailSize, trailSize, trailSize));
        }
        if(racer1.getDirection().equals("left")){
            g.fillRect(racer1.getX(), racer1.getY(), 20, 20);
            trailList1.add(new Path(racer1.getX() + 20, racer1.getY() + 8, trailSize, trailSize));
        }

        if(racer1.getDirection().equals("right")){
            g.fillRect(racer1.getX(), racer1.getY(), 20, 20);
            trailList1.add(new Path(racer1.getX() - trailSize, racer1.getY() + 8, trailSize, trailSize));
        }


        g.setColor(racer2.getColor());

        if(racer2.getDirection().equals("up")){
            g.fillRect(racer2.getX(), racer2.getY(), 20, 20);
            trailList2.add(new Path(racer2.getX() + 8, racer2.getY() + 20, trailSize, trailSize));
        }
        if(racer2.getDirection().equals("down")){
            g.fillRect(racer2.getX(), racer2.getY(), 20, 20);
            trailList2.add(new Path(racer2.getX() + 8, racer2.getY() - trailSize, trailSize, trailSize));
        }
        if(racer2.getDirection().equals("left")){
            g.fillRect(racer2.getX(), racer2.getY(), 20, 20);
            trailList2.add(new Path(racer2.getX() + 20, racer2.getY() + 8, trailSize, trailSize));
        }

        if(racer2.getDirection().equals("right")){
            g.fillRect(racer2.getX(), racer2.getY(), 20, 20);
            trailList2.add(new Path(racer2.getX() - trailSize, racer2.getY()  + 8, trailSize, trailSize));
        }
        for(int k = 0; k < trailList1.size(); k++) {
            g.setColor(racer1.getColor());
            trailList1.get(k).draw(g);
            g.setColor(racer2.getColor());
            trailList2.get(k).draw(g);
        }

    }

}
