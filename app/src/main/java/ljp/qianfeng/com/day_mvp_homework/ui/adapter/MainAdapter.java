package ljp.qianfeng.com.day_mvp_homework.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ljp.qianfeng.com.day_mvp_homework.R;
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
        if(mainListBean!=null) {
            listBeen = mainListBean.getListbuttom();
        }else {
            listBeen=new ArrayList<>();
        }
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
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.list_item,null,false);
            viewHolder=new ViewHolder(convertView);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        viewHolder.textViewtitle.setText(listBeen.get(position).getGname());
        viewHolder.textViewtype.setText(listBeen.get(position).getPtype());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textViewtitle;
        TextView textViewtype;
        ViewHolder(View view){
            view.setTag(this);
            imageView= (ImageView) view.findViewById(R.id.list_item_image);
            textViewtitle=(TextView)view.findViewById(R.id.list_item_hand);
            textViewtype=(TextView)view.findViewById(R.id.list_item_type);
        }
    }
}
