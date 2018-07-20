/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeptoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

/**
 *
 * @author oXCToo
 */
public class KTextField  extends JTextField{
    
    private KTextField()
    {
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setBorder(new MatteBorder(new Insets(0, 0, 1, 0), Color.yellow));
        //setBackground(SwingUtilities.getRoot(KTextField.this).getBackground());
        
    }
    
    
}
