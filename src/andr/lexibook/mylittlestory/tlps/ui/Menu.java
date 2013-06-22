package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.BtnGifSrc;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.MenuBluePigGif;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * Created by rain on 6/8/13.
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnClickListener {

    private MenuBluePigGif pig_blue;
    private GifMovieView pig_brown;
    private GifMovieView pig_yel;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;

    private AbsoluteLayout.LayoutParams params;
    private AbsoluteLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnSrc = BtnGifSrc.getInstance(this);
        bgSrc = BgSrc.getInstance(this);
        layout = (AbsoluteLayout) findViewById(R.id.layout_menu);

        pig_blue = (MenuBluePigGif) findViewById(R.id.gif_menu_pig_blue);
        pig_brown = (GifMovieView) findViewById(R.id.gif_menu_pig_brown);
        pig_yel = (GifMovieView) findViewById(R.id.gif_menu_pig_yel);
        btn_read_auto = (GifMovieView) findViewById(R.id.gif_menu_read_auto);
        btn_read_self = (GifMovieView) findViewById(R.id.gif_menu_read_self);

        pig_blue.setMovieAsset(getString(R.string.menu_pig_blue));
        pig_brown.setMovieAsset(getString(R.string.menu_pig_brown));
        pig_yel.setMovieAsset(getString(R.string.menu_pig_yel));
        btn_read_auto.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuSelf());

        params = (AbsoluteLayout.LayoutParams) pig_blue.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_pig_blue_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_pig_blue_y));
        pig_blue.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_brown.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_pig_brown_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_pig_brown_y));
        pig_brown.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_yel.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_pig_yel_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_pig_yel_y));
        pig_yel.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_read_auto.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_auto_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_auto_y));
        btn_read_auto.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_read_self.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_self_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_self_y));
        btn_read_self.setLayoutParams(params);


        //set listener
        btn_read_auto.setOnClickListener(this);
        btn_read_self.setOnClickListener(this);

        pig_blue.setMenuCallBack(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_menu_read_auto:
                setReadMode(true);
                break;
            case R.id.gif_menu_read_self:
                setReadMode(false);
                break;
            default:
                break;
        }
        pig_blue.releasePlay();
        toPage(Pages.class);
        onDestroy();
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        /**
         *  here need to change menu button suitted language
         */
        btn_read_auto.setMovieAsset(btnSrc.setLang(langId).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(langId).getMenuSelf());
        layout.setBackgroundResource(bgSrc.setLang(langId).getMenuDrawableId());
    }
}
