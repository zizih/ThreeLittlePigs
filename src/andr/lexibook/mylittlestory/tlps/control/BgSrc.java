package andr.lexibook.mylittlestory.tlps.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by rain on 5/20/13.
 */
public class BgSrc {

    private Activity ctx;
    private static BgSrc instance;
    private int langId;
    private WeakHashMap<String, SoftReference<Drawable>> drawableCache;
    private Drawable d;
    private Bitmap b;

    private int[] splashs = {R.drawable.eng_splash
            , R.drawable.fra_splash
            , R.drawable.deu_splash
            , R.drawable.esp_splash
            , R.drawable.ita_splash};

    private int[] engs = {R.drawable.eng_p01_bkg
            , R.drawable.eng_p02_bkg
            , R.drawable.eng_p03_bkg
            , R.drawable.eng_p04_bkg
            , R.drawable.eng_p05_bkg
            , R.drawable.eng_p06_bkg
            , R.drawable.eng_p07_bkg
            , R.drawable.eng_p08_bkg
            , R.drawable.eng_p09_bkg
            , R.drawable.eng_p10_bkg
            , R.drawable.eng_p11_bkg
            , R.drawable.eng_p12_bkg
    };

    private int[] fras = {R.drawable.fra_p01_bkg
            , R.drawable.fra_p02_bkg
            , R.drawable.fra_p03_bkg
            , R.drawable.fra_p04_bkg
            , R.drawable.fra_p05_bkg
            , R.drawable.fra_p06_bkg
            , R.drawable.fra_p07_bkg
            , R.drawable.fra_p08_bkg
            , R.drawable.fra_p09_bkg
            , R.drawable.fra_p10_bkg
            , R.drawable.fra_p11_bkg
            , R.drawable.fra_p12_bkg
    };

    private int[] deus = {R.drawable.deu_p01_bkg
            , R.drawable.deu_p02_bkg
            , R.drawable.deu_p03_bkg
            , R.drawable.deu_p04_bkg
            , R.drawable.deu_p05_bkg
            , R.drawable.deu_p06_bkg
            , R.drawable.deu_p07_bkg
            , R.drawable.deu_p08_bkg
            , R.drawable.deu_p09_bkg
            , R.drawable.deu_p10_bkg
            , R.drawable.deu_p11_bkg
            , R.drawable.deu_p12_bkg
    };

    private int[] esps = {R.drawable.esp_p01_bkg
            , R.drawable.esp_p02_bkg
            , R.drawable.esp_p03_bkg
            , R.drawable.esp_p04_bkg
            , R.drawable.esp_p05_bkg
            , R.drawable.esp_p06_bkg
            , R.drawable.esp_p07_bkg
            , R.drawable.esp_p08_bkg
            , R.drawable.esp_p09_bkg
            , R.drawable.esp_p10_bkg
            , R.drawable.esp_p11_bkg
            , R.drawable.esp_p12_bkg
    };

    private int[] itas = {R.drawable.ita_p01_bkg
            , R.drawable.ita_p02_bkg
            , R.drawable.ita_p03_bkg
            , R.drawable.ita_p04_bkg
            , R.drawable.ita_p05_bkg
            , R.drawable.ita_p06_bkg
            , R.drawable.ita_p07_bkg
            , R.drawable.ita_p08_bkg
            , R.drawable.ita_p09_bkg
            , R.drawable.ita_p10_bkg
            , R.drawable.ita_p11_bkg
            , R.drawable.ita_p12_bkg
    };


    private int[][] langPagesId = {engs, fras, deus, esps, itas};

    private BgSrc(Context ctx) {
        this.ctx = (Activity) ctx;
        drawableCache = new WeakHashMap<String, SoftReference<Drawable>>();
    }

    public static BgSrc getInstance(Context ctx) {
        if (instance == null)
            instance = new BgSrc(ctx);
        return instance;
    }

    public BgSrc setLang(int langId) {
        this.langId = langId;
        return this;
    }

    /**
     * get drawable
     */
    public Drawable getPageDrawable(int pageIndex) {
        if (!drawableCache.containsKey(this.langId + "" + pageIndex) || drawableCache.get(this.langId + "" + pageIndex) == null)
            return getDrawable(langPagesId[this.langId][pageIndex]);
        return drawableCache.get(this.langId + "" + pageIndex).get();
    }

    public Drawable getSplashDrawable() {
        if (!drawableCache.containsKey("splash" + this.langId) || drawableCache.get("splash" + this.langId) == null)
            return getDrawable(splashs[this.langId]);
        return drawableCache.get("splash" + this.langId).get();
    }

    private Drawable getDrawable(int drawableId) {
        return ctx.getResources().getDrawable(drawableId);
    }

    /**
     * get drawablw ID
     */
    public int getPageDrawableId(int pageIndex) {
        return langPagesId[this.langId][pageIndex];
    }

    public int getSplashDrawableId() {
        return splashs[this.langId];
    }

    public void Clear() {
        if (drawableCache == null || drawableCache.isEmpty())
            return;
        for (Map.Entry<String, SoftReference<Drawable>> entry : drawableCache.entrySet()) {
            d = entry.getValue().get();
            if (d != null) {
                b = ((BitmapDrawable) d).getBitmap();
                if (b != null && !b.isRecycled()) {
                    b.recycle();
                }
                b = null;
                d = null;
            }
        }
        drawableCache.clear();
        System.gc();
        System.gc();
    }
}
