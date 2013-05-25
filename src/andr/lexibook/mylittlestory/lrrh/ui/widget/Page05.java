package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page05 extends PageView {

    private GifMovieView door;
    private GifMovieView wolf;
    private GifMovieView grand;

    public Page05(Context context) {
        super(context, R.layout.page05);

        door = (GifMovieView) page.findViewById(R.id.gif_p05_door);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p05_wolf);
        grand = (GifMovieView) page.findViewById(R.id.gif_p05_grand);

        door.setMovieAsset(ctx.getString(R.string.p05_door));
        wolf.setMovieAsset(ctx.getString(R.string.p05_wolf));
        grand.setMovieAsset(ctx.getString(R.string.p05_grand));

        params = (AbsoluteLayout.LayoutParams) door.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p05_door_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p05_door_y));
        door.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p05_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p05_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p05_grand_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p05_grand_y));
        grand.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p05);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(4));
    }
}
