package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.rocheikoaresalfabooks.alfabooks.Activities.ExibirLivroActivity;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivrosAdapter extends RecyclerView.Adapter<LivrosAdapter.ViewHolder>{

    private String[][] mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public LivrosAdapter(String[][] myDataset) {
        mDataset = myDataset;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tituloTxtv.setText(mDataset[position][0]);
        holder.addCarrinhoBtn.setText("+ carrinho");
        holder.descricaoTxtv.setText(mDataset[position][1]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }





    /** View Holder **/


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View mView;
        private TextView tituloTxtv;
        private Button addCarrinhoBtn;
        private TextView descricaoTxtv;
        public ViewHolder(View v) {
            super(v);
            mView = v;
            tituloTxtv = mView.findViewById(R.id.titulo_txtv );
            addCarrinhoBtn = mView.findViewById(R.id.add_carrinho_btn );
            descricaoTxtv = mView.findViewById(R.id.descricao_txtv );


        }
    }


    @Override
    public LivrosAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_livro, parent, false);

        v.setMinimumWidth(parent.getMeasuredWidth());
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);


        return vh;
    }
}
