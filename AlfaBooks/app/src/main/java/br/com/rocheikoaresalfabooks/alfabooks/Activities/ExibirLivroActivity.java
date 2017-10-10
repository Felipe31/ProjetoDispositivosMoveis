package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroFragment;
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

//        LivroFragment fragment = new LivroFragment();
//        Bundle args = new Bundle();
//        args.putSerializable("livro", getIntent().getSerializableExtra("livro"));
//        args.putSerializable("onclick", false);
//        fragment.setArguments(args);
//
//
//
//((fragment)findViewById(R.id.livro_fragment)).getFragmentManager()
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//// Replace the contents of the container with the new fragment
//        ft.add(R.id.livro_fragment, fragment);
//// or ft.add(R.id.your_placeholder, new FooFragment());
//// Complete the changes added above
//        ft.commit();


        /** ViewPager **/
        ViewPager vp = (ViewPager) findViewById(R.id.livros_vpager);

        LivrosFragmentStatePagerAdapter pagerAdapter = new LivrosFragmentStatePagerAdapter(
                                                                getSupportFragmentManager(),
                                                                BancoTemporario.getInstance().getItensDataSet(),
                                                                false);
        vp.setAdapter(pagerAdapter);
    }
}
