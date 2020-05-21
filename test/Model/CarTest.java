package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest
{
    Model.Road road = new Model.Road("0", 1, new int[]{0, 0}, 5, Road.Orientation.VERTICAL);
    Model.Car car = new Model.Car("0", road);

    @Test
    void getId()
    {
        assertEquals("Car: 0", car.getId());
    }

    @Test
    void getLength()
    {
        assertEquals(4, car.getLength());
    }

    @Test
    void getWidth()
    {
        assertEquals(2, car.getWidth());
    }

    @Test
    void getSpeed()
    {
        assertEquals(0, car.getSpeed());
    }

    @Test
    void getPosition()
    {
        assertEquals(-4, car.getPosition());
    }

    @Test
    void getCurrentRoad()
    {
        assertEquals(road, car.getCurrentRoad());
    }

    @Test
    void testDrive()
    {
        car.drive();
        assertEquals(-3, car.getPosition());
    }
}