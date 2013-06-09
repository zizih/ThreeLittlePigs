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
public class Page10 extends PageView {

    private GifMovieView wolf;

    public Page10(Context context) {
        super(context, R.layout.page10);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p10_wolf);
        wolf.setMovieAsset(ctx.getString(R.string.p10_wolf));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p10);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(9));
    }
}
