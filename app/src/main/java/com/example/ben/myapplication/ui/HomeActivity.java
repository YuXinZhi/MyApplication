
package com.example.ben.myapplication.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ben.myapplication.R;
import com.example.ben.myapplication.utils.Cheeses;

public class HomeActivity extends AppCompatActivity {
    static final int NUM_ITEMS = 4;
    static final String[] TITLE_INDEX =

            {
                     "文本", "图片", "音频", "视频"

            };
    ViewPager mPager;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

    }

    public static class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {

            return ArrayListFragment.newInstance(TITLE_INDEX[position]);
        }
    }

    public static class ArrayListFragment extends ListFragment {
        String mTitle;

        static ArrayListFragment newInstance(String mTitle) {
            ArrayListFragment fragment = new ArrayListFragment();

            Bundle args = new Bundle();
            args.putString("mTitle", mTitle);
            fragment.setArguments(args);
            return fragment;

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mTitle = getArguments() != null ? getArguments().getString("mTitle") : TITLE_INDEX[0];


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView) tv).setText(mTitle);
            return v;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
        }


    }


}
