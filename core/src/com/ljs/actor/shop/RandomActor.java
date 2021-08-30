package com.ljs.actor.shop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

import java.util.Random;

/**商店每日随机刷新2个科技材料*/
public class RandomActor extends BaseGroup {
    /**num*/
    private int num1 = 0;
    private int num2 = 1;
    /**price*/
    private int tprice0 = 0;
    private int tprice1 = 0;

    /**购买按钮*/
    private Button buy0btn;
    private Button buy1btn;
    /**物品图片*/
    private Button item0;
    private Button item1;
    /**物品标签*/
    private Label label0;
    private Label label1;
    /**价格标签*/
    private Label price0;
    private Label price1;
    public RandomActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        /**
         * 0       1      2
         * luomu  luosi store
         * */
        /**TEXT*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        /**0*/
        Button.ButtonStyle styleitem0 = new Button.ButtonStyle();
        styleitem0.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOSI)
        );
        item0 = new Button(styleitem0);
        item0.setBounds(70,25,255,255);
        addActor(item0);
        label0 = new Label("螺丝",msgStyle);
        label0.setBounds(325,195,160,85);
        //label0.setPosition(360,660);
        label0.setFontScale(4F);
        addActor(label0);
        price0 = new Label("15",msgStyle);
        price0.setBounds(325,110,160,85);
        //price0.setPosition(360,570);
        price0.setFontScale(3F);
        addActor(price0);
        Button.ButtonStyle style0 = new Button.ButtonStyle();
        style0.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style0.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy0btn = new Button(style0);
        buy0btn.setBounds(325,25,160,85);
        buy0btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowResPurchaseStage(true,num1,tprice0,0);
            }
        });
        addActor(buy0btn);
        /**1*/
        Button.ButtonStyle styleitem1 = new Button.ButtonStyle();
        styleitem1.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOSI)
        );
        item1 = new Button(styleitem1);
        item1.setBounds(500,25,255,255);
        addActor(item1);
        label1 = new Label("螺丝",msgStyle);
        label1.setBounds(755,195,160,85);
        //label0.setPosition(360,660);
        label1.setFontScale(4F);
        addActor(label1);
        price1 = new Label("15",msgStyle);
        price1.setBounds(755,110,160,85);
        //price0.setPosition(360,570);
        price1.setFontScale(3F);
        addActor(price1);
        Button.ButtonStyle style1 = new Button.ButtonStyle();
        style0.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style0.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy1btn = new Button(style0);
        buy1btn.setBounds(755,25,160,85);
        buy1btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowResPurchaseStage(true,num2,tprice1,1);
            }
        });
        addActor(buy1btn);
        /**每天限制一次购买 刷新后可再购买*/
        setPurchaseEnable(-1);



    }

    public void goRandom(){
        /**商店每日随机刷新2个科技材料*/
        /**
         * 0       1      2
         * luomu  luosi store
         * 10-25  5-20  20-40
         *
         * */
        setPurchaseEnable(-1);
        Random r = new Random();
        int ban =  r.nextInt(100)%3;
        if(ban == 0){
            //luosi store
            num1 = 1;
            num2 = 2;
            /**改图片*/
            Button.ButtonStyle styleitem0 = new Button.ButtonStyle();
            styleitem0.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOSI)
            );
            item0.setStyle(styleitem0);
            /**改名*/
            label0.setText("螺丝");
            /**改价格*/
            tprice0 = (int) (Math.random()*(20-5)+5);
            price0.setText(tprice0+"");

            /**改图片*/
            Button.ButtonStyle styleitem1 = new Button.ButtonStyle();
            styleitem1.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_STORE)
            );
            item1.setStyle(styleitem1);
            /**改名*/
            label1.setText("铁矿");
            /**改价格*/
            tprice1 =  (int) (Math.random()*(40-20)+20);
            price1.setText(tprice1+"");
        }else if(ban == 1){
            //luosi store
            num1 = 0;
            num2 = 2;
            /**改图片*/
            Button.ButtonStyle styleitem0 = new Button.ButtonStyle();
            styleitem0.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOMU)
            );
            item0.setStyle(styleitem0);
            /**改名*/
            label0.setText("螺母");
            /**改价格*/
            tprice0 =  (int) (Math.random()*(25-10)+10);
            price0.setText(tprice0+"");

            /**改图片*/
            Button.ButtonStyle styleitem1 = new Button.ButtonStyle();
            styleitem1.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_STORE)
            );
            item1.setStyle(styleitem1);
            /**改名*/
            label1.setText("铁矿");
            /**改价格*/
            tprice1 =  (int) (Math.random()*(40-20)+20);
            price1.setText(tprice1+"");

        }else {
            //luomu luosi
            num1 = 0;
            num2 = 1;

            /**改图片*/
            Button.ButtonStyle styleitem0 = new Button.ButtonStyle();
            styleitem0.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOMU)
            );
            item0.setStyle(styleitem0);
            /**改名*/
            label0.setText("螺母");
            /**改价格*/
            tprice0 =  (int) (Math.random()*(25-10)+10);
            price0.setText(tprice0+"");

            /**改图片*/
            Button.ButtonStyle styleitem1 = new Button.ButtonStyle();
            styleitem1.up = new TextureRegionDrawable(
                    getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOSI)
            );
            item1.setStyle(styleitem1);
            /**改名*/
            label1.setText("螺丝");
            /**改价格*/
            tprice1 =  (int) (Math.random()*(20-5)+5);
            price1.setText(tprice1+"");


        }

    }

    public void setPurchaseEnable(Integer btn){

        if(btn == 0) buy0btn.setVisible(false);
        if(btn == 1) buy1btn.setVisible(false);
        if(btn == -1) {
            buy0btn.setVisible(true);
            buy1btn.setVisible(true);

        }
    }
}
