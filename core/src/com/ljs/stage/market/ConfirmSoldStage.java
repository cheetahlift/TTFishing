package com.ljs.stage.market;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;
/**卖出stage*/
public class ConfirmSoldStage extends BaseStage {
    /**鱼的种类*/
    private Integer fish;
    /**价格*/
    private Integer price;
    /**剩余金额*/
    private Integer golds;
    /**背景*/
    private Image bgImg;
    /**TEXT*/
    private Label label;
    private Label line1;
    private Label line2;
    private Label line3;

    private Button confirmBtn;
    /**取消按钮*/
    private Button cancelBtn;
    /**X*/
    private Button xBtn;

    public ConfirmSoldStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();

    }
    private  void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        /**
         * 卖出提示
         * 你将邀请客户前往你的鱼塘
         * 若客户中意 则以__金币成交
         * 客户有拒绝交易的可能
         * */
        label = new Label("卖出提示",msgStyle);
        label.setPosition(Res.Positions.DIALOG_TITLE_X,Res.Positions.DIALOG_TITLE_Y);
        label.setFontScale(5F);
        addActor(label);

        line1 = new Label("你将邀请客户前往你的鱼塘",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("若客户中意 则以"+price+"金币成交",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(3F);
        addActor(line2);

        line3 = new Label("客户有取消交易的可能",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(3F);
        addActor(line3);

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
                getMainGame().getGameScreen().setShowConfirmSoldStage(false,fish,price);
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
                 * 卖鱼 客户要求
                 * 健康度0.9-1.0  市场价格
                 * 健康度0.6-0.8  市场价格85%-95%
                 * 健康度0.6以下 不收
                 *鱼苗 小鱼 未成年鱼 成年鱼 老年鱼
                 * 1-4   4-9    9- 14    14-18   19-20
                 * &&
                 * 成长阶段
                 * 1-4  市场价格30%
                 * 4-9  市场价格 75%
                 * 9-14 市场价格90%
                 *14-18 市场价格
                 *19-20 市场价格95%
                 * */
                /**
                 * code
                 * */
                /**
                 * 算法思路
                 * 检查user池塘里有没有这种鱼
                 * 给池塘里的同类鱼估价
                 * 取价格最高的
                 * 无法卖出价格为负1
                 * 判断是否有最高价格的池塘号
                 * 置state为0
                 * 用户余额增加
                 * 弹出交易成功提示
                 *
                 * */
                Integer countPrice = -1;
                Integer target = -1;
                Integer tcountPrice;
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[0]);
                for(int i = 0;i<6;i++){
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
                    int state = prefs.getInteger(Res.GameData.USER_POOL[i],0);
                    if(state == 0){
                        continue;
                    }else{
                        prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[i]);
                        int tfish = prefs.getInteger(Res.GameData.USER_POOL_FISH[i],0);
                        if(tfish == fish){
                            //若为同类鱼 则估算价格
                            tcountPrice = price;
                            //获得健康度
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[i]);
                            float health = prefs.getFloat(Res.GameData.USER_POOL_HEALTH[i]);
                            if(health>=0.6 && health < 0.9){
                                //市场价格85%-95%
                                int ran2 =  (int) (Math.random()*(95-85)+85);
                                float ranf = ran2/100.0f;
                                tcountPrice =(int)(tcountPrice*ranf);
                            }else if(health>=0.9){
                                //市场价格

                            }else {//不收
                                tcountPrice = -1;
                            }
                            //获得成长阶段
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                            Integer grow = prefs.getInteger(Res.GameData.USER_POOL_GROW[i]);
                            if(grow>=1 && grow <= 4){
                                //30%
                                tcountPrice = (int)(tcountPrice*0.3f);
                            }else if(grow >= 4 && grow <= 9){
                                //75%
                                tcountPrice = (int)(tcountPrice*0.75f);
                            }else if(grow >= 9 && grow <= 14){
                                //90%
                                tcountPrice = (int)(tcountPrice*0.9f);
                            }else if(grow >= 14 && grow <= 18){
                                //100%
                            }else if(grow >= 19 && grow <= 20){
                                //95%
                                tcountPrice = (int)(tcountPrice*0.95f);
                            }
                        }else{
                            continue;
                        }
                    }
                    if(tcountPrice > countPrice){
                        countPrice = tcountPrice;
                        target = i;
                    }

                }

                if(countPrice<=0){
                    //交易失败
                    getMainGame().getGameScreen().setShowAnsStage(true,2,0);
                    getMainGame().getGameScreen().setShowConfirmSoldStage(false,fish,price);
                }else{
                    //以countPrice的价格交易成功
                    //置为0
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[target]);
                    prefs.putInteger(Res.GameData.USER_POOL[target],0);
                    prefs.flush();
                    //用户余额增加
                    golds += countPrice;
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
                    prefs.putInteger(Res.GameData.USER_GOLDS,golds);
                    prefs.flush();
                    //弹出交易成功的提示
                    getMainGame().getGameScreen().setShowAnsStage(true,1,countPrice);
                    getMainGame().getGameScreen().setShowConfirmSoldStage(false,fish,price);


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
                 * 点击取消 回到MarketStage
                 *
                 *
                 * */
                /***
                 * code
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(false,fish,price);
                getMainGame().getGameScreen().setShowMarketStage(true);

            }
        });
        cancelBtn.setBounds(Res.Positions.DIALOG_BTN2_X,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(cancelBtn);

    }

    public void setFish(Integer fish){
        this.fish = fish;
        setGolds();
    }
    public void setPrice(Integer price){
        this.price = price;
        line2.setText("若客户中意 则以"+price+"金币成交");
    }
    public void setGolds(){
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
        int gold = prefs.getInteger(Res.GameData.USER_GOLDS, 0);
        this.golds = gold;
    }
}
