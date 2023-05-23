package sk.stuba.fei.uim.oop.drawing;

import java.awt.*;

public class Circle extends Shape{

    public Circle(int x,int y,int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graph) {
        super.draw(graph);
        graph.setColor(this.color);

        graph.fillOval(this.x-radius / 2,this.y -radius / 2, this.radius, this.radius);
    }
}
