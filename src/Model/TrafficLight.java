package Model;
import java.awt.*;
import java.util.Random;

public class TrafficLight
{
    private static final double CHANGE = 0.5d;
    private static final String RED = "RED";
    private static final String GREEN = "GREEN";
    private String id;
    private String status;
    private int position;
    private Road lightPlacements;

    public TrafficLight(String id, Road road)
    {
        this.id = "Traffic Light: " + id;
        status = RED;
        this.lightPlacements = road;
        position = this.lightPlacements.getLength();
        this.lightPlacements.getRoadLights().add(this);
    }

    public void display(Graphics graphics, int scale)
    {
        if (lightPlacements.getOrientation() == Road.Orientation.HORIZONTAL)
        {
            switch (status)
            {
                case "RED":
                    graphics.setColor(Color.red);
                    break;
                case "GREEN":
                    graphics.setColor(Color.green);
            }
            int[] start = getLightPlacements().getStart();
            int x = (getPosition() + start[0]) * scale;
            int y = start[1] * scale;
            int height = (getLightPlacements().getWidth() / 2) * scale;
            graphics.fillRect(x, y, scale, height);
        }
        else if (lightPlacements.getOrientation() == Road.Orientation.VERTICAL)
        {
            switch (status)
            {
                case "RED":
                    graphics.setColor(Color.red);
                    break;
                case "GREEN":
                    graphics.setColor(Color.green);
            }
            int[] start = getLightPlacements().getStart();
            int x = (start[0] + (getLightPlacements().getWidth() / 2)) * scale;
            int y = (getPosition() + start[1]) * scale;
            int width = (getLightPlacements().getWidth() / 2) * scale;
            graphics.fillRect(x, y, width, scale);
        }
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void changeLightStatus(int time)
    {
        Random random = new Random(time);
        double probability = random.nextDouble();
        if (probability > CHANGE && !getLightPlacements().getRoadVehicles().isEmpty())
        {
            setStatus(RED);
        }
        else
        {
            setStatus(GREEN);
        }
    }

    public void printLightStatus()
    {
        System.out.printf("%s is currently %s on %s %s%n",
                getId(), getStatus(), this.getLightPlacements().getId(), this.getPosition());
    }

    public String getId()
    {
        return id;
    }

    public String getStatus()
    {
        return status;
    }

    public int getPosition()
    {
        return position;
    }

    public Road getLightPlacements()
    {
        return lightPlacements;
    }
}
