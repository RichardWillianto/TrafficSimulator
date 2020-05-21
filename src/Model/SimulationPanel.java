package Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SimulationPanel extends JPanel
{
    private Status status = Status.STOP;
    private Random random = new Random();
    private int scale;
    private Timer timer;
    private Boolean stop = true;
    private static int cycle = 0;
    private int incomingVehicles = 2;
    private int spawnedVehicles = 0;
    private int removedVehicles = 0;
    private int cycleNumber = 20;
    private int updateRate = 1000;
    private ArrayList<Road> roads;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<TrafficLight> lights;

    public enum Status
    {
        RUN, STOP, FINISH
    }

    public void map(ArrayList<Road> roads, ArrayList<TrafficLight> lights)
    {
        this.roads = roads;
        this.lights = lights;
    }

    public void setScale(int scale)
    {
        this.scale = scale;
    }

    public void setIncomingVehiclesRate(int rate)
    {
        this.cycleNumber = rate;
    }

    public void setIncomingVehicles(int spawn)
    {
        this.incomingVehicles = spawn - 1;
        spawnVehicles();
    }

    private int getTotalVehicles()
    {
        return spawnedVehicles + 1 - removedVehicles;
    }

    private String getAverageSpeed()
    {
        int totalSpeed = 0;

        for (Vehicle vehicle : vehicles)
        {
            totalSpeed = totalSpeed + vehicle.getSpeed();
        }

        if (!vehicles.isEmpty())
        {
            int average = totalSpeed / vehicles.size();
            return average * 3.6 + "km/h";
        }
        else
        {
            return "0";
        }
    }

    public void setUpdateRate(int updateRate)
    {
        this.updateRate = updateRate;
    }

    public void setStop(Boolean stop)
    {
        this.stop = stop;
    }

    private void spawnVehicles()
    {
        int randomVehicles = random.nextInt(3);

        switch (randomVehicles)
        {
            case 0:
                vehicles.add(new Bus(Integer.toString(cycle), roads.get(0)));
                break;
            case 1:
                vehicles.add(new Car(Integer.toString(cycle), roads.get(0)));
                break;
            case 2:
                vehicles.add(new Motorbike(Integer.toString(cycle), roads.get(0)));
                break;
        }
    }

    public void simulate()
    {
        setLayout(new BorderLayout());
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(1, 0));
        info.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        JLabel vehiclesLabel = new JLabel("Vehicles: ");
        info.add(vehiclesLabel);
        JLabel averageSpeedLabel = new JLabel("Average Speed: ");
        info.add(averageSpeedLabel);
        JLabel statusLabel = new JLabel("Status: " + status);
        info.add(statusLabel);
        add(info, BorderLayout.SOUTH);

        if (timer != null)
        {
            timer.stop();
        }

        timer = new Timer(updateRate / 60, e ->
        {
            cycle++;
            if (vehicles.size() == 0)
            {
                status = Status.FINISH;
            }
            else if (stop)
            {
                status = Status.STOP;
            }
            else
            {
                status = Status.RUN;
            }
            statusLabel.setText("Status: " + status);
            vehiclesLabel.setText("Vehicles: " + getTotalVehicles());
            averageSpeedLabel.setText("Average Speed: " + getAverageSpeed());
            if (vehicles.size() == 0 || stop)
            {
                timer.stop();
            }
            if (cycle % 30 == 0)
            {
                for (TrafficLight light : lights)
                {
                    light.changeLightStatus(random.nextInt());
                    light.printLightStatus();
                }
            }
            for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext();)
            {
                Vehicle vehicle = iterator.next();
                vehicle.drive();
                vehicle.printVehicleStatus();
                if (vehicle.getPosition() + vehicle.getLength() + vehicle.getSpeed() >=
                        vehicle.getCurrentRoad().getLength() && vehicle.getCurrentRoad().getConnectedRoads().isEmpty()
                        && (vehicle.getSpeed() == 0))
                {
                    vehicle.getCurrentRoad().getRoadVehicles().remove(vehicle);
                    iterator.remove();
                    removedVehicles++;
                }
            }
            if (cycle % cycleNumber == 0 && spawnedVehicles < incomingVehicles)
            {
                spawnVehicles();
                spawnedVehicles++;
            }
            repaint();
        });

        timer.start();
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);

        for (Road road : roads)
        {
            road.display(graphics, scale);
        }

        if (!vehicles.isEmpty())
        {
            for (Vehicle vehicle : vehicles)
            {
                vehicle.display(graphics, scale);
            }
        }

        for (TrafficLight light : lights)
        {
            light.display(graphics, scale);
        }
    }
}