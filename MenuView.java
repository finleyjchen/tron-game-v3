import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Finley on 5/23/2016.
 */
public class MenuView extends JPanel {

    private JLabel title, startButton;
    private Font font;
    public MenuView()
    {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        try {
            font = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("Vermin Vibes 4 Helium.otf"));

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
        title = new JLabel("        LightRacer");
        title.setFont(test);
        title.setForeground(Color.CYAN);
        this.add(title, BorderLayout.NORTH);

        startButton = new JLabel("                                                            Start");
        test = font.deriveFont(Font.PLAIN, 50);
        startButton.setFont(test);
        startButton.setForeground(Color.BLUE);
        this.add(startButton, BorderLayout.CENTER);


    }

}
