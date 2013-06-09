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
public class Page05 extends PageView {

    private GifMovieView wolf;

    public Page05(Context context) {
        super(context, R.layout.page05);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p05_wolf);
        wolf.setMovieAsset(ctx.getString(R.string.p05_wolf));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p05_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p05_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p05);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(4));
    }
}
