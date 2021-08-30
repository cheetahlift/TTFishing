package com.ljs.stage.market;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.dialog.ForBuyActors;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

public class ConfirmBuyStage extends BaseStage {
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
    /**actor**/
    private ForBuyActors forBuyActors;
    public ConfirmBuyStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }

    private void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);


        label = new Label("买入提示",msgStyle);
        label.setPosition(Res.Positions.DIALOG_TITLE_X,Res.Positions.DIALOG_TITLE_Y);
        label.setFontScale(5F);
        addActor(label);

        line1 = new Label("确定以"+price+"金币买入吗?",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("市场保证鱼类满健康度满状态",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(3F);
        addActor(line2);

        line3 = new Label(" ",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(3F);
        addActor(line3);

        forBuyActors = new ForBuyActors(getMainGame());
        forBuyActors.setPosition(0,0);
        addActor(forBuyActors);

    }

    public void setFish(Integer fish){
        this.fish = fish;
        forBuyActors.changeFish(fish);
        setGolds();
    }
    public void setPrice(Integer price){
        this.price = price;
        forBuyActors.setPrice(price);
        label.setText("买入提示");
        line1.setText("确定以"+price+"金币买入吗?");
        line2.setText("市场保证鱼类成年且满健康度");
        line3.setText(" ");
    }
    public void setGolds(){
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
        int gold = prefs.getInteger(Res.GameData.USER_GOLDS, 0);
        this.golds = gold;
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
            label.setText("提示");
            line1.setText("购买失败");
            line2.setText("金币不足");
            line3.setText(" ");

        }else if(purchase == 3){
            label.setText("提示");
            line1.setText("购买失败");
            line2.setText("池塘容量不足");
            line3.setText("升级科技以获得更多容量");
        }
    }
}
