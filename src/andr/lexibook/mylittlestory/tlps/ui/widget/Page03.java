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

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p03);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(2));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p03_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p03_y));
            params.width = (int) (getWidthScale() * BTN_WIDTH);
            params.height = (int) (getWidthScale() * BTN_HEIGHT);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        super.Clear();
        pig_brown.Clear();
        pig_yel.Clear();
        wood_house.Clear();
    }
}
