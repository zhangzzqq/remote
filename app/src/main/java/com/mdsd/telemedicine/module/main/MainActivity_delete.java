//package com.mdsd.telemedicine.module.main;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.view.menu.MenuBuilder;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.AbsListView;
//import android.widget.ListView;
//
//import com.mdsd.telemedicine.R;
//import com.mdsd.telemedicine.databinding.MainActivityBinding;
//import com.mdsd.telemedicine.module.chat.ChatDialog;
//import com.mdsd.telemedicine.module.patient.PatientSelectorActivity;
//
//
//public class MainActivity_delete extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {
//
//    private MainContract.Presenter mPresenter;
//    private MainActivityBinding mBinding;
//    private MainViewModel mViewModel;
//    private ListView navShortcuts;
//
//    public static void start(Context context) {
//        Intent intent = new Intent(context, MainActivity_delete.class);
//        context.startActivity(intent);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        navShortcuts =  findViewById(R.id.nav_shortcuts);
//        navShortcuts.setAdapter(new NavShortcutsAdapter(this));
//        navShortcuts.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
//
//        Toolbar toolbar = mBinding.toolbar;
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        final DrawerLayout drawer =  findViewById(R.id.drawer_layout);
//        /**
//         * 设置toolbar与drawerlayout联动
//         */
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        /**
//         * 侧滑
//         */
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        mPresenter = new MainPresenter(this);
//        mViewModel = new MainViewModel(this);
//        mBinding.setHandler(mPresenter);
//        mBinding.setViewModel(mViewModel);
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    /**
//     * 创建toolbar上面的menu item
//     * @param menu
//     * @return
//     */
//
//    @SuppressLint("RestrictedApi")
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        if (menu instanceof MenuBuilder) {
//            ((MenuBuilder) menu).setOptionalIconsVisible(true);
//        }
//        getMenuInflater().inflate(R.menu.main, menu);
////        Switch s = (Switch) menu.getItem(2).getActionView().findViewById(R.id.shortcuts_switch);
//        return true;
//    }
//
//
//    /**
//     * 实现功能：
//     *
//     * toolbar 上面的item点击事件
//     *
//     * 注意事项：
//     */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        int id = item.getItemId();
////        switch (id) {
////            case R.id.action_mic:
////                //dialogFragment
////                VoiceAssistantDialog dialog = new VoiceAssistantDialog();
////                dialog.show(getSupportFragmentManager(), "VoiceAssistantDialog");
////                break;
////            case R.id.action_shortcut:
////                break;
////            case R.id.shortcuts_switch:
////                break;
////        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * 侧滑item点击事件
//     *
//     * @param item
//     * @return
//     */
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    @Override
//    public void showPatientSelector() {
//        PatientSelectorActivity.start(this);
//    }
//
//    @Override
//    public void showChatPage() {
//        ChatDialog dialog = new ChatDialog();
//        dialog.show(getSupportFragmentManager(), "ChatDialog");
//    }
//
//    @Override
//    public void setPresenter(MainContract.Presenter presenter) {
//        this.mPresenter = presenter;
//    }
//
//
//}
