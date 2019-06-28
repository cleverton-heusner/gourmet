package br.com.gourmet.view.window;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private JButton button;

    public JanelaPrincipal() {
        configurarJanela();
        adicionarLabel();
        adicionarBotao();
    }

    private void configurarJanela() {
        super.setTitle("Gourmet - Cleverton Heusner");
        super.setVisible(true);
        super.setSize(400, 200);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void adicionarLabel() {
        JLabel label = new JLabel("Pense em um prato que gosta");
        super.add(label);
    }

    private void adicionarBotao() {
        button = new JButton("OK");
        button.setSize(300, 300);
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        super.add(button);
    }

    public JButton getButton() {
        return button;
    }
}
