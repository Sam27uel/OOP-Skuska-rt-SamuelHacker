package sk.stuba.fei.uim.oop.drawing;

import javax.swing.*;
import java.awt.*;

public class DrawArea extends JPanel {

    private ChainShape chainShape;

    public DrawArea(int length, int space, int shapeRadius, int shapeID) {
        this.chainShape = new ChainShape(length, space, shapeRadius, shapeID);
    }

    public void setChainShapeId(int id){
        this.chainShape.setChainShapeId(id);
        this.chainShape.changeShapes();

        repaint();
    }
    public void setChainLength(int length){
        this.chainShape.setChainLength(length);

        super.repaint();
    }

    public void setChainSpace(int space){
        this.chainShape.setChainSpace(space);
        super.repaint();
    }

    public void setChainRadius(int radius){
        this.chainShape.setChainRadius(radius);
        this.chainShape.changeChainShapesRadius();

        super.repaint();
    }
    public void addNewShape(int x, int y){
        this.chainShape.addShape(x,y);
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.chainShape.draw(g);
    }
}
