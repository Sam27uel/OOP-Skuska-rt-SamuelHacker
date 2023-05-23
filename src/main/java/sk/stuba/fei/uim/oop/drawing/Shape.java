package sk.stuba.fei.uim.oop.drawing;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Shape {

    protected int x;

    protected int y;

    protected int radius;

    protected Color color;

    public void draw(Graphics g){
    }
    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public int getY()
    {
        return this.y;
    }

    public int getX()
    {
        return this.x;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

}
