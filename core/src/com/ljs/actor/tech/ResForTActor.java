package com.ljs.actor.tech;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

public class ResForTActor extends BaseGroup {
    private Button LuoMuBtn;
    private Button LuoSiBtn;
    private Button StoreBtn;

    public ResForTActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        /**LuoMu*/
        Button.ButtonStyle styleA = new Button.ButtonStyle();
        styleA.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOMU)
        );
        LuoMuBtn = new Button(styleA);
        LuoMuBtn.setBounds(870,1259,130,130);
        addActor(LuoMuBtn);

        /**LuoSi*/
        Button.ButtonStyle styleB = new Button.ButtonStyle();
        styleB.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_LUOSI)
        );
        LuoSiBtn = new Button(styleB);
        LuoSiBtn.setBounds(1190,1259,130,130);
        addActor(LuoSiBtn);


        /**Store*/
        Button.ButtonStyle styleC = new Button.ButtonStyle();
        styleC.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.TECH_STORE)
        );
        StoreBtn = new Button(styleC);
        StoreBtn.setBounds(1510,1259,130,130);
        addActor(StoreBtn);


    }

}
