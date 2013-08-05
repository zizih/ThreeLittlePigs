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
public class Page07 extends PageView {

    private GifMovieView pig_brown;
    private GifMovieView pig_yel;
    private GifMovieView star;

    private AbsoluteLayout bg_up;

    public Page07(Context context) {
        super(context, R.layout.page07);

        pig_brown = (GifMovieView) page.findViewById(R.id.gif_p07_pig_brown);
        pig_yel = (GifMovieView) page.findViewById(R.id.gif_p07_pig_yel);
        star = (GifMovieView) page.findViewById(R.id.gif_p07_star);
        bg_up = (AbsoluteLayout) page.findViewById(R.id.p07_bg_up);

        pig_brown.setMovieAsset(ctx.getString(R.string.p07_pig_brown));
        pig_yel.setMovieAsset(ctx.getString(R.string.p07_pig_yel));
        star.setMovieAsset(ctx.getString(R.string.p07_star));

        params = (AbsoluteLayout.LayoutParams) bg_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        bg_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p07);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(6));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p07_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p07_y));
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
    }
}
