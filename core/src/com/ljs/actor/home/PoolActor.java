package com.ljs.actor.home;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;

import java.util.Random;


public class PoolActor extends BaseGroup {

    private FishActor[] fishActors;
    private final Integer LEFT_X = 430;
    private final Integer LEFT_Y = 30;
    private final Integer RIGHT_X = 1700;
    private final Integer RIGHT_Y = 500;
    private final float FISH_W = 290;
    private final float FISH_H = 290;
    private final Integer SPEED = 75;

    /**fish info*/
    //现在选择了那条鱼
    private Integer nowChoose = 0;

    private Integer[] direct = new Integer[6];//鱼儿游来游去方向
    /**
     * 池塘安全区域
     *                           1800,500
     *       <----1370----->^
     *                      |
     *                      470
     *                      |
     *                      v
     * 430,30
     * */
    /**
     * 290*290
     * */

    public PoolActor(MainGame mainGame){
        super(mainGame);
        init();
    }
    private void init(){
        fishActors = new FishActor[6];
        for(int i  = 0;i<6;i++){

            fishActors[i] = new FishActor(getMainGame());
            fishActors[i].setVisible(false);
            fishActors[i].setNumber(i);
            addActor(fishActors[i]);
        }


        /**加载鱼儿*/
        for(int i = 0;i<6;i++){
            // 读取本地鱼儿数据
            Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
            Integer state = prefs.getInteger(Res.GameData.USER_POOL[i], 0);

            if(state == 0) continue;
            else{
                Button.ButtonStyle style = new Button.ButtonStyle();
                //获取鱼儿种类
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[i]);
                Integer whatfish = prefs.getInteger(Res.GameData.USER_POOL_FISH[i],0);
                style.up = new TextureRegionDrawable(
                        getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[whatfish])
                );
                //fishActors[i] = new FishActor(getMainGame());
                fishActors[i].changeStyle(style);
                //获取鱼儿名
                String fishName =  Res.GameData.FISH_NAME[whatfish];
                //获取鱼儿健康度
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_HEALTH_FILENAME[i]);
                float health = prefs.getFloat(Res.GameData.USER_POOL_HEALTH[i],0.0f);
                //获取鱼儿成长度
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                Integer grow = prefs.getInteger(Res.GameData.USER_POOL_GROW[i],0);
                fishActors[i].setData(fishName,health,grow);
                int ranx = (int) (Math.random()*(RIGHT_X-LEFT_X)+LEFT_X);
                int rany = (int) (Math.random()*(RIGHT_Y-LEFT_Y)+LEFT_Y);
                fishActors[i].changePos((float) ranx,(float) rany);
//
                fishActors[i].setVisible(true);


            }

        }
        changeDires();



    }

    public void DataFlush(){
        /**加载鱼儿*/
        for(int i = 0;i<6;i++){
            // 读取本地鱼儿数据
            Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
            Integer state = prefs.getInteger(Res.GameData.USER_POOL[i], 0);

            if(state == 0) {
                fishActors[i].setVisible(false);
            }
            else{
                Button.ButtonStyle style = new Button.ButtonStyle();
                //获取鱼儿种类
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[i]);
                Integer whatfish = prefs.getInteger(Res.GameData.USER_POOL_FISH[i],0);
                style.up = new TextureRegionDrawable(
                        getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[whatfish])
                );
                fishActors[i].changeStyle(style);
                //获取鱼儿成长度
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                Integer grow = prefs.getInteger(Res.GameData.USER_POOL_GROW[i],0);
                fishActors[i].setGrow(grow);

                int ranx = (int) (Math.random()*(RIGHT_X-LEFT_X)+LEFT_X);
                int rany = (int) (Math.random()*(RIGHT_Y-LEFT_Y)+LEFT_Y);
                fishActors[i].changePos((float) ranx,(float) rany);
                //addActor(fish[i]);
                fishActors[i].DataFlush();

                fishActors[i].setVisible(true);


            }

        }

    }
    public void setDirect(Integer direct){

    }

    public void FishSwim(){
        /**鱼儿游动*/
        /**
         * 池塘安全区域
         *                           1800,500
         *       <----1370----->^
         *                      |
         *                      470
         *                      |
         *                      v
         * 430,30
         * */
        /**
         * 290*290
         * */
        /**加载鱼儿*/
        for(int i = 0;i<6;i++){
            // 读取本地鱼儿数据
            Preferences prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_STATE_FILENAME[i]);
            Integer state = prefs.getInteger(Res.GameData.USER_POOL[i], 0);

            /**准备水平翻转图片*/
            Button.ButtonStyle style = new Button.ButtonStyle();
            //获取鱼儿种类
            prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_FISH_FILENAME[i]);
            Integer whatfish = prefs.getInteger(Res.GameData.USER_POOL_FISH[i],0);
            if(state == 0) {
                fishActors[i].setVisible(false);
            }
            else{
                /**
                 * 鱼儿游来游去
                 * y不变
                 * x随机方向direct（每次进入homestage随机一次
                 * 向左 -  向右 +）
                 * x最小430 最大1800
                 * 触碰墙壁 x==430  || x== 1800
                 * direct改变
                 * 速度SPEED * Gdx.graphics.getDeltaTime()
                 * */
                /**获取初始值*/
                float ox = fishActors[i].getX();
                float oy = fishActors[i].getY();
                /**获取方向*/
                int dir = direct[i];
                if(dir == 0){
                    //Gdx.app.log("TAG","ori_x = "+ox);
                    //左 -
                    ox -= SPEED*Gdx.graphics.getDeltaTime();
                    //检查是否越界
                    if(ox<=LEFT_X){
                        //越界了
                        direct[i] = 1;//改变方向
                        ox += 100*Gdx.graphics.getDeltaTime();
                    }
                    //Gdx.app.log("TAG","new_x = "+ox);

                    /**水平翻转图片*/
                    style.up = new TextureRegionDrawable(
                            getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[whatfish])
                    );
                    //fishActors[i] = new FishActor(getMainGame());


                }else{
                    //右+
                    //Gdx.app.log("TAG","ori_x = "+ox);

                    ox += SPEED*Gdx.graphics.getDeltaTime();
                    //检查是否越界
                    if(ox>=RIGHT_X){
                        //越界了
                        direct[i] = 0;//改变方向
                        ox -= 100*Gdx.graphics.getDeltaTime();
                    }
                    //Gdx.app.log("TAG","new_x = "+ox);
                    /**水平翻转图片*/
                    TextureRegion textureRegion = new TextureRegion(
                            getMainGame().getAtlas().findRegion(Res.AtlasNames.FISH_PIC[whatfish])
                    );
                    textureRegion.flip(true,false);
                    style.up = new TextureRegionDrawable(textureRegion);
                }
                //获取鱼儿成长度
                prefs = Gdx.app.getPreferences(Res.GameData.USER_POOL_GROW_FILENAME[i]);
                Integer grow = prefs.getInteger(Res.GameData.USER_POOL_GROW[i],0);
                fishActors[i].setGrow(grow);
                fishActors[i].changePos((float) ox,(float) oy);

                fishActors[i].changeStyle(style);
                //addActor(fish[i]);
                fishActors[i].DataFlush();
                fishActors[i].setVisible(true);


            }

        }

    }

    public void changeDires(){
        //随机方向
        Random r = new Random();
        for(int i = 0;i<6;i++){
            direct[i] = r.nextInt()%2;
        }
    }

    public void setNowChoose(Integer nowChoose) {
        this.nowChoose = nowChoose;
    }

    public Integer getNowChoose() {
        return nowChoose;
    }

    public float getChoose_X(){
        return fishActors[nowChoose].getX();
    }
    public float getChoose_Y(){
        return fishActors[nowChoose].getY();
    }
}
