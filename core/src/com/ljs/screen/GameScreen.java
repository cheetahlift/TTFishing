package com.ljs.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.ljs.MainGame;
import com.ljs.stage.home.FishInfoStage;
import com.ljs.stage.home.HomeStage;
import com.ljs.stage.home.SpeedStage;
import com.ljs.stage.market.AnsStage;
import com.ljs.stage.market.ConfirmBuyStage;
import com.ljs.stage.market.ConfirmSoldStage;
import com.ljs.stage.market.MarketStage;
import com.ljs.stage.shop.ConfirmPurchaseStage;
import com.ljs.stage.shop.ResPurchaseStage;
import com.ljs.stage.shop.ShopStage;
import com.ljs.stage.tech.ConfirmStage;
import com.ljs.stage.tech.TechStage;

public class GameScreen extends ScreenAdapter {
    private MainGame mainGame;

    /**home界面stage*/
    private HomeStage homeStage;
    private FishInfoStage fishInfoStage;
    private SpeedStage speedStage;

    /**tech界面stage*/
    private TechStage techStage;
    private ConfirmStage confirmStage;

    /**shop界面stage*/
    private ShopStage shopStage;
    private ConfirmPurchaseStage confirmPurchaseStage;
    private ResPurchaseStage resPurchaseStage;

    /**market界面stage*/
    private MarketStage marketStage;
    private ConfirmBuyStage confirmBuyStage;
    private ConfirmSoldStage confirmSoldStage;
    private AnsStage ansStage;


    public GameScreen(MainGame mainGame){
        this.mainGame = mainGame;
        init();
    }

    private void init(){
        /**创建home界面stage*/
        homeStage = new HomeStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        homeStage.DataFlush();

        //homeStage.setVisible(false);

        /**创建fishinfo界面stage*/
        fishInfoStage = new FishInfoStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        fishInfoStage.setVisible(false);

        /**创建speed界面stage*/
        speedStage = new SpeedStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        speedStage.setVisible(false);

        /**创建market界面stage*/
        marketStage = new MarketStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        marketStage.DataFlush();
        marketStage.setVisible(false);

        /**创建ConfirmBuy界面stage*/
        confirmBuyStage = new ConfirmBuyStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        confirmBuyStage.setVisible(false);

        /**创建confirmSold界面stage*/
        confirmSoldStage = new ConfirmSoldStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        confirmSoldStage.setVisible(false);
        /**创建ansStage*/
        ansStage = new AnsStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        ansStage.setVisible(false);

        /**创建Shop界面stage*/
        shopStage = new ShopStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        shopStage.setVisible(false);

        /**创建confirmpurchase界面stage*/
        confirmPurchaseStage = new ConfirmPurchaseStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        confirmPurchaseStage.setVisible(false);

        /**创建ResPurchase界面Stage*/
        resPurchaseStage = new ResPurchaseStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        resPurchaseStage.setVisible(false);

        /**创建Tech界面stage*/
        techStage = new TechStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        techStage.setVisible(false);

        /**创建confirm界面stage*/
        confirmStage = new ConfirmStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );
        confirmStage.setVisible(false);


