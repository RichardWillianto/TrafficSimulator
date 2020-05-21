package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EditorPanel extends JPanel
{
    private ArrayList<Road> roads;
    private ArrayList<TrafficLight> lights;
    private int scale;

    public void setScale(int scale)
    {
        this.scale = scale;
    }

    public void map()
    {
        roads = new ArrayList<>();
        lights = new ArrayList<>();

        MouseAdapter mouse = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int xValue = e.getX() / scale;
                int yValue = e.getY() / scale;
                System.out.println("X: " + xValue);
                System.out.println("Y: " + yValue);

                if (roads.size() == 0)
                {
                    if (e.getY() < 10)
                    {
                        roads.add(new Road(Integer.toString
                                (roads.size()), 1, new int[]{xValue, 0}, 50, Road.Orientation.VERTICAL));
                    }
                    else if (e.getX() < 10)
                    {
                        roads.add(new Road(Integer.toString
                                (roads.size()), 1, new int[]{0, yValue}, 50, Road.Orientation.HORIZONTAL));
                    }
                }
                else
                {
                    String[] orientationOptions = {"Horizontal", "Vertical"};
                    int orientationSelection = JOptionPane.showOptionDialog
                            (null,"Choose Orientation: ", "Orientation Selection",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                    orientationOptions, roads);

                    switch (orientationSelection)
                    {
                        case 0:
                            roads.add(new Road(Integer.toString(roads.size()), 1,
                                    new int[]{xValue, yValue}, 50, Road.Orientation.HORIZONTAL));
                            break;
                        case 1:
                            roads.add(new Road(Integer.toString(roads.size()), 1,
                                    new int[]{xValue, yValue}, 50, Road.Orientation.VERTICAL));
                    }

                    String[] connectionOptions = new String[30];

                    for (int i = 0; i < connectionOptions.length; i++)
                    {
                        connectionOptions[i] = Integer.toString(i);
                    }

                    int connectionSelection = JOptionPane.showOptionDialog
                            (null, "Choose Connection:", "Connections Selection",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                    connectionOptions, connectionOptions[0]);
                    roads.get(connectionSelection).getConnectedRoads().add(roads.get(roads.size() - 1));
                }

                for (Road road : roads)
                {
                    lights.add(new TrafficLight("1", road));
                }

                repaint();
            }
        };

        addMouseListener(mouse);
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);

        if (roads.size() == 0)
        {
            graphics.setColor(Color.yellow);
            graphics.fillRect(0, 0, this.getWidth(), 10);
            graphics.fillRect(0, 0, 10, this.getHeight());
        }

        if (!roads.isEmpty())
        {
            for (Road road : roads)
            {
                road.display(graphics, scale);
            }
        }

        if (!lights.isEmpty())
        {
            for (TrafficLight light : lights)
            {
                light.display(graphics, scale);
            }
        }
    }

    public ArrayList<Road> getRoads()
    {
        return roads;
    }

    public ArrayList<TrafficLight> getLights()
    {
        return lights;
    }
}
