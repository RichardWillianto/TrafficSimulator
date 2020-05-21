package Model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoadTest
{
    Model.Road road = new Model.Road("0", 1, new int[]{0, 0}, 5, Road.Orientation.HORIZONTAL);

    @Test
    void getId()
    {
        assertEquals("Road: 0", road.getId());
    }

    @Test
    void getLength()
    {
        assertEquals(5, road.getLength());
    }

    @Test
    void getStart()
    {
        int[] expected = {0, 0};
        int[] actual = this.road.getStart();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getEnd()
    {
        int[] expected = {5, 0};
        assertArrayEquals(expected, road.getEnd());
    }

    @Test
    void getLimit()
    {
        assertEquals(1, road.getLimit());
    }

    @Test
    void getConnectedRoads()
    {
        ArrayList<Model.Road> expected = new ArrayList<>();
        assertEquals(expected, road.getConnectedRoads());
    }

    @Test
    void getRoadVehicles()
    {
        ArrayList<Model.Vehicle> expected = new ArrayList<>();
        assertEquals(expected, road.getRoadVehicles());
    }

    @Test
    void getRoadLights()
    {
        ArrayList<Model.TrafficLight> expected = new ArrayList<>();
        assertEquals(expected, road.getRoadLights());
    }
}