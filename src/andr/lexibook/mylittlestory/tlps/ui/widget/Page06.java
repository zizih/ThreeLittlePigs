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

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p06);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(5));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p06_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p06_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }
    @Override
    public void Clear() {
        super.Clear();
        pigs.Clear();
        wolf.Clear();
    }
}
