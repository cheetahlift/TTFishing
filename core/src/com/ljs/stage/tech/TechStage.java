package com.ljs.stage.tech;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.tech.GoBackBtn;
import com.ljs.actor.tech.ResForTActor;
import com.ljs.actor.tech.TechGroupActor;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

public class TechStage extends BaseStage {
    /**背景*/
    private Image bgImg;
    /**tech actor*/
    private TechGroupActor techGroupActor;
    private GoBackBtn goBackBtn;
    private ResForTActor resForTActor;
    /**3个材料数量*/
    private Label luomu_num ;
    private Label luosi_num ;
    private Label store_num ;


    public TechStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }

    private void init(){
        /**加载背景*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_BG));
        bgImg.setBounds(0,0,getMainGame().getWorldWidth(),getMainGame().getWorldHeight());
        addActor(bgImg);

        /**加载科技*/
        techGroupActor = new TechGroupActor(getMainGame());
        techGroupActor.setPosition(0,0);
        addActor(techGroupActor);

        /**加载3个材料*/
        resForTActor = new ResForTActor(getMainGame());
        resForTActor.setPosition(0,0);
        addActor(resForTActor);


        /**加载返回按钮*/
        goBackBtn = new GoBackBtn(getMainGame());
        goBackBtn.setPosition(1949,160);
        addActor(goBackBtn);

        /**加载3个材料数量*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        luomu_num = new Label("000",msgStyle);
        luomu_num.setBounds(1030,1259,130,130);
        luomu_num.setFontScale(2F);
        addActor(luomu_num);

        luosi_num = new Label("000",msgStyle);
        luosi_num.setBounds(1350,1259,130,130);
        luosi_num.setFontScale(2F);
        addActor(luosi_num);

        store_num = new Label("000",msgStyle);
        store_num.setBounds(1670,1259,130,130);
        store_num.setFontScale(2F);
        addActor(store_num);




    }

    public void DataFlush(){
        /**读取本地数据*/
        /**3个材料*/
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
        int luomus = prefs.getInteger(Res.GameData.USER_LUOMUS,0);
        prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
        int luosis = prefs.getInteger(Res.GameData.USER_LUOSIS,0);
        prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
        int stores = prefs.getInteger(Res.GameData.USER_STORES,0);
        Gdx.app.log("TAG","luomus = "+ luomus+" luosi = "+luosis+" store = "+stores);
        luomu_num.setText(luomus+"");
        luosi_num.setText(luosis+"");
        store_num.setText(stores+"");

    }

    public void tellMe(){
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
        int atech = prefs.getInteger(Res.GameData.USER_ATECH,-1);
        prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
        int btech = prefs.getInteger(Res.GameData.USER_BTECH,-1);
        prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
        int ctech = prefs.getInteger(Res.GameData.USER_CTECH,-1);
        Gdx.app.log("TAG","a = " + atech+" b = "+btech + " c =" +ctech);

    }
}
