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

public class NormalActor extends BaseGroup {
    /**购买按钮*/
    private Button buy0btn;
    private Button buy1btn;
    private Button buy2btn;
    private Button buy3btn;
    private Button buy4btn;
    /**物品图片*/
    private Image item0;
    private Image item1;
    private Image item2;
    private Image item3;
    private Image item4;
    /**物品标签*/
    private Label label0;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    /**价格标签*/
    private Label price0;
    private Label price1;
    private Label price2;
    private Label price3;
    private Label price4;

    public NormalActor(MainGame mainGame){
        super(mainGame);
        init();
    }

    private void init(){
       /**烤鱼 青鱼 草鱼 鲨鱼 金鱼*/
       /**0    1   2   3   4*/
        /**加载烤鱼*/
        /**TEXT*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        /**0*/
        item0 = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[0]));
        item0.setBounds(70,480,290,290);
        addActor(item0);
        label0 = new Label(Res.GameData.FISH_NAME[0],msgStyle);
        label0.setBounds(360,660,160,90);
        //label0.setPosition(360,660);
        label0.setFontScale(4F);
        addActor(label0);
        price0 = new Label(String.valueOf(Res.GameData.FISH_CHILD_PRICE[0]),msgStyle);
        price0.setBounds(360,570,160,90);
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
        buy0btn.setBounds(360,480,160,90);
        buy0btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowConfirmPurchaseStage(true,0);
            }
        });
        addActor(buy0btn);
        /**1*/
        item1 = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[1]));
        item1.setBounds(550,480,290,290);
        addActor(item1);
        label1 = new Label(Res.GameData.FISH_NAME[1],msgStyle);
        label1.setBounds(840,660,160,90);
        //label0.setPosition(360,660);
        label1.setFontScale(4F);
        addActor(label1);
        price1 = new Label(String.valueOf(Res.GameData.FISH_CHILD_PRICE[1]),msgStyle);
        price1.setBounds(840,570,160,90);
        //price0.setPosition(360,570);
        price1.setFontScale(3F);
        addActor(price1);
        Button.ButtonStyle style1 = new Button.ButtonStyle();
        style1.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style1.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy1btn = new Button(style1);
        buy1btn.setBounds(840,480,160,90);
        buy1btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowConfirmPurchaseStage(true,1);
            }
        });
        addActor(buy1btn);
        /**2*/
        item2 = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[2]));
        item2.setBounds(1030,480,290,290);
        addActor(item2);
        label2 = new Label(Res.GameData.FISH_NAME[2],msgStyle);
        label2.setBounds(1320,660,160,90);
        //label0.setPosition(360,660);
        label2.setFontScale(4F);
        addActor(label2);
        price2 = new Label(String.valueOf(Res.GameData.FISH_CHILD_PRICE[2]),msgStyle);
        price2.setBounds(1320,570,160,90);
        //price0.setPosition(360,570);
        price2.setFontScale(3F);
        addActor(price2);
        Button.ButtonStyle style2 = new Button.ButtonStyle();
        style2.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style2.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy2btn = new Button(style2);
        buy2btn.setBounds(1320,480,160,90);
        buy2btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowConfirmPurchaseStage(true,2);
            }
        });
        addActor(buy2btn);

        /**3*/
        item3 = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[3]));
        item3.setBounds(1510,480,290,290);
        addActor(item3);
        label3 = new Label(Res.GameData.FISH_NAME[3],msgStyle);
        label3.setBounds(1800,660,160,90);
        //label0.setPosition(360,660);
        label3.setFontScale(4F);
        addActor(label3);
        price3 = new Label(String.valueOf(Res.GameData.FISH_CHILD_PRICE[3]),msgStyle);
        price3.setBounds(1800,570,160,90);
        //price0.setPosition(360,570);
        price3.setFontScale(3F);
        addActor(price3);
        Button.ButtonStyle style3 = new Button.ButtonStyle();
        style3.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style3.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy3btn = new Button(style3);
        buy3btn.setBounds(1800,480,160,90);
        buy3btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowConfirmPurchaseStage(true,3);
            }
        });
        addActor(buy3btn);

        /**4*/
        item4 = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[4]));
        item4.setBounds(1990,480,290,290);
        addActor(item4);
        label4 = new Label(Res.GameData.FISH_NAME[4],msgStyle);
        label4.setBounds(2280,660,160,90);
        //label0.setPosition(360,660);
        label4.setFontScale(4F);
        addActor(label4);
        price4 = new Label(String.valueOf(Res.GameData.FISH_CHILD_PRICE[4]),msgStyle);
        price4.setBounds(2280,570,160,90);
        //price0.setPosition(360,570);
        price4.setFontScale(3F);
        addActor(price4);
        Button.ButtonStyle style4 = new Button.ButtonStyle();
        style4.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_U)
        );
        style4.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUY_D)
        );
        buy4btn = new Button(style0);
        buy4btn.setBounds(2280,480,160,90);
        buy4btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击商品 进入确认购买界面
                 *
                 * 显示confirmpurchaseStage
                 * */
                getMainGame().getGameScreen().setShowConfirmPurchaseStage(true,4);
            }
        });
        addActor(buy4btn);







    }




}
