package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgSrc;
import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;
import andr.lexibook.mylittlestory.lrrh.model.FlipAdapter;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.widget.Page02;
import andr.lexibook.mylittlestory.lrrh.ui.widget.Page07;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
@SuppressWarnings("deprecation")
public class Pages extends BaseActivity implements PageFactory.Callback {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private Fliplistener flipListener;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private FlipAdapter flipAdapter;
    private PageFactory pageFactory;
    private GifMovieView p02_grand_start;
    private GifMovieView p02_grand_loop;
    private GifMovieView p02_window;
    private GifMovieView p02_mother;
    private GifMovieView p07_window;
    private Page02 p02;
    private Page07 p07;
    /**
     * there are a strange thing that p02 is true after call factory.get();
     */
    private int p07WindowIndex = -1;
    private int p02WindowIndex = -1;
    private int p02MotherIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bgSrc = BgSrc.getInstance(this);
        pageFactory = PageFactory.getInstance(this);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipAdapter = new FlipAdapter(this);
        flipView.setAdapter(flipAdapter);
        flipAdapter.notifyDataSetChanged();
        setContentView(flipView);

//        setting.setAuto(false);
        flipListener = new Fliplistener();
        flipView.setFlipByTouchEnabled(true);
        flipView.setOnViewFlipListener(flipListener);

        if (setting.getReadMode().isAuto()) {
            langCompleteListener = new LangListener();
            pageCompleteListener = new PageListener();
//            flipView.setFlipByTouchEnabled(false);
            if (isFirst) {
                mPlayer = mediaFactory.getPage01();
                mPlayer.setOnCompletionListener(pageCompleteListener);
                try {
                    mPlayer.prepare();
                    mPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isFirst = false;
            }
        }
        pageFactory.setCallback(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mPlayer != null && mPlayer.isPlaying())
                mPlayer.release();
            toPage(Menu.class);
        }
        return false;
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        if (setting.getReadMode().isAuto()) {
            mPlayer.release();
            langPlayer.setOnCompletionListener(langCompleteListener);
        }
        if (langChanged) {
            pageFactory.getPage(this.position).getLayoutView().setBackgroundResource(bgSrc.setLang(langId).getPageDrawableId(this.position));
            flipAdapter.notifyDataSetChanged();
            flipView.flipToPageAgain();
            langChanged = false;
        }
    }

    private void play(int position) {
        this.position = position;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            System.gc();
        }
        switch (position) {
            case 0:
                mPlayer = mediaFactory.getPage01();
                break;
            case 1:
                mPlayer = mediaFactory.getPage02();
                break;
            case 2:
                mPlayer = mediaFactory.getPage03();
                break;
            case 3:
                mPlayer = mediaFactory.getPage04();
                break;
            case 4:
                mPlayer = mediaFactory.getPage05();
                break;
            case 5:
                mPlayer = mediaFactory.getPage06();
                break;
            case 6:
                mPlayer = mediaFactory.getPage07();
                break;
            case 7:
                mPlayer = mediaFactory.getPage08();
                break;
            case 8:
                mPlayer = mediaFactory.getPage09();
                break;
            case 9:
                mPlayer = mediaFactory.getPage10();
                break;
            case 10:
                mPlayer = mediaFactory.getPage11();
                break;
            case 11:
                mPlayer = mediaFactory.getPage12();
                break;
        }
        try {
            mPlayer.setOnCompletionListener(pageCompleteListener);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPosition(int posit) {
        this.position = posit;
    }

    @Override
    public void autoFlip() {
        flipView.autoFlip();
        flipView.setFlipByTouchEnabled(true);
    }

    @Override
    public void diableFlip() {
        flipView.setFlipByTouchEnabled(false);
    }

    @SuppressWarnings("deprecation")
    class Fliplistener implements FlipViewController.ViewFlipListener {

        @Override
        public void onViewFlipped(View view, int position) {
            setPosition(position);
            if (setting.getReadMode().isAuto() && !langChanged)
                play(position);
            /**
             * do with abnormal gif of page02
             */
            for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                System.out.println(position + " View " + i + "  " + ((AbsoluteLayout) view).getChildAt(i).getId());
            }

            if (position == 1) {
                p02 = (Page02) pageFactory.getPage(position);
                p02_grand_start = p02.getGrandStart();
                p02_grand_loop = p02.getGrandLoop();
                p02_window = p02.getWindow();
                p02_mother = p02.getMother();
                p02WindowIndex = -1;
                p02MotherIndex = -1;
                for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p02_window.getId())
                        p02WindowIndex = i;
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p02_mother.getId())
                        p02MotherIndex = i;
                }
                ((AbsoluteLayout) view).addView(p02_grand_start);
                ((AbsoluteLayout) view).addView(p02_grand_loop);
                ((AbsoluteLayout) view).addView(p02_window);
                ((AbsoluteLayout) view).addView(p02_mother);
                if (p02MotherIndex != -1) {
                    ((AbsoluteLayout) view).removeViewAt(p02WindowIndex);
                    if (p02MotherIndex > p02WindowIndex)
                        p02MotherIndex--;
                    ((AbsoluteLayout) view).removeViewAt(p02MotherIndex);
                }
                p02 = null;
                p02_window = null;
                p02_mother = null;
                p02_grand_loop = null;
                p02_grand_start = null;
                System.gc();
            }
            /**
             * do with abnormal gif of page07
             */
            if (position == 6) {
                p07 = (Page07) pageFactory.getPage(position);
                p07_window = p07.getWindow();
                p07WindowIndex = -1;
                for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p07_window.getId())
                        p07WindowIndex = i;
                }
                ((AbsoluteLayout) view).addView(p07_window);
                if (p07WindowIndex != -1) {
                    ((AbsoluteLayout) view).removeViewAt(p07WindowIndex);
                }
                p07 = null;
                p07_window = null;
                System.gc();
            }
        }
    }

    class LangListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            play(position);
        }
    }

    class PageListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (position >= 0 && position < 11 && !setting.isOOM()) {
                flipView.autoFlip();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Pages OnResume ");
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pages OnPause ");
        flipView.onPause();
    }

    @Override
    protected void onDestroy() {
        flipView = null;
        mPlayer = null;
        System.out.println("Pages OnDestroy ");
        super.onDestroy();
    }

}


