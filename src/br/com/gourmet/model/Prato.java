package br.com.gourmet.model;

import java.util.ArrayList;
import java.util.List;

public class Prato {

    private String nome;
    private List<Prato> pratos = new ArrayList<>();

    public Prato() {
    }

    public Prato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addPratoFilho(Prato prato) {
        this.pratos.add(prato);
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("br.com.gourmet.model.Prato{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", pratos=").append(pratos);
        sb.append('}');
        return sb.toString();
    }
}
