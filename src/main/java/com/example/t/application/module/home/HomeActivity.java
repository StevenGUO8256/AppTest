package com.example.t.application.module.home;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.t.application.R;
import com.example.t.application.base.BaseActivity;
import com.example.t.application.global.MyApplication;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/25 10:43
 * 作 者：T
 * 微信：704003376
 */
public class HomeActivity extends BaseActivity {
    @Override
    protected void initView() {
        MyApplication.objectVector.add(this);
        addFragment(R.id.ll_container, new HomeFragment());
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void loadData() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            clickTwoExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean mFlag;
    private void clickTwoExit() {
        if (!mFlag) {
            mFlag = true;
            Toast.makeText(HomeActivity.this, R.string.click_two_exit_message, Toast.LENGTH_SHORT).show();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFlag = false;
                }
            }, 2000);

        } else {
            for (Activity activity : MyApplication.objectVector) {
                activity.finish();
            }
        }

    }
}
