package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.Menu;
import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.content.Intent;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page13 extends PageView {

    private GifMovieView wolf;
    private GifMovieView sun;
    private Intent menuIntent;


    public Page13(Context context) {
        super(context, R.layout.page12);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p12_wolf);
        sun = (GifMovieView) page.findViewById(R.id.gif_p12_sun);

        wolf.setMovieAsset(ctx.getString(R.string.p12_wolf));
        sun.setMovieAsset(ctx.getString(R.string.p12_sun));

        params = (AbsoluteLayout.LayoutParams) sun.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_sun_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_sun_x));
        sun.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p12);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(11));
    }

}
