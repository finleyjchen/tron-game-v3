import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by root on 5/23/16.
 */
public class Main extends JFrame implements ActionListener, KeyListener
{

    private static Timer timer, menuTimer;
    public static final int WIDTH = 1400, HEIGHT = 800;
    private static Racer racer1, racer2;
    private static RacerView view;
    private boolean inMenu;
    private MenuView menuView;
    private CardLayout cardLayout;
    private Container c;
    private Random rand;



    public static void main(String[] args)
    {
        Main m = new Main();
        m.setVisible(true);
    }

    public Main()
    {
       start();
        //Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor("volger.png", new Point(0, 0), "Name");


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == menuTimer)
        {
            menuView.setTitleColor(new Color((int)(Math.random() * 0x1000000)));
            if(menuView.isRunning() == false)
            {
                menuTimer.stop();
                cardLayout.next(c);
                timer.start();
            }
        }
        if(e.getSource() == timer)
        {
            if(view.checkLost() == 0) {
                racer1.move();
                racer2.move();
            }
            else if(view.checkLost() == 2) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Racer 1 Lost, Racer 2 Wins");
                int reply = JOptionPane.showConfirmDialog(null, "Play again?", "You Lost", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION)
                {
                    restart();
                    cardLayout.next(c);
                }
                if(reply == JOptionPane.NO_OPTION)
                    System.exit(0);


            }
            else if(view.checkLost() == 1) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Racer 2 Lost, Racer 1 Wins");
                int reply = JOptionPane.showConfirmDialog(null, "Play again?", "You Lost", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION) {
                    restart();
                    cardLayout.next(c);
                }
                if(reply == JOptionPane.NO_OPTION)
                    System.exit(0);
            }


        }

        if(e.getActionCommand() == "Play")
        {
            cardLayout.next(c);
            timer.start();
        }


        if(e.getActionCommand() == "Pause")
        {
            cardLayout.next(c);
            timer.stop();
            menuTimer.start();
            menuView.setRunning(true);
        }


    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            if(racer1.checkValidDirection("up"))
                racer1.setDirection("up");

        }

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            if(racer1.checkValidDirection("left"))
                racer1.setDirection("left");

        }

        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            if(racer1.checkValidDirection("down"))
                racer1.setDirection("down");

        }

        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            if(racer1.checkValidDirection("right"))
                racer1.setDirection("right");

        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(racer2.checkValidDirection("up"))
                racer2.setDirection("up");

        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(racer2.checkValidDirection("left"))
                racer2.setDirection("left");

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(racer2.checkValidDirection("down"))
                racer2.setDirection("down");

        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(racer2.checkValidDirection("right"))
                racer2.setDirection("right");

        }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void start()
    {
        cardLayout = new CardLayout();
        setSize(WIDTH,  HEIGHT);
        setTitle("Tr0n");
        setLocation (50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setBackground(Color.DARK_GRAY);

        c.setLayout(cardLayout);


        racer1 = new Racer(50, HEIGHT / 2, "right");
        racer2 = new Racer(WIDTH - 50, HEIGHT / 2, "left");
        racer1.setColor(Color.red);
        racer1.setTrailColor(Color.red);
        racer2.setColor(Color.blue);
        racer2.setTrailColor(Color.blue);
        timer = new Timer(7, this);
        menuTimer = new Timer(300, this);

        try {
            menuView = new MenuView(racer1, racer2);
        } catch(Exception e)
        {
            System.out.println("Error");
        }
        view = new RacerView(racer1, racer2);
        c.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        c.add(menuView);
        c.add(view);
        pack();

        JMenuItem m;
        JMenu menu = new JMenu("Options");
        m = new JMenuItem("Pause");	// Create a menu option
        m.addActionListener(this);
        menu.add(m);
        m = new JMenuItem("How to Play");

        JMenuBar mBar = new JMenuBar();
        mBar.add(menu);
        setJMenuBar(mBar);
        racer1.addObserver(view);
        racer2.addObserver(view);
        addKeyListener(this);
        menuTimer.start();
    }

    public void restart()
    {
        menuView.setRunning(true);

        timer = null;
        menuTimer = null;
        racer1 = null;
        racer2 = null;
        view = null;
        JPanel scorePanel = null;
        menuView = null;
        cardLayout = null;
        c = null;
        start();
    }

}
