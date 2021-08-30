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

public class ForResActors extends BaseGroup {
    /**确定按钮*/
    private Button confirmBtn;
    /**取消按钮*/
    private Button cancelBtn;
    /**X*/
    private Button xBtn;

    /**科技资源的种类*/
    private Integer num;
    /**价格*/
    private Integer price;
    /**按钮位置*/
    private Integer btn;

    public ForResActors(MainGame mainGame){
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
                 * 点击x 回到shopstage
                 * 隐藏confirmpurchasestage
                 *
                 * */
                getMainGame().getGameScreen().setShowResPurchaseStage(false,-1,-1,btn);
                getMainGame().getGameScreen().setShowShopStage(true);

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
                 * 点击确认 回到shopstage
                 * 并执行相关操作
                 *
                 * */
                /**
                 * code
                 * */
                /**检查是否有足够金币*/
                /**读取金币*/
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                int golds = prefs.getInteger(Res.GameData.USER_GOLDS, 0);
                if(price>golds){
                    //不够钱
                    getMainGame().getGameScreen().getResPurchaseStage().changeText(2);

                }else{
                    /**减去金币数*/
                    golds -= price;
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                    prefs.putInteger(Res.GameData.USER_GOLDS,golds);
                    prefs.flush();
                    /**增加对应材料*/
                    /**
                     * 0       1      2
                     * luomu  luosi store
                     * */
                    if(num == 0){
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                        int now = prefs.getInteger(Res.GameData.USER_LUOMUS,0);
                        now++;
                        prefs.putInteger(Res.GameData.USER_LUOMUS,now);
                        prefs.flush();

                    }else if(num == 1){
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                        int now = prefs.getInteger(Res.GameData.USER_LUOSIS,0);
                        now++;
                        prefs.putInteger(Res.GameData.USER_LUOSIS,now);
                        prefs.flush();
                    }else if(num == 2){
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                        int now = prefs.getInteger(Res.GameData.USER_STORES,0);
                        now++;
                        prefs.putInteger(Res.GameData.USER_STORES,now);
                        prefs.flush();

                    }
                    getMainGame().getGameScreen().getShopStage().setPurchaseEnable(btn);
                    getMainGame().getGameScreen().setShowResPurchaseStage(false,-1,-1,btn);
                    getMainGame().getGameScreen().setShowShopStage(true);


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
                getMainGame().getGameScreen().setShowResPurchaseStage(false,-1,-1,btn);
                getMainGame().getGameScreen().setShowShopStage(true);

            }
        });
        cancelBtn.setBounds(Res.Positions.DIALOG_BTN2_X,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(cancelBtn);
    }

    public void changeRes(Integer num){
        this.num = num;
    }

    public void changePrice(Integer price){
        this.price = price;
    }

    public void changeBtn(Integer btn){
        this.btn = btn;
    }

}


