package br.com.gourmet.view.dialog;

import javax.swing.*;

public class DialogoCategorizacaoPrato implements DialogoEntrada {

    private String mensagem;

    public DialogoCategorizacaoPrato comMensagem(final String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    @Override
    public String mostrarELerValor() {
        return JOptionPane.showInputDialog(null,
                mensagem, "Complete", JOptionPane.QUESTION_MESSAGE);
    }
}
