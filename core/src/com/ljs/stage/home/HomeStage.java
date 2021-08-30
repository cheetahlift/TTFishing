package com.ljs.stage.home;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.home.LeftActor;
import com.ljs.actor.home.PoolActor;
import com.ljs.actor.home.RightActor;
import com.ljs.actor.home.SunActor;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

/**
 * 主界面stage
 * */
public class HomeStage extends BaseStage {

    /**背景*/
    private Image bgImg;

    /**left actor*/
    private LeftActor leftActor;
    /**right actor*/
    private RightActor rightActor;
    /**sun*/
    private SunActor sunActor;
    /**fish*/
    private PoolActor poolActor;

    public HomeStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }

    private void init(){

        /**加载背景*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.HOME_BG));
        Gdx.app.log("TAG","running--------------");
        bgImg.setBounds(0,0,getMainGame().getWorldWidth(),getMainGame().getWorldHeight());
        addActor(bgImg);

        /**加载left*/
        leftActor = new LeftActor(getMainGame());
        leftActor.setBounds(0,813,400,634);
        addActor(leftActor);
        /**加载right*/
        rightActor = new RightActor(getMainGame());
        rightActor.setBounds(2183,813,400,634);
        addActor(rightActor);

        /**加载sun*/
        sunActor = new SunActor(getMainGame());
        sunActor.setPosition(1615,1097);
        addActor(sunActor);

        /**加载鱼儿们*/
        poolActor = new PoolActor(getMainGame());
        poolActor.setPosition(0,0);
        addActor(poolActor);



    }

    public void tellMe(){
        //读取本地鱼儿数据
        Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_MAX_FILENAME);
        int max = prefs.getInteger(Res.GameData.USER_MAX, 0);
        Gdx.app.log("TAG","max = "+max);
        for(int i = 0 ; i<6;i++){

            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
            int state = prefs.getInteger(Res.GameData.USER_POOL[i]);
            Gdx.app.log("TAG",i+" user.state ="+state);

            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[i]);
            int fish = prefs.getInteger(Res.GameData.USER_POOL_FISH[i]);
            Gdx.app.log("TAG",i+" user.fish ="+fish);

            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[i]);
            float health = prefs.getFloat(Res.GameData.USER_POOL_HEALTH[i]);
            Gdx.app.log("TAG",i+" user.health ="+health);


        }

    }

    public void DataFlush(){
        poolActor.DataFlush();
    }

    public void FishSwim(){
        /**鱼儿游动*/
        poolActor.FishSwim();
    }

    public void changeDires(){
        /**每次进入home刷新方向*/
        poolActor.changeDires();
    }

    public void setNowChoose(Integer number){
        poolActor.setNowChoose(number);
    }

    public float getChoose_X(){
        return poolActor.getChoose_X();
    }
    public float getChoose_Y(){
        return poolActor.getChoose_Y();
    }
    /**
     * 重新开始游戏
     */
    public void restartGame() {

    }

    @Override
    public void dispose() {
        super.dispose();

    }





}
