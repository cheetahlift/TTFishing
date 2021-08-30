package com.ljs.actor.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

import java.util.Random;

public class ForSpeedActors extends BaseGroup {
    /**确定按钮*/
    private Button confirmBtn;
    /**取消按钮*/
    private Button cancelBtn;
    /**X*/
    private Button xBtn;

    public ForSpeedActors(MainGame mainGame){
        super(mainGame);
        init();
    }

    private void init(){
        /**加载x*/
        Button.ButtonStyle stylex = new Button.ButtonStyle();
        stylex.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.X)
        );
        xBtn = new Button(stylex);
        xBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击x 回到homestage
                 * 隐藏speedstage
                 *
                 * */
                /**
                 * bug==================================================================
                 * 添加测试用假数据
                 * 每次点击账户变为500金币
                 *5 螺母 5 螺丝 5铁矿
                 * */
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                prefs.putInteger(Res.GameData.USER_GOLDS,500);
                prefs.flush();
                prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                prefs.putInteger(Res.GameData.USER_LUOMUS,5);
                prefs.flush();
                prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                prefs.putInteger(Res.GameData.USER_LUOSIS,5);
                prefs.flush();
                prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                prefs.putInteger(Res.GameData.USER_STORES,5);
                prefs.flush();
                /**
                 * ======================================================================
                 * */
                getMainGame().getGameScreen().setShowSpeedStage(false);
                getMainGame().getGameScreen().setShowHomeStage(true);

            }
        });
        xBtn.setBounds(Res.Positions.DIALOG_X_X,Res.Positions.DIALOG_X_Y,Res.Positions.DIALOG_X_WIDTH,Res.Positions.DIALOG_X_WIDTH);
        addActor(xBtn);

        /**加载确认键*/
        Button.ButtonStyle stylebtn1 = new Button.ButtonStyle();
        stylebtn1.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CONFIRM_U)
        );
        stylebtn1.down = new TextureRegionDrawable(
               getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CONFIRM_D)
        );
        confirmBtn = new Button(stylebtn1);
        confirmBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击确认 回到homestage
                 * 并执行相关加速操作
                 *
                 * */
                /***
                 * code
                 * */
                /**加速时间*/
                /**
                 * 金币减少10个
                 * 鱼类成长
                 * 基于B科技等级
                 * 0级 鱼类成长阶段+1
                 * 1级 鱼类成长阶段+2
                 * 2级 鱼类成长阶段+3
                 * 3级 鱼类成长阶段+4
                 * 鱼类最低阶段1 最高阶段20
                 * 鱼类健康度
                 * 基于A科技等级
                 * 0级 鱼类50%概率降低0.05健康度
                 * 1级 鱼类40%概率降低0.02健康度 60%概率提升0.1健康度
                 * 2级 鱼类30%概率降低0.01健康度 70%提升0.1健康度
                 * 3级 鱼类不会降低健康度 100%提升0.3健康度
                 * 鱼类健康度最低0 （死亡） 最高1.0（十分健康）
                 *
                 * */
                /**金币减少10个*/
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                int golds = prefs.getInteger(Res.GameData.USER_GOLDS,0);
                if(golds<1){
                    //金币不足 无法加速
                }else{
                    golds -= 1;
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                    prefs.putInteger(Res.GameData.USER_GOLDS,golds);
                    prefs.flush();
                    /**刷新商店*/
                    getMainGame().getGameScreen().getShopStage().randomFlush();
                    /**刷新市场*/
                    getMainGame().getGameScreen().getMarketStage().DataFlush();

                    /**获取当前科技等级*/
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
                    int atech = prefs.getInteger(Res.GameData.USER_ATECH, 0);
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
                    int btech = prefs.getInteger(Res.GameData.USER_BTECH,0);

                    /**获取当前池塘里的活鱼*/
                    for(int i = 0;i<6;i++){
                        // 读取本地鱼儿数据
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
                        Integer state = prefs.getInteger(Res.GameData.USER_POOL[i], 0);


                        if(state == 0) {
                            //此鱼已死 有事烧纸
                        }
                        else{
                            /**获取成长度数据*/
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                            Integer grow = prefs.getInteger(Res.GameData.USER_POOL_GROW[i],0);
                            /**根据B科技使成长阶段增加*/
                            grow += (btech+1);
                            if(grow>=20) grow = 20;//最大20
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                            prefs.putInteger(Res.GameData.USER_POOL_GROW[i],grow);
                            prefs.flush();

                            /**获取健康度数据*/
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[i]);
                            float health = prefs.getFloat(Res.GameData.USER_POOL_HEALTH[i],0);
                            /**根据A科技使健康度变化*/
                            Random r = new Random();
                            if(atech == 0){
                                /**0级 鱼类50%概率降低0.3健康度*/
                                int ran2 = r.nextInt()%100;
                                if(ran2<50){
                                    //降低0.05
                                    health -= 0.05f;
                                    if(health<=0){
                                        //若鱼直接死亡
                                        health = 0;
                                    }
                                }else{
                                    //do nothing
                                }

                            }else if(atech == 1){
                                /**1级 鱼类40%概率降低0.02健康度 60%概率提升0.1健康度*/
                                int ran2 = r.nextInt()%100;
                                if(ran2<40){
                                    //降低0.02健康度
                                    health -= 0.02f;
                                    if(health<=0){
                                        //若鱼直接死亡
                                        health = 0;
                                    }
                                }else{
                                    //提升0.1健康度
                                    health += 0.1f;
                                    if(health>=1){
                                        //若鱼非常健康
                                        health = 1.0f;
                                    }
                                }
                            }else if(atech == 2){
                                /**2级 鱼类30%概率降低0.01健康度 70%提升0.1健康度*/
                                int ran2 = r.nextInt()%100;
                                if(ran2<30){
                                    //降低0.01健康度
                                    health -= 0.01f;
                                    if(health<=0){
                                        //若鱼直接死亡
                                        health = 0;
                                    }
                                }else{
                                    //提升0.1健康度
                                    health += 0.1f;
                                    if(health>=1){
                                        //若鱼非常健康
                                        health = 1.0f;
                                    }
                                }
                            }else if(atech == 3){
                                /**3级 鱼类不会降低健康度 100%提升0.3健康度*/

                                //提升0.1健康度
                                health += 0.3f;
                                if(health>=1){
                                    //若鱼非常健康
                                    health = 1.0f;
                                }
                            }
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[i]);
                            prefs.putFloat(Res.GameData.USER_POOL_HEALTH[i],health);
                            prefs.flush();
                        }

                }//end for

                    }//end else 金币判断
                getMainGame().getGameScreen().setShowSpeedStage(false);
                getMainGame().getGameScreen().setShowHomeStage(true);
                }

        });
        confirmBtn.setBounds(Res.Positions.DIALOG_BTN1_X,Res.Positions.DIALOG_BTN1_Y,Res.Positions.DIALOG_BTN1_WIDTH,Res.Positions.DIALOG_BTN1_HEIGHT);
        addActor(confirmBtn);

        /**加载取消键*/
        Button.ButtonStyle stylebtn2 = new Button.ButtonStyle();
        stylebtn2.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CANCEL_U)
        );
        stylebtn2.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CANCEL_D)
        );
        cancelBtn = new Button(stylebtn2);
        cancelBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击取消 回到homestage
                 *
                 *
                 * */
                /***
                 * code
                 * */
                getMainGame().getGameScreen().setShowSpeedStage(false);
                getMainGame().getGameScreen().setShowHomeStage(true);

            }
        });
        cancelBtn.setBounds(Res.Positions.DIALOG_BTN2_X,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(cancelBtn);
    }

}
