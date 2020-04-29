package com.company;
import java.util.ArrayList;

public class Road
{
    private String id;
    private int length;
    private int start;
    private int end;
    private int limit;
    private ArrayList<Road> connected_roads = new ArrayList<Road>();
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<TrafficLight> lights = new ArrayList<TrafficLight>();

}
