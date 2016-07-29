package mx.nitrogena.dadm.mod4.nim4practica2.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Nidia on 28/07/2016.
 */
public class ViewpageAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> arrLstFrag;

    public ViewpageAdapter(FragmentManager fm, ArrayList<Fragment> arrLstFrag) {
        super(fm);
        this.arrLstFrag = arrLstFrag;
    }

    @Override
    public Fragment getItem(int position) {
        return arrLstFrag.get(position);
    }

    @Override
    public int getCount() {
        return arrLstFrag.size();
    }
}
