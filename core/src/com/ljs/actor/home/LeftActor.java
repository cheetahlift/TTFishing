package com.ljs.actor.home;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

/**左侧*/
public class LeftActor extends BaseGroup {
    private Button goTechBtn;

    public LeftActor(MainGame mainGame){
        super(mainGame);
        init();
    }

    private void init(){
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.LEFT_HOUSE)
        );
        goTechBtn = new Button(style);
        goTechBtn.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event, float x, float y) {
               /**
                * 点击左侧房子 进入科技界面
                * 隐藏homestage
                * 显示techStage
                * */
                getMainGame().getGameScreen().setShowHomeStage(false);
                getMainGame().getGameScreen().setShowTechStage(true);
           }
        });
        addActor(goTechBtn);
        //goTechBtn.setBounds(0,806,400,634);

    }

}
