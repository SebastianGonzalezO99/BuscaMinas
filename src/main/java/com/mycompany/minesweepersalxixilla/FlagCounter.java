/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minesweepersalxixilla;

import static com.mycompany.minesweepersalxixilla.MineButton.BUTTON_SIZE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alu13114532
 */
public class FlagCounter extends JPanel implements FlagPanelInterface {
    
    private JTextField textField;
    private int countFlags;
    
    public FlagCounter() {
        setLayout(new FlowLayout());
        Image image = new ImageIcon(getClass().getResource("/images/flag.png")).getImage();
        Image flagImage = image.getScaledInstance(BUTTON_SIZE, BUTTON_SIZE, java.awt.Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(flagImage);
        JLabel labelFlag = new JLabel(icon);
        add(labelFlag);
        textField = new JTextField("0");
        reset();
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(Color.black);
        textField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        textField.setForeground(Color.red);
        textField.setPreferredSize(new Dimension(80, 30));
        add(textField);
    }
    
    public void addOne() {
        countFlags++;
        textField.setText("" + countFlags);
    }
    
    public void decrementOne() {
        if (countFlags > 0) {
            countFlags--;
            textField.setText("" + countFlags);
        }
    }
    
    public void reset(){
        countFlags = ConfigData.getInstance().getNumBombs();
        textField.setText(""+ countFlags);
    }
    
    public int getNumFlags(){
        return countFlags;
    }
    
}
