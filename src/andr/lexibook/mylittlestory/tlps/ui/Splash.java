package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Locale;

/**
 * @author hezi
 */
public class Splash extends BaseActivity implements View.OnClickListener {

    private Button btn_splash_bg;
    private boolean toMenued = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //set defualt lang
        if (setting.isFirst()) {
            toSysLang();
        }

        bgSrc = BgSrc.getInstance(this);
        btn_splash_bg = (Button) findViewById(R.id.btn_splash_bg);
        btn_splash_bg.setOnClickListener(this);
        refreshBg();
        setMenuView(findViewById(R.id.any_widget_4_menu_splash));

        mPlayer = mediaFactory.getSplash();
        try {
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!toMenued)
                    toMenu();
            }
        }, 3000);
    }

    @Override
    public void onClick(View view) {
        if (!toMenued)
            toMenu();
    }

    private void toMenu() {
        toMenued = true;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        if (setting.isFirst()) {
            setting.setFirst(false);
            setting.save();
            toPage(LangSelect.class);
        } else {
            toPage(Menu.class);
        }
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        refreshBg();
    }

    private void refreshBg() {
        this.btn_splash_bg.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getSplashDrawable());
    }

    private void toSysLang() {
        String lang = Locale.getDefault().getLanguage();
        if (lang.indexOf("fr") != -1) {
            setting.setLang(FRANCH);
            mediaFactory.toFraLang();
        } else if (lang.indexOf("en") != -1) {
            setting.setLang(ENGLISH);
            mediaFactory.toEngLang();
        } else if (lang.indexOf("it") != -1) {
            setting.setLang(ITALIANO);
            mediaFactory.toItaLang();
        } else if (lang.indexOf("de") != -1) {
            setting.setLang(EUTSCH);
            mediaFactory.toDeuLang();
        } else if (lang.indexOf("es") != -1) {
            setting.setLang(ESPANOL);
            mediaFactory.toEspLang();
        } else {
            return;
        }
        setting.save();
    }

}
