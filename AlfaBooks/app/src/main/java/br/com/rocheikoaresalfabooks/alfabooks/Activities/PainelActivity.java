package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.rocheikoaresalfabooks.alfabooks.R;
/**
 * Created by aleffer on 09/10/17.
 */

public class PainelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_painel);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Button cadCliBtn = (Button) findViewById(R.id.cad_cli_btn);
        Button atuCliBtn = (Button) findViewById(R.id.atu_cli_btn);
        Button delCliBtn = (Button) findViewById(R.id.del_cli_btn);
        Button cadProdBtn = (Button) findViewById(R.id.cad_prod_btn);
        Button atuProdBtn = (Button) findViewById(R.id.atu_prod_btn);
        Button delProdBtn = (Button) findViewById(R.id.del_prod_btn);
        Button cadFornBtn = (Button) findViewById(R.id.cad_forn_btn);
        Button atuFornBtn = (Button) findViewById(R.id.atu_forn_btn);
        Button delFornBtn = (Button) findViewById(R.id.del_forn_btn);


        cadCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        atuCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        delCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cadProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        atuProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        delProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cadFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        atuFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        delFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
