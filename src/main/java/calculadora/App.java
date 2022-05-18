/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author davidfdez
 */
public class App {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setBounds(250, 250, 0, 0);
        frame.add(new PanelPrincipal());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

}
