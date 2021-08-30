package com.ljs.stage.shop;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.shop.GoBackBtn2;
import com.ljs.actor.shop.NormalActor;
import com.ljs.actor.shop.RandomActor;
import com.ljs.actor.tech.GoBackBtn;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;
/**商店界面*/
public class ShopStage extends BaseStage {
    /**背景*/
    private Image bgImg;

    /**shop actor*/
    private GoBackBtn2 goBackBtn2;
    private NormalActor normalActor;
    private RandomActor randomActor;

    /**去往market*/
    private Button goMarketBtn;


    public ShopStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }
    private void init(){
        /**加载背景*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.SHOP_BG));
        bgImg.setBounds(0,0,getMainGame().getWorldWidth(),getMainGame().getWorldHeight());
        addActor(bgImg);

        /**加载返回按钮*/
        goBackBtn2 = new GoBackBtn2(getMainGame());
        goBackBtn2.setPosition(60,1060);
        addActor(goBackBtn2);

        /**加载商品列表*/
        normalActor = new NormalActor(getMainGame());
        normalActor.setPosition(0,0);
        addActor(normalActor);

        /**加载随机材料列表*/
        randomActor = new RandomActor(getMainGame());
        randomActor.setPosition(0,0);
        randomActor.goRandom();
        addActor(randomActor);

        Button.ButtonStyle style2 = new Button.ButtonStyle();
        style2.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.MARKET_BTN_D)
        );
        style2.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.MARKET_BTN_U)
        );
        goMarketBtn = new Button(style2);
        goMarketBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击返回 回到homestage
                 * 隐藏techstage
                 * 显示homeStage
                 * */
                getMainGame().getGameScreen().setShowShopStage(false);
                getMainGame().getGameScreen().setShowMarketStage(true);

            }
        });
        goMarketBtn.setBounds(1849,100,600,300);
        addActor(goMarketBtn);



    }

    public void randomFlush(){
        randomActor.goRandom();
    }

    public void setPurchaseEnable(Integer btn){
        randomActor.setPurchaseEnable(btn);
    }
}
