package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felip on 08/10/2017.
 */

public class ExibirLivroActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_livro);

        /** ViewPager **/
        ViewPager vp = (ViewPager) findViewById(R.id.livros_vpager);



        Object[] dataSet = new Object[]{new LivroSerializable(1, "Titulo 1", "Descrição 1", 1, null)};



        LivrosFragmentStatePagerAdapter pagerAdapter = new LivrosFragmentStatePagerAdapter(getSupportFragmentManager(), dataSet);
        vp.setAdapter(pagerAdapter);
    }
}
