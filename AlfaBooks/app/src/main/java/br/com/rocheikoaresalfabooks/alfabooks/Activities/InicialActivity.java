package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosAdapter;
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


        /** Recycler View code **/
        mRecyclerView = (RecyclerView) findViewById(R.id.livros_rclrv);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.ori

        // specify an adapter
        mAdapter = new LivrosAdapter(new String[][]{{"Nome 1", "Descrição 1"}, {"Nome 2", "Descrição 2"}, {"Nome 3", "Descrição 3"}});
        mRecyclerView.setAdapter(mAdapter);


    }





    /** Action bar Menu **/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                startActivity(new Intent(this, LoginActivity.class));
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
