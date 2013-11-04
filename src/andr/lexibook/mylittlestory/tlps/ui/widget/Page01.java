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
public class Page01 extends PageView {

    private GifMovieView pigs;
    private GifMovieView butterfly;

    public Page01(Context context) {
        super(context, R.layout.page01);

        pigs = (GifMovieView) page.findViewById(R.id.gif_p01_pigs);
        butterfly = (GifMovieView) page.findViewById(R.id.gif_p01_butterfly);

        pigs.setMovieAsset(context.getString(R.string.p01_pigs));
        butterfly.setMovieAsset(context.getString(R.string.p01_butterfly));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p01);
        setBG(this.getContext(), layout, 0);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p01_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p01_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        pigs.Clear();
        butterfly.Clear();
    }
}
