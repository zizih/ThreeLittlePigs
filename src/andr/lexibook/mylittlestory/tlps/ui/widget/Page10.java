package andr.lexibook.mylittlestory.tlps.ui.widget;

import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page10 extends PageView {

    private GifMovieView cloud;
    private GifMovieView grand_red;
    private GifMovieView hunter;
    private GifMovieView stone;
    private GifMovieView wolf;
    private ImageView bg_cover;

    public Page10(Context context) {
        super(context, R.layout.page10);

        cloud = (GifMovieView) page.findViewById(R.id.gif_p10_cloud);
        grand_red = (GifMovieView) page.findViewById(R.id.gif_p10_grand_red);
        hunter = (GifMovieView) page.findViewById(R.id.gif_p10_hunter);
        stone = (GifMovieView) page.findViewById(R.id.gif_p10_stone);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p10_wolf);
        bg_cover = (ImageView) page.findViewById(R.id.img_bg_cover);

        cloud.setMovieAsset(ctx.getString(R.string.p10_cloud));
        grand_red.setMovieAsset(ctx.getString(R.string.p10_grand_red));
        hunter.setMovieAsset(ctx.getString(R.string.p10_hunter));
        stone.setMovieAsset(ctx.getString(R.string.p10_stone));
        wolf.setMovieAsset(ctx.getString(R.string.p10_wolf));

        params = (AbsoluteLayout.LayoutParams) cloud.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_cloud_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_cloud_y));
        cloud.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand_red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_grand_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_grand_red_y));
        grand_red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) hunter.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_hunter_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_hunter_y));
        hunter.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) stone.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_stone_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_stone_y));
        stone.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p10_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p10_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) bg_cover.getLayoutParams();
        params.x = (int) getWinWidth();
        params.y = (int) getWinHeight();
        bg_cover.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p10);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(9));
    }
}
