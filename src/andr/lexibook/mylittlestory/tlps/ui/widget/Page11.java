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

    private GifMovieView sun;
    private GifMovieView wolf;
    private GifMovieView win_pig;

    public Page11(Context context) {
        super(context, R.layout.page11);

        sun = (GifMovieView) page.findViewById(R.id.gif_p11_sun);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p11_wolf);
        win_pig = (GifMovieView) page.findViewById(R.id.gif_p11_win_pig);

        sun.setMovieAsset(ctx.getString(R.string.p11_sun));
        wolf.setMovieAsset(ctx.getString(R.string.p11_wolf));
        win_pig.setMovieAsset(ctx.getString(R.string.p11_win_pig));


        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p11);
        setBG(this.getContext(), layout, 10);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p11_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p11_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        sun.Clear();
        wolf.Clear();
        win_pig.Clear();
    }
}
