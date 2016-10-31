package ljp.qianfeng.com.day_mvp_homework.persenter;

import android.text.TextUtils;

import ljp.qianfeng.com.day_mvp_homework.bean.MainListBean;
import ljp.qianfeng.com.day_mvp_homework.model.MainModel;
import ljp.qianfeng.com.day_mvp_homework.model.inter.Model;
import ljp.qianfeng.com.day_mvp_homework.persenter.inter.MainCallBack;
import ljp.qianfeng.com.day_mvp_homework.persenter.inter.Persenter;
import ljp.qianfeng.com.day_mvp_homework.ui.view.ViewInter;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MainPersenter implements Persenter,MainCallBack {
    Model model;
    ViewInter viewInter;

    public MainPersenter(ViewInter viewInter) {
        this.viewInter = viewInter;
    }

    @Override
    public void queryList(String pageno) {
        if(!TextUtils.isEmpty(pageno)) {
            model = new MainModel(this);
            model.queryMainList(pageno);
        }
    }

    @Override
    public void sucess(MainListBean mainListBean) {
        if(mainListBean!=null){
            viewInter.refreshData(mainListBean);
        }
    }
}
