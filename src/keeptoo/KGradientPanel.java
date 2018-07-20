/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseMotionListener;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author oXCToo
 */
public class KGradientPanel extends JPanel {

    public Color kStartColor = Color.MAGENTA;
    public Color kEndColor = Color.BLUE;
    public boolean kTransparentControls = true;
    public int kGradientFocus = 500;
    public int kBorderRadius = 10;
    public boolean kFillBackground = true;
    
    

    public boolean iskFillBackground() {
        return kFillBackground;
    }

    public void setkFillBackground(boolean kFillBackground) {
        this.kFillBackground = kFillBackground;
    }

    public int getkBorderRadius() {
        return kBorderRadius;
    }

    public void setkBorderRadius(int kBorderRadius) {
        this.kBorderRadius = kBorderRadius;
    }

    public Color getkStartColor() {
        return kStartColor;
    }

    public void setkStartColor(Color kStartColor) {
        this.kStartColor = kStartColor;
    }

    public Color getkEndColor() {
        return kEndColor;
    }

    public void setkEndColor(Color kEndColor) {
        this.kEndColor = kEndColor;
    }

    public boolean iskTransparentControls() {
        return kTransparentControls;
    }

    public void setkTransparentControls(boolean kTransparentControls) {
        this.kTransparentControls = kTransparentControls;
    }

    public int getkGradientFocus() {
        return kGradientFocus;
    }

    public void setkGradientFocus(int kGradientFocus) {
        this.kGradientFocus = kGradientFocus;
    }

    public KGradientPanel() {

        this.setPreferredSize(new Dimension(380, 280));

        if (kTransparentControls) {
            setBg(true);
        } else {
            setBg(false);
        }

    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {
        super.addMouseMotionListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        Dimension arcs = new Dimension(kBorderRadius, kBorderRadius);

        GradientPaint gp = new GradientPaint(0, 0, kStartColor, kGradientFocus, h, kEndColor);;

        // g2d.fillRect(0, 0, w, h);
        g2d.setPaint(gp);
        if (kFillBackground == true) {
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }

        g2d.drawRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);

        //g2d.dispose();
    }

    private void setBg(boolean isOpaque) {
        Component[] components = this.getComponents();
        for (Component component : components) {

            ((JLabel) component).setOpaque(isOpaque);
            ((JCheckBox) component).setOpaque(isOpaque);
            ((JTextField) component).setOpaque(isOpaque);
            ((JPasswordField) component).setOpaque(isOpaque);
            ((JFormattedTextField) component).setOpaque(isOpaque);
            ((JToolBar) component).setOpaque(isOpaque);
            ((JRadioButton) component).setOpaque(isOpaque);

        }
    }

}
