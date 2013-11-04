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
public class Page04 extends PageView {

    private GifMovieView tree_cloud;
    private GifMovieView pig_blue;

    private AbsoluteLayout bg_up;

    public Page04(Context context) {
        super(context, R.layout.page04);

        tree_cloud = (GifMovieView) page.findViewById(R.id.gif_p04_tree_coud);
        pig_blue = (GifMovieView) page.findViewById(R.id.gif_p04_pig_blue);
        bg_up = (AbsoluteLayout) page.findViewById(R.id.p04_bg_up);

        tree_cloud.setMovieAsset(ctx.getString(R.string.p04_tree_cloud));
        pig_blue.setMovieAsset(ctx.getString(R.string.p04_pig_blue));

        params = (AbsoluteLayout.LayoutParams) bg_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        bg_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p04);
        setBG(this.getContext(), layout, 3);

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p04_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p04_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        tree_cloud.Clear();
        pig_blue.Clear();
    }
}
