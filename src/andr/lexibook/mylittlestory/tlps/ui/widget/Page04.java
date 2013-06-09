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
public class Page04 extends PageView {

    private GifMovieView tree_cloud;
    private GifMovieView pig_blue;

    public Page04(Context context) {
        super(context, R.layout.page04);

        tree_cloud = (GifMovieView) page.findViewById(R.id.gif_p04_tree_coud);
        pig_blue = (GifMovieView) page.findViewById(R.id.gif_p04_pig_blue);

        tree_cloud.setMovieAsset(ctx.getString(R.string.p04_tree_cloud));
        pig_blue.setMovieAsset(ctx.getString(R.string.p04_pig_blue));

        params = (AbsoluteLayout.LayoutParams) tree_cloud.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_tree_cloud_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_tree_cloud_y));
        tree_cloud.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) pig_blue.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p04_pig_blue_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p04_pig_blue_y));
        pig_blue.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p04);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(3));
    }
}