        /**把输入交给homestage*/
        Gdx.input.setInputProcessor(homeStage);
    }
    public void restartGame() {
        homeStage.restartGame();
    }

    /**homestage 是否显示*/
    public void setShowHomeStage(boolean showHomeStage){
        homeStage.setVisible(showHomeStage);
        if(homeStage.isVisible()){
            /**刷新鱼类*/
            homeStage.DataFlush();
            homeStage.tellMe();
            homeStage.changeDires();
            Gdx.input.setInputProcessor(homeStage);
        }
    }

    /**fishinfo 是否显示*/
    public void setShowFishInfoStage(boolean showStage,String fishName,float health,Integer grow,Integer number){
        fishInfoStage.setVisible(showStage);
        //fishInfoStage.setData(fishName,health,grow);
        fishInfoStage.setNumber(number);
        homeStage.setNowChoose(number);
        if(fishInfoStage.isVisible()){
            Gdx.input.setInputProcessor(fishInfoStage);
        }else{
            Gdx.input.setInputProcessor(homeStage);
        }
    }
    /**SpeedStage 是否显示*/
    public void setShowSpeedStage(boolean showStage){
        speedStage.setVisible(showStage);
        if(speedStage.isVisible()){
            speedStage.DataFlush();
            Gdx.input.setInputProcessor(speedStage);
        }
    }

    /**market 是否显示*/
    public void setShowMarketStage(boolean showStage){
        marketStage.setVisible(showStage);
        if(marketStage.isVisible()){
            Gdx.input.setInputProcessor(marketStage);
        }
    }

    /** ConfirmBuyStage是否显示*/
    public void setShowConfirmBuyStage(boolean showStage,Integer fish,Integer price){
        confirmBuyStage.setVisible(showStage);
        confirmBuyStage.setFish(fish);
        confirmBuyStage.setPrice(price);
        if(confirmBuyStage.isVisible()){
            Gdx.input.setInputProcessor(confirmBuyStage);
        }
    }
    /**confirmsoldStage 是否显示*/
    public void setShowConfirmSoldStage(boolean showStage,Integer fish,Integer price){
        confirmSoldStage.setVisible(showStage);
        confirmSoldStage.setFish(fish);
        confirmSoldStage.setPrice(price);
        if(confirmSoldStage.isVisible()){
            Gdx.input.setInputProcessor(confirmSoldStage);
        }
    }
    /**ansStage是否显示*/
    public void setShowAnsStage(boolean showStage,Integer answer,Integer money){
        ansStage.setVisible(showStage);
        ansStage.setAnswer(answer);
        ansStage.setMoney(money);
        if(ansStage.isVisible()){
            Gdx.input.setInputProcessor(ansStage);
        }
    }

    /**ShopStage 是否显示*/
    public void setShowShopStage(boolean showStage){
        shopStage.setVisible(showStage);
        if(shopStage.isVisible()){
            confirmPurchaseStage.DataFlush();
            resPurchaseStage.DataFlush();
            Gdx.input.setInputProcessor(shopStage);
        }
    }
    /** ConfirmPurchase是否显示 并传参*/
    public void setShowConfirmPurchaseStage(boolean showStage,Integer num){
        confirmPurchaseStage.setVisible(showStage);
        confirmPurchaseStage.whichitem(num);
        if(confirmPurchaseStage.isVisible()){
            Gdx.input.setInputProcessor(confirmPurchaseStage);
        }
    }
    /** ResPurchase是否显示 并传参*/
    public void setShowResPurchaseStage(boolean showStage,Integer num,Integer price,Integer btn){
        resPurchaseStage.setVisible(showStage);
        resPurchaseStage.whichitem(num);
        resPurchaseStage.whichprice(price);
        resPurchaseStage.changeBtn(btn);

        if(resPurchaseStage.isVisible()){
            Gdx.input.setInputProcessor(resPurchaseStage);
        }
    }


    /** tech是否显示*/
    public void setShowTechStage(boolean showStage){
        techStage.setVisible(showStage);
        if(techStage.isVisible()){
            techStage.DataFlush();
            techStage.tellMe();
            Gdx.input.setInputProcessor(techStage);
        }
    }
    /**ConfirmStage 是否显示*/
    public void setShowConfirmStage(boolean showStage){
        confirmStage.setVisible(showStage);
        if(confirmStage.isVisible()){
            Gdx.input.setInputProcessor(confirmStage);
        }
    }


    @Override
    public void render(float delta) {
        /** 使用背景颜色清屏*/
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /**homeStage*/
        if(homeStage.isVisible()){
            homeStage.act();
            homeStage.draw();
        }

        /**FishInfostage*/
        if(fishInfoStage.isVisible()){
            fishInfoStage.act();
            fishInfoStage.draw();
        }
        /**speedstage*/
        if(speedStage.isVisible()){
            speedStage.act();
            speedStage.draw();
        }
        /**marketstage*/
        if(marketStage.isVisible()){
            marketStage.act();
            marketStage.draw();
        }
        /**confimrbuystage*/
        if(confirmBuyStage.isVisible()){
            confirmBuyStage.act();
            confirmBuyStage.draw();
        }

        /**confirmsoldstage*/
        if(confirmSoldStage.isVisible()){
            confirmSoldStage.act();
            confirmSoldStage.draw();
        }
        /**ansStage*/
        if(ansStage.isVisible()){
            ansStage.act();
            ansStage.draw();
        }

        /**Shopstage*/
        if(shopStage.isVisible()){
            shopStage.act();
            shopStage.draw();
        }
        /**confirmpurchasestage*/
        if(confirmPurchaseStage.isVisible()){
            confirmPurchaseStage.act();
            confirmPurchaseStage.draw();
        }
        /**respurchasestage*/
        if(resPurchaseStage.isVisible()){
            resPurchaseStage.act();
            resPurchaseStage.draw();
        }

        /**techstage*/
        if(techStage.isVisible()){
            techStage.act();
            techStage.draw();
        }

        /**confirmstage*/
        if(confirmStage.isVisible()){
            confirmStage.act();
            confirmStage.draw();
        }
        /**数据刷新*/

        homeStage.FishSwim();
        fishInfoStage.DataFlush();


    }
    @Override
    public void dispose() {
        /** 场景销毁时, 同时销毁所有舞台*/
        if (homeStage != null) {
            homeStage.dispose();
        }
        if(fishInfoStage!= null){
            fishInfoStage.dispose();
        }
        if(speedStage!= null){
            speedStage.dispose();
        }
        if(confirmBuyStage!= null){
            confirmBuyStage.dispose();
        }
        if(confirmSoldStage!= null){
            confirmSoldStage.dispose();
        }
        if(marketStage!= null){
            marketStage.dispose();
        }
        if(confirmPurchaseStage!= null){
            confirmPurchaseStage.dispose();
        }
        if(shopStage!= null){
            shopStage.dispose();
        }
        if(confirmStage!= null){
            confirmStage.dispose();
        }
        if(techStage!= null){
            techStage.dispose();
        }

    }
    public HomeStage getHomeStage() {
        return homeStage;
    }

    public ConfirmBuyStage getConfirmBuyStage() {
        return confirmBuyStage;
    }

    public ConfirmPurchaseStage getConfirmPurchaseStage() {
        return confirmPurchaseStage;
    }

    public ConfirmSoldStage getConfirmSoldStage() {
        return confirmSoldStage;
    }

    public ConfirmStage getConfirmStage() {
        return confirmStage;
    }

    public FishInfoStage getFishInfoStage() {
        return fishInfoStage;
    }

    public MarketStage getMarketStage() {
        return marketStage;
    }

    public ShopStage getShopStage() {
        return shopStage;
    }

    public SpeedStage getSpeedStage() {
        return speedStage;
    }

    public TechStage getTechStage() {
        return techStage;
    }

    public ResPurchaseStage getResPurchaseStage(){
        return resPurchaseStage;
    }

    public AnsStage getAnsStage() {
        return ansStage;
    }

}

