package com.ljs.stage.home;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

import java.text.NumberFormat;

/**点击鱼儿 鱼儿详情就会显示且跟随着动*/
public class FishInfoStage extends BaseStage {

    private Image bgImg;
    private float posX = 0;
    private float posY = 0;
    private Integer width = 621;
    private Integer height = 400;
    private float line1_posX = 0;
    private float line1_posY = 0;
    private float line2_posX = 0;
    private float line2_posY = 0;
    private float line3_posX = 0;
    private float line3_posY = 0;
    /**fishinfo*/
    private String fishName;
    private float health;
    private Integer grow;
    /**label*/
    private Label line1;
    private Label line2;
    private Label line3;
    /**fish actor*/
    private Integer number;

    public FishInfoStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }
    private void init(){
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.INFO_BG));
        bgImg.setBounds(posX,posY,width,height);
        addActor(bgImg);

        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        line1 = new Label("鱼类:",msgStyle);
        line1.setPosition(line1_posX,line1_posY);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("健康度:",msgStyle);
        line2.setPosition(line2_posX,line2_posY);
        line2.setFontScale(3F);
        addActor(line2);

        line3 = new Label("成长度:",msgStyle);
        line3.setPosition(line3_posX,line3_posY);
        line3.setFontScale(3F);
        addActor(line3);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getMainGame().getGameScreen().setShowFishInfoStage(false,fishName,health,grow,number);

            }
        });

    }
    //小数转百分比
    private static String getPercentValue( float similarity){
        NumberFormat fmt = NumberFormat.getPercentInstance();
        fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
        return fmt.format(similarity);
    }
    private static String getGrowValue(Integer grow){

        if(grow>= 1 && grow <= 4){
            return "鱼苗";
        }else if(grow >= 4 && grow <=9){
            return "小鱼";
        }else if(grow >= 9 && grow <= 14){
            return "未成年鱼";
        }else if(grow >= 14 && grow <=18){
            return "成年鱼";
        }else if (grow >= 19){
            return "老年鱼";
        }
        return "";
    }

    private void setData(String fishName,float health,Integer grow){
        this.fishName = fishName;
        this.health = health;
        this.grow = grow;
        line1.setText("鱼类:"+fishName);
        line2.setText("健康度:"+getPercentValue(health));
        line3.setText("成长度:"+getGrowValue(grow));
    }

    public void setPos(float posX,float posY){
        this.posX = posX + 200;
        this.posY = posY + 200;
        this.line1_posX = this.posX + 30;
        this.line1_posY = this.posY + 305;
        this.line2_posX = this.posX + 30;
        this.line2_posY = this.posY + 182;
        this.line3_posX = this.posX + 30;
        this.line3_posY = this.posY + 53;
        PosFlush();
        //设置相关坐标
    }

    public void PosFlush(){
        bgImg.setBounds(posX,posY,width,height);
        line1.setPosition(line1_posX,line1_posY);
        line2.setPosition(line2_posX,line2_posY);
        line3.setPosition(line3_posX,line3_posY);
    }

    public void setNumber(Integer number){
        this.number = number;
        //直接读取本地prefs
        Preferences perfs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[number]);
        int tn = perfs.getInteger(Res.GameData.USER_POOL_FISH[number]);
        String fname = Res.GameData.FISH_NAME[tn];
        perfs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[number]);
        float hn = perfs.getFloat(Res.GameData.USER_POOL_HEALTH[number],0.0f);
        perfs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[number]);
        Integer gn = perfs.getInteger(Res.GameData.USER_POOL_GROW[number],0);
        setData(fname,hn,gn);
    }

    public void DataFlush(){
        //得到所选鱼的坐标
        float fish_x = getMainGame().getGameScreen().getHomeStage().getChoose_X();
        float fish_y = getMainGame().getGameScreen().getHomeStage().getChoose_Y();
        setPos(fish_x,fish_y);

    }

}
