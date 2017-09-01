package com.scottsu.smovie.module.search;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.events.SearchEvent;
import com.scottsu.utils.FragmentUtil;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.search
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 17:18
 **/
public class SearchActivity extends BaseActivity<SearchContract.View, SearchContract.Presenter>
        implements SearchContract.View {

    private EditText mSearchEditText;
    private View mSearchButton;
    private SearchListFragment mSearchListFragment;


    @Override
    protected boolean subscribeEvents() {
        return false;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_search;
    }

    @Override
    protected SearchContract.Presenter providePresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(getWindow().getSharedElementEnterTransition().excludeTarget(android.R.id.statusBarBackground, true));
            getWindow().setSharedElementEnterTransition(getWindow().getSharedElementEnterTransition().excludeTarget(android.R.id.navigationBarBackground, true));
        }

        mSearchEditText = (EditText) findViewById(R.id.et_search);
        mSearchButton = findViewById(R.id.fl_search);
        mSearchButton.setOnClickListener(this);

        mSearchListFragment = SearchListFragment.newInstance();
        FragmentUtil.show(this, R.id.fl_container_search_list, mSearchListFragment);

        mSearchEditText.addTextChangedListener(mSearchTextWatcher);

        getPresenter().subscribe(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (mSearchButton == v) {
            notifySearch(true);
        }
    }

    private TextWatcher mSearchTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            notifySearch(false);
        }
    };

    private void notifySearch(boolean byClick) {
        String keyword = mSearchEditText.getText().toString().trim();
        if (TextUtils.isEmpty(keyword)) {
            if (byClick) {
                showSnackbar("请输入一个搜索关键词");
            }
            return;
        }

        closeKeyboard();

        postEvent(new SearchEvent(keyword));
    }

}
