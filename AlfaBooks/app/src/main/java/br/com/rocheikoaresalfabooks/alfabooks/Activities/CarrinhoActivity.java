package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.CarrinhoFragment;
import br.com.rocheikoaresalfabooks.alfabooks.R;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.cart_title_txtv);

    }
}
