package com.ljs.stage.home;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.dialog.ForSpeedActors;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;


/**加速时间对话框*/
public class SpeedStage extends BaseStage {

    /**对话框*/
    private Image bgImg;


    /**actor*/
    private ForSpeedActors forSpeedActors;

    /**TEXT*/
    private Label label;
    private Label line1;
    private Label line2;
    private Label line3;
    private Label line4;


    public SpeedStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }
    private void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        /**加载actor*/
        forSpeedActors = new ForSpeedActors(getMainGame());
        forSpeedActors.setPosition(0,0);
        addActor(forSpeedActors);

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

        line1 = new Label("您将消耗1金币使时间度过一天",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("您目前还有"+golds+"金币",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(3F);
        addActor(line2);


        line3 = new Label("您确定吗?",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(3F);
        addActor(line3);


        Gdx.app.log("TAG","SpeedStage Loaded success");

    }

    public void DataFlush(){
        /**读取本地数据*/
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
        int golds = prefs.getInteger(Res.GameData.USER_GOLDS, 0);
        line2.setText("您目前还有"+golds+"金币");
    }
}
