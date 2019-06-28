package br.com.gourmet.test;

import br.com.gourmet.controller.AdivinhacaoPratoController;
import br.com.gourmet.model.Prato;
import br.com.gourmet.view.window.JanelaPrincipal;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        List<Prato> pratos = inicializarPratos();
        AdivinhacaoPratoController adivinhacaoPrato = new AdivinhacaoPratoController();

        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.getButton().addActionListener(listener -> {
            adivinhacaoPrato.adivinharPrato(pratos);
        });
    }

    private static List<Prato> inicializarPratos() {
        List<Prato> pratos = new ArrayList<>();

        Prato massa = new Prato("Massa");
        Prato lasanha = new Prato("Lasanha");
        massa.addPratoFilho(lasanha);

        pratos.add(massa);

        Prato bolo = new Prato("Bolo de Chocolate");
        pratos.add(bolo);
        return pratos;
    }
}
