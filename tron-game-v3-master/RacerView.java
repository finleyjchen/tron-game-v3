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
    private ArrayList<Path> trailList1, trailList2;
    public final int RACER1WIN = 1;
    public final int RACER2WIN = 2;
    public final int NOWIN = 0;
    private int ctr = 1;
    private Image right = Toolkit.getDefaultToolkit().getImage("right.png");
    private Image left = Toolkit.getDefaultToolkit().getImage("left.png");
    private Image up = Toolkit.getDefaultToolkit().getImage("up.png");
    private Image down = Toolkit.getDefaultToolkit().getImage("down.png");

    public RacerView(Racer a, Racer b)
    {
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

        int trailSize = 3;
        int racerSize = 30;
            if (racer1.getDirection().equals("up")) {
                g.drawImage(up, racer1.getX(), racer1.getY(), this);
                trailList1.add(new Path(racer1.getX(), racer1.getY() + 5, trailSize, trailSize));
            }
            if (racer1.getDirection().equals("down")) {
                g.drawImage(down, racer1.getX(), racer1.getY(), this);
                trailList1.add(new Path(racer1.getX(), racer1.getY(), trailSize, trailSize));
            }
            if (racer1.getDirection().equals("left")) {
                g.drawImage(left, racer1.getX(), racer1.getY(), this);
                trailList1.add(new Path(racer1.getX(), racer1.getY(), trailSize, trailSize));

            }

            if (racer1.getDirection().equals("right")) {
                g.drawImage(right, racer1.getX(), racer1.getY(), this);
                trailList1.add(new Path(racer1.getX() - 7, racer1.getY(), trailSize, trailSize));
            }


            g.setColor(racer2.getColor());

            if (racer2.getDirection().equals("up")) {
                g.drawImage(up, racer2.getX(), racer2.getY(), this);
                trailList2.add(new Path(racer2.getX(), racer2.getY() , trailSize, trailSize));
            }
            if (racer2.getDirection().equals("down")) {
                g.drawImage(down, racer2.getX(), racer2.getY(), this);
                trailList2.add(new Path(racer2.getX(), racer2.getY() , trailSize, trailSize));
            }
            if (racer2.getDirection().equals("left")) {
                g.drawImage(left, racer2.getX(), racer2.getY(), this);
                trailList2.add(new Path(racer2.getX() + 7, racer2.getY() , trailSize, trailSize));
            }

            if (racer2.getDirection().equals("right")) {
                g.drawImage(right, racer2.getX(), racer2.getY(), this);
                trailList2.add(new Path(racer2.getX(), racer2.getY() , trailSize, trailSize));
            }
            for (int k = 0; k < trailList1.size(); k++) {
                g.setColor(racer1.getTrailColor());
                trailList1.get(k).draw(g);
                g.setColor(racer2.getTrailColor());
                trailList2.get(k).draw(g);
            }

    }

    //returns 1 if racer 1 wins, returns 2 if racer 2 wins, 0 if game still running
    public int checkLost()
    {
        if(racer1.checkLost())
            return RACER2WIN;
        if(racer2.checkLost())
            return RACER2WIN;
        for(int k = 0; k < trailList1.size(); k++)
        {
            //System.out.println(racer1.getPoint());

            if(racer1.getFrontPoint().equals(trailList1.get(k).getPoint()) || racer1.getFrontPoint().equals(trailList2.get(k).getPoint()))
            {
                System.out.println("2 Win");
                return RACER2WIN;
            }
            System.out.println(racer1.getX() + " =? " + trailList1.get(k).getX() + "; " + racer2.getX() + " =? " + trailList2.get(k).getX());
            if(racer2.getFrontPoint().equals(trailList1.get(k).getPoint()) || racer2.getFrontPoint().equals(trailList2.get(k).getPoint()))
            {
                System.out.println("1 WIN");
                return RACER1WIN;
            }
        }

        return 0;

    }

}
