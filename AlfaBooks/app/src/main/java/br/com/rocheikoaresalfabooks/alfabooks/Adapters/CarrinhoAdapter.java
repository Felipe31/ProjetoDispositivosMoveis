package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 26/09/17.
 */

public class CarrinhoAdapter extends BaseAdapter {
    ArrayList<ItensCarrinhoSerializable> itensArrayList;

    Context context;
    LayoutInflater inflater;
    TextView nome;
    EditText qtd;
    View areaRow;

    public CarrinhoAdapter(Context context, ArrayList<ItensCarrinhoSerializable> itensArrayList) {
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (itensArrayList != null) {

            this.itensArrayList = itensArrayList;

        }

    }

    @Override
    public int getCount() {
        return itensArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itensArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        areaRow = inflater.inflate(R.layout.fragment_item_cart, null);

        nome = (TextView) areaRow.findViewById(R.id.item_cart_txtv); //To set name of menu item, for example Corn Soup

        qtd = (EditText) areaRow.findViewById(R.id.qtd_cart_etxt);

        nome.setText(itensArrayList.get(position).getNome());
        qtd.setText(String.valueOf(itensArrayList.get(position).getQtd()));

        //row onClickListener
        areaRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.deleta_item_txtv){
                    nome.setText("removido");
                }
                else nome.setText("não removido");
            }
        });
        return areaRow;
    }



}