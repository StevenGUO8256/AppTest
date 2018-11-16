package com.example.t.application.module.home;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.t.application.R;
import com.example.t.application.base.BaseFragment;
import com.example.t.application.entity.GankInfo;
import com.example.t.application.mvp.Contract;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:49
 * 作 者：T
 * 微信：704003376
 */
public class HomeFragment extends BaseFragment implements Contract.BaseView {
    private HomePresenter mHomePresenter;

    @Override
    protected void loadData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.start();
    }


    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {
        if (mHomePresenter instanceof Contract.BasePresenter) {
            this.mHomePresenter = (HomePresenter) basePresenter;
        }
    }

    @Override
    public void onDataSucess(Object object) {
        if (object instanceof GankInfo) {
            GankInfo info = (GankInfo) object;
            Log.e("111", info.toString() + "+++++++++++++++++++++");
        }
    }

    @Override
    public void onDataFaile(Object o) {
        Log.e("111", "请求数据失败......" + o.toString());
    }

    @Override
    public void onComplete() {
        Log.e("111", "请求数据完成......");
    }


    @Override
    protected void initView(View view) {
        TextView tvFragment = view.findViewById(R.id.tv_fragment);
        tvFragment.setText("啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
    }

}
