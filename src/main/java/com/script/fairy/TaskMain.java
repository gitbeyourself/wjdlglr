package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


/**
 * Created by Administrator on 2022/6/9.
 */

public class TaskMain {
    AtFairyImpl mFairy;
    Util util;
    SingleTask singleTask;
    LimitlessTask limitlessTask;
     public  TaskMain (AtFairyImpl ATFairy) throws Exception {
         mFairy = ATFairy;
         mFairy.setGameName("无尽的拉格朗日");
         mFairy.setGameVersion(6);
         init();
         util= new Util(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         mFairy.initMatTime();
    }

     public void main() throws Exception {
         switch (task_id) {
             case 2743:
                 singleTask.sign();//奖励领取
                 break;
             case 2745:
                 singleTask.BaseConstruction();//基地建设
                 break;
             case 2749:
                 limitlessTask.InfiniteDaily();//无限日常
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;

   public void  init() throws Exception {
       task_id=0;
       try {
           JSONObject optionJson = new JSONObject(Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg"));
           LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
       } catch (JSONException e) {
           e.printStackTrace();
       }
       if (!AtFairyConfig.getOption("task_id").equals("")) {
           task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
       }
   }

}
