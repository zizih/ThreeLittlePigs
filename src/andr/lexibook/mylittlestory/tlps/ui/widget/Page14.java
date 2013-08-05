package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.control.BtnGifSrc;
import andr.lexibook.mylittlestory.tlps.ui.Menu;
import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page14 extends PageView implements View.OnClickListener {

    private GifMovieView pigs;
    private GifMovieView pig_blue;
    private GifMovieView btn_menu;
    private GifMovieView btn_quit;
    private Intent menuIntent;
    public BtnGifSrc btnSrc;


    public Page14(Context context) {
        super(context, R.layout.page14);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        pigs = (GifMovieView) page.findViewById(R.id.gif_p14_pigs);
        pig_blue = (GifMovieView) page.findViewById(R.id.gif_p14_pig_blue);
        btn_menu = (GifMovieView) page.findViewById(R.id.gif_p14_menu);
        btn_quit = (GifMovieView) page.findViewById(R.id.gif_p14_quit);

        btnSrc = BtnGifSrc.getInstance(context);
        pigs.setMovieAsset(ctx.getString(R.string.p14_pigs));
        pig_blue.setMovieAsset(ctx.getString(R.string.p14_pig_blue));
        btn_menu.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuBack());
        btn_quit.setMovieAsset(btnSrc.setLang(setting.getLangId()).getQuit());

        params = (AbsoluteLayout.LayoutParams) btn_menu.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p14_menu_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p14_menu_y));
        btn_menu.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_quit.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p14_quit_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p14_quit_y));
        btn_quit.setLayoutParams(params);

        btn_menu.setOnClickListener(this);
        btn_quit.setOnClickListener(this);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p14);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(13));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_p14_menu:
                ctx.startActivity(menuIntent);
                break;
            case R.id.gif_p14_quit:
                ctx.finish();
                System.exit(0);
                break;
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        pig_blue.Clear();
        pigs.Clear();
        btn_menu.Clear();
        btn_quit.Clear();
    }

}
