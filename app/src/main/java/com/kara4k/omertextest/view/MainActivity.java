package com.kara4k.omertextest.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kara4k.omertextest.R;
import com.kara4k.omertextest.di.DaggerMainComponent;
import com.kara4k.omertextest.di.modules.MainModule;
import com.kara4k.omertextest.presenter.MainPresenter;
import com.kara4k.omertextest.presenter.vo.ReadyPost;
import com.kara4k.omertextest.view.Adapters.PostsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    MainPresenter mPresenter;

    PostsAdapter mAdapter;


    @Override
    int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewPrepared() {
        super.onViewPrepared();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new PostsAdapter());
        mPresenter.onStart();
    }

    @Override
    protected void injectDaggerDependencies() {
        DaggerMainComponent.builder()
                .appComponent(getAppComponent())
                .mainModule(new MainModule(this))
                .build().injectMainActivity(this);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void setList(List<ReadyPost> posts) {
        mAdapter.setList(posts);
    }

    @Override
    public void onShowMessage(String message) {
        showMessage(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_refresh:
                mPresenter.onStart();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }
}
