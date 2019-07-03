package br.com.gourmet.controller;

import br.com.gourmet.model.Prato;
import br.com.gourmet.view.dialog.DialogoAcerto;
import br.com.gourmet.view.dialog.DialogoCategorizacaoPrato;
import br.com.gourmet.view.dialog.DialogoDesistenciaAdivinhacao;
import br.com.gourmet.view.dialog.DialogoTentativaAdivinhacao;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class AdivinhacaoPratoController {

    private Prato prato;

    public void adivinharPrato(final Queue<Prato> pratos) {
        Iterator<Prato> iterator = ordenarPratosPorFilhos(pratos).iterator();

        while (iterator.hasNext()) {
            prato = iterator.next();
            int resp = new DialogoTentativaAdivinhacao().mostrarEObterResposta(getMensagemDialogoAdivinhacao());

            if (resp == DialogoTentativaAdivinhacao.SIM) {
                if (prato.getPratosFilhos().isEmpty()) {
                    new DialogoAcerto().mostrar();
                } else {
                    adivinharPrato(prato.getPratosFilhos());
                }
                break;
            } else if (!iterator.hasNext()) {
                String nomePratoEscolhio = new DialogoDesistenciaAdivinhacao().mostrarELerValor();
                String nomePratoPaiEscolhido = new DialogoCategorizacaoPrato()
                        .comMensagem(getMensagemDialogoCategorizacao(nomePratoEscolhio))
                        .mostrarELerValor();

                Prato pratoEscolhido = new Prato(nomePratoEscolhio);
                Prato pratoPaiEscolhido = new Prato(nomePratoPaiEscolhido);
                pratoPaiEscolhido.addPratoFilho(pratoEscolhido);
                pratos.add(pratoPaiEscolhido);
                break;
            }
        }
    }

    private Queue<Prato> ordenarPratosPorFilhos(final Queue<Prato> pratos) {
        return pratos.stream()
                .sorted(Comparator.comparing(Prato::getPratosFilhos, Comparator.comparing(p -> p.isEmpty())))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private String getMensagemDialogoAdivinhacao() {
        return String.format("O prato que você pensou é %s?", prato.getNome());
    }

    private String getMensagemDialogoCategorizacao(final String nomePratoEscolhio) {
        return String.format("%s é ______, mas %s não.", nomePratoEscolhio, prato.getNome());
    }
}