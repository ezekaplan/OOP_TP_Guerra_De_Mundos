package vista;

import javax.swing.*;

/**
 * Created by Nicolás on 08/07/2017.
 */
public class VistaError extends JDialog {

    public VistaError(JFrame parent, boolean modal, String mensaje){
        this.setTitle("Error");
        this.setSize(200, 200);
        this.setLocation(100, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel message = new JLabel(mensaje);
        message.setBounds(10, 10, 200, 30);
        this.add(message);
    }
}
