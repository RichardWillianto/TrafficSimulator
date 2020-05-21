package Model;
import java.awt.*;
import java.util.Random;

public class Vehicle
{
    private Random random =  new Random();
    private static final int START = 0;
    private static final int STOP = 0;
    public String id;
    public int length;
    public int width;
    private int speed;
    public int position;
    private Color color;
    private Road currentRoad;

    public Vehicle(Road currentRoad)
    {
        id = "000";
        length = 4;
        width = 2;
        speed = 0;
        color = randomVehicleColor();
        this.currentRoad = currentRoad;
        currentRoad.getRoadVehicles().add(this);
    }

    public void display(Graphics graphics, int scale)
    {
        int xValue = 0;
        int yValue = 1;

        if (currentRoad.getOrientation() == Road.Orientation.HORIZONTAL)
        {
            int[] start = getCurrentRoad().getStart();
            int height = getWidth() * scale;
            int width = getLength() * scale;
            int x = (getPosition() + start[xValue]) * scale;
            int y = (start[yValue] * scale) + scale;
            graphics.setColor(color);
            graphics.fillRect(x, y, width, height);
        }
        else if (currentRoad.getOrientation() == Road.Orientation.VERTICAL)
        {
            int[] start = getCurrentRoad().getStart();
            int height = getLength() * scale;
            int width = getWidth() * scale;
            int x = (start[xValue] * scale) + ((currentRoad.getWidth() * scale) - (width + scale));
            int y = (getPosition() + start[yValue]) * scale;
            graphics.setColor(color);
            graphics.fillRect(x, y, width, height);
        }
    }

    public Vehicle()
    {
        id = "000";
        length = 0;
        width = 0;
        speed = 0;
        position = 0;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    private Color randomVehicleColor()
    {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void drive()
    {
        Random random = new Random();
        int nextPosition = length + speed + position;

        for (Vehicle nextVehicle : currentRoad.getRoadVehicles())
        {
            if (nextVehicle.position > position && nextVehicle.position <= nextPosition + 4)
            {
                speed = STOP;
                break;
            }
            else
            {
                speed = currentRoad.getLimit();
            }
        }

        if (speed == STOP)
        {

        }
        else
        {
            if (!currentRoad.getRoadLights().isEmpty() &&
                    nextPosition + 1 >= currentRoad.getRoadLights().get(0).getPosition() &&
                    this.currentRoad.getRoadLights().get(0).getStatus().equals("RED"))
            {
                speed = STOP;
            }
            else
            {
                speed = currentRoad.getLimit();

                if (currentRoad.getLength() <= nextPosition && !currentRoad.getConnectedRoads().isEmpty())
                {
                    currentRoad.getRoadVehicles().remove(this);
                    int nextRoad = random.nextInt(2);
                    currentRoad = currentRoad.getConnectedRoads().get(nextRoad);
                    currentRoad.getRoadVehicles().add(this);
                    position = START;
                }
                else if (currentRoad.getLength() >= nextPosition)
                {
                    position = position + speed;
                }
                else
                {
                    speed = STOP;
                }
            }
        }
    }

    public void  printVehicleStatus()
    {
        System.out.printf("%s moving %s on %s %s%n", getId(), getSpeed(), getCurrentRoad().getId(), getPosition());
    }

    public String getId()
    {
        return id;
    }

    public int getLength()
    {
        return length;
    }

    public int getWidth()
    {
        return width;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getPosition()
    {
        return position;
    }

    public Road getCurrentRoad()
    {
        return currentRoad;
    }
}
