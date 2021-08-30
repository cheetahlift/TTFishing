package com.ljs.stage.market;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.market.GoBackBtn3;
import com.ljs.actor.market.MarketActor;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

/**市场界面*/
public class MarketStage extends BaseStage {
    /**背景*/
    private Image bgImg;

    /**market actor*/
    private MarketActor marketActor;
    /**actor*/
    private GoBackBtn3 goBackBtn3;

    public MarketStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }

    private void init(){
        /**加载背景*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.MARKET_BG));
        bgImg.setBounds(0,0,getMainGame().getWorldWidth(),getMainGame().getWorldHeight());
        addActor(bgImg);

        marketActor = new MarketActor(getMainGame());
        marketActor.setPosition(0,0);
        addActor(marketActor);

        goBackBtn3 = new GoBackBtn3(getMainGame());
        goBackBtn3.setPosition(60,1060);
        addActor(goBackBtn3);


    }
    public void DataFlush(){
        marketActor.DataFlush();
    }



}
