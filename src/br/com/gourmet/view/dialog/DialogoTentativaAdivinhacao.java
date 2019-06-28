package br.com.gourmet.view.dialog;

import javax.swing.*;

public class DialogoTentativaAdivinhacao implements DialogoConfirmacao {

    public static int SIM = JOptionPane.YES_OPTION;

    @Override
    public int mostrarEObterResposta(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem,
                "Confirm", JOptionPane.YES_NO_OPTION);
    }
}
