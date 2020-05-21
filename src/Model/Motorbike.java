package Model;

public class Motorbike extends Vehicle
{
    public Motorbike(String id, Road currentRoad)
    {
        super(currentRoad);
        this.id = "Motorbike: " + id;
        setLength(super.getLength() / 2);
        width = super.getWidth() / 2;
        position = -length;
    }
}
