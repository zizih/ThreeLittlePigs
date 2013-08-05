package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.ui.ViewIml.GifMovieView;
import android.os.Bundle;
import android.view.MotionEvent;


/**
 * User: rain
 * Date: 4/16/13
 * Time: 7:44 PM
 */
@SuppressWarnings("deprecation")
public class LangSelect extends BaseActivity{

    private GifMovieView eng;
    private GifMovieView fra;
    private GifMovieView deu;
    private GifMovieView esp;
    private GifMovieView ita;
    private GifMovieView wolf;

    private int[] eng_location;
    private int[] fra_location;
    private int[] deu_location;
    private int[] esp_location;
    private int[] ita_location;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lang);
        setMenuView(findViewById(R.id.any_widget_4_menu_lang));

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

        eng_location = getResources().getIntArray(R.array.lang_eng_location);
        fra_location = getResources().getIntArray(R.array.lang_fra_location);
        deu_location = getResources().getIntArray(R.array.lang_deu_location);
        esp_location = getResources().getIntArray(R.array.lang_esp_location);
        ita_location = getResources().getIntArray(R.array.lang_ita_location);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (checkLocation(event, eng_location)) {
                setLanguage(ENGLISH);
            }
            if (checkLocation(event, fra_location)) {
                setLanguage(FRANCH);
            }
            if (checkLocation(event, deu_location)) {
                setLanguage(EUTSCH);
            }
            if (checkLocation(event, esp_location)) {
                setLanguage(ESPANOL);
            }
            if (checkLocation(event, ita_location)) {
                setLanguage(ITALIANO);
            }
            toPage(Menu.class);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        eng.Clear();
        fra.Clear();
        deu.Clear();
        esp.Clear();
        ita.Clear();
        wolf.Clear();
        super.onDestroy();
    }
}
