package br.com.gourmet.test;

import br.com.gourmet.controller.AdivinhacaoPratoController;
import br.com.gourmet.model.Prato;
import br.com.gourmet.view.window.JanelaPrincipal;

import java.util.LinkedList;
import java.util.Queue;

public class Teste {

    public static void main(String[] args) {
        Queue<Prato> pratos = inicializarPratos();

        AdivinhacaoPratoController adivinhacaoPrato = new AdivinhacaoPratoController();

        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.getButton().addActionListener(listener -> {
            adivinhacaoPrato.adivinharPrato(pratos);
        });
    }

    private static Queue<Prato> inicializarPratos() {
        Queue<Prato> pratos = new LinkedList<>();

        Prato massa = new Prato("Massa");
        Prato lasanha = new Prato("Lasanha");
        massa.addPratoFilho(lasanha);

        pratos.add(massa);

        Prato bolo = new Prato("Bolo de Chocolate");
        pratos.add(bolo);

        return pratos;
    }
}
