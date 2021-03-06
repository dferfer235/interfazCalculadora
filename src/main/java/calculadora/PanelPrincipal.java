package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Juan Carlos Fernández Vico
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    boolean suma = false, resta = false, multiplicar = false, dividir = false;
    int num1 = 0, num2 = 0;
    int turno = 1;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    private void limpiar() {
        num1 = 0;
        num2 = 0;
        turno = 1;
        suma = false;
        resta = false;
        multiplicar = false;
        dividir = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTexto.setText(((JButton) o).getText());

            try {
                if (turno == 1) {
                    num1 = Integer.valueOf((((JButton) o).getText()));
                } else {
                    num2 = Integer.valueOf((((JButton) o).getText()));
                }

            } catch (Exception e) {
                if (((JButton) o).getText().equalsIgnoreCase("+")) {
                    suma = true;
                    resta = false;
                    multiplicar = false;
                    dividir = false;
                    turno++;
                }
                if (((JButton) o).getText().equalsIgnoreCase("-")) {
                    suma = false;
                    resta = true;
                    multiplicar = false;
                    dividir = false;
                    turno++;
                }
                if (((JButton) o).getText().equalsIgnoreCase("*")) {
                    suma = false;
                    resta = false;
                    multiplicar = true;
                    dividir = false;
                    turno++;
                }
                if (((JButton) o).getText().equalsIgnoreCase("/")) {
                    suma = false;
                    resta = false;
                    multiplicar = false;
                    dividir = true;
                    turno++;
                }
            }

            if (((JButton) o).getText().equalsIgnoreCase("=")) {
                if (suma) {
                    int RSuma = num1 + num2;
                    System.out.println("Resultado:" + num1 + "+" + num2 + "=" + RSuma);
                }
                if (resta) {
                    int RResta = num1 - num2;
                    System.out.println("Resultado:" + num1 + "-" + num2 + "=" + RResta);
                }
                if (multiplicar) {
                    double RMultiplicacion = num1 * num2;
                    System.out.println("Resultado:" + num1 + "*" + num2 + "=" + RMultiplicacion);
                }
                if (dividir) {
                    if (num2 == 0) {
                        System.out.println("Ni lo sueñes...");
                        System.out.println("No se puede dividir entre 0");
                    } else {
                        int RDivision = num1 / num2;
                        double resto = num1 % num2;
                        System.out.println("Resultado:" + num1 + "/" + num2 + "=" + RDivision);
                        System.out.println("Resto = " + resto);
                    }

                }

                limpiar();
            }
            if (((JButton) o).getText().equalsIgnoreCase("c")) {
                limpiar();
            }
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
    }

}
