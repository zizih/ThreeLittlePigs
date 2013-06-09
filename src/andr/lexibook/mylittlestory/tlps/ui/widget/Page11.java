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

    private GifMovieView grand;
    private GifMovieView hunter;
    private GifMovieView red;
    private GifMovieView wolf;

    public Page11(Context context) {
        super(context, R.layout.page11);

        grand = (GifMovieView) page.findViewById(R.id.gif_p11_grand);
        red = (GifMovieView) page.findViewById(R.id.gif_p11_red);
        hunter = (GifMovieView) page.findViewById(R.id.gif_p11_hunter);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p11_wolf);

        grand.setMovieAsset(ctx.getString(R.string.p11_grand));
        hunter.setMovieAsset(ctx.getString(R.string.p11_hunter));
        red.setMovieAsset(ctx.getString(R.string.p11_red));
        wolf.setMovieAsset(ctx.getString(R.string.p11_wolf));

        params = (AbsoluteLayout.LayoutParams) grand.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_grand_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_grand_y));
        grand.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) hunter.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_hunter_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_hunter_y));
        hunter.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p11_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p11_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p11);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(10));
    }
}
