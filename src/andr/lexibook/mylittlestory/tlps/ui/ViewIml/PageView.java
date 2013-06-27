package andr.lexibook.mylittlestory.tlps.ui.ViewIml;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.Setting;
import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.util.ViewUtil;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

/**
 * User: rain
 * Date: 5/1/13
 * Time: 12:11 PM
 */
@SuppressWarnings("deprecation")
public class PageView extends View {

    protected static Activity ctx;
    public AbsoluteLayout page;
    public AbsoluteLayout layout;
    public AbsoluteLayout.LayoutParams params;
    public BgSrc bgSrc;
    public Setting setting;

    public CallBack callBack;
    private ImageView play;
    private ImageView pause;

    public PageView(Context context, CallBack callBack, int layoutId) {
        super(context);
        System.out.println(" New PageView: " + this.getClass().getName());
        this.ctx = (Activity) context;
        this.callBack = callBack;

        page = (AbsoluteLayout) ctx.getLayoutInflater().inflate(layoutId, null);
        params = (AbsoluteLayout.LayoutParams) page.getLayoutParams();
        bgSrc = BgSrc.getInstance(ctx);
        setting = Setting.getInstance(ctx);

    }

    public AbsoluteLayout getLayout() {
        return page;
    }

    public AbsoluteLayout getLayoutView() {
        return layout;
    }

    public float getDimens(int dimensId) {
        return ctx.getResources().getDimension(dimensId);
    }

    public float getWidthScale() {
        return ViewUtil.getInstance(ctx).getWidthScale();
    }

    public float getHeightScale() {
        return ViewUtil.getInstance(ctx).getHeightScale();
    }

    public float getWinWidth() {
        return ViewUtil.getInstance(ctx).getWinWidth();
    }

    public float getWinHeight() {
        return ViewUtil.getInstance(ctx).getWinHeight();
    }

    public interface CallBack {
        public boolean play();

        public boolean pause();

        public boolean quit();
    }

}
