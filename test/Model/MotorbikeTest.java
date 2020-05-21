package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MotorbikeTest
{
    Model.Road road = new Model.Road("0", 1, new int[]{0, 0}, 5 , Road.Orientation.VERTICAL);
    Model.Motorbike motorbike = new Model.Motorbike("0", road);

    @Test
    void getId()
    {
        assertEquals("Motorbike: 0", motorbike.getId());
    }

    @Test
    void getLength()
    {
        assertEquals(2, motorbike.getLength());
    }

    @Test
    void getWidth()
    {
        assertEquals(1, motorbike.getWidth());
    }

    @Test
    void getSpeed()
    {
        assertEquals(0, motorbike.getSpeed());
    }

    @Test
    void getPosition()
    {
        assertEquals(-2, motorbike.getPosition());
    }

    @Test
    void getCurrentRoad()
    {
        assertEquals(road, motorbike.getCurrentRoad());
    }

    @Test
    void testDrive()
    {
        motorbike.drive();
        assertEquals(-1, motorbike.getPosition());
    }
}