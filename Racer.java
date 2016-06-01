import java.awt.*;
import java.util.Observable;
/**
 * Created by root on 5/23/16.
 */
public class Racer extends Observable {
    private int x, y, speed;
    private int[][] field;
    private String direction;
    private Path path;
    private Color color;


    public Racer()
    {
        x = 0;
        y = 0;
        speed = 5;
        direction = "up";
        field = new int[640][360];
    }

    public Racer(int x, int y, String direction){
        this.x = x;
        this.y = y;
        speed = 5;
        this.direction = direction;
        field = new int[640][360];
        color = Color.CYAN;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color c)
    {
        color = c;
    }

    public void move()
    {
        switch(direction) {
            case "up":
                if(checkValidDirection("up"))
                    moveUp();
                break;
            case "down":
                if(checkValidDirection("down"))
                    moveDown();
                break;
            case "left":
                if(checkValidDirection("left"))
                    moveLeft();
                break;
            case "right":
                if(checkValidDirection("right"))
                    moveRight();
                break;
        }
        setChanged();
        notifyObservers();

    }
    // leaves the trail coordinates, changes Path
    public void leaveTrail()
    {

    }

    public boolean checkLost()
    {
        if(x == 0 || x + speed == 1400 || x == 1400)
        {
            return true;
        }
        if(y == 0 || y + speed == 800 || y == 800)
        {
            return true;
        }
        return false;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }



    public String getDirection()
    {
        return direction;
    }
    // returns 1 for up, 2 for down, 3 for left, 4 for right

    public boolean checkValidDirection(String a)
    {
        String current = direction;
        if(current.equals("right"))
        {
            if(a.equals("right"))
                return true;
            else if(a.equals("left"))
                return false;
            else if(a.equals("down"))
                return true;
            else if(a.equals("up"))
                return true;
            else
                return false;
        }
        else if(current.equals("left"))
        {
            if(a.equals("right"))
                return false;
            else if(a.equals("left"))
                return true;
            else if(a.equals("down"))
                return true;
            else if(a.equals("up"))
                return true;
            else
                return false;
        }
        else if(current.equals("up"))
        {
            if(a.equals("right"))
                return true;
            else if(a.equals("left"))
                return true;
            else if(a.equals("down"))
                return false;
            else if(a.equals("up"))
                return true;
            else
                return false;
        }
        else
        {
            if(a.equals("right"))
                return true;
            else if(a.equals("left"))
                return true;
            else if(a.equals("down"))
                return true;
            else if(a.equals("up"))
                return false;
            else
                return false;
        }
    }
    public void moveUp()
    {
        if(direction.equals("down"))
            return;
        y -= speed;
    }

    public void moveDown()
    {
        if(direction.equals("up"))
            return;
        y += speed;
    }

    public void moveLeft()
    {
        if(direction.equals("right"))
            return;
        x -= speed;
    }

    public void moveRight()
    {
        // if moving
        if(direction.equals("left"))
            return;
        x += speed;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getSpeed()
    {
        return speed;
    }







}