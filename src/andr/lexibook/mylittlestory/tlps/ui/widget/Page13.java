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
public class Page13 extends PageView {

    private GifMovieView pig_blue;
    private GifMovieView pigs;
    private GifMovieView smoke;
    private GifMovieView bird;
    private Intent menuIntent;


    public Page13(Context context) {
        super(context, R.layout.page13);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        pig_blue = (GifMovieView) page.findViewById(R.id.gif_p13_pig_blue);
        pigs = (GifMovieView) page.findViewById(R.id.gif_p13_pigs);
        smoke = (GifMovieView) page.findViewById(R.id.gif_p13_smoke);
        bird = (GifMovieView) page.findViewById(R.id.gif_p13_bird);

        pig_blue.setMovieAsset(ctx.getString(R.string.p13_pig_blue));
        pigs.setMovieAsset(ctx.getString(R.string.p13_pigs));
        smoke.setMovieAsset(ctx.getString(R.string.p13_smoke));
        bird.setMovieAsset(ctx.getString(R.string.p13_bird));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p13);
        setBG(this.getContext(), layout, 12);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p13_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p13_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        pig_blue.Clear();
        pigs.Clear();
    }

}
