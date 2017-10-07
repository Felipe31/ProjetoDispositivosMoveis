package br.com.rocheikoaresalfabooks.alfabooks;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;

/**
 * Created by felipesoares on 06/10/17.
 */

public class BancoTemporario {
    private static final BancoTemporario ourInstance = new BancoTemporario();
    private ArrayList<ItensCarrinhoSerializable> dataSet;
    private ArrayList<ItensCarrinhoSerializable> carrinho;
    public static BancoTemporario getInstance() {
        return ourInstance;
    }

    private BancoTemporario() {
        dataSet = new ArrayList<>();
        carrinho = new ArrayList<>();
    }
    public void addItemCarrinho(ItensCarrinhoSerializable it){
        carrinho.add(it);
    }
    public void remItemCarrinho(ItensCarrinhoSerializable it){
        carrinho.remove(it);
    }

    public ArrayList<ItensCarrinhoSerializable> getItensCarrinho() {
        return carrinho;
    }
}
