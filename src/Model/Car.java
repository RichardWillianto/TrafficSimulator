package Model;

public class Car extends Vehicle
{
    public Car(String id, Road currentRoad)
    {
        super(currentRoad);
        this.id = "Car: " + id;
        setLength(super.getLength());
        width = length / 2;
        position = -length;
    }
}
