package br.com.gourmet.view.dialog;

import javax.swing.*;

public class DialogoAcerto implements Dialogo {

    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, "Acertei de novo!",
                "Confirm", JOptionPane.INFORMATION_MESSAGE);
    }
}
