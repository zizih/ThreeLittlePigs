package andr.lexibook.mylittlestory.tlps.control;

import andr.lexibook.mylittlestory.tlps.ui.R;
import android.app.Activity;
import android.content.Context;

/**
 * Created by rain on 5/20/13.
 */
public class BtnGifSrc {

    private Activity ctx;
    private static BtnGifSrc instance;
    private String langPath;

    public final int ENGLISH = 0;
    public final int FRANCH = 1;
    public final int EUTSCH = 2;
    public final int ESPANOL = 3;
    public final int ITALIANO = 4;

    private BtnGifSrc(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    public static BtnGifSrc getInstance(Context ctx) {
        if (instance == null)
            instance = new BtnGifSrc(ctx);
        return instance;
    }

    /**
     * about change language
     */
    public BtnGifSrc setLang(int langId) {
        switch (langId) {
            case ENGLISH:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_eng);
                break;
            case FRANCH:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_fra);
                break;
            case EUTSCH:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_deu);
                break;
            case ESPANOL:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_esp);
                break;
            case ITALIANO:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_ita);
                break;
            default:
                this.langPath = ctx.getResources().getString(R.string.gif_lang_default);
        }
        return this;
    }

    /**
     * about menu button
     */
    public String getMenuAuto() {
        return this.langPath + ctx.getResources().getString(R.string.menu_read_auto);
    }

    public String getMenuSelf() {
        return this.langPath + ctx.getResources().getString(R.string.menu_read_self);
    }

    /**
     * about eng button
     */

    public String getMenuBack() {
        return this.langPath + ctx.getResources().getString(R.string.p14_menu);
    }

    public String getQuit() {
        return this.langPath + ctx.getResources().getString(R.string.p14_quit);
    }
}
