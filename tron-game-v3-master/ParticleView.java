import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finley on 5/24/2016.
 */
public class ParticleView extends JPanel implements Observer {

    private ArrayList<Particle> particles;
    private final int PARTICLE_WIDTH = 3;

    public ParticleView()
    {
        particles = new ArrayList<>();
        particles.add(new Particle(0, WIDTH, PARTICLE_WIDTH, PARTICLE_WIDTH));
    }

    public void paintComponent(Graphics g)
    {
        int random;
        g.setColor(Color.GREEN);
        for(int k = 0; k < particles.size(); k++) {
            random = (int) (Math.random() * HEIGHT);
            particles.add(new Particle(random, WIDTH, PARTICLE_WIDTH, PARTICLE_WIDTH));
            particles.get(k).draw(g);
            particles.get(k).particleMove();
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
