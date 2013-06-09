package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;


/**
 * User: rain
 * Date: 4/16/13
 * Time: 7:44 PM
 */
@SuppressWarnings("deprecation")
public class LangSelect extends BaseActivity implements GifMovieView.DispearCallback, View.OnClickListener {

    private GifMovieView eng;
    private GifMovieView fra;
    private GifMovieView deu;
    private GifMovieView esp;
    private GifMovieView ita;
    private GifMovieView wolf;
    private AbsoluteLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lang);

        //init
        eng = (GifMovieView) findViewById(R.id.gif_lang_eng);
        fra = (GifMovieView) findViewById(R.id.gif_lang_fra);
        deu = (GifMovieView) findViewById(R.id.gif_lang_deu);
        esp = (GifMovieView) findViewById(R.id.gif_lang_esp);
        ita = (GifMovieView) findViewById(R.id.gif_lang_ita);
        wolf = (GifMovieView) findViewById(R.id.gif_lang_wolf);

        eng.setMovieAsset(getString(R.string.lang_eng_box));
        fra.setMovieAsset(getString(R.string.lang_fra_box));
        deu.setMovieAsset(getString(R.string.lang_deu_box));
        esp.setMovieAsset(getString(R.string.lang_esp_box));
        ita.setMovieAsset(getString(R.string.lang_ita_box));
        wolf.setMovieAsset(getString(R.string.lang_wolf));

        params = (AbsoluteLayout.LayoutParams) eng.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_eng_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_eng_y));
        eng.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) fra.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_fra_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_fra_y));
        fra.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) deu.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_deu_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_deu_y));
        deu.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) esp.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_esp_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_esp_y));
        esp.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) ita.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_ita_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_ita_y));
        ita.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_wolf_y));
        wolf.setLayoutParams(params);

        eng.setOnClickListener(this);
        fra.setOnClickListener(this);
        deu.setOnClickListener(this);
        esp.setOnClickListener(this);
        ita.setOnClickListener(this);

    }

    @Override
    public void dispear(View view) {
        view.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_lang_eng:
                setLanguage(ENGLISH);
                break;
            case R.id.gif_lang_fra:
                setLanguage(FRANCH);
                break;
            case R.id.gif_lang_deu:
                setLanguage(EUTSCH);
                break;
            case R.id.gif_lang_esp:
                setLanguage(ESPANOL);
                break;
            case R.id.gif_lang_ita:
                setLanguage(ITALIANO);
                break;
        }
        toPage(Menu.class);
    }

    @Override
    protected void onDestroy() {
        eng = null;
        fra = null;
        deu = null;
        esp = null;
        ita = null;
        super.onDestroy();
    }
}
