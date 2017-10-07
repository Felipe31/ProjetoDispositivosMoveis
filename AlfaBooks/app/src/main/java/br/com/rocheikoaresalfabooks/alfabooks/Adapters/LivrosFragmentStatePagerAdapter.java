package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroFragment;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivrosFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    Object[] dataSet;

    public LivrosFragmentStatePagerAdapter(FragmentManager fm, Object[] dataSet) {
        super(fm);
        this.dataSet = dataSet;
    }

    @Override
    public Fragment getItem(int position) {

        LivroFragment fragment = new LivroFragment();
        Bundle args = new Bundle();
        args.putSerializable("livro", (LivroSerializable) dataSet[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataSet.length;
    }
}
