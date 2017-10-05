package br.com.rocheikoaresalfabooks.alfabooks.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LivroFragment extends Fragment {
    View aux = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_livro, container, false);

        // Inflate the layout for this fragment
        aux = inflater.inflate(R.layout.fragment_livro, container, false);



        TextView tituloTxtv = aux.findViewById(R.id.titulo_txtv);
        TextView descricaoTxtv = aux.findViewById(R.id.descricao_txtv);
        Button button = aux.findViewById(R.id.add_carrinho_btn);

        LivroSerializable livroSerializable = (LivroSerializable) this.getArguments().get("item");

        tituloTxtv.setText(livroSerializable.getTitulo());
        descricaoTxtv.setText(livroSerializable.getDescricao());
        button.setText("Carrinho "+livroSerializable.getValor());


        return aux;
    }

    public View getAux() {
        return aux;
    }

}
