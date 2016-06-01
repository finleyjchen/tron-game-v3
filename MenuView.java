import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Finley on 5/23/2016.
 */
public class MenuView extends JPanel implements MouseListener{

    private JLabel title, startButton, player1color, player2color;
    private BoxLayout thisBox;
    private Racer r1, r2;
    private Font font;
    private boolean running;
    public MenuView(Racer r, Racer r2) {
        running = true;
        thisBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(thisBox);
        setBackground(Color.DARK_GRAY);
        r1 = r;
        this.r2 = r2;

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
        title = new JLabel("LightRacer");
        title.setFont(test);
        title.setForeground(Color.ORANGE);
        //title.setBorder(BorderFactory.createLineBorder(Color.blue, 4));

        startButton = new JLabel("Start");
        test = font.deriveFont(Font.PLAIN, 50);
        startButton.setFont(test);
        startButton.setForeground(Color.CYAN);
        startButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                running = false;
            }
        });


        test = font.deriveFont(Font.PLAIN, 40);

        player1color = new JLabel("Choose Color for Player 1");
        player2color = new JLabel("Choose Color for Player 2");
        player1color.setFont(test);
        player2color.setFont(test);
        player1color.setForeground(Color.RED);
        player2color.setForeground(Color.BLUE);
        player1color.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r1.setColor(c);
                player1color.setForeground(c);
            }
        });

        player2color.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                if (c != null)
                    r2.setColor(c);
                player2color.setForeground(c);
            }
        });

        player1color.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2color.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createVerticalStrut(30));
        this.add(startButton);
        this.add(Box.createVerticalStrut(5));
        this.add(player1color);
        this.add(player2color);


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

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean runner)
    {
        running = runner;
    }

}


