package sk.stuba.fei.uim.oop.drawing;

import java.awt.*;
import java.util.ArrayList;

public class ChainShape {
    private ArrayList<Shape> listShapes;
    private int x;
    private int y;

    private int chainRadius;

    private int chainLength;

    private int chainSpace;

    private int chainShapeId;

    private Color headColor = Color.YELLOW;
    private Color tailColor = Color.BLUE;
    public ChainShape(int chainLength, int spacing, int shapeRadius, int shapeId) {
        this.listShapes = new ArrayList<>();
        this.chainLength = chainLength;
        this.chainSpace = spacing;
        this.chainRadius = shapeRadius;
        this.chainShapeId = shapeId;
    }

    public void setChainSpace(int space) {
        this.chainSpace = space;
    }

    public void setChainRadius(int radius) {
        this.chainRadius = radius;
    }

    public void setChainLength(int length) {
        this.chainLength = length;
    }

    public void setChainShapeId(int id) {
        this.chainShapeId = id;
    }

    public void addShape(int x,int y){

        this.x = x;
        this.y = y;

        this.addShape();

        this.changeChainShapesRadius();
        this.setColors();
        this.deleteExceededShapes();
    }

    private void deleteExceededShapes(){
        if(this.listShapes.size() > chainLength){
            this.listShapes.remove(0);
        }
    }
    private void addShape(){
        switch (this.chainShapeId){
            case 0:
                this.listShapes.add(new Circle(this.x, this.y, this.chainRadius));
                break;
            case 1:
                this.listShapes.add(new Square(this.x, this.y, this.chainRadius));
                break;
            case 2:
                this.listShapes.add(new SandGlass(this.x, this.y, this.chainRadius));
                break;
        }
    }

    public void changeChainShapesRadius(){
        for (Shape s: this.listShapes) {
            s.setRadius(this.chainRadius);
        }
    }
    public void changeShapes(){
        ArrayList<Shape> listNewShapes = new ArrayList<>();

        for (Shape s: this.listShapes) {
            switch (this.chainShapeId){
                case 0:
                    listNewShapes.add(new Circle(s.getX(),s.getY(),this.chainRadius));
                    break;
                case 1:
                    listNewShapes.add(new Square(s.getX(),s.getY(),this.chainRadius));
                    break;
                case 2:
                    listNewShapes.add(new SandGlass(s.getX(),s.getY(),this.chainRadius));
                    break;
            }
        }

        this.listShapes.clear();
        this.listShapes = listNewShapes;
        this.setColors();
    }

    private void setColors() {
        int cntShapes = this.listShapes.size();

        int redDiffer = tailColor.getRed() - headColor.getRed();
        int greenDiffer = tailColor.getGreen() - headColor.getGreen();
        int blueDiffer = tailColor.getBlue() - headColor.getBlue();

        for (int i = 0; i < cntShapes; i++) {
            Shape shape = this.listShapes.get(i);

            int red = headColor.getRed() + (int) (i * (double) redDiffer / (cntShapes - 1));
            int green = headColor.getGreen() + (int) (i * (double) greenDiffer / (cntShapes - 1));
            int blue = headColor.getBlue() + (int) (i * (double) blueDiffer / (cntShapes - 1));

            Color gradient = new Color(red, green, blue);

            shape.setColor(gradient);
        }
    }
    public void draw(Graphics g){
        int counter = 1;
        g.setColor(Color.blue);

        for (Shape s : this.listShapes) {
            counter++;

            if (counter % this.chainSpace == 0) {;
                s.draw(g);
            }
        }

    }

}
