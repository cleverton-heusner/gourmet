package br.com.gourmet.view.dialog;

import javax.swing.*;

public class DialogoDesistenciaAdivinhacao implements DialogoEntrada {

    @Override
    public String mostrarELerValor() {
        return JOptionPane.showInputDialog(null,
                "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
    }
}
