package ljp.qianfeng.com.day_mvp_homework.ui;

import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import ljp.qianfeng.com.day_mvp_homework.R;
import ljp.qianfeng.com.day_mvp_homework.bean.MainListBean;
import ljp.qianfeng.com.day_mvp_homework.bind.BindString;
import ljp.qianfeng.com.day_mvp_homework.binder.MyBinder;
import ljp.qianfeng.com.day_mvp_homework.persenter.MainPersenter;
import ljp.qianfeng.com.day_mvp_homework.persenter.inter.Persenter;
import ljp.qianfeng.com.day_mvp_homework.ui.adapter.MainAdapter;
import ljp.qianfeng.com.day_mvp_homework.ui.view.ViewInter;

public class MainActivity extends AppCompatActivity implements ViewInter{
    @BindString(R.id.list_hand)
    ListView mlistview;
    Persenter persenter;
    private int pageno=1;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        persenter=new MainPersenter(this);
        persenter.queryList(pageno+"");
        mainAdapter=new MainAdapter(null,MainActivity.this);
        mlistview.setAdapter(mainAdapter);
        mlistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    void initview(){
        MyBinder.setActivityById(this);
    }
    @Override
    public void refreshData(MainListBean mainListBean) {
            mainAdapter.setMainListBean(mainListBean);
            mainAdapter.notifyDataSetChanged();
    }
}
