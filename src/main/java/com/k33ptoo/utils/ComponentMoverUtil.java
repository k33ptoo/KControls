/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k33ptoo.utils;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 *
 * @author ----
 * Updated by KeepToo 2021
 */
public class ComponentMoverUtil {

    private static int xx, xy;
    private static int locationX, locationY;

    public static void moveComponent(JFrame frame, final Component component) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                xx = arg0.getX();
                xy = arg0.getY();
            }

        });
        component.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                int x = arg0.getXOnScreen();
                int y = arg0.getYOnScreen();
                int newlocationX = x - xx;
                int newlocationY = y - xy;
                component.setLocation(newlocationX, newlocationY);
                //for location saving
                setLocationX(newlocationX);
                setLocationY(newlocationY);
            }
        });
    }

    public static void moveFrame(final JFrame frame, final boolean allowMaximize, Component... components) {
        for (Component component : components) {
            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent arg0) {
                    xx = arg0.getX();
                    xy = arg0.getY();
                }

                @Override
                public void mouseClicked(MouseEvent e) {

                    //maximize
                    if (allowMaximize == true) {
                        if (e.getClickCount() == 2 && !e.isConsumed()) {
                            e.consume();
                            if (frame.getExtendedState() == Frame.MAXIMIZED_BOTH) {
                                frame.setExtendedState(JFrame.NORMAL);
                            } else {
                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            }
                        }
                    }

                }

            });
            component.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent arg0) {
                    int x = arg0.getXOnScreen();
                    int y = arg0.getYOnScreen();
                    frame.setLocation(x - xx, y - xy);
                }
            });
        }
    }

    public static int getLocationX() {
        return locationX;
    }

    public static void setLocationX(int locationX) {
        ComponentMoverUtil.locationX = locationX;
    }

    public static int getLocationY() {
        return locationY;
    }

    public static void setLocationY(int locationY) {
        ComponentMoverUtil.locationY = locationY;
    }

}
