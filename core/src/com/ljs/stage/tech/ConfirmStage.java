package com.ljs.stage.tech;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.actor.dialog.ForSpeedActors;
import com.ljs.actor.dialog.ForTechActors;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

public class ConfirmStage extends BaseStage {

    /**对话框*/
    private Image bgImg;

    /**actor*/
    private ForTechActors forTechActors;

    /**TEXT*/
    private Label label;
    private Label line1;
    private Label line2;
    private Label line3;


    public ConfirmStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }
    private void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        /**加载actor*/
        forTechActors = new ForTechActors(getMainGame());
        forTechActors.setPosition(0,0);
        addActor(forTechActors);

        /**TEXT*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);
        /**
         * 你将消耗_螺母 _螺丝 _铁板
         * 升级本装置
         * 将提升鱼类的健康度/将加速鱼类的成长/将增加池塘的容量
         * 你目前还有_螺母 _螺丝 _铁板
         * */


        /**获取当前科技等级
         * 以判断需要多少材料
         * */
        /**
         * 0级->1级   1螺母 1螺丝 1铁矿
         * 1级->2级   3螺母 3螺丝 3铁矿
         * 2级->3级   5螺母 5螺丝 5铁矿
         * */

        label = new Label("提示",msgStyle);
        label.setPosition(Res.Positions.DIALOG_TITLE_X-400,Res.Positions.DIALOG_TITLE_Y);
        label.setFontScale(4F);
        addActor(label);

        line1 = new Label("你将消耗_螺母 _螺丝 _铁板",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("升级本装置",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(3F);
        addActor(line2);

        line3 = new Label("将提升鱼类的健康度",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(3F);
        addActor(line3);
        Gdx.app.log("TAG","confirmstage Loaded success");


    }

    public void changeText(Integer tech_num){
        Gdx.app.log("TAG","comfirmStage91:"+tech_num);
        forTechActors.changeTech(tech_num);
        /**读取本地数据*/
        Preferences prefs;
        if(tech_num == 1){
            label.setText("水分子过滤发动机");
            /**获取科技等级*/
            prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
            int rank = prefs.getInteger(Res.GameData.USER_ATECH,0);
            if(rank == 0){
                line1.setText("您将消耗1螺母1螺丝1铁矿");
                line2.setText("升级本装置");
                line3.setText("将提升鱼类的健康度");

            }else if(rank == 1){
                line1.setText("您将消耗3螺母3螺丝3铁矿");
                line2.setText("升级本装置");
                line3.setText("将提升鱼类的健康度");

            }else if(rank == 2){
                line1.setText("您将消耗5螺母5螺丝5铁矿");
                line2.setText("升级本装置");
                line3.setText("将提升鱼类的健康度");

            }else if(rank >=3){
                //科技已经满级
                line1.setText("科技已经满级");
                line2.setText("您的鱼塘鱼类很健康");
                line3.setText(" ");
            }


        }else if(tech_num == 2){
            label.setText("量子力学增氧装置");
            /**获取科技等级*/
            prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
            int rank = prefs.getInteger(Res.GameData.USER_BTECH,0);
            if(rank == 0){
                line1.setText("您将消耗1螺母1螺丝1铁矿");
                line2.setText("升级本装置");
                line3.setText("将加速鱼类的成长");

            }else if(rank == 1){
                line1.setText("您将消耗3螺母3螺丝3铁矿");
                line2.setText("升级本装置");
                line3.setText("将加速鱼类的成长");

            }else if(rank == 2){
                line1.setText("您将消耗5螺母5螺丝5铁矿");
                line2.setText("升级本装置");
                line3.setText("将加速鱼类的成长");

            }else if(rank >=3){
                //科技已经满级
                line1.setText("科技已经满级");
                line2.setText("您的鱼塘鱼类成长迅速");
                line3.setText(" ");
            }


        }else if(tech_num == 3){
            label.setText("锂离子科技扩容板");
            /**获取科技等级*/
            prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
            int rank = prefs.getInteger(Res.GameData.USER_CTECH,0);
            if(rank == 0){
                line1.setText("您将消耗1螺母1螺丝1铁矿");
                line2.setText("升级本装置");
                line3.setText("将增加池塘的容量");

            }else if(rank == 1){
                line1.setText("您将消耗3螺母3螺丝3铁矿");
                line2.setText("升级本装置");
                line3.setText("将增加池塘的容量");

            }else if(rank == 2){
                line1.setText("您将消耗5螺母5螺丝5铁矿");
                line2.setText("升级本装置");
                line3.setText("将增加池塘的容量");

            }else if(rank >=3){
                //科技已经满级
                line1.setText("科技已经满级");
                line2.setText("您的鱼塘容量已达最大");
                line3.setText(" ");
            }


        }

    }

    public void showError(){
        line1.setText("升级失败");
        line2.setText("相关材料不足");
        line3.setText("请前往商店以购买");
    }


}
