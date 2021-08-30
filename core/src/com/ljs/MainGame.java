package com.ljs;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ljs.res.Res;
import com.ljs.screen.GameScreen;

public class MainGame extends Game {

	public static final String TAG = "TTFishing";

	/**世界高度*/
	private float worldHeight;

	/**世界宽度*/
	private float worldWidth;

	/**资源管理器*/
	private AssetManager assetManager;

	/**atlas*/
	private TextureAtlas atlas;

	/**字体*/
	private BitmapFont bitmapFont;

	/**主游戏场景*/
	private GameScreen gameScreen;


	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		/**按实际比例拉长世界宽度*/
		worldHeight = Res.FIX_WORLD_HEIGHT;
		worldWidth = Res.FIX_WORLD_WIDTH;

		Gdx.app.log(TAG,"world size(height*width) :"+worldHeight+"*"+worldWidth);

		/**资源管理器*/
		assetManager = new AssetManager();
		assetManager.load(Res.ATLAS_PATH,TextureAtlas.class);
		assetManager.load(Res.BITMAP_FONT_PATH,BitmapFont.class);

		assetManager.finishLoading();

		/**获取资源*/
		atlas = assetManager.get(Res.ATLAS_PATH,TextureAtlas.class);
		bitmapFont = assetManager.get(Res.BITMAP_FONT_PATH,BitmapFont.class);

		/**创建主游戏场景*/
		gameScreen = new GameScreen(this);


		/**设置当前场景*/
		setScreen(gameScreen);

		Gdx.input.setCatchBackKey(true);

	}

//	@Override
//	public void render () {
//
//	}
	
	@Override
	public void dispose () {
		super.dispose();
		// 应用退出时, 需要手动销毁场景
		if (gameScreen != null) {
			gameScreen.dispose();
		}
		// 应用退出时释放资源
		if (assetManager != null) {
			assetManager.dispose();
		}


	}
	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public float getWorldWidth() {
		return worldWidth;
	}

	public float getWorldHeight() {
		return worldHeight;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public TextureAtlas getAtlas() {
		return atlas;
	}

	public BitmapFont getBitmapFont() {
		return bitmapFont;
	}

}
