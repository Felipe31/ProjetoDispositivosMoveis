package br.com.rocheikoaresalfabooks.alfabooks.Fragments;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivroSerializable implements Serializable {

    private String titulo;
    private String descricao;
    private float valor;
    private Image image;

    public LivroSerializable (String titulo, String descricao, float valor, Image image){
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.image = image;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }

    public Image getImage() {
        return image;
    }
}
