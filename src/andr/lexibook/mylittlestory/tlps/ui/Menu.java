package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.BtnGifSrc;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.BluePigGif;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnClickListener {

    private BluePigGif pig_blue;
    private GifMovieView pig_brown;
    private GifMovieView pig_yel;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;

    private AbsoluteLayout.LayoutParams params;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnSrc = BtnGifSrc.getInstance(this);
        bgSrc = BgSrc.getInstance(this);

        pig_blue = (BluePigGif) findViewById(R.id.gif_menu_pig_blue);
        pig_brown = (GifMovieView) findViewById(R.id.gif_menu_pig_brown);
        pig_yel = (GifMovieView) findViewById(R.id.gif_menu_pig_yel);
        btn_read_auto = (GifMovieView) findViewById(R.id.gif_menu_read_auto);
        btn_read_self = (GifMovieView) findViewById(R.id.gif_menu_read_self);

        pig_blue.setMovieAsset(getString(R.string.menu_pig_blue));
        pig_brown.setMovieAsset(getString(R.string.menu_pig_brown));
        pig_yel.setMovieAsset(getString(R.string.menu_pig_yel));
        btn_read_auto.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuSelf());

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

        //
        pig_blue.setMenuCallBack(this);
        setMenuView(findViewById(R.id.any_widget_4_menu_menu));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toPage(Pages.class);
            }
        }, 2000);
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        /**
         *  here need to change menu button suitted language
         */
        btn_read_auto.setMovieAsset(btnSrc.setLang(langId).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(langId).getMenuSelf());
        /**
         * set player
         */
        pig_blue.changLanguage();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pig_blue.releasePlay();
    }

    @Override
    protected void onDestroy() {
        pig_yel.Clear();
        pig_brown.Clear();
        pig_blue.Clear();
        btn_read_self.Clear();
        btn_read_auto.Clear();
        super.onDestroy();
    }

}
