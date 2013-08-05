package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.BtnGifSrc;
import andr.lexibook.mylittlestory.tlps.control.MediaFactory;
import andr.lexibook.mylittlestory.tlps.control.Setting;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.BluePigGif;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.CustomMenuItem;
import andr.lexibook.mylittlestory.tlps.util.ViewUtil;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MotionEvent;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class BaseActivity extends CustomMenuBase implements BluePigGif.MenuCallBack {

    public int WIN_WIDTH;
    public int WIN_HEIGHT;

    private MenuInflater inflater;
    private Intent toPage;

    public Setting setting;

    public MediaFactory mediaFactory;
    public MediaPlayer mPlayer;
    public MediaPlayer langPlayer;

    public BgSrc bgSrc;
    public BtnGifSrc btnSrc;
    public boolean langChanged;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(" Oncreate: ", this.getClass().getName());
        toPage = new Intent();
        inflater = getMenuInflater();
        setting = Setting.getInstance(this);

        //about sound
        mediaFactory = MediaFactory.getInstance(this);
        mediaFactory.setLang(checkLangToPath(setting.getReadMode().getLang()));

        //adapt difference dispay
        WIN_WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        WIN_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();

    }

    public boolean checkLocation(MotionEvent event, int[] location) {
        if (event.getX() > location[0] * getWidthScale()
                && event.getY() > location[1] * getHeightScale()
                && event.getX() < location[2] * getWidthScale()
                && event.getY() < location[3] * getHeightScale()) {
            return true;
        }
        return false;
    }

    @Override
    public void MenuItemSelectedEvent(CustomMenuItem selection) {
        super.MenuItemSelectedEvent(selection);
        setLanguage(selection.getId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(" Ondestry: ", this.getClass().getName());
        setting.save();
        System.gc();
        finish();
    }

    /**
     * 清理gif后 页面跳转
     */

    public void toPage(Class<?> cls) {
        toPage.setClass(this, cls);
        startActivity(toPage);
        this.finish();
        System.gc();
    }

    /**
     * 设置所选的语言
     */
    public void setLanguage(int langId) {
        if (setting.getLangId() != langId) {
            langChanged = true;
        }
        switch (langId) {
            case ENGLISH:
                langPlayer = mediaFactory.toEngLang().getLang();
                break;
            case FRANCH:
                langPlayer = mediaFactory.toFraLang().getLang();
                break;
            case EUTSCH:
                langPlayer = mediaFactory.toDeuLang().getLang();
                break;
            case ESPANOL:
                langPlayer = mediaFactory.toEspLang().getLang();
                break;
            case ITALIANO:
                langPlayer = mediaFactory.toItaLang().getLang();
                break;
        }
        try {
            langPlayer.prepare();
            langPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setting.setLang(langId);
        setting.save();
    }

    /**
     * 设置所选的阅读模式
     */
    public void setReadMode(boolean isAuto) {
        setting.setAuto(isAuto);
        setting.save();
    }

    public float getDimens(int dimensId) {
        return getResources().getDimension(dimensId);
    }

    public float getWidthScale() {
        return ViewUtil.getInstance(this).getWidthScale();
    }

    public float getHeightScale() {
        return ViewUtil.getInstance(this).getHeightScale();
    }

    public float getWinWidth() {
        return ViewUtil.getInstance(this).getWinWidth();
    }

    public float getWinHeight() {
        return ViewUtil.getInstance(this).getWinHeight();
    }

    private String checkLangToPath(String lang) {
        switch (setting.checkLangToId(lang)) {
            case ENGLISH:
                return getResources().getString(R.string.mp3_lang_eng);
            case FRANCH:
                return getResources().getString(R.string.mp3_lang_fra);
            case EUTSCH:
                return getResources().getString(R.string.mp3_lang_deu);
            case ESPANOL:
                return getResources().getString(R.string.mp3_lang_esp);
            case ITALIANO:
                return getResources().getString(R.string.mp3_lang_ita);
            default:
                return getResources().getString(R.string.mp3_lang_default);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        onDestroy();
    }

    @Override
    public MediaPlayer getLangPlayer() {
        return langPlayer;
    }
}

