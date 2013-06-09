package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.tlps.ui.R;
import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page02 extends PageView implements GifMovieView.DispearCallback {

    private GifMovieView window;
    private GifMovieView mother;
    private GifMovieView red;
    private GifMovieView grand_start;
    private GifMovieView grand_loop;

    @SuppressWarnings("deprecation")
    public Page02(Context context) {
        super(context, R.layout.page02);
        //init
        window = (GifMovieView) page.findViewById(R.id.gif_p02_window);
        mother = (GifMovieView) page.findViewById(R.id.gif_p02_mother);
        red = (GifMovieView) page.findViewById(R.id.gif_p02_red);
        grand_start = (GifMovieView) page.findViewById(R.id.gif_p02_grand_start);
        grand_loop = (GifMovieView) page.findViewById(R.id.gif_p02_grand_loop);

        mother.setMovieAsset(ctx.getString(R.string.p02_mother));
        window.setMovieAsset(ctx.getString(R.string.p02_window));
        red.setMovieAsset(ctx.getString(R.string.p02_red));
        grand_start.setMovieAsset(ctx.getString(R.string.p02_grand_start));
        grand_loop.setMovieAsset(ctx.getString(R.string.p02_grand_loop));
        grand_start.dispear(2080, this);
        grand_loop.delay(2080);
        window.setPaused(4240);

        params = (AbsoluteLayout.LayoutParams) mother.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_mother_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_mother_y));
        mother.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) window.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_window_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_window_y));
        window.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand_loop.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_grand_loop_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_grand_loop_y));
        grand_loop.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand_start.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_grand_start_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_grand_start_y));
        grand_start.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(1));
    }

    @Override
    public void dispear(View view) {
        view.setVisibility(GONE);
    }

}
