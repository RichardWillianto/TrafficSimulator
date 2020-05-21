package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BusTest
{
    Model.Road road = new Model.Road("0", 1, new int[]{0, 0}, 5 , Road.Orientation.VERTICAL);
    Model.Bus bus = new Model.Bus("0", road);

    @Test
    void getId()
    {
        assertEquals("Bus: 0", bus.getId());
    }

    @Test
    void getLength()
    {
        assertEquals(12, bus.getLength());
    }

    @Test
    void getWidth()
    {
        assertEquals(2, bus.getWidth());
    }

    @Test
    void getSpeed()
    {
        assertEquals(0, bus.getSpeed());
    }

    @Test
    void getPosition()
    {
        assertEquals(-12, bus.getPosition());
    }

    @Test
    void getCurrentRoad()
    {
        assertEquals(road, bus.getCurrentRoad());
    }

    @Test
    void testDrive()
    {
        bus.drive();
        assertEquals(-11, bus.getPosition());
    }
}