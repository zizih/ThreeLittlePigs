package andr.lexibook.mylittlestory.tlps.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by rain on 5/18/13.
 */
public class MediaFactory {

    private Activity ctx;
    private static MediaFactory instance;
    private String langPath;

    private MediaFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        this.langPath = ctx.getResources().getString(R.string.mp3_lang_default);
    }

    public static MediaFactory getInstance(Context ctx) {
        if (instance == null) instance = new MediaFactory(ctx);
        return instance;
    }

    public MediaPlayer getMedia(String fileName) {
        AssetFileDescriptor descriptor = null;
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            descriptor = ctx.getAssets().openFd(langPath + fileName);
            mPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getDeclaredLength());
            descriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return mPlayer;
    }

    public MediaPlayer getLang() {
        return getMedia(ctx.getResources().getString(R.string.mp3_lang));
    }

    public MediaPlayer getPage01() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p01));
    }

    public MediaPlayer getPage02() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p02));
    }

    public MediaPlayer getPage03() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p03));
    }

    public MediaPlayer getPage04() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p04));
    }

    public MediaPlayer getPage05() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p05));
    }

    public MediaPlayer getPage06() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p06));
    }

    public MediaPlayer getPage07() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p07));
    }

    public MediaPlayer getPage08() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p08));
    }

    public MediaPlayer getPage09() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p09));
    }

    public MediaPlayer getPage10() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p10));
    }

    public MediaPlayer getPage11() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p11));
    }

    public MediaPlayer getPage12() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p12));
    }

    public MediaPlayer getSplash() {
        return getMedia(ctx.getResources().getString(R.string.mp3_splash));
    }

    public MediaPlayer getMenuAuto() {
        return getMedia(ctx.getResources().getString(R.string.mp3_menu_auto));
    }

    public MediaPlayer getMenuSelf() {
        return getMedia(ctx.getResources().getString(R.string.mp3_menu_self));
    }

    /**
     * set Language
     */

    public MediaFactory setLang(String langPath) {
        this.langPath = langPath;
        return this;
    }

    public MediaFactory toEngLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_eng));
    }

    public MediaFactory toFraLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_fra));
    }

    public MediaFactory toDeuLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_deu));
    }

    public MediaFactory toEspLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_esp));
    }

    public MediaFactory toItaLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_ita));
    }
}
