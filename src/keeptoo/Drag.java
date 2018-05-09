/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author oXCToo
 */
public class Drag {

    private final JComponent component;
    private static int posX, posY = 0;

    public Drag(JComponent component) {
        this.component = component;
    }

    public void onPress(java.awt.event.MouseEvent evt) {
        posX = evt.getX();
        posY = evt.getY();
    }

    public void moveWindow(java.awt.event.MouseEvent evt) {
        SwingUtilities.getRoot(component).setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }
}
