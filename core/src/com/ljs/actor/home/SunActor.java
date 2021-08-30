package com.ljs.actor.home;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;


public class SunActor extends BaseGroup {
    private Button sunBtn;
    public SunActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.SUN)
        );
        sunBtn = new Button(style);
        sunBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击sun 弹出speed stage对话框
                 * 不隐藏homestage
                 * 显示speedStage
                 * */
                //getMainGame().getGameScreen().setShowHomeStage(false);
                getMainGame().getGameScreen().setShowSpeedStage(true);
            }
        });
        addActor(sunBtn);
    }

}
