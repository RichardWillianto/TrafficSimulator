## Problem Specification
Based on user stories, people in the area have trouble dealing with the traffic management system.
Especially on the crossroad which is a significant part of the road as it connects a lot of important places.
This traffic simulator program will act as a simulator to display the traffic so user can learn what problems that can happen and come up with solution to the problem.
As of now, we already know that they need traffic light at the crossroads and speed limit for the roads.
Therefore, the program will contain vehicles that go through roads with speed limit and traffic light if it connects to crossroads.

## Problem Decomposition
The program has vehicle, road, and traffic light classes that resemble each of the objects and everything is operated in the main method.

## Main
Class that calls every methods and handle the user input.

## Vehicle
Class that represents descriptions of the vehicle.
Have subclasses which are Bus, Car, and Motorbike.
Contains following attributes:
- id: Unique identifier
- length: Length
- width: Width
- speed: Maximum speed
- position: Location
- color: Color
- currentRoad: Part of the road the vehicle is currently travelling
Contains following methods:
- display()
- drive()
- printVehicleStatus()

## Bus
Subclass of Vehicle which represents large sized vehicles.
This subclass will inherit the attributes of Vehicle class.

## Car
Subclass of Vehicle that represents normal sized vehicles.
This subclass will inherit the attributes of Vehicle class.

## Motorbike
Subclass of Vehicle which represents small sized vehicles.
This subclass will inherit the attributes of Vehicle class.

## Road
Class that represent description of the road.
Contains following attributes:
- orientation: Orientation
- id: Unique identifier
- length: Length
- width: Width
- start: Start of the road
- end: End of the road
- limit: Maximum speed vehicle can go
- roadVehicles: All vehicles that are currently on the road
- roadLights: All traffic lights on the road
- connectedRoads: other road that is connected to the road
Contains following methods:
- display()
- end()

## TrafficLight
Class that represent description of the traffic light.
Contains following attributes:
- id: Unique identifier
- status: Determine the current light status
- position: Location
- lightPlacements: The road that the light is attached to
Contains following methods:
- display()
- changeLightStatus()
- printLightStatus()

## SaveFile
Class that handle the simulation files saving.

## SimulationPanel
Class that handle the simulation display.

## EditorPanel
Class that handle the simulation editing screen display.