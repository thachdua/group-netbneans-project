/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;

public class OpenPdf {
    public OpenPdf() {
    }

    public static void openById(String id) {
        try {
            if ((new File("D:\\" + id + ".pdf")).exists()) {
                Process var1 = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\" + id + ".pdf");
            } else {
                JOptionPane.showMessageDialog((Component)null, "File does not exists");
            }
        } catch (Exception var2) {
            JOptionPane.showMessageDialog((Component)null, var2);
        }

    }
}

