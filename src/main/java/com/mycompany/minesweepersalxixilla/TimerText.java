/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minesweepersalxixilla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author alu13114532
 */
public class TimerText extends JTextField implements TimerInterface{
    
    private Timer timer;
    private int sec;
    private int min;
    
    public TimerText() {
        sec = 0;
        min = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(sec > 59) {
                    sec = 0;
                    min++;
                } else {
                    sec++;
                }
                displayTiem();
            }
        });
    }
    
    @Override
    public void start() {
        if(!timer.isRunning()) {
        timer.start();
        }
    }
    
    @Override
    public void stop() {
        if(timer.isRunning()) {
        timer.stop();
        }
    }
    
    @Override
    public void reset() {
        timer.stop();
        sec = 0;
        min = 0;
        displayTiem();
    }
    
    private void displayTiem(){
        setText((min < 10 ? "0" : "") + min + ":" + 
                (sec < 10 ? "0" : "" ) + sec);
    }
}
