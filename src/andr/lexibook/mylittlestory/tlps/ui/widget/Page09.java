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

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p09);
        setBG(this.getContext(), layout, 8);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p09_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p09_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        pig_brown.Clear();
        pig_yel.Clear();
    }
}
