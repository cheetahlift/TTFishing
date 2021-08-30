package com.ljs.stage.shop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.dialog.ForShopActors;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

public class ConfirmPurchaseStage extends BaseStage {
    private ForShopActors forShopActors;
    private Image bgImg;
    /**TEXT*/
    private Label label;
    private Label line1;
    private Label line2;
    private Label line3;
    private Label line4;

    public ConfirmPurchaseStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }

    private void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        forShopActors = new ForShopActors(getMainGame());
        forShopActors.setPosition(0,0);
        addActor(forShopActors);
        /**TEXT*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        /**读取本地数据*/
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
        int golds = prefs.getInteger(Res.GameData.USER_GOLDS, 0);

        label = new Label("提示",msgStyle);
        label.setPosition(Res.Positions.DIALOG_TITLE_X,Res.Positions.DIALOG_TITLE_Y);
        label.setFontScale(5F);
        addActor(label);

        line1 = new Label("您将消耗金币",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(4F);
        addActor(line1);

        line2 = new Label("以购买",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(4F);
        addActor(line2);

        line3 = new Label("您目前还有"+golds+"金币",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(4F);
        addActor(line3);

    }
    public void whichitem(Integer num){
        line1.setText("您将消耗"+Res.GameData.FISH_CHILD_PRICE[num]+"金币");
        line2.setText("以购买"+Res.GameData.FISH_NAME[num]);
        forShopActors.changeFish(num);
    }
    public void changeText(Integer purchase){
        if(purchase == 1){
            /**购买成功*/
            label.setText("购买成功");
            line1.setText("返回鱼塘查看您刚买的鱼苗");
            line2.setText(" ");
            line3.setText(" ");
        }else if(purchase == 2){
            /**购买失败*/
            /**金币不足*/
            line1.setText("购买失败");
            line2.setText("金币不足");
            line3.setText(" ");

        }else if(purchase == 3){
            line1.setText("购买失败");
            line2.setText("池塘容量不足");
            line3.setText("升级科技以获得更多容量");
        }
    }

    public void DataFlush(){
        /**读取本地数据*/
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
        int golds = prefs.getInteger(Res.GameData.USER_GOLDS, 0);
        line3.setText("您目前还有"+golds+"金币");
    }
}
