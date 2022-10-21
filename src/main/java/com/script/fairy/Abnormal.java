package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2022/6/9.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    int task_id;
    public Abnormal(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {

        result=mFairy.findPic(631,527,1205,659,"jieshou.png");
        mFairy.onTap(0.8F,result,"接受协议",2000);

        result=mFairy.findPic(438,480,847,643,new String[]{"ks.png","ks1.png"});
        mFairy.onTap(0.8F,result,"开始游戏",1000);

        //剧情跳过按钮
        result=mFairy.findPic(414,531,873,592,"continue.png");
        if(result.sim>0.8){
            result=mFairy.findPic(414,531,873,592,"xykb.png");
            mFairy.onTap(0.8f,result,"协议勾选",1000);
        }

        result=mFairy.findPic(4,3,1274,713,new String[]{"tips1.png","tips8.png"});
        mFairy.onTap(0.8f,result,635,364,639,368,"屏幕中间提示",500);

        result=mFairy.findPic(4,3,1274,713,new String[]{"tips2.png","tips4.png","tips5.png","tips6.png","tips7.png"});
        mFairy.onTap(0.85f,result,"提示点击",500);

        result=mFairy.findPic(4,3,1274,713,new String[]{"tips9.png","tips10.png","tips11.png"});
        mFairy.onTap(0.8f,result,"提示点击2",500);

    }

}
