package com.ljs.actor.base;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.ljs.MainGame;

public abstract class BaseGroup extends Group {
    private MainGame mainGame;
    public BaseGroup(MainGame mainGame){
        this.mainGame = mainGame;
    }
    public MainGame getMainGame(){
        return mainGame;
    }
    public void setMainGame(MainGame mainGame){
        this.mainGame = mainGame;
    }
}
