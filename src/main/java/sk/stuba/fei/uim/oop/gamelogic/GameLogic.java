package sk.stuba.fei.uim.oop.gamelogic;

import sk.stuba.fei.uim.oop.drawing.DrawArea;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

public class GameLogic extends UniversalAdapter {
    private JLabel lblLength;
    private JLabel lblRadius;
    private JLabel lblSpace;
    private JSlider sldLength;
    private JSlider sldRadius;
    private JSlider sldSpace;

    private JComboBox cbShape;

    private DrawArea drawArea;

    private int actualShapeId;

    public GameLogic(){
        this.lblLength = new JLabel("Length");
        this.lblLength.setFocusable(false);

        this.lblRadius = new JLabel("Radius");
        this.lblRadius.setFocusable(false);

        this.lblSpace = new JLabel("Spacing");
        this.lblSpace.setFocusable(false);

        this.sldLength = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        this.sldLength.setMajorTickSpacing(10);
        this.sldLength.setSnapToTicks(true);
        this.sldLength.setPaintTicks(true);
        this.sldLength.setPaintLabels(true);

        this.sldLength.setFocusable(false);
        this.sldLength.addChangeListener(this);

        this.sldRadius = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        this.sldRadius.setMajorTickSpacing(1);
        this.sldRadius.setSnapToTicks(true);
        this.sldRadius.setPaintTicks(true);
        this.sldRadius.setPaintLabels(true);

        this.sldRadius.setFocusable(false);
        this.sldRadius.addChangeListener(this);

        this.sldSpace = new JSlider(JSlider.VERTICAL,1,20,5);
        this.sldSpace.setMajorTickSpacing(1);
        this.sldSpace.setSnapToTicks(true);
        this.sldSpace.setPaintTicks(true);
        this.sldSpace.setPaintLabels(true);

        this.sldSpace.setFocusable(false);
        this.sldSpace.addChangeListener(this);

        this.cbShape = new JComboBox<>();
        this.cbShape.addItem("Circle");
        this.cbShape.addItem("Square");
        this.cbShape.addItem("SandHour");
        this.cbShape.addItemListener(this);
        this.cbShape.setFocusable(false);

        this.cbShape.setSelectedIndex(0);
        this.actualShapeId = 0;

        this.drawArea = new DrawArea(this.sldLength.getValue(), this.sldRadius.getValue(), this.sldSpace.getValue(), actualShapeId);
        this.drawArea.setBackground(Color.ORANGE);
        this.drawArea.addMouseMotionListener(this);
        this.drawArea.addMouseListener(this);
    }

    public DrawArea getDrawArea()
    {
        return drawArea;
    }
    public JLabel getLengthLabel()
    {
        return this.lblLength;
    }

    public JLabel getRadiusLabel()
    {
        return this.lblRadius;
    }

    public JLabel getSpacingLabel()
    {
        return this.lblSpace;
    }

    public JSlider getLengthSlider()
    {
        return this.sldLength;
    }
    public JSlider getRadiusSlider()
    {
        return this.sldRadius;
    }

    public JSlider getSpacingSlider() {
        return this.sldSpace;
    }

    public JComboBox getComboBoxShape()
    {
        return this.cbShape;
    }

    private void getActualShapeId(String s){
        switch (s){
            case "Circle":
                this.actualShapeId = 0;
                break;
            case "Square":
                this.actualShapeId = 1;
                break;
            case "SandHour":
                this.actualShapeId = 2;
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.drawArea.addNewShape(e.getX(),e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.drawArea.addNewShape(e.getX(),e.getY());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == this.cbShape){
            this.getActualShapeId(e.getItem().toString());
            this.drawArea.setChainShapeId(this.actualShapeId);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.sldLength){
            this.drawArea.setChainLength(this.sldLength.getValue());
        }

        if(e.getSource() == this.sldRadius){

            this.drawArea.setChainRadius(this.sldRadius.getValue());
        }

        if(e.getSource() == this.sldSpace){
            this.drawArea.setChainSpace(this.sldSpace.getValue());
        }
    }
}
