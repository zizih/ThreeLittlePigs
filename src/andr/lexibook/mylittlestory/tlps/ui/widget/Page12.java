package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.Menu;
import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.content.Intent;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page12 extends PageView {

    private GifMovieView wolf;
    private GifMovieView sun;
    private Intent menuIntent;

    private AbsoluteLayout bg_up;

    public Page12(Context context) {
        super(context, R.layout.page12);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p12_wolf);
        sun = (GifMovieView) page.findViewById(R.id.gif_p12_sun);
        bg_up = (AbsoluteLayout) page.findViewById(R.id.p12_bg_up);

        wolf.setMovieAsset(ctx.getString(R.string.p12_wolf));
        sun.setMovieAsset(ctx.getString(R.string.p12_sun));

        params = (AbsoluteLayout.LayoutParams) bg_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        bg_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p12);
        setBG(this.getContext(), layout, 11);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p12_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p12_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        wolf.Clear();
        sun.Clear();
    }

}
