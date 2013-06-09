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
public class Page08 extends PageView {

    private GifMovieView basket;
    private GifMovieView red;
    private GifMovieView wolf;
    private GifMovieView hat;

    public Page08(Context context) {
        super(context, R.layout.page08);

        basket = (GifMovieView) page.findViewById(R.id.gif_p08_basket);
        red = (GifMovieView) page.findViewById(R.id.gif_p08_red);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p08_wolf);
        hat = (GifMovieView) page.findViewById(R.id.gif_p08_hat);

        basket.setMovieAsset(ctx.getString(R.string.p08_basket));
        red.setMovieAsset(ctx.getString(R.string.p08_red));
        wolf.setMovieAsset(ctx.getString(R.string.p08_wolf));
        hat.setMovieAsset(ctx.getString(R.string.p08_hat));

        params = (AbsoluteLayout.LayoutParams) basket.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_basket_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_basket_y));
        basket.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_red_y));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) hat.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_hat_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_hat_y));
        hat.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p08);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(7));
    }
}
