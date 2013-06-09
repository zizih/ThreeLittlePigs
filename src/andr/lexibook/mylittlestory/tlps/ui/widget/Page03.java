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


    private GifMovieView red;
    private GifMovieView board;
    private GifMovieView wolf;

    public Page03(Context context) {
        super(context, R.layout.page03);
        red = (GifMovieView) page.findViewById(R.id.gif_p03_red);
        board = (GifMovieView) page.findViewById(R.id.gif_p03_board);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p03_wolf);

        red.setMovieAsset(ctx.getString(R.string.p03_red));
        board.setMovieAsset(ctx.getString(R.string.p03_board));
        wolf.setMovieAsset(ctx.getString(R.string.p03_wolf));

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) board.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_board_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_board_y));
        board.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p03_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p03_wolf_y));
        wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p03);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(2));
    }
}
