package com.ljs.stage.market;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ljs.MainGame;
import com.ljs.res.Res;
import com.ljs.stage.base.BaseStage;

public class AnsStage extends BaseStage {
    /**concern*/
    private Integer answer;/**1 成功  2失败*/
    private Integer money;
    /**背景*/
    private Image bgImg;
    /**TEXT*/
    private Label label;
    private Label line1;
    private Label line2;
    private Label line3;

    private Button okBtn;

    public AnsStage(MainGame mainGame, Viewport viewport){
        super(mainGame,viewport);
        init();
    }
    private void init(){
        /**加载对话框*/
        bgImg = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.DIALOG));
        bgImg.setBounds(Res.Positions.DIALOG_X,Res.Positions.DIALOG_Y,Res.Positions.DIALOG_WIDTH,Res.Positions.DIALOG_HEIGHT);
        addActor(bgImg);

        Label.LabelStyle  msgStyle = new Label.LabelStyle();
        msgStyle.font = getMainGame().getBitmapFont();
        msgStyle.fontColor = new Color(Color.WHITE);

        /**
         * 卖出提示
         * 你将邀请客户前往你的鱼塘
         * 若客户中意 则以__金币成交
         * 客户有拒绝交易的可能
         * */
        label = new Label("交易结果",msgStyle);
        label.setPosition(Res.Positions.DIALOG_TITLE_X,Res.Positions.DIALOG_TITLE_Y);
        label.setFontScale(5F);
        addActor(label);

        line1 = new Label("客户中意了您的鱼",msgStyle);
        line1.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE1_Y);
        line1.setFontScale(3F);
        addActor(line1);

        line2 = new Label("最终成交金币",msgStyle);
        line2.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE2_Y);
        line2.setFontScale(3F);
        addActor(line2);

        line3 = new Label(" ",msgStyle);
        line3.setPosition(Res.Positions.DIALOG_LINE_X,Res.Positions.DIALOG_LINE3_Y);
        line3.setFontScale(3F);
        addActor(line3);

        /**加载取消键*/
        Button.ButtonStyle stylebtn2 = new Button.ButtonStyle();
        stylebtn2.up = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_OK_U)
        );
        stylebtn2.down = new TextureRegionDrawable(
                getMainGame().getAtlas().findRegion(Res.AtlasNames.BTN_OK_D)
        );
        okBtn = new Button(stylebtn2);
        okBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /**
                 * 点击取消 回到MarketStage
                 *
                 *
                 * */
                /***
                 * code
                 * */
                getMainGame().getGameScreen().setShowAnsStage(false,answer,money);
                getMainGame().getGameScreen().setShowMarketStage(true);

            }
        });
        okBtn.setBounds(1210,Res.Positions.DIALOG_BTN2_Y,Res.Positions.DIALOG_BTN2_WIDTH,Res.Positions.DIALOG_BTN2_HEIGHT);
        addActor(okBtn);

    }

    public void setAnswer(Integer answer){
        this.answer = answer;
    }
    public void setMoney(Integer money){
        this.money = money;
        changeText();
    }
    public void changeText(){
        if(answer == 1){
            //交易成功
            line1.setText("客户中意了您的鱼");
            line2.setText("最终成交金币"+money);
            line3.setText(" ");
        }else if(answer == 2){
            //交易失败
            line1.setText("您所养的鱼没有得到客户的青睐");
            line2.setText("交易失败");
            line3.setText("可以尝试提升科技等级");
        }
    }

}
