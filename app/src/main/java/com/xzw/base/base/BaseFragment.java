package com.xzw.base.base;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by xuzw-pc on 2017/9/7.
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment{

    T presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initPresenter();
        presenter.attach((V)this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.dettach();
    }

    public abstract void initPresenter();
}
