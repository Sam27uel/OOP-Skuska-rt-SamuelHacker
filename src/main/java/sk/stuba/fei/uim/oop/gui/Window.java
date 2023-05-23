package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.gamelogic.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Window
{
    public Window()
    {
        JFrame mainFrame = new JFrame("Samuel Hacker RT-OOP 115004");
        mainFrame.setSize(1000, 1000);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        JOptionPane.showMessageDialog(null,
                "Welcome in this painting canvas, choose your shape from menu and set all settings you want from sliders" +
                        "\n which represents length, radius and spacing. After you choose use mouse at yellow background and see the chain.",
                "Introduction - Drawing",
                JOptionPane.INFORMATION_MESSAGE);


        GameLogic gameLogic = new GameLogic();

        JPanel menuLabels = new JPanel();
        menuLabels.setLayout(new GridLayout(1,3));
        menuLabels.add(gameLogic.getLengthLabel());
        menuLabels.add(gameLogic.getRadiusLabel());
        menuLabels.add(gameLogic.getSpacingLabel());
        menuLabels.setFocusable(false);

        JPanel menuSliders = new JPanel();
        menuSliders.setLayout(new GridLayout(1,3));
        menuSliders.add(gameLogic.getLengthSlider());
        menuSliders.add(gameLogic.getRadiusSlider());
        menuSliders.add(gameLogic.getSpacingSlider());
        menuSliders.setFocusable(false);

        JPanel controlMenu = new JPanel();
        controlMenu.setLayout(new BorderLayout());
        controlMenu.setFocusable(false);

        controlMenu.add(menuLabels,BorderLayout.PAGE_START);
        controlMenu.add(menuSliders,BorderLayout.CENTER);
        controlMenu.add(gameLogic.getComboBoxShape(),BorderLayout.PAGE_END);

        mainFrame.add(controlMenu,BorderLayout.EAST);
        mainFrame.add(gameLogic.getDrawArea(),BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

}
