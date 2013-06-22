package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.BtnGifSrc;
import andr.lexibook.mylittlestory.tlps.control.MediaFactory;
import andr.lexibook.mylittlestory.tlps.control.Setting;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.MenuBluePigGif;
import andr.lexibook.mylittlestory.tlps.util.ViewUtil;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class BaseActivity extends Activity implements MenuBluePigGif.MenuCallBack {

    public final int ENGLISH = 0;
    public final int FRANCH = 1;
    public final int EUTSCH = 2;
    public final int ESPANOL = 3;
    public final int ITALIANO = 4;

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
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater.inflate(R.menu.language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lang_english:
                setLanguage(ENGLISH);
                break;
            case R.id.lang_franch:
                setLanguage(FRANCH);
                break;
            case R.id.lang_eutsch:
                setLanguage(EUTSCH);
                break;
            case R.id.lang_espanol:
                setLanguage(ESPANOL);
                break;
            case R.id.lang_italiano:
                setLanguage(ITALIANO);
                break;
        }
        return true;
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
    public MediaPlayer getLangPlayer() {
        return langPlayer;
    }
}

