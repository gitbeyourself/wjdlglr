package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2022/6/9.
 */

public class LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    SingleTask singleTask;

    public LimitlessTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);
        singleTask = new SingleTask(mFairy);
    }

    public void inOperation() throws Exception {

    }

    public void InfiniteDaily() throws Exception {
        new LimitlessTask(mFairy) {
            ControlSplit optime1 =null,optime2 = null,optime3 = null;

            @Override
            public void create() throws Exception {
                if (AtFairyConfig.getOption("optime1").contains("1||")) {
                    optime1 = strSplit(AtFairyConfig.getOption("optime1"));
                }

                if (AtFairyConfig.getOption("optime2").contains("1||")) {
                    optime2 = strSplit(AtFairyConfig.getOption("optime2"));
                }

                if (AtFairyConfig.getOption("optime3").contains("1||")) {
                    optime2 = strSplit(AtFairyConfig.getOption("optime3"));
                }
            }

            public void inOperation() throws Exception {
                super.inOperation();
            }

            public void content_0() throws Exception {
                LtLog.e(""+AtFairyConfig.getOption("optime2"));
                util.close();
                setTaskName(1);
                return;

            }

            public void content_1() throws Exception {
                if (AtFairyConfig.getOption("optime1").contains("1||")) {
                    singleTask.sign();//奖励领取
                }
                util.close();
                setTaskName(2);
                return;
            }//奖励领取

            public void content_2() throws Exception {
                if (AtFairyConfig.getOption("optime2").contains("1||")) {
                    singleTask.BaseConstruction();//基地建设
                }
                if (AtFairyConfig.getOption("optime3").contains("1||")) {
                    singleTask.KsBaseConstruction();//基地建设
                }
                util.close();
                setTaskName(3);
                return;
            }//基地建设

            public void content_3() throws Exception {

                if (optime1 != null && optime1.choice == 1 && timekeep(0, optime1.timeMillis, "奖励领取")) {
                    setTaskName(1);//每隔多少分奖励一次
                    return;
                }

                if (optime2 != null && optime2.choice == 1 && timekeep(0, optime2.timeMillis, "基地建设")) {
                    setTaskName(2);//每隔多少分基地建设一次
                    return;
                }

                if (optime3 != null && optime3.choice == 1 && timekeep(0, optime3.timeMillis, "快速基地建设")) {
                    setTaskName(2);//每隔多少分基地建设一次
                    return;
                }

                LtLog.e("等待中！");
                Thread.sleep(60000);

            }

        }.taskContent(mFairy, "无限挂机");
    }//无限挂机

}
