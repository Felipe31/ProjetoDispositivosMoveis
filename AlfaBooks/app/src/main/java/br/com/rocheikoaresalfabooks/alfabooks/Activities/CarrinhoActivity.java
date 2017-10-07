package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.CarrinhoAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.cart_title_txtv);


        mRecyclerView = (RecyclerView) findViewById(R.id.carrinho_rcyclview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        Log.e("TAAG", "Passou");

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CarrinhoAdapter(carregarLista());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mRecyclerView.getLayoutManager());
    }

    private ArrayList<ItensCarrinhoSerializable> carregarLista() {

        return BancoTemporario.getInstance().getItensCarrinho();
    }
}
