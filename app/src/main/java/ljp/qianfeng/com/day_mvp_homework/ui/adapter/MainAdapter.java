package ljp.qianfeng.com.day_mvp_homework.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import ljp.qianfeng.com.day_mvp_homework.bean.MainListBean;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MainAdapter extends BaseAdapter {
    MainListBean mainListBean;
    Context context;
    LayoutInflater layoutInflater;
    List<MainListBean.ListBean> listBeen;
    public MainAdapter(MainListBean mainListBean, Context context) {
        this.mainListBean = mainListBean;
        this.context = context;
        listBeen=mainListBean.getListbuttom();
        layoutInflater=LayoutInflater.from(context);
    }

    public void setMainListBean(MainListBean mainListBean) {
        this.mainListBean = mainListBean;
        listBeen.addAll(mainListBean.getListbuttom());
    }

    @Override
    public int getCount() {
        return listBeen==null?0:listBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
