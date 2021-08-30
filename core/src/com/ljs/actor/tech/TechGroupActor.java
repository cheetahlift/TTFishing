package com.ljs.actor.tech;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

public class TechGroupActor extends BaseGroup {
    private Button ATechBtn;
    private Button BTechBtn;
    private Button CTechBtn;
    public TechGroupActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        /**A*/
        Button.ButtonStyle styleA = new Button.ButtonStyle();
        styleA.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_A)
        );
        ATechBtn = new Button(styleA);
        ATechBtn.setBounds(315,910,448,280);
        ATechBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击A科技进入confirm界面
                 *
                 * 显示confirmStage
                 * */
                Gdx.app.log("TAG","event:"+event);
                Gdx.app.log("TAG","x:"+x);
                Gdx.app.log("TAG","x:"+y);
                getMainGame().getGameScreen().getConfirmStage().changeText(1);
                getMainGame().getGameScreen().setShowConfirmStage(true);

            }
        });

        addActor(ATechBtn);

        /**B*/
        Button.ButtonStyle styleB = new Button.ButtonStyle();
        styleB.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_B)
        );
        BTechBtn = new Button(styleB);
        BTechBtn.setBounds(1843,720,478,500);
        BTechBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击B科技进入confirm界面
                 *
                 * 显示confirmStage
                 * */
                Gdx.app.log("TAG","event:"+event);
                Gdx.app.log("TAG","x:"+x);
                Gdx.app.log("TAG","x:"+y);
                getMainGame().getGameScreen().getConfirmStage().changeText(2);
                getMainGame().getGameScreen().setShowConfirmStage(true);

            }
        });
        addActor(BTechBtn);


        /**C*/
        Button.ButtonStyle styleC = new Button.ButtonStyle();
        styleC.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_C)
        );
        CTechBtn = new Button(styleC);
        CTechBtn.setBounds(1070,333,667,207);
        CTechBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击C科技进入confirm界面
                 *
                 * 显示confirmStage
                 * */
                Gdx.app.log("TAG","event:"+event);
                Gdx.app.log("TAG","x:"+x);
                Gdx.app.log("TAG","x:"+y);
                getMainGame().getGameScreen().getConfirmStage().changeText(3);
                getMainGame().getGameScreen().setShowConfirmStage(true);

            }
        });
        addActor(CTechBtn);

    }
}
