package br.com.rocheikoaresalfabooks.alfabooks.Fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LivroFragment extends Fragment {
    View aux = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        ViewGroup rootView = (ViewGroup) inflater.inflate(
//                R.layout.fragment_livro, container, false);

        // Inflate the layout for this fragment
        aux = inflater.inflate(R.layout.fragment_livro, container, false);


        final TextView tituloTxtv = aux.findViewById(R.id.titulo_txtv);
        TextView descricaoTxtv = aux.findViewById(R.id.descricao_txtv);
        TextView valorTxtv = aux.findViewById(R.id.valor_livro);
        Button button = aux.findViewById(R.id.add_carrinho_btn);

        LivroSerializable livroSerializable = (LivroSerializable) this.getArguments().get("livro");

        tituloTxtv.setText(livroSerializable.getTitulo());
        descricaoTxtv.setText(livroSerializable.getDescricao());
        valorTxtv.setText(String.format("R$%.2f", livroSerializable.getValor()));

        button.setTag(livroSerializable);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LivroSerializable ls = (LivroSerializable) view.getTag();

                ItensCarrinhoSerializable it = new ItensCarrinhoSerializable(1, ls.getTitulo(), 1, ls.getValor());

                Snackbar snackbar = Snackbar.make(view, "Título adicionado ao carrinho", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.desfazer, new DesfazerAdicionarAoCarrrinho(it));
                snackbar.show();

                addCarrinho(it);

            }
        });

        return aux;
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
