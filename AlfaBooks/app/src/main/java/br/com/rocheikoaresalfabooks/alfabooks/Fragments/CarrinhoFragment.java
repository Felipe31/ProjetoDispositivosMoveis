package br.com.rocheikoaresalfabooks.alfabooks.Fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.rocheikoaresalfabooks.alfabooks.Activities.CarrinhoActivity;
import br.com.rocheikoaresalfabooks.alfabooks.Adapters.CarrinhoAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 26/09/17.
 */

public class CarrinhoFragment extends Fragment{
    // TODO: 27/09/17 substituir ListView por RecyclerView

    private ListView listArea;
    private ArrayList<ItensCarrinhoSerializable> itensArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_carrinho, container, false);//fragment_one layout is the layout for first tab in filter

        listArea=(ListView)view.findViewById(R.id.fragment_carrinho_lv);

        itensArrayList = carregarLista();

        CarrinhoAdapter myOrderAdapter = new CarrinhoAdapter(getActivity(), itensArrayList);
        listArea.setAdapter(myOrderAdapter);
        return view;
    }

    private ArrayList<ItensCarrinhoSerializable> carregarLista() {
        ArrayList<ItensCarrinhoSerializable> itens = new ArrayList<>();


        itens.add(new ItensCarrinhoSerializable("TV", 12));
        itens.add(new ItensCarrinhoSerializable("TV1", 132));
        itens.add(new ItensCarrinhoSerializable("TV2", 122));
        itens.add(new ItensCarrinhoSerializable("TV3", 112));
        itens.add(new ItensCarrinhoSerializable("TV", 12));
        itens.add(new ItensCarrinhoSerializable("TV1", 132));
        itens.add(new ItensCarrinhoSerializable("TV2", 122));
        itens.add(new ItensCarrinhoSerializable("TV3", 112));

        return itens;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}