package com.ljs.actor.market;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ljs.MainGame;
import com.ljs.actor.base.BaseGroup;
import com.ljs.res.Res;
/** 0    1   2    3    4 */
/**烤鱼 青鱼 草鱼 鲨鱼 金鱼*/
/**价格 按钮*/
public class MarketActor extends BaseGroup {

    /**买卖价格标签*/
    private Label  item_0_buy;
    private Label  item_0_sold;
    private Label  item_1_buy;
    private Label  item_1_sold;
    private Label  item_2_buy;
    private Label  item_2_sold;
    private Label  item_3_buy;
    private Label  item_3_sold;
    private Label  item_4_buy;
    private Label  item_4_sold;
    /**买卖按钮*/
    private Button buy_0_btn;
    private Button sold_0_btn;
    private Button buy_1_btn;
    private Button sold_1_btn;
    private Button buy_2_btn;
    private Button sold_2_btn;
    private Button buy_3_btn;
    private Button sold_3_btn;
    private Button buy_4_btn;
    private Button sold_4_btn;
    /**买卖价格*/
    private Integer price_0_buy;
    private Integer price_0_sold;
    private Integer price_1_buy;
    private Integer price_1_sold;
    private Integer price_2_buy;
    private Integer price_2_sold;
    private Integer price_3_buy;
    private Integer price_3_sold;
    private Integer price_4_buy;
    private Integer price_4_sold;


