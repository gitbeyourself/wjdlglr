package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2022/6/9.
 */

public class Util extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public Util(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }
    public  void close()throws Exception{
        for (int i=0;i<5;i++){
            mFairy.condit();

            result2=mFairy.findPic(244,120,395,218,"maintain.png");
            if (result2.sim > 0.8f){
                LtLog.e("维护中！");
                Thread.sleep(100000);
            }

            result=mFairy.findPic(889,7,1275,354,"cha.png");
            mFairy.onTap(0.8f,result,"关叉",Sleep);

            result1=mFairy.findPic(1010,7,1274,165,new String[]{"fanhui.png","close.png"});
            mFairy.onTap(0.8f,result1,"返回",Sleep);

            if (result.sim>0.8f || result1.sim>0.8f || result2.sim>0.8f){
                i=0;
            }
        }
    }

}
