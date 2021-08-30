package com.ljs.actor.market;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

public class GoBackBtn3 extends BaseGroup {
    private Button goBackBtn3;
    public GoBackBtn3(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_GOBACK_L_U)
        );
        style.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_GOBACK_L_D)
        );
        goBackBtn3 = new Button(style);
        goBackBtn3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击返回 回到homestage
                 * 隐藏shopstage
                 * 显示homeStage
                 * */

                getMainGame().getGameScreen().setShowMarketStage(false);
                getMainGame().getGameScreen().setShowShopStage(true);

            }
        });

        addActor(goBackBtn3);
    }
}
