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

        params = (AbsoluteLayout.LayoutParams) flower.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_flower_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_flower_y));
        flower.setLayoutParams(params);


        params = (AbsoluteLayout.LayoutParams) butterfly.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_butterfly_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_butterfly_y));
        butterfly.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(1));
    }

    @Override
    public void dispear(View view) {
        view.setVisibility(GONE);
    }

}
