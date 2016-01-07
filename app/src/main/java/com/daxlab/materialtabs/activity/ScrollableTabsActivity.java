package com.daxlab.materialtabs.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import com.daxlab.materialtabs.R;
import com.daxlab.materialtabs.fragments.EightFragment;
import com.daxlab.materialtabs.fragments.FiveFragment;
import com.daxlab.materialtabs.fragments.FourFragment;
import com.daxlab.materialtabs.fragments.NineFragment;
import com.daxlab.materialtabs.fragments.OneFragment;
import com.daxlab.materialtabs.fragments.SevenFragment;
import com.daxlab.materialtabs.fragments.SixFragment;
import com.daxlab.materialtabs.fragments.TenFragment;
import com.daxlab.materialtabs.fragments.ThreeFragment;
import com.daxlab.materialtabs.fragments.TwoFragment;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "One");
        adapter.addFrag(new TwoFragment(), "Two");
        adapter.addFrag(new ThreeFragment(), "Three");
        adapter.addFrag(new FourFragment(), "Four");
        adapter.addFrag(new FiveFragment(), "Five");
        adapter.addFrag(new SixFragment(), "Six");
        adapter.addFrag(new SevenFragment(), "Seven");
        adapter.addFrag(new EightFragment(), "Eight");
        adapter.addFrag(new NineFragment(), "Nine");
        adapter.addFrag(new TenFragment(), "Ten");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
