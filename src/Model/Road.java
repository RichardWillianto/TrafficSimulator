package Model;
import java.awt.*;
import java.util.ArrayList;

public class Road
{
    private Orientation orientation;
    private String id;
    private int length;
    private int width;
    private int[] start;
    private int[] end;
    private int limit;
    private ArrayList<Road> connectedRoads = new ArrayList<>();
    private ArrayList<Vehicle> roadVehicles = new ArrayList<>();
    private ArrayList<TrafficLight> roadLights = new ArrayList<>();

    public enum Orientation
    {
        HORIZONTAL, VERTICAL
    }

    public Road(String id, int limit, int[] start, int length, Orientation orientation)
    {
        this.orientation = orientation;
        this.id = "Road: " + id;
        this.length = length;
        this.width = 8;
        this.start = start;
        end();
        this.limit = limit;
    }

    public void display(Graphics graphics, int scale)
    {
        if (orientation == Orientation.HORIZONTAL)
        {
            int[] start = this.start;
            int x = start[0] * scale;
            int y = start[1] * scale;
            int width = length * scale;
            int height = this.width * scale;
            graphics.setColor(Color.darkGray);
            graphics.fillRect(x, y, width, height);
            graphics.setColor(Color.white);
            graphics.fillRect(x, y + (height / 2) - scale / 6, width, scale / 6);
            graphics.fillRect(x, y + (height / 2) + scale / 6, width, scale / 6);
        }
        else if (orientation == Orientation.VERTICAL)
        {
            int[] start = this.start;
            int x = start[0] * scale;
            int y = start[1] * scale;
            int width = this.width * scale;
            int height = length * scale;
            graphics.setColor(Color.darkGray);
            graphics.fillRect(x, y, width, height);
            graphics.setColor(Color.white);
            graphics.fillRect(x + (width / 2) - scale / 6, y, scale / 6, height);
            graphics.fillRect(x + (width / 2) + scale / 6, y, scale / 6, height);
        }
    }

    public void end()
    {
        if (orientation == Orientation.HORIZONTAL)
        {
            this.end = new int[] {this.length + this.start[0], this.start[1]};
        }
        else if (orientation == Orientation.VERTICAL)
        {
            this.end = new int[] {this.start[1], this.length + this.start[0]};
        }
    }

    Orientation getOrientation()
    {
        return orientation;
    }

    String getId()
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

    public int[] getStart()
    {
        return start;
    }

    public int[] getEnd()
    {
        return end;
    }

    public int getLimit()
    {
        return  limit;
    }

    public ArrayList<Road> getConnectedRoads()
    {
        return connectedRoads;
    }

    public ArrayList<Vehicle> getRoadVehicles()
    {
        return roadVehicles;
    }

    public ArrayList<TrafficLight> getRoadLights()
    {
        return roadLights;
    }
}
