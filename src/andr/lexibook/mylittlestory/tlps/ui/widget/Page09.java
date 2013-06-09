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
@SuppressWarnings("deprecation")
public class Page09 extends PageView {

    private GifMovieView basket;
    private GifMovieView hunter;
    private GifMovieView wolf;

    public Page09(Context context) {
        super(context, R.layout.page09);

        basket = (GifMovieView) page.findViewById(R.id.gif_p09_basket);
        hunter = (GifMovieView) page.findViewById(R.id.gif_p09_hunter);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p09_wolf);

        basket.setMovieAsset(ctx.getString(R.string.p09_basket));
        hunter.setMovieAsset(ctx.getString(R.string.p09_hunter));
        wolf.setMovieAsset(ctx.getString(R.string.p09_wolf));

        params = (AbsoluteLayout.LayoutParams) basket.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_basket_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_basket_y));
        basket.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) hunter.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_hunter_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_hunter_y));
        hunter.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p09);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(8));
    }
}
