package br.com.rocheikoaresalfabooks.alfabooks.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.rocheikoaresalfabooks.alfabooks.Activities.ExibirLivroActivity;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LivroFragment extends Fragment {
    View aux = null;
    LivroSerializable livroSerializable;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        aux = inflater.inflate(R.layout.fragment_livro, container, false);

        ImageView imageView = aux.findViewById(R.id.livro_imgv);
        final TextView tituloTxtv = aux.findViewById(R.id.titulo_txtv);
        TextView descricaoTxtv = aux.findViewById(R.id.descricao_txtv);
        TextView valorTxtv = aux.findViewById(R.id.valor_livro);
        Button button = aux.findViewById(R.id.add_carrinho_btn);

        livroSerializable = (LivroSerializable) this.getArguments().get("livro");
        boolean onclick = (boolean) this.getArguments().get("onclick");

        String descricao = (boolean) this.getArguments().get("breve")? livroSerializable.getDescricaoBreve() : livroSerializable.getDescricaoLonga();

        imageView.setImageBitmap(livroSerializable.getBitmap());
        tituloTxtv.setText(livroSerializable.getTitulo());
        descricaoTxtv.setText(descricao);
        valorTxtv.setText(String.format("R$%.2f", livroSerializable.getValor()));

//        button.setTag(livroSerializable);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ItensCarrinhoSerializable it = new ItensCarrinhoSerializable(livroSerializable.getId(), livroSerializable.getTitulo(), 1, livroSerializable.getValor());

                Snackbar snackbar = Snackbar.make(view, "Título adicionado ao carrinho", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.desfazer, new DesfazerAdicionarAoCarrrinho(it));
                snackbar.show();

                addCarrinho(it);

            }
        });

        if(onclick) {

            tituloTxtv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciaItem();
                }
            });
            descricaoTxtv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciaItem();
                }
            });
            valorTxtv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciaItem();

                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iniciaItem();

                }
            });
        }

        return aux;
    }

    private void iniciaItem(){
        Intent it = new Intent(aux.getContext(), ExibirLivroActivity.class);
        it.putExtra("livro", livroSerializable);
        startActivity(it);
    }

    public View getAux() {
        return aux;
    }

    private void addCarrinho(ItensCarrinhoSerializable it) {
        BancoTemporario.getInstance().addItemCarrinho(it);
    }
    private void remCarrinho(ItensCarrinhoSerializable it) {
        BancoTemporario.getInstance().remItemCarrinho(it);
    }



    public class DesfazerAdicionarAoCarrrinho implements View.OnClickListener{

        private ItensCarrinhoSerializable it;

        public DesfazerAdicionarAoCarrrinho(ItensCarrinhoSerializable it) {

            this.it = it;

        }

        @Override
        public void onClick(View view) {

            remCarrinho(it);
        }

    }

}
