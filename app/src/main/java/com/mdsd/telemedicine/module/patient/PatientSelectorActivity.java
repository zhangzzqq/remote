package com.mdsd.telemedicine.module.patient;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.base.AppBaseActivity;
import com.mdsd.telemedicine.databinding.PatientSelectorActivityBinding;
import com.mdsd.telemedicine.module.patient.dummy.DummyContent;


public class PatientSelectorActivity extends AppBaseActivity implements PatientListFragment.OnListFragmentInteractionListener {
    public static final String TAG = PatientSelectorActivity.class.getName();

    private PatientSelectorActivityBinding mBinding;
    private TabLayout tabs;
    private ViewPager pager;

    public static void start(Context context) {
        Intent intent = new Intent(context, PatientSelectorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_patient_selector);
        int orientation = getResources().getConfiguration().orientation;
        tabs = mBinding.tabs;
        pager = mBinding.pager;
        pager.setAdapter(new DepartmentPageAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(pager);
        setupToolbar();
        Log.d(TAG, "orientation:" + orientation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_patient_selector_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.title_activity_patient_selector);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        this.finish();
    }

    class DepartmentPageAdapter extends FragmentPagerAdapter {
        private PatientListFragment[] views;

        public DepartmentPageAdapter(FragmentManager fm) {
            super(fm);
            views = new PatientListFragment[20];
            for (int i = 0; i < views.length; i++) {
                views[i] = PatientListFragment.newInstance();
            }
        }

        // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
        @Override
        public int getCount() {
            return views.length;
        }

        @Override
        public Fragment getItem(int position) {
            return views[position];
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "科室" + (position + 1);
        }
    }
}
