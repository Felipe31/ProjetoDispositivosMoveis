package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.ListViewAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felip on 05/10/2017.
 */

public class PesquisarActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener  {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] nomeLivroLista;
    ArrayList<Livro> livrosLista = new ArrayList<Livro>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        // Generate sample data

        nomeLivroLista = new String[]{"Titulo 1", "Titulo 2", "Titulo 3",
                "Titulo 4", "Titulo 5", "Titulo 6"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < nomeLivroLista.length; i++) {
            Livro livro = new Livro(nomeLivroLista[i]);
            // Binds all strings into an array
            livrosLista.add(livro);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, livrosLista);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        list.setOnItemClickListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(parent.getContext(), ExibirLivroActivity.class);
        it.putExtra("livro", BancoTemporario.getInstance().getLivroSerializable(nomeLivroLista[position]));
        startActivity(it);

        //Toast.makeText(getApplicationContext(),"Position of Selected Item is : "+position,Toast.LENGTH_LONG).show();
    }



    }



