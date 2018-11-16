package com.example.t.application.mvp;

import com.example.t.application.mvp.presenter.IPresenter;
import com.example.t.application.mvp.view.IView;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:31
 * 作 者：T
 * 微信：704003376
 */
public interface Contract {

    interface BaseView extends IView {
        void setPresenter(BasePresenter basePresenter);
    }

    interface BasePresenter extends IPresenter {

    }

}
