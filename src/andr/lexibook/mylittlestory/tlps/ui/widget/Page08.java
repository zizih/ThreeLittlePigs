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
public class Page08 extends PageView {

    private GifMovieView wolf;
    private GifMovieView pigs_house;

    public Page08(Context context) {
        super(context, R.layout.page08);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p08_wolf);
        pigs_house = (GifMovieView) page.findViewById(R.id.gif_p08_pigs_house);

        wolf.setMovieAsset(ctx.getString(R.string.p08_wolf));
        pigs_house.setMovieAsset(ctx.getString(R.string.p08_pigs_house));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pigs_house.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p08_pigs_house_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p08_pigs_house_y));
        pigs_house.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p08);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(7));
    }
}
