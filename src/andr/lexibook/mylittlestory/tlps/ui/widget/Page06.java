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
public class Page06 extends PageView {


    private GifMovieView pigs;
    private GifMovieView wolf;

    public Page06(Context context) {
        super(context, R.layout.page06);

        pigs = (GifMovieView) page.findViewById(R.id.gif_p06_pigs);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p06_wolf);

        pigs.setMovieAsset(ctx.getString(R.string.p06_pigs));
        wolf.setMovieAsset(ctx.getString(R.string.p06_wolf));

        params = (AbsoluteLayout.LayoutParams) pigs.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p06_pigs_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p06_pigs_y));
        pigs.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p06_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p06_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p06);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(5));
    }
}
