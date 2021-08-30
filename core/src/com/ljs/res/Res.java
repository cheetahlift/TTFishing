package com.ljs.res;

/**
 * 资源包
 * */
public interface Res {
    /**世界高度 1440*/
    public static final float FIX_WORLD_HEIGHT = 1440;
    /**世界宽度 2560*/
    public static final float FIX_WORLD_WIDTH = 2560;

    /**对话框 高度*/
    public static final float DIALOG_HEIGHT = 800;

    /**texture 路径*/
    public static final String ATLAS_PATH = "atlas/myatlas.atlas";

    /**字体路径*/
    public static final String BITMAP_FONT_PATH = "font/chinese.fnt";


    /***
     * position
     * */
    public static interface Positions{
        public static final float LUOMU_X = 1030;
        public static final float LUOMU_Y = 1259;
        public static final float LUOSI_X = 1190;
        public static final float LUOSI_Y = 1259;
        public static final float STORE_X = 1670;
        public static final float STORE_Y = 1259;

        public static final float DIALOG_X = 480;
        public static final float DIALOG_Y = 340;
        public static final float DIALOG_WIDTH = 1543;
        public static final float DIALOG_HEIGHT = 877;
        public static final float DIALOG_BTN1_X = 797;
        public static final float DIALOG_BTN1_Y = 407;
        public static final float DIALOG_BTN1_WIDTH = 356;
        public static final float DIALOG_BTN1_HEIGHT = 166;
        public static final float DIALOG_BTN2_X = 1350;
        public static final float DIALOG_BTN2_Y = 407;
        public static final float DIALOG_BTN2_WIDTH = 356;
        public static final float DIALOG_BTN2_HEIGHT = 166;
        public static final float DIALOG_X_X = 1835;
        public static final float DIALOG_X_Y = 1040;
        public static final float DIALOG_X_WIDTH = 128;
        public static final float DIALOG_TITLE_X = 1077;
        public static final float DIALOG_TITLE_Y = 1053;
        public static final float DIALOG_LINE_X = 640;
        public static final float DIALOG_LINE1_Y = 910;
        public static final float DIALOG_LINE2_Y = 805;
        public static final float DIALOG_LINE3_Y = 700;
        public static final float DIALOG_LINE4_Y = 595;


    }

    /**
     * atlas
     * */
    public static interface AtlasNames{
        /**home*/
        public static final String HOME_BG = "homebg";
        public static final String SUN = "sun";
        public static final String LEFT_HOUSE = "lefthouse";
        public static final String RIGHT_HOUSE = "righthouse";
        public static final String INFO_BG = "info_bg";

        /**fish*/
        public static final String[] FISH_PIC = {"kaoyu","qinyu","caoyu","shayu","jinyu"};

        /**tech*/
        public static final String TECH_A = "atech";
        public static final String TECH_B = "btech";
        public static final String TECH_C = "ctech";
        public static final String TECH_BG = "tech_bg";
        public static final String TECH_LUOMU = "luomu";
        public static final String TECH_LUOSI = "luosi";
        public static final String TECH_STORE = "store";

        /**shop*/
        public static final String SHOP_BG = "shopbg";
        public static final String SHOP_KUANG = "kuang";

        /**button*/
        public static final String BTN_BUY_D = "buy_d";
        public static final String BTN_BUY_U = "buy_u";
        public static final String BTN_BUYIN = "buyin";
        public static final String BTN_SOLD = "soldout";
        public static final String BTN_CANCEL_D = "cancel_d";
        public static final String BTN_CANCEL_U = "cancel_u";
        public static final String BTN_CONFIRM_D = "confirm_d";
        public static final String BTN_CONFIRM_U = "confirm_u";
        public static final String BTN_GOBACK_R_D = "goback_d";
        public static final String BTN_GOBACK_R_U = "goback_u";
        public static final String BTN_GOBACK_L_D = "goback_l_d";
        public static final String BTN_GOBACK_L_U = "goback_l_u";
        public static final String BTN_OK_D = "ok_d";
        public static final String BTN_OK_U = "ok_u";

        /**dialog*/
        public static final String DIALOG = "dialog";
        public static final String X = "x";

        /**market*/
        public static final String MARKET_BG = "marketbg";
        public static final String MARKET_BTN_U = "marketBtn_D";
        public static final String MARKET_BTN_D = "marketBtn_U";



    }

    /**
     * 游戏数值
     * */
    public static interface GameData{
        /**鱼类信息*/
        public static final String[] FISH_NAME = {"烤鱼","青鱼","草鱼","鲨鱼","金鱼"};
        public static final float[] FISH_CHILD_PRICE = {20,20,30,50,100};
        public static final float[] FISH_ORI_HEALTH = {0.7f,0.7f,0.8f,0.8f,0.5f};

        /**Preferences*/
        /**金币数*/
        public static final String USER_GOLDS_FILENAME = "user_golds";
        public static final String USER_GOLDS = "usesr_golds";

        /**螺母数*/
        public static final String USER_LUOMUS_FILENAME = "user_luomus";
        public static final String USER_LUOMUS = "usesr_luomus";

        /**螺丝数*/
        public static final String USER_LUOSIS_FILENAME = "user_luosis";
        public static final String USER_LUOSIS = "usesr_luosis";

        /**矿石数*/
        public static final String USER_STOREs_FILENAME = "user_stores";
        public static final String USER_STORES = "usesr_stores";

        /**鱼塘最大养鱼数*/
        public static final String USER_MAX_FILENAME = "user_max";
        public static final String USER_MAX = "usesr_max";

        /**a科技*/
        public static final String USER_ATECH_FILENAME = "user_atech";
        public static final String USER_ATECH = "usesr_atech";
        /**b科技*/
        public static final String USER_BTECH_FILENAME = "user_btech";
        public static final String USER_BTECH = "usesr_btech";
        /**c科技*/
        public static final String USER_CTECH_FILENAME = "user_ctech";
        public static final String USER_CTECH = "usesr_ctech";

        /**SPACE 0-5*/
        /**状态*/
        public static final String[] USER_POOL_STATE_FILENAME = {
                "ups0","ups1","ups2","ups3","ups4","ups5"
        };
        public static final String[] USER_POOL = {
                "ups0","ups1","ups2","ups3","ups4","ups5"
        };
        /**鱼的种类*/
        public static final String[] USER_POOL_FISH_FILENAME = {
                "upf0","upf1","upf2","upf3","upf4","upf5"
        };
        public static final String[] USER_POOL_FISH = {
                "upf0","upf1","upf2","upf3","upf4","upf5"
        };
        /**鱼的健康度*/
        public static final String[] USER_POOL_HEALTH_FILENAME = {
                "uph0","uph1","uph2","uph3","uph4","uph5"
        };
        public static final String[] USER_POOL_HEALTH = {
                "uph0","uph1","uph2","uph3","uph4","uph5"
        };
        /**鱼的成长度*/
        public static final String[] USER_POOL_GROW_FILENAME = {
                "upg0","upg1","upg2","upg3","upg4","upg5"
        };
        public static final String[] USER_POOL_GROW = {
                "upg0","upg1","upg2","upg3","upg4","upg5"
        };

    }





}
