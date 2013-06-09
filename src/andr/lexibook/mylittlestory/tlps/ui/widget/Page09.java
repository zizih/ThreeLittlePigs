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

    private GifMovieView pig_brown;
    private GifMovieView pig_yel;
    private GifMovieView wolf;

    public Page09(Context context) {
        super(context, R.layout.page09);

        pig_brown = (GifMovieView) page.findViewById(R.id.gif_p09_pig_brown);
        pig_yel = (GifMovieView) page.findViewById(R.id.gif_p09_pig_yel);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p09_wolf);

        pig_brown.setMovieAsset(ctx.getString(R.string.p09_pig_brown));
        pig_yel.setMovieAsset(ctx.getString(R.string.p09_pig_yel));
        wolf.setMovieAsset(ctx.getString(R.string.p09_wolf));

        params = (AbsoluteLayout.LayoutParams) pig_brown.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_pig_brown_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_pig_brown_y));
        pig_brown.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_yel.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_pig_yel_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_pig_yel_y));
        pig_yel.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p09);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(8));
    }
}
