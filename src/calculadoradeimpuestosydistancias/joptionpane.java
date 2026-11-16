/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoradeimpuestosydistancias;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class joptionpane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UIManager.put("OptionPane.background",new Color(0,0,0));
        UIManager.put("Panel.background", new Color(102, 0, 0));
        UIManager.put("Buttton.foreground", new Color(0,0,0));
        JOptionPane.showMessageDialog(null, "No ingresó un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
