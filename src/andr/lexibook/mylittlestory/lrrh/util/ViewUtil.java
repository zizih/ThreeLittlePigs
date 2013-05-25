package andr.lexibook.mylittlestory.lrrh.util;

import android.app.Activity;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 5/1/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewUtil {

    private static ViewUtil instance;
    private Activity ctx;

    public ViewUtil(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    public static ViewUtil getInstance(Context ctx) {
        if (instance == null)
            instance = new ViewUtil(ctx);
        return instance;
    }

    /**
     * 获取gif输入流，设置图片
     */
    public InputStream getIS(String asset) {
        try {
            return ctx.getAssets().open(asset);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public float getWidthScale() {
        return getWinWidth() / 800.0f;
    }

    public float getHeightScale() {
        return getWinHeight() / 480.0f;
    }

    public float getWinWidth() {
        return ctx.getWindowManager().getDefaultDisplay().getWidth();
    }

    public float getWinHeight() {
        return ctx.getWindowManager().getDefaultDisplay().getHeight();
    }

}
