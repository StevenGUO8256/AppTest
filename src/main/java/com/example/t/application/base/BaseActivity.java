package com.example.t.application.base;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.t.application.global.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 10:03
 * 作 者：T
 * 微信：704003376
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnBinder;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        mUnBinder = ButterKnife.bind(this);
        MyApplication.mCtontext = this;
        mManager = getSupportFragmentManager();
        initView();
        loadData();
    }


    //添加Fragment  add()         replace()
    public void addFragment(int containerId, BaseFragment fragment) {
        if (fragment != null) {
            mManager.beginTransaction().
                    add(containerId, fragment,
                            fragment.getClass().getSimpleName()).
                    commit();
        } else {
            fragment = (BaseFragment)
                    mManager.findFragmentByTag(fragment.getClass().getSimpleName());
            mManager.beginTransaction().add(containerId, fragment, fragment.getClass().
                    getSimpleName()).commit();
        }
    }

    //添加Fragment
    public void startFragment(int containerId, BaseFragment fragment) {
        if (fragment != null) {
            mManager.beginTransaction().replace(containerId, fragment,
                    fragment.getClass().getSimpleName()).commit();
        }
    }

    protected abstract void initView();

    protected abstract int getActivityLayoutId();

    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
