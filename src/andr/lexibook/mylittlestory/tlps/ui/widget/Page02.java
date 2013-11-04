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
public class Page02 extends PageView {

    private GifMovieView flower;
    private GifMovieView butterfly;
    private GifMovieView wolf;

    @SuppressWarnings("deprecation")
    public Page02(Context context) {
        super(context, R.layout.page02);
        //init
        flower = (GifMovieView) page.findViewById(R.id.gif_p02_flower);
        butterfly = (GifMovieView) page.findViewById(R.id.gif_p02_butterfly);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p02_wolf);

        butterfly.setMovieAsset(ctx.getString(R.string.p02_flower));
        flower.setMovieAsset(ctx.getString(R.string.p02_butterfly));
        wolf.setMovieAsset(ctx.getString(R.string.p02_wolf));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        setBG(this.getContext(), layout, 1);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p02_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p02_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        flower.Clear();
        butterfly.Clear();
        wolf.Clear();
    }
}