    public MarketActor(MainGame mainGame){
        super(mainGame);
        init();

    }
    private void init(){

        /**TEXT*/
        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.BLACK);
        /**Button Style*/
        Button.ButtonStyle buy_style = new Button.ButtonStyle();
        buy_style.up = new TextureRegionDrawable(getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_BUYIN));
        Button.ButtonStyle sold_style = new Button.ButtonStyle();
        sold_style.up = new TextureRegionDrawable(getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_SOLD));

        /**item 0*/
        /**label*/
        item_0_buy = new Label("888",msgStyle);
        item_0_buy.setBounds(193,343,170,87);
        item_0_buy.setFontScale(2F);
        addActor(item_0_buy);
        item_0_sold = new Label("111",msgStyle);
        item_0_sold.setBounds(376,343,178,87);
        item_0_sold.setFontScale(2F);
        addActor(item_0_sold);
        /**button*/
        buy_0_btn = new Button(buy_style);
        buy_0_btn.setBounds(193,241,170,87);
        buy_0_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(true,0,price_0_buy);
            }
        });
        addActor(buy_0_btn);
        sold_0_btn = new Button(sold_style);
        sold_0_btn.setBounds(376,244,178,87);
        sold_0_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(true,0,price_0_sold);
            }
        });
        addActor(sold_0_btn);
        /**item 1*/
        /**label*/
        item_1_buy = new Label("888",msgStyle);
        item_1_buy.setBounds(657,347,170,87);
        item_1_buy.setFontScale(2F);
        addActor(item_1_buy);
        item_1_sold = new Label("111",msgStyle);
        item_1_sold.setBounds(840,347,178,87);
        item_1_sold.setFontScale(2F);
        addActor(item_1_sold);
        /**button*/
        buy_1_btn = new Button(buy_style);
        buy_1_btn.setBounds(657,244,170,87);
        buy_1_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(true,1,price_1_buy);
            }
        });
        addActor(buy_1_btn);
        sold_1_btn = new Button(sold_style);
        sold_1_btn.setBounds(840,244,178,87);
        sold_1_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(true,1,price_1_sold);
            }
        });
        addActor(sold_1_btn);
        /**item 2*/
        /**label*/
        item_2_buy = new Label("888",msgStyle);
        item_2_buy.setBounds(1095,347,170,87);
        item_2_buy.setFontScale(2F);
        addActor(item_2_buy);
        item_2_sold = new Label("111",msgStyle);
        item_2_sold.setBounds(1276,347,178,87);
        item_2_sold.setFontScale(2F);
        addActor(item_2_sold);
        /**button*/
        buy_2_btn = new Button(buy_style);
        buy_2_btn.setBounds(1095,245,170,87);
        buy_2_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(true,2,price_2_buy);
            }
        });
        addActor(buy_2_btn);
        sold_2_btn = new Button(sold_style);
        sold_2_btn.setBounds(1276,245,178,87);
        sold_2_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(true,2,price_2_sold);
            }
        });
        addActor(sold_2_btn);
        /**item 3*/
        /**label*/
        item_3_buy = new Label("888",msgStyle);
        item_3_buy.setBounds(1523,347,170,87);
        item_3_buy.setFontScale(2F);
        addActor(item_3_buy);
        item_3_sold = new Label("111",msgStyle);
        item_3_sold.setBounds(1705,347,178,87);
        item_3_sold.setFontScale(2F);
        addActor(item_3_sold);
        /**button*/
        buy_3_btn = new Button(buy_style);
        buy_3_btn.setBounds(1523,245,170,87);
        buy_3_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(true,3,price_3_buy);
            }
        });
        addActor(buy_3_btn);
        sold_3_btn = new Button(sold_style);
        sold_3_btn.setBounds(1705,245,178,87);
        sold_3_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(true,3,price_3_sold);
            }
        });
        addActor(sold_3_btn);
        /**item 4*/
        /**label*/
        item_4_buy = new Label("888",msgStyle);
        item_4_buy.setBounds(1961,347,170,87);
        item_4_buy.setFontScale(2F);
        addActor(item_4_buy);
        item_4_sold = new Label("111",msgStyle);
        item_4_sold.setBounds(2144,347,178,87);
        item_4_sold.setFontScale(2F);
        addActor(item_4_sold);
        /**button*/
        buy_4_btn = new Button(buy_style);
        buy_4_btn.setBounds(1961,245,170,87);
        buy_4_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmBuyStage(true,4,price_4_buy);
            }
        });
        addActor(buy_4_btn);
        sold_4_btn = new Button(sold_style);
        sold_4_btn.setBounds(2144,245,178,87);
        sold_4_btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 买入按钮
                 * 展示confirmbuystage
                 * */
                getMainGame().getGameScreen().setShowConfirmSoldStage(true,4,price_4_sold);
            }
        });
        addActor(sold_4_btn);


    }

    public void DataFlush(){
        /**刷新价格 每次时间加速后*/
        /**
         * 市场价格波动(买卖)
         * 烤鱼 	青鱼 	草鱼 	鲨鱼 	金鱼
         * 70,100	120,140  100,160  230,250  300,500
         * */
        price_0_buy = (int) (Math.random()*(100-70)+70);
        price_0_sold = (int) (Math.random()*(100-70)+70);
        price_1_buy = (int) (Math.random()*(140-120)+120);
        price_1_sold = (int) (Math.random()*(140-120)+120);
        price_2_buy = (int) (Math.random()*(160-100)+100);
        price_2_sold = (int) (Math.random()*(160-100)+100);
        price_3_buy = (int) (Math.random()*(250-230)+230);
        price_3_sold = (int) (Math.random()*(250-230)+230);
        price_4_buy = (int) (Math.random()*(500-300)+300);
        price_4_sold = (int) (Math.random()*(500-300)+300);

        item_0_buy.setText(price_0_buy+"");
        item_0_sold.setText(price_0_sold+"");
        item_1_buy.setText(price_1_buy+"");
        item_1_sold.setText(price_1_sold+"");
        item_2_buy.setText(price_2_buy+"");
        item_2_sold.setText(price_2_sold+"");
        item_3_buy.setText(price_3_buy+"");
        item_3_sold.setText(price_3_sold+"");
        item_4_buy.setText(price_4_buy+"");
        item_4_sold.setText(price_4_sold+"");

    }
}
