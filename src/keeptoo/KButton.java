/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import com.sun.glass.ui.Size;
import com.sun.org.apache.regexp.internal.recompile;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @auauthor oXCToo
 */
public class KButton extends JButton {

    public Color kBackGroundColor = Color.magenta;
    public Color kStartColor = new Color(0, 153, 153);
    public Color kEndColor = Color.GREEN;
    public Color kHoverStartColor = new Color(255, 0, 255);
    public Color kHoverEndColor = Color.green;
    public Color kHoverColor = Color.white;
    public Color kHoverForeGround = Color.magenta;
    public boolean kAllowGradient = true;
    public int kBorderRadius = 10;
    private boolean mouseExited = false;
    private boolean mouseEntered = false;
    private boolean mousePressed = false;
    private boolean mouseReleased = false;
    public boolean kFillButton = true;
    public Color kForeGround = Color.white;
    public Color kSelectedColor = Color.magenta;
    public Color kPressedColor = Color.LIGHT_GRAY;
    public int kIndicatorThickness = 2;
    public Color kIndicatorColor = Color.white;
    public boolean kAllowTab = true;

    public boolean iskAllowTab() {
        return kAllowTab;
    }

    public void setkAllowTab(boolean kAllowTab) {
        this.kAllowTab = kAllowTab;
    }

    public int getkIndicatorThickness() {
        return kIndicatorThickness;
    }

    public void setkIndicatorThickness(int kIndicatorThickness) {
        this.kIndicatorThickness = kIndicatorThickness;

    }

    public Color getkIndicatorColor() {
        return kIndicatorColor;
    }

    public void setkIndicatorColor(Color kIndicatorColor) {
        this.kIndicatorColor = kIndicatorColor;
    }

    public Color getkPressedColor() {
        return kPressedColor;
    }

    public void setkPressedColor(Color kPressedColor) {
        this.kPressedColor = kPressedColor;
    }

    public Color getkSelectedColor() {
        return kSelectedColor;
    }

    public void setkSelectedColor(Color kSelectedColor) {
        this.kSelectedColor = kSelectedColor;
    }

    public Color getkForeGround() {
        return kForeGround;
    }

    public void setkForeGround(Color kForeGround) {
        this.kForeGround = kForeGround;

    }

    public Color getkBackGroundColor() {
        return kBackGroundColor;
    }

