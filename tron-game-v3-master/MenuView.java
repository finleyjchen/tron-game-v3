import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Finley on 5/23/2016.
 */
public class MenuView extends JPanel implements ActionListener, MouseListener{

    private JLabel player1color;
    private JLabel player2color;
    private JLabel player1trailColor;
    private JLabel player2trailColor;
    private JLabel howToPlay;
    private Racer r1, r2;
    private Font font;
    private boolean running;
    private Color titleColor = Color.ORANGE;
    private Timer timer;
    private Random rand;
    private ArrayList<Racer> racers;
    public MenuView(Racer racer1, Racer racer2) {
        rand = new Random();
        racers = new ArrayList<>();
        running = true;
        BoxLayout thisBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(thisBox);
        setBackground(Color.DARK_GRAY);
        r1 = racer1;
        r2 = racer2;
        timer = new Timer(10, this);

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("Vermin Vibes 4 Helium.otf"));

        } catch (FileNotFoundException e) {
            System.out.println("Cant find file.");
            e.printStackTrace();
        } catch (FontFormatException e) {
            System.out.println("Wrong file type.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unknown error.");
            e.printStackTrace();
        }
        Font test = new Font("Arial", Font.BOLD, 150);
        test = font;
        test = font.deriveFont(Font.PLAIN, 150);
        JLabel title = new JLabel("LightRacer");
        title.setFont(test);
        title.setForeground(titleColor);

        final JLabel startButton = new JLabel("Start");
        test = font.deriveFont(Font.PLAIN, 50);
        startButton.setFont(test);
        startButton.setForeground(Color.cyan);
        startButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                running = false;
            }
            public void mouseEntered(MouseEvent e) {
                startButton.setForeground(Color.white);
                startButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                startButton.setForeground(Color.cyan);
                startButton.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });


        test = font.deriveFont(Font.PLAIN, 40);

        player1color = new JLabel("Player 1 Racer Color");
        player2color = new JLabel("Player 2 Racer Color");
        player1trailColor = new JLabel("Player 1 Trail Color");
        player2trailColor = new JLabel("Player 2 Trail Color");
        howToPlay = new JLabel("How to Play");
        player1color.setFont(test);
        player2color.setFont(test);
        player1trailColor.setFont(test);
        player2trailColor.setFont(test);
        howToPlay.setFont(test);
        player1color.setForeground(Color.cyan);
        player1trailColor.setForeground(Color.cyan);
        player2trailColor.setForeground(Color.cyan);
        player2color.setForeground(Color.cyan);
        howToPlay.setForeground(Color.cyan);
        startButton.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        player1trailColor.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        player2trailColor.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        player1color.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        player2color.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        player1color.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r1.setColor(c);
            }
            public void mouseEntered(MouseEvent e) {
                player1color.setForeground(Color.white);
                player1color.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                player1color.setForeground(Color.cyan);
                player1color.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });

        player2color.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r2.setColor(c);

            }
            public void mouseEntered(MouseEvent e) {
                player2color.setForeground(Color.white);
                player2color.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                player2color.setForeground(Color.cyan);
                player2color.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });

        player1trailColor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r1.setTrailColor(c);
            }
            public void mouseEntered(MouseEvent e) {
                player1trailColor.setForeground(Color.white);
                player1trailColor.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                player1trailColor.setForeground(Color.cyan);
                player1trailColor.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });
        player2trailColor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r2.setTrailColor(c);
            }
            public void mouseEntered(MouseEvent e) {
                player2trailColor.setForeground(Color.white);
                player2trailColor.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                player2trailColor.setForeground(Color.cyan);
                player2trailColor.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });

        howToPlay.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

        howToPlay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "This is a game 1v1 game with two racers who produce a light trail when they move. \n" +
                        "If you hit either player's light trail or the wall, you lose. Whoever is still standing wins. \n" +
                        "Player 1 uses WASD to move, Player 2 uses the arrow keys to move");
            }

            public void mouseEntered(MouseEvent e) {
                howToPlay.setForeground(Color.white);
                howToPlay.setBorder(BorderFactory.createLineBorder(Color.white, 2));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                howToPlay.setForeground(Color.cyan);
                howToPlay.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

            }
        });

        player1color.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2color.setAlignmentX(Component.CENTER_ALIGNMENT);
        player1trailColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2trailColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        howToPlay.setAlignmentX(Component.CENTER_ALIGNMENT);




        this.add(title);
        this.add(Box.createVerticalStrut(30));
        this.add(startButton);
        this.add(Box.createVerticalStrut(5));
        this.add(player1color);
        this.add(player2color);
        this.add(player1trailColor);
        this.add(player2trailColor);
        this.add(howToPlay);
        timer.start();

    }
        public void mousePressed(MouseEvent e) {
    }

        public void mouseReleased(MouseEvent e) {
    }

        public void mouseEntered(MouseEvent e) {
    }

        public void mouseExited(MouseEvent e) {
    }

        public void mouseClicked(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == timer)
        {
            int r = rand.nextInt(800 + 1);
            boolean oneortwo = rand.nextBoolean();
            if(oneortwo)
                racers.add(new Racer(0, r, "right", new Color((int)(Math.random() * 0x1000000)), 3));
            if(!oneortwo)
                racers.add(new Racer(1400, r, "left", new Color((int)(Math.random() * 0x1000000)), 3));
            for(int k = 0; k < racers.size(); k++) {
                racers.get(k).move();
                if(racers.get(k).getX() < 0 || racers.get(k).getX() > 1400)
                    racers.remove(k);
            }
            repaint();
        }

    }
    public boolean isRunning()
    {
        return running;
    }
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);

        for(int k = 0; k < racers.size(); k++)
        {
            g.setColor(racers.get(k).getColor());
            g.fillRect(racers.get(k).getX(), racers.get(k).getY(), 6, 6);
        }
        g.setColor(r1.getColor());
        g.fillRect(player1color.getX() - 55, player1color.getY(), 50, 50);
        g.setColor(r1.getTrailColor());
        g.fillRect(player1trailColor.getX() - 55, player1trailColor.getY(), 50, 50);
        g.setColor(r2.getColor());
        g.fillRect(player2color.getX() - 55, player2color.getY(), 50, 50);
        g.setColor(r2.getTrailColor());
        g.fillRect(player2trailColor.getX() - 55, player2trailColor.getY(), 50, 50);
    }

    public void setRunning(boolean runner)
    {
        running = runner;
    }

    public void setTitleColor(Color c)
    {
        titleColor = c;
    }

}


