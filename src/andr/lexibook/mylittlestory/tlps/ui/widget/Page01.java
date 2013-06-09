package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.tlps.ui.R;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page01 extends PageView {

    private GifMovieView pig_mom;
    private GifMovieView pig_yel;
    private GifMovieView pig_brown;
    private GifMovieView pig_blue;

    public Page01(Context context) {
        super(context, R.layout.page01);

        pig_mom = (GifMovieView) page.findViewById(R.id.gif_p01_pig_mom);
        pig_yel = (GifMovieView) page.findViewById(R.id.gif_p01_pig_yel);
        pig_brown = (GifMovieView) page.findViewById(R.id.gif_p01_pig_brown);
        pig_blue = (GifMovieView) page.findViewById(R.id.gif_p01_pig_blue);

        pig_mom.setMovieAsset(context.getString(R.string.p01_pig_mom));
        pig_yel.setMovieAsset(context.getString(R.string.p01_pig_yel));
        pig_brown.setMovieAsset(context.getString(R.string.p01_pig_brown));
        pig_blue.setMovieAsset(context.getString(R.string.p01_pig_blue));

        params = ((AbsoluteLayout.LayoutParams) pig_mom.getLayoutParams());
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_pig_mom_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_pig_mom_y));
        pig_mom.setLayoutParams(params);

        params = ((AbsoluteLayout.LayoutParams) pig_yel.getLayoutParams());
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_pig_yel_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_pig_yel_y));
        pig_yel.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_brown.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_pig_brown_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_pig_brown_y));
        pig_brown.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_blue.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p01_pig_blue_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p01_pig_blue_y));
        pig_blue.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p01);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(0));
    }

}
