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
public class Page04 extends PageView {

    private GifMovieView wolf;
    private GifMovieView grand;

    public Page04(Context context) {
        super(context, R.layout.page04);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p04_wolf);
        grand = (GifMovieView) page.findViewById(R.id.gif_p04_grand);

        wolf.setMovieAsset(ctx.getString(R.string.p04_wolf));
        grand.setMovieAsset(ctx.getString(R.string.p04_grand));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_grand_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_grand_y));
        grand.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p04);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(3));
    }
}
