package sk.stuba.fei.uim.oop.drawing;

import java.awt.*;

public class SandGlass extends Shape{

    public SandGlass(int x, int y, int radius) {
        this.setCoordinates(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graph) {
        super.draw(graph);

        Graphics2D graph2D = (Graphics2D)graph;
        graph2D.setColor(this.color);

        int xCoordinates[] = { this.x - radius, this.x + radius, this.x };

        int yCoordinatesUpPolygon[] = {this.y - radius / 2,this.y - radius / 2, this.y};

        int yCoordinatesDownPolygon[] = {this.y + radius / 2,this.y + radius / 2,this.y};

        graph2D.fillPolygon(xCoordinates, yCoordinatesUpPolygon,3);
        graph2D.fillPolygon(xCoordinates, yCoordinatesDownPolygon,3);
    }
}
