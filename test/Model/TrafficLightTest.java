package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrafficLightTest
{
    Model.Road road = new Model.Road("0", 1, new int[]{0, 0}, 5, Road.Orientation.VERTICAL);
    Model.TrafficLight light = new Model.TrafficLight("0", road);

    @Test
    void getId()
    {
        assertEquals("Traffic Light: 0", light.getId());
    }

    @Test
    void getStatus()
    {
        assertEquals("RED", light.getStatus());
    }

    @Test
    void getPosition()
    {
        assertEquals(5, light.getPosition());
    }

    @Test
    void getLightPlacements()
    {
        assertEquals(road, light.getLightPlacements());
    }

    @Test
    void testChangeLightStatus()
    {
        light.changeLightStatus(0);
        assertEquals("GREEN", light.getStatus());
    }
}