package com.pruebaclass1.camilo.StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TutorialActivity extends Activity {


    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    public static Integer[] mImageIds = {
            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4,
            R.drawable.imagen5,
            R.drawable.imagen6,
            R.drawable.imagen7,
            R.drawable.imagen8,
            R.drawable.imagen9,
            R.drawable.imagen10,
            R.drawable.imagen11,
            R.drawable.imagen12,
            R.drawable.imagen13,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen1));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen2));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen3));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen4));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen5));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen6));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen7));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen8));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen9));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen10));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen11));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen12));
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(getResources().getColor(R.color.android_orange), R.drawable.imagen13));

        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_nuevo:
                Intent i = new Intent(getApplicationContext(), NuevoActivity.class);
                startActivity(i);
                return true;

            case R.id.action_buscar:
                Intent i4 = new Intent(getApplicationContext(), BuscarActivity.class);
                startActivity(i4);
                return true;

            case R.id.action_tutorial:
                Intent i2 = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(i2);
                return true;

            case R.id.action_ayuda:
                Intent i3 = new Intent(getApplicationContext(), AyudaActivity.class);
                startActivity(i3);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments; //acá voy a guardar los fragments

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
            this.fragments = new ArrayList();
        }

        @Override
        public Fragment getItem(int position) {
            //return PlaceholderFragment.newInstance(position + 1);
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //return 3;
            return this.fragments.size();
        }

        public void addFragment(Fragment xfragment){
            this.fragments.add(xfragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String BACKGROUND_COLOR = "color";
        private static final String IMAGEVIEW = "image";
        private int color;
        private int image;

        public static PlaceholderFragment newInstance(int color, int image) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(BACKGROUND_COLOR, color); //agrego color de fondo
            args.putInt(IMAGEVIEW, image); //agrego imagen
            fragment.setArguments(args);
            fragment.setRetainInstance(true);     //agrego para que no se pierda los valores de la instancia
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //cuando crea una instancia de tipo PlaceholderFragment
            //si lo enviamos parametros, guarda esos
            //si no le envio nada, toma el color gris y un número aleatroio
            if (getArguments() != null) {
                this.color = getArguments().getInt(BACKGROUND_COLOR);
                this.image = getArguments().getInt(IMAGEVIEW);
            } else {
                this.color = Color.GRAY;
            }
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tutorial, container, false);

            rootView.setBackgroundColor(this.color);
            ImageView frg_image = (ImageView) rootView.findViewById(R.id.frg_imageView);
            frg_image.setImageResource(image);

            return rootView;
        }
    }

}
