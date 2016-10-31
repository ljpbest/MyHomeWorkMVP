package ljp.qianfeng.com.day_mvp_homework.model;

import com.google.gson.Gson;

import ljp.qianfeng.com.day_mvp_homework.bean.MainListBean;
import ljp.qianfeng.com.day_mvp_homework.model.http.HttpConstants;
import ljp.qianfeng.com.day_mvp_homework.model.http.HttpUtils;
import ljp.qianfeng.com.day_mvp_homework.model.inter.Model;
import ljp.qianfeng.com.day_mvp_homework.persenter.inter.MainCallBack;
import ljp.qianfeng.com.day_mvp_homework.tool.LogUtils;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MainModel implements Model{
    MainCallBack mainCallBack;

    public MainModel(MainCallBack mainCallBack) {
        this.mainCallBack = mainCallBack;
    }

    @Override
    public void queryMainList(String pageno) {
        HttpUtils.request(HttpConstants.MAIN_URL, true, "pageno=" + pageno, new HttpUtils.ICallBack() {
            @Override
            public void success(String result) {
                LogUtils.logString(this.getClass(),result);
                Gson gson=new Gson();
                MainListBean mainListBean = gson.fromJson(result, MainListBean.class);
                LogUtils.logString(this.getClass(),mainListBean.getListbuttom().size()+"");
                mainCallBack.sucess(mainListBean);
            }
        });
    }

}
