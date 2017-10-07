package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 20/09/17.
 */

public class InicialActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), LoginActivity.class));
            }
        });

        TextView sobreNosTxtv = (TextView) findViewById(R.id.sobre_nos);
        sobreNosTxtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), SobreActivity.class));
            }
        });

        /** ViewPager **/
        ViewPager vp = (ViewPager) findViewById(R.id.livros_vpager);



        Object[] dataSet = new Object[]{
                new LivroSerializable(1, "Titulo 1", "Descrição 1", 1, null),
                new LivroSerializable(2, "Titulo 2", "Descrição 2", 2, null),
                new LivroSerializable(3, "Titulo 3", "Descrição 3", 3, null),
                new LivroSerializable(4, "Titulo 4", "Descrição 4", 4, null),
                new LivroSerializable(5, "Titulo 5", "Descrição 5", 5, null)};



        LivrosFragmentStatePagerAdapter pagerAdapter = new LivrosFragmentStatePagerAdapter(getSupportFragmentManager(), dataSet);
        vp.setAdapter(pagerAdapter);

    }





    /** Action bar Menu **/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                startActivity(new Intent(this, PesquisarActivity.class));
                break;
            case R.id.action_shopping_cart:
                startActivity(new Intent(this, CarrinhoActivity.class));
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_actionbar, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
