package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page06 extends PageView {


    private GifMovieView red;
    private GifMovieView wolf;

    public Page06(Context context) {
        super(context, R.layout.page06);

        red = (GifMovieView) page.findViewById(R.id.gif_p06_red);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p06_wolf);

        red.setMovieAsset(ctx.getString(R.string.p06_red));
        wolf.setMovieAsset(ctx.getString(R.string.p06_wolf));

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p06_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p06_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p06_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p06_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p06);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(5));
    }
}
