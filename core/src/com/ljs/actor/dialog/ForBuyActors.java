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

public class ForBuyActors extends BaseGroup {
    /**确定按钮*/
    private Button confirmBtn;
    /**取消按钮*/
    private Button cancelBtn;
    /**X*/
    private Button xBtn;

    /**鱼的种类*/
    private Integer num;
    /**鱼的价格*/
    private Integer price;

    public ForBuyActors(MainGame mainGame){
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
                 * 点击x 回到marketstage
                 * 隐藏confirmBuystage
                 *
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(false,num,0);
                getMainGame().getGameScreen().setShowMarketStage(true);

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
                /**
                 * code
                 * */
                /**搜寻可用鱼塘space*/
                /**读取C科技*/
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                int goldss = prefs.getInteger(Res.GameData.USER_GOLDS,0);
                if(price>goldss){
                    //金额不足
                    getMainGame().getGameScreen().getConfirmBuyStage().changeText(2);

                }else {
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
                    int ctech = prefs.getInteger(Res.GameData.USER_CTECH, 0);
                    /**转换为池塘最大容量
                     * 0--->3
                     * 1--->4
                     * 2--->5
                     * 3--->6
                     * */
                    int max = ctech + 3;

                    int reach = 0;
                    int target = 0;
                    for (int i = 0; i < 6; i++) {
                        //遍历6个space
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
                        int state = prefs.getInteger(Res.GameData.USER_POOL[i], 0);
                        if (state == 0) {
                            target = i;
                            continue;
                        } else {
                            reach++;
                        }
                    }
                    if (reach >= max) {
                        //池塘满了
                        getMainGame().getGameScreen().getConfirmBuyStage().changeText(3);

                    } else {
                        //将鱼苗放在池塘[target]
                        //设置状态为1
                        Gdx.app.log("TAG", "now purchase; target = " + target);

                        Preferences prefs2 = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[target]);
                        prefs2.putInteger(Res.GameData.USER_POOL[target], 1);
                        prefs2.flush();
                        //保存鱼儿种类
                        prefs2 = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[target]);
                        prefs2.putInteger(Res.GameData.USER_POOL_FISH[target], num);
                        prefs2.flush();
                        //保存鱼儿初始成长度
                        prefs2 = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[target]);
                        prefs2.putInteger(Res.GameData.USER_POOL_GROW[target], 14);
                        prefs2.flush();
                        //保存鱼儿初始健康度
                        prefs2 = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[target]);
                        prefs2.putFloat(Res.GameData.USER_POOL_HEALTH[target], 1.0f);
                        prefs2.flush();
                        //减去金额
                        prefs2 = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                        int mon = prefs2.getInteger(Res.GameData.USER_GOLDS,0);
                        mon -= (int)price;
                        prefs2.putInteger(Res.GameData.USER_GOLDS,mon);
                        prefs2.flush();

                        /**返回到*/
                        getMainGame().getGameScreen().setShowConfirmBuyStage(false, num, 0);
                        getMainGame().getGameScreen().setShowMarketStage(true);

                    }
                }



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
                getMainGame().getGameScreen().setShowConfirmBuyStage(false,num,0);
                getMainGame().getGameScreen().setShowMarketStage(true);

            }
        });
        cancelBtn.setBounds(Res.Positions.DIALOG_BTN2_X,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(cancelBtn);
    }

    public void changeFish(Integer num){
        this.num = num;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

}
