package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2022/6/9.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    Util util;
    public static int Sleep = 1000;

    public SingleTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);

    }
    //奖励领取
    public void sign()throws Exception{
        new SingleTask(mFairy){
            boolean DoubleCharge;
            @Override
            public void create() throws Exception {
                DoubleCharge=AtFairyConfig.getOption("DoubleCharge").equals("1");
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                overtime(15,0);

                result=mFairy.findPic(5,6,158,73,new String[]{"thread.png","thread3.png","thread4.png"});
                mFairy.onTap(0.8f,result,"主线",2000);

                result1=mFairy.findPic(5,8,942,78,new String[]{"thread2.png"});
                if(result1.sim>0.8){
                    LtLog.e("任务列表中");
                    mFairy.onTap(0.8f,result1,"点击主线",Sleep);

                    for (int i=0;i<=10;i++){
                        result=mFairy.findPic(1133,62,1251,689,"jiangli.png");
                        if (result.sim>0.8f){
                            i=0;
                            mFairy.onTap(0.8f,result,"奖励",Sleep);
                            mFairy.onTap(0.8f,result,1212,40,1221,50,"奖励",Sleep);
                        }
                        result=mFairy.findPic(31,465,384,705,"lingqu1.png");
                        if (result.sim>0.8f){
                            i=0;
                            mFairy.onTap(0.8f,result,"奖励",Sleep);
                            mFairy.onTap(0.8f,result,1212,40,1221,50,"奖励",Sleep);
                        }

                    }
                    result1=mFairy.findPic(5,8,942,78,new String[]{"weituo.png"});
                    mFairy.onTap(0.8f,result1,"点击委托",Sleep);
                    for (int i=0;i<=10;i++){
                        result=mFairy.findPic(25,133,1263,640,"lingqu.png");
                        mFairy.onTap(0.8f,result,"领取",Sleep);
                        mFairy.onTap(0.8f,result,1212,40,1221,50,"领取",Sleep);
                    }
                    result=mFairy.findPic(1163,7,1265,90,"cha.png");
                    mFairy.onTap(0.8f,result,"关叉",Sleep);

                    LtLog.e("已签到完成,跳转到2");
                    setTaskName(2);
                    return;
                }

            }

            @Override
            public void content_2() throws Exception {
                overtime(15,0);
                result=mFairy.findPic(0,588,157,715,new String[]{"base.png","base1.png","base2.png"});
                mFairy.onTap(0.8f,result,"点击进入基地",Sleep);

                result =mFairy.findPic(6,9,1264,672,"resources.png");
                mFairy.onTap(0.8f,result,"资源管理",Sleep);

                result =mFairy.findPic(5,6,224,86,"resources1.png");
                if(result.sim>0.8) {
                    if (DoubleCharge){
                        result = mFairy.findPic(9, 14, 404, 711, "DoubleCharge.png");
                        if (result.sim > 0.8) {
                            mFairy.onTap(0.8f, result, "双倍资源收取", Sleep);
                            mFairy.onTap(0.8f, result, 1213,38,1218,44,"返回", Sleep);
                        }
                    }else{
                        result = mFairy.findPic(9, 14, 404, 711, "collect.png");
                        if (result.sim > 0.8) {
                            mFairy.onTap(0.8f, result, "资源收取", Sleep);
                            mFairy.onTap(0.8f, result, 1213,38,1218,44,"返回", Sleep);
                        }
                    }
                    result = mFairy.findPic(9, 14, 404, 711, "collect1.png");
                    if (result.sim > 0.8) {
                        mFairy.onTap(0.8f, result, "资源收取全部", Sleep);
                        mFairy.onTap(0.8f, result, 1213,38,1218,44,"返回", Sleep);
                    }
                    util.close();
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"奖励领取");
    }
    boolean accelerate;//升级加速
    //基地建设
    public void BaseConstruction() throws Exception {
        new SingleTask(mFairy){

            int x=237,y=511;
            @Override
            public void create() throws Exception {//获取需要的参数
                accelerate=AtFairyConfig.getOption("accelerate").equals("1");
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(30,0);
                result=mFairy.findPic(0,588,157,715,"base.png");
                mFairy.onTap(0.8f,result,"点击进入基地",Sleep);

                result = mFairy.findPic(2,593,1272,716,"build.png");
                mFairy.onTap(0.8f,result,"点击基地建设",Sleep);

                result2 = mFairy.findPic(3,8,193,91,"build1.png");
                if(result2.sim>0.8){
                    LtLog.e("基地建设中");

                    result = mFairy.findPic(5,458,164,685,"extension.png");
                    if(result.sim>0.8) {
                        mFairy.onTap(0.8f, result, "点击扩建", 3000);
                        result = mFairy.findPic(517,543,763,668,"extension1.png");
                        mFairy.onTap(0.8f,result,"扩建",2000);
                        result = mFairy.findPic(517,543,763,668,"extension1.png");
                        mFairy.onTap(0.8f,result,"扩建",2000);

                        result1 = mFairy.findPic(3,3,163,448,"effect.png");
                        if(result.sim>0.8) {
                            LtLog.e("扩建中");
                            mFairy.onTap(0.8f,result,1206,39,1219,51,"扩建",Sleep);
                            mFairy.ranSwipe(566,485,566,608,500, (long) 500,0);
                        }
                        result=mFairy.findPic(829,10,1006,136,"close1.png");
                        mFairy.onTap(0.8f,result,"关叉",Sleep);
                    }

                   for (int i=0;i<3;i++){
                       for (int n=0;n<3;n++){
                           LtLog.e("i—n="+i+","+n);
                           LtLog.e("坐标—x=237,y=511—"+(x+n*353)+","+(y+i*62)+","+(x+1+n*353)+","+(y+1+i*62));
                           mFairy.onTap(0.8f,result2,x+n*353,y+i*62,x+1+n*353,y+1+i*62,"选择项目",2000);

                           result = mFairy.findPic(292,510,1080,716,new String[]{"unable1.png","unable2.png","uppelimit.png","uppelimit1.png","uppelimit2.png"});//不可操作
                           if (result.sim>0.8){
                               mFairy.onTap(0.8f,result,1214,36,1220,43,"返回选择",2000);
                               continue;
                           }

                           result = mFairy.findPic(292,510,1080,716,new String[]{"upgrade.png"});//升级
                           mFairy.onTap(0.8f,result,"点击升级",2000);

                           if (accelerate) {
                               result = mFairy.findPic(292, 510, 1080, 716, new String[]{"accelerate.png"});//加速
                               if (result.sim > 0.8) {
                                   mFairy.onTap(0.8f, result, "加速", 1000);
                                   result = mFairy.findPic(516,311,759,410,new String[]{"Deficiency.png"});//不足
                                   if (result.sim>0.8){
                                       mFairy.onTap(0.8f,result,1211,36,1224,48,"返回选择",Sleep);
                                       continue;
                                   }
                                   result = mFairy.findPic(448,414,1122,572,new String[]{"determine.png"});//确定
                                   mFairy.onTap(0.8f,result,"确定",Sleep);
                               }

                               result = mFairy.findPic(292, 510, 1080, 716, new String[]{"accelerate.png"});//加速
                               if (result.sim > 0.8) {
                                   mFairy.onTap(0.8f, result, "加速", 1000);
                                   result = mFairy.findPic(516,311,759,410,new String[]{"Deficiency.png"});//不足
                                   if (result.sim>0.8){
                                       mFairy.onTap(0.8f,result,1211,36,1224,48,"返回选择",Sleep);
                                       continue;
                                   }
                                   result = mFairy.findPic(448,414,1122,572,new String[]{"determine.png"});//确定
                                   mFairy.onTap(0.8f,result,"确定",Sleep);
                               }

                               result = mFairy.findPic(292,510,1080,716,new String[]{"unable1.png","unable2.png","uppelimit.png","uppelimit1.png","uppelimit2.png"});//不可操作
                               if (result.sim>0.8){
                                   mFairy.onTap(0.8f,result,1214,36,1220,43,"返回选择",2000);
                                   continue;
                               }
                           }
                       }
                   }
                    mFairy.onTap(0.8f,result2,1211,36,1224,48,"返回选择",Sleep);
                   setTaskEnd();
                   return;
                }
            }
        }.taskContent(mFairy,"基地建设");
    }

    //快速基地建设
    public void KsBaseConstruction() throws Exception {
        new SingleTask(mFairy){


            int x=447,y=528,x1=237,y1=511;;
            @Override
            public void create() throws Exception {//获取需要的参数
                accelerate=AtFairyConfig.getOption("accelerate").equals("1");
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(30,0);
                result=mFairy.findPic(0,588,157,715,new String[]{"base.png","base1.png"});
                mFairy.onTap(0.8f,result,"点击进入基地",Sleep);

                result = mFairy.findPic(2,593,1272,716,"build.png");
                mFairy.onTap(0.8f,result,"点击基地建设",Sleep);

                result2 = mFairy.findPic(3,8,193,91,"build1.png");
                if(result2.sim>0.8){
                    LtLog.e("基地建设中");
                    result1 = mFairy.findPic(5,467,141,528,new String[]{"effect.png","effect1.png","effect2.png"});
                    if(result1.sim>0.8) {
                        LtLog.e("扩建中");
                        mFairy.ranSwipe(566,485,566,608,500, (long) 500,0);
                    }

                    result = mFairy.findPic(5,458,164,685,"extension.png");
                    if(result.sim>0.8) {
                        mFairy.onTap(0.8f, result, "点击扩建", 3000);
                        result = mFairy.findPic(517,543,763,668,"extension1.png");
                        mFairy.onTap(0.8f,result,"扩建",2000);
                        result = mFairy.findPic(517,543,763,668,"extension1.png");
                        mFairy.onTap(0.8f,result,"扩建",2000);
                        result1 = mFairy.findPic(5,83,102,135,new String[]{"effect3.png"});
                        if(result1.sim>0.8) {
                            LtLog.e("扩建中");
                            mFairy.onTap(0.8f,result1,1206,39,1219,51,"扩建",Sleep);
                            mFairy.ranSwipe(566,485,566,608,500, (long) 500,0);
                        }
                        result=mFairy.findPic(829,10,1006,136,"close1.png");
                        mFairy.onTap(0.8f,result,"关叉",Sleep);
                    }

                    for (int i=0;i<3;i++){
                        for (int n=0;n<3;n++){
                            LtLog.e("i—n="+i+","+n);
                            LtLog.e("坐标—x=237,y=511—"+(x+n*353)+","+(y+i*62)+","+(x+97+n*353)+","+(y+30+i*62));
                            result=mFairy.findPic(x+n*353,y+i*62,x+97+n*353,y+30+i*62,new String[]{"fast1.png","fast2.png","fast3.png"});
                            mFairy.onTap(0.85f,result,x1+n*353,y1+i*62,x1+1+n*353,y1+1+i*62,"选择项目",2000);

                            result = mFairy.findPic(292,510,1080,716,new String[]{"unable1.png","unable2.png","uppelimit.png","uppelimit1.png","uppelimit2.png"});//不可操作
                            if (result.sim>0.8){
                                mFairy.onTap(0.8f,result,1214,36,1220,43,"返回选择",2000);
                                continue;
                            }

                            result = mFairy.findPic(292,510,1080,716,new String[]{"upgrade.png"});//升级
                            mFairy.onTap(0.8f,result,"点击升级",2000);
                            if (accelerate) {
                                result = mFairy.findPic(292, 510, 1080, 716, new String[]{"accelerate.png","accelerate1.png"});//加速
                                if (result.sim > 0.8){
                                    mFairy.onTap(0.8f, result, "加速", 2000);
                                    result = mFairy.findPic(516,311,759,410,new String[]{"Deficiency.png"});//不足
                                    if (result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,1211,36,1224,48,"返回选择",Sleep);
                                        continue;
                                    }
                                    result = mFairy.findPic(448,414,1122,572,new String[]{"determine.png"});//确定
                                    mFairy.onTap(0.8f,result,"确定",Sleep);
                                }

                                result = mFairy.findPic(292, 510, 1080, 716, new String[]{"accelerate.png","accelerate.png"});//加速
                                if (result.sim > 0.8) {
                                    mFairy.onTap(0.8f, result, "加速", 1000);
                                    result = mFairy.findPic(516,311,759,410,new String[]{"Deficiency.png"});//不足
                                    if (result.sim>0.8){
                                        mFairy.onTap(0.8f,result,1211,36,1224,48,"返回选择",Sleep);
                                        continue;
                                    }
                                    result = mFairy.findPic(448,414,1122,572,new String[]{"determine.png"});//确定
                                    mFairy.onTap(0.8f,result,"确定",Sleep);
                                }
                            }
                            result = mFairy.findPic(292,510,1080,716,new String[]{"accelerate.png","accelerate.png"});//升级
                            mFairy.onTap(0.8f,result,1214,36,1220,43,"返回选择",2000);
                        }
                    }
                    mFairy.onTap(0.8f,result2,1211,36,1224,48,"返回选择",Sleep);
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"快速基地建设");
    }
}
