package andr.lexibook.mylittlestory.tlps.ui.ViewIml;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.Setting;
import andr.lexibook.mylittlestory.tlps.util.ViewUtil;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AbsoluteLayout;

import java.io.InputStream;

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
    public AbsoluteLayout pause;
    public AbsoluteLayout.LayoutParams params;
    public BgSrc bgSrc;
    public Setting setting;
    public final int BTN_WIDTH = 48;
    public final int BTN_HEIGHT = 44;
    public Bitmap bitmapBg;

    public PageView(Context context, int layoutId) {
        super(context);
        System.out.println(" New PageView: " + this.getClass().getName());
        this.ctx = (Activity) context;
        page = (AbsoluteLayout) ctx.getLayoutInflater().inflate(layoutId, null);
        params = (AbsoluteLayout.LayoutParams) page.getLayoutParams();
        bgSrc = BgSrc.getInstance(ctx);
        setting = Setting.getInstance(ctx);
    }

    public void setBG(Context ctx, View layout, int pageId) {
        bitmapBg = readBitMap(ctx, bgSrc.setLang(setting.getLangId()).getPageDrawableId(pageId));
        layout.setBackgroundDrawable(new BitmapDrawable(bitmapBg));
    }

    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
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

    public void Clear() {
        if(!bitmapBg.isRecycled()) {
            bitmapBg.recycle();
        }
    }

}
