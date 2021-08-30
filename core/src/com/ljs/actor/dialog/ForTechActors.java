package com.ljs.actor.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

public class ForTechActors extends BaseGroup {
    /**确定按钮*/
    private Button confirmBtn;
    /**取消按钮*/
    private Button cancelBtn;
    /**X*/
    private Button xBtn;

    /**tech*/
    private Integer tech = 1;


    public ForTechActors(MainGame mainGame){
        super(mainGame);
        init();
    }

    private void init(){
        /**加载x*/
        Button.ButtonStyle stylex = new Button.ButtonStyle();
        stylex.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.X)
        );
        xBtn = new Button(stylex);
        xBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击x 回到techstage
                 * 隐藏confirmstage
                 *
                 * */

                getMainGame().getGameScreen().setShowConfirmStage(false);
                getMainGame().getGameScreen().setShowTechStage(true);

            }
        });
        xBtn.setBounds(Res.Positions.DIALOG_X_X,Res.Positions.DIALOG_X_Y,Res.Positions.DIALOG_X_WIDTH,Res.Positions.DIALOG_X_WIDTH);
        addActor(xBtn);

        /**加载确认键*/
        Button.ButtonStyle stylebtn1 = new Button.ButtonStyle();
        stylebtn1.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CONFIRM_U)
        );
        stylebtn1.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CONFIRM_D)
        );
        confirmBtn = new Button(stylebtn1);
        confirmBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击确认 回到techstage
                 * 并执行相关操作
                 *
                 * */
                /***
                 * code
                 * */
                // 读取本地材料剩余数量
                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                int luomus = prefs.getInteger(Res.GameData.USER_LUOMUS,0);
                prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                int luosis = prefs.getInteger(Res.GameData.USER_LUOSIS,0);
                prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                int stores = prefs.getInteger(Res.GameData.USER_STORES,0);


                if(tech == 1){
                    Gdx.app.log("TAG","running forTecACtir.84");
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
                    int rank = prefs.getInteger(Res.GameData.USER_ATECH,0);
                    Gdx.app.log("TAG","current rank = "+rank);
                    if(rank == 0){
                            if(luomus>=1 && luosis>=1 && stores>=1){
                                prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
                                prefs.putInteger(Res.GameData.USER_ATECH,1);
                                prefs.flush();
                                //升级
                                //减去相关数据
                                prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                                prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-1);
                                prefs.flush();
                                prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                                prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-1);
                                prefs.flush();
                                prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                                prefs.putInteger(Res.GameData.USER_STORES,stores-1);
                                prefs.flush();

                                getMainGame().getGameScreen().setShowConfirmStage(false);
                                getMainGame().getGameScreen().setShowTechStage(true);

                            }else {
                                //升级失败
                                getMainGame().getGameScreen().getConfirmStage().showError();
                            }

                    }else if( rank == 1){
                        if(luomus>=3 && luosis>=3 && stores>=3){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_ATECH,2);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-3);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank == 2){
                        if(luomus>=5 && luosis>=5 && stores>=5){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_ATECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_ATECH,3);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-5);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank >=3){
                        //升级失败 已满级


                    }

                }else if (tech == 2){
                    Gdx.app.log("TAG","running forTecACtir.170");
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
                    int rank = prefs.getInteger(Res.GameData.USER_BTECH,0);
                    Gdx.app.log("TAG","current rank = "+rank);
                    if(rank == 0){
                        if(luomus>=1 && luosis>=1 && stores>=1){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_BTECH,1);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-1);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-1);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-1);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if( rank == 1){
                        if(luomus>=3 && luosis>=3 && stores>=3){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_BTECH,2);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-3);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank == 2){
                        if(luomus>=5 && luosis>=5 && stores>=5){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_BTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_BTECH,3);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-5);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank >=3){
                        //升级失败 已满级

                    }

                }else if(tech == 3){
                    Gdx.app.log("TAG","running forTecACtir.255");
                    prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
                    int rank = prefs.getInteger(Res.GameData.USER_CTECH,0);
                    Gdx.app.log("TAG","current rank = "+rank);
                    if(rank == 0){
                        if(luomus>=1 && luosis>=1 && stores>=1){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_CTECH,1);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-1);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-1);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-1);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if( rank == 1){
                        if(luomus>=3 && luosis>=3 && stores>=3){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_CTECH,2);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-3);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-3);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank == 2){
                        if(luomus>=5 && luosis>=5 && stores>=5){
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_CTECH_FILENAME);
                            prefs.putInteger(Res.GameData.USER_CTECH,3);
                            prefs.flush();
                            //升级
                            //减去相关数据
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOMUS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOMUS,luomus-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_LUOSIS_FILENAME);
                            prefs.putInteger(Res.GameData.USER_LUOSIS,luosis-5);
                            prefs.flush();
                            prefs = Gdx.app.getPreferences(Res.GameData.USER_STOREs_FILENAME);
                            prefs.putInteger(Res.GameData.USER_STORES,stores-5);
                            prefs.flush();

                            getMainGame().getGameScreen().setShowConfirmStage(false);
                            getMainGame().getGameScreen().setShowTechStage(true);

                        }else {
                            //升级失败
                            getMainGame().getGameScreen().getConfirmStage().showError();
                        }

                    }else if(rank >=3){
                        //升级失败 已满级

                    }


                }




            }
        });
        confirmBtn.setBounds(Res.Positions.DIALOG_BTN1_X,Res.Positions.DIALOG_BTN1_Y,Res.Positions.DIALOG_BTN1_WIDTH,Res.Positions.DIALOG_BTN1_HEIGHT);
        addActor(confirmBtn);

        /**加载取消键*/
        Button.ButtonStyle stylebtn2 = new Button.ButtonStyle();
        stylebtn2.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CANCEL_U)
        );
        stylebtn2.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_CANCEL_D)
        );
        cancelBtn = new Button(stylebtn2);
        cancelBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击取消 回到techstage
                 *
                 *
                 * */
                /**测试保存数据*/
//                Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_GOLDS_FILENAME);
//                prefs.putInteger(Res.GameData.USER_GOLDS, 993);
//                prefs.flush();
                getMainGame().getGameScreen().setShowConfirmStage(false);
                getMainGame().getGameScreen().setShowTechStage(true);

            }
        });
        cancelBtn.setBounds(Res.Positions.DIALOG_BTN2_X,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(cancelBtn);
    }

    public void changeTech(Integer tech){
        this.tech = tech;
        Gdx.app.log("TAG","Tech change to "+tech);
    }

}
