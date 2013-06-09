package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page11 extends PageView {

    private GifMovieView sun;
    private GifMovieView wolf;
    private GifMovieView win_pig;

    public Page11(Context context) {
        super(context, R.layout.page11);

        sun = (GifMovieView) page.findViewById(R.id.gif_p11_sun);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p11_wolf);
        win_pig = (GifMovieView) page.findViewById(R.id.gif_p11_win_pig);

        sun.setMovieAsset(ctx.getString(R.string.p11_sun));
        wolf.setMovieAsset(ctx.getString(R.string.p11_wolf));
        win_pig.setMovieAsset(ctx.getString(R.string.p11_win_pig));

        params = (AbsoluteLayout.LayoutParams) sun.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_sun_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_sun_y));
        sun.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) win_pig.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_win_pig_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_win_pig_y));
        win_pig.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p11);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(10));
    }
}
