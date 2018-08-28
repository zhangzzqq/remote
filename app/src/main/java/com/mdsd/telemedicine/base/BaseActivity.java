package com.mdsd.telemedicine.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mdsd.telemedicine.R;
import com.mdsd.telemedicine.utils.AppManager;

/**
 * Created by zq on 16/8/4.
 *
 * 最后需要MainActivity（主页面、主类）或者Service中处理Dialog的显示问题，
 * 通过AppManager获取到当前栈顶的Activity，用于构造Dialog就行了。

 Dialog myDialog = new Dialog(AppManager.getAppManager().currentActivity(), R.style.dialog_style);
 */
public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;
    public Toolbar mToolbarTb;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        mContext = this;
        mToolbarTb = (Toolbar) findViewById(R.id.tb_toolbar);
        if (mToolbarTb != null) {
            setSupportActionBar(mToolbarTb);

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        //将Activity实例添加到AppManager的堆栈
        AppManager.getAppManager().addActivity(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mToolbarTb != null) {
            mToolbarTb.setTitle(title);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //将Activity实例从AppManager的堆栈中移除
        AppManager.getAppManager().finishActivity(this);


    }
}
