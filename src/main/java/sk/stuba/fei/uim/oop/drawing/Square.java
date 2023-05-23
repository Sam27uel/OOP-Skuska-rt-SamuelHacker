package sk.stuba.fei.uim.oop.drawing;

import java.awt.*;

public class Square extends Shape {

    public Square(int x,int y,int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graph){
        graph.setColor(this.color);
        graph.fillRect(this.x - this.radius / 2, this.y - this.radius / 2, this.radius, this.radius);
    }

}
