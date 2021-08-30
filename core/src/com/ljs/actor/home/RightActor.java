package com.ljs.actor.home;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;


/**右侧*/
public class RightActor extends BaseGroup {
    private Button goShopBtn;
    public RightActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.RIGHT_HOUSE)
        );
        goShopBtn = new Button(style);
        goShopBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击右侧房子 进入shop界面
                 * 隐藏homestage
                 * 显示shopStage
                 * */
                getMainGame().getGameScreen().setShowHomeStage(false);
                getMainGame().getGameScreen().setShowShopStage(true);
            }
        });

        addActor(goShopBtn);
    }
}