    public void setkBackGroundColor(Color kBackGroundColor) {
        this.kBackGroundColor = kBackGroundColor;
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

    public Color getkHoverStartColor() {
        return kHoverStartColor;
    }

    public void setkHoverStartColor(Color kHoverStartColor) {
        this.kHoverStartColor = kHoverStartColor;
    }

    public Color getkHoverEndColor() {
        return kHoverEndColor;
    }

    public void setkHoverEndColor(Color kHoverEndColor) {
        this.kHoverEndColor = kHoverEndColor;
    }

    public Color getkHoverColor() {
        return kHoverColor;
    }

    public void setkHoverColor(Color kHoverColor) {
        this.kHoverColor = kHoverColor;
    }

    public Color getkHoverForeGround() {
        return kHoverForeGround;
    }

    public void setkHoverForeGround(Color kHoverForeGround) {
        this.kHoverForeGround = kHoverForeGround;
    }

    public boolean iskAllowGradient() {
        return kAllowGradient;
    }

    public void setkAllowGradient(boolean kAllowGradient) {
        this.kAllowGradient = kAllowGradient;
    }

    public int getkBorderRadius() {
        return kBorderRadius;
    }

    public void setkBorderRadius(int kBorderRadius) {
        this.kBorderRadius = kBorderRadius;
    }

    public boolean iskFillButton() {
        return kFillButton;
    }

    public void setkFillButton(boolean kFillButton) {
        this.kFillButton = kFillButton;
    }

    public KButton() {

        this.setPreferredSize(new Dimension(185, 45));
        this.setForeground(Color.white);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                if (contains(me.getX(), me.getY())) {
                    mouseEntered = true;
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseExited = false;
                mouseEntered = false;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                mouseReleased = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                mouseReleased = false;
            }

        };
        addMouseListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (mousePressed == true) {
            g2.setPaint(kPressedColor);
            if (iskAllowTab()) {
                Component[] comp = getParent().getComponents();
                for (int i = 0; i < comp.length; i++) {
                    if (comp[i] instanceof KButton) {

                        ((KButton) comp[i]).setSelected(false);
                        ((KButton) comp[i]).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, kIndicatorColor));
                    }
                }
                this.setBorder(BorderFactory.createMatteBorder(0, kIndicatorThickness, 0, 0, kIndicatorColor));
                this.setSelected(true);
            }

        } else {
            if (kAllowGradient == true) {
                GradientPaint gp = new GradientPaint(0, 0, kStartColor, 300, getHeight(), kEndColor);
                g2.setPaint(gp);
                setForeground(kForeGround);
                if (mouseEntered) {
                    gp = new GradientPaint(0, 0, kHoverStartColor, 300, getHeight(), kHoverEndColor);
                    g2.setPaint(gp);
                    setForeground(kHoverForeGround);
                } else if (mouseExited) {
                    gp = new GradientPaint(0, 0, kStartColor, 300, getHeight(), kEndColor);
                    g2.setPaint(gp);
                    setForeground(kForeGround);
                }

            } else {

                if (mouseEntered) {
                    g2.setPaint(kHoverColor);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), kBorderRadius, kBorderRadius);
                    setForeground(kHoverForeGround);
                } else if (mouseExited) {
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, kBorderRadius, kBorderRadius);
                    g2.setPaint(kBackGroundColor);
                    setForeground(kForeGround);

                } else {
                    g2.setPaint(kBackGroundColor);
                }

            }
        }
        // g2.fillRect(0, 0, getWidth(), getHeight());
        if (isSelected()) {
            g2.setPaint(kSelectedColor);
            setForeground(kForeGround);
        }
        if (kFillButton == true) {
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), kBorderRadius, kBorderRadius);
        }
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, kBorderRadius, kBorderRadius);
        // The drawString(string) must be put after the setPaint(gradient)
        g2.setPaint(Color.BLACK);
        centerString(g, new Rectangle(getWidth(), getHeight()), getText(), getFont());

        // draw account
//        try {
//            getIcon().paintIcon(this, g2, getHeight()/2, 4);
//        } catch (Exception e) {
//        }
        drawIcons(g, new Rectangle(0, 0, getWidth(), getHeight()));
        //dispose
        g2.dispose();

    }

    public void centerString(Graphics g, Rectangle r, String s,
            Font font) {
        FontRenderContext frc
                = new FontRenderContext(null, true, true);

        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }

    public void drawIcons(Graphics g, Rectangle r) {

        try {
            FontRenderContext frc
                    = new FontRenderContext(null, true, true);

            Rectangle2D r2D = getFont().getStringBounds(getText(), frc);
            int rWidth = (int) Math.round(r2D.getWidth());
            int rHeight = (int) Math.round(r2D.getHeight());
            int rX = (int) Math.round(r2D.getX());
            int rY = (int) Math.round(r2D.getY());

            int a = (r.width / 2) - (rWidth / 2) - rX;
            int b = (r.height / 2) - (rHeight / 2) - rY;

            getIcon().paintIcon(this, g, getIconTextGap(), (getHeight() / 3));

//            if (getIcon().getIconHeight() > getHeight() / 2) {
//                int zoomLevel = 10;
//                int newImageWidth = getIcon().getIconWidth() * zoomLevel;
//                int newImageHeight = getIcon().getIconHeight() * zoomLevel;
//                BufferedImage resizedImage = new BufferedImage(newImageWidth, newImageHeight, 0);
//                 resizedImage.createGraphics();
//                g.drawImage((Image) getIcon(), 0, 0, newImageWidth, newImageHeight, null);
//              
//            }
        } catch (Exception e) {
        }

    }

}
