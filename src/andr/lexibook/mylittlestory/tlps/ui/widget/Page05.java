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

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p05);
        setBG(this.getContext(), layout, 4);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p05_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p05_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        wolf.Clear();
    }
}
