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
public class Page03 extends PageView {


    private GifMovieView pig_brown;
    private GifMovieView wood_house;
    private GifMovieView pig_yel;

    public Page03(Context context) {
        super(context, R.layout.page03);

        pig_brown = (GifMovieView) page.findViewById(R.id.gif_p03_pig_brown);
        wood_house = (GifMovieView) page.findViewById(R.id.gif_p03_wood_house);
        pig_yel = (GifMovieView) page.findViewById(R.id.gif_p03_pig_yel);

        pig_brown.setMovieAsset(ctx.getString(R.string.p03_pig_brown));
        wood_house.setMovieAsset(ctx.getString(R.string.p03_wood_house));
        pig_yel.setMovieAsset(ctx.getString(R.string.p03_pig_yel));

        params = (AbsoluteLayout.LayoutParams) pig_brown.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_pig_brown_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_pig_brown_y));
        pig_brown.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wood_house.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_wood_house_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_wood_house_y));
        wood_house.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_yel.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_pig_yel_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_pig_yel_y));
        pig_yel.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p03);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(2));
    }
}
