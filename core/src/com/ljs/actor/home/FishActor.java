package com.ljs.actor.home;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;
/**鱼儿本体*/
public class FishActor extends BaseGroup {
    private Button fish;
    private float x = 0;
    private float y = 0;
    private Button.ButtonStyle style;
    private boolean flips;

    /**fish info */
    private String fishName;
    private float health;
    private Integer grow;

    /**stage concern*/
    private Integer number;

    public FishActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        fish = new Button();
        fish.setBounds(x,y,290,290);
        style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[0])
        );

        fish.setStyle(style);
        fish.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                /**NullPointerException*/
                changeListener();
            }
        });
        addActor(fish);
    }
    public void changePos(float x , float y){
        this.x = x;
        this.y = y;
    }
    public void changeStyle(Button.ButtonStyle style){
        this.style = style;
    }
    public void DataFlush(){
        fish.setBounds(x,y,convertW(grow),convertH(grow));
        fish.setStyle(style);
    }

    private float convertW(Integer grow) {
        if(grow >= 1 && grow <=4){
            return 190.0f;
        }else if(grow > 4 && grow <= 9){
            return 230.0f;
        }else if(grow > 9 && grow <= 14 ){
            return 280.0f;
        }else if(grow >14){
            return 310.0f;
        }
        return 0;
    }
    private float convertH(Integer grow) {
        if(grow >= 1 && grow <=4){
            return 160.0f;
        }else if(grow > 4 && grow <= 9){
            return 200.0f;
        }else if(grow > 9 && grow <= 14 ){
            return 250.0f;
        }else if(grow >14){
            return 290.0f;
        }
        return 0;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public void changeListener(){
        getMainGame().getGameScreen().setShowFishInfoStage(true,fishName,health,grow,number);

    }

    public void setData(String fishName,float health,Integer grow){
        this.fishName = fishName;
        this.health = health;
        this.grow = grow;
    }


    public void setNumber(Integer number){
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setGrow(Integer grow) {
        this.grow = grow;
    }
}
