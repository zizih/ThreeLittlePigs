package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by rain on 5/20/13.
 */
public class BgSrc {

    private Activity ctx;
    private static BgSrc instance;
    private int langId;

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
        return getDrawable(langPagesId[this.langId][pageIndex]);
    }

    public Drawable getSplashDrawable() {
        return getDrawable(splashs[this.langId]);
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
}
