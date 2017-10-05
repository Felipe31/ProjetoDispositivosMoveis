package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

import static android.R.id.list;

/**
 * Created by felipesoares on 26/09/17.
 */

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder>{

    private ArrayList<ItensCarrinhoSerializable> dataSet;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CarrinhoAdapter(ArrayList<ItensCarrinhoSerializable> dataSet) {
        this.dataSet = dataSet;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CarrinhoAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tituloTxtv.setText(dataSet.get(position).getNome());
        holder.qtdTxtv.setText(String.valueOf (dataSet.get(position).getQtd()));

        holder.removeBtn.setTag(position);

        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int)view.getTag();

                Snackbar mySnackbar = Snackbar.make(view,
                        R.string.remove_item_carrinho, Snackbar.LENGTH_LONG);
                mySnackbar.setAction(R.string.desfazer_remover_item_carrinho, new DesfazerRemover(dataSet, dataSet.get(position), position));
//                mySnackbar.setAction(R.string.desfazer_remover_item_carrinho, null);
                mySnackbar.show();

                dataSet.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataSet.size()-position+1);

            }
        });

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    /** View Holder **/


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View mView;
        private TextView tituloTxtv;
        private TextView qtdTxtv;
        private ImageButton removeBtn;
        public ViewHolder(View v) {
            super(v);
            mView = v;
            tituloTxtv = mView.findViewById(R.id.item_cart_txtv );
            qtdTxtv = mView.findViewById(R.id.qtd_cart_etxt );
            removeBtn = mView.findViewById(R.id.deleta_item_imgbtn);



        }
    }


    @Override
    public CarrinhoAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_cart, parent, false);

        v.setMinimumWidth(parent.getMeasuredWidth());
        // set the view's size, margins, paddings and layout parameters
        CarrinhoAdapter.ViewHolder vh = new CarrinhoAdapter.ViewHolder(v);



        return vh;
    }

    public class DesfazerRemover implements View.OnClickListener {

        private ArrayList<ItensCarrinhoSerializable> dataSet;
        private ItensCarrinhoSerializable item;
        private int position;

        public DesfazerRemover(ArrayList<ItensCarrinhoSerializable> dataSet, ItensCarrinhoSerializable item, int position) {

            this.dataSet = dataSet;
            this.item = item;
            this.position = position;

        }

        @Override
        public void onClick(View view) {

            dataSet.add(position, item);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, dataSet.size()-position+1);

        }
    }
}
