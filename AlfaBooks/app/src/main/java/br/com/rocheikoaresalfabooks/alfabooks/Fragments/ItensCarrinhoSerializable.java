package br.com.rocheikoaresalfabooks.alfabooks.Fragments;

import java.io.Serializable;

/**
 * Created by felipesoares on 26/09/17.
 */

public class ItensCarrinhoSerializable implements Serializable {

    private String nome;
    private int qtd;

    public ItensCarrinhoSerializable(String nome, int qtd){
        this.nome=nome;
        this.qtd=qtd;

    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }
}
