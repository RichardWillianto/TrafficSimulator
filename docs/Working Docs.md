## Problem Specification
Based on user stories, people in the area have trouble dealing with the traffic management system.
Especially on the crossroad which is a significant part of the road as it connects a lot of important places.
This traffic simulator program will act as a simulator to display the traffic so user can learn what problems that can happen and come up with solution to the problem.
As of now, we already know that they need traffic light at the crossroads and speed limit for the roads.
Therefore, the program will contain vehicles that go through roads with speed limit and traffic light if it connects to crossroads.

## Problem Decomposition
The program has vehicle, road, and traffic light classes that resemble each of the objects and everything is operated in the main method.

## Main
Main method will contain all classes and loop for the program to work.

## Vehicle
Class that represent description of vehicles such as:
id - identifier for each vehicle.
length - length of the vehicle.
width - width of the vehicle.
speed - maximum speed of the vehicle.
position - location of the vehicle.
current_road - part of the road the vehicle is currently travelling.

## Bus
Subclass of vehicle which represents large sized vehicles.
This subclass will inherit the attributes of vehicle class.

## Sedan
Subclass of vehicle that represents normal sized vehicles.
This subclass will inherit the attributes of vehicle class.

## Motorbike
Subclass of vehicle which represents small sized vehicles.
This subclass will inherit the attributes of vehicle class.

## Road
Class that represent description of the road such as:
id - identifier for the road.
length - length of the road
start - part where the road begin
end - part where the road end
limit - maximum speed vehicle can go on the road
vehicles - all vehicles that are currently on the road
lights - all traffic lights on the road
connected_roads - other road that is connected to the road

## TrafficLight
Class that represent description of the traffic light such as:
id - identifier for each traffic light.
status – determine the current light of the traffic light
position - position of the traffic light on the road
road_side - the road that the light is attached to
