package br.com.gourmet.controller;

import br.com.gourmet.model.Prato;
import br.com.gourmet.view.dialog.DialogoAcerto;
import br.com.gourmet.view.dialog.DialogoCategorizacaoPrato;
import br.com.gourmet.view.dialog.DialogoDesistenciaAdivinhacao;
import br.com.gourmet.view.dialog.DialogoTentativaAdivinhacao;

import java.util.List;

public class AdivinhacaoPratoController {

    public void adivinharPrato(final List<Prato> pratos) {
        for (int i = 0; i < pratos.size(); i++) {
            String mensagemDialogoAdivinhacao = String.format("O prato que você pensou é %s?", pratos.get(i).getNome());
            int resp = new DialogoTentativaAdivinhacao().mostrarEObterResposta(mensagemDialogoAdivinhacao);

            if (resp == DialogoTentativaAdivinhacao.SIM) {
                if (pratos.get(i).getPratos().isEmpty()) {
                    new DialogoAcerto().mostrar();
                } else {
                    adivinharPrato(pratos.get(i).getPratos());
                    break;
                }
            } else if (i == pratos.size() - 1) {
                String nomePratoEscolhio = new DialogoDesistenciaAdivinhacao().mostrarELerValor();

                String mensagemDialogo = String.format("%s é ______, mas %s não.", nomePratoEscolhio, pratos.get(i).getNome());
                String nomePratoPaiEscolhido = new DialogoCategorizacaoPrato().comMensagem(mensagemDialogo)
                        .mostrarELerValor();

                Prato pratoEscolhido = new Prato(nomePratoEscolhio);
                Prato pratoPaiEscolhido = new Prato(nomePratoPaiEscolhido);
                pratoPaiEscolhido.addPratoFilho(pratoEscolhido);
                pratos.add(pratoPaiEscolhido);
                break;
            }
        }
    }
}
