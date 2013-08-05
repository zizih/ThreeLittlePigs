package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.PageFactory;
import andr.lexibook.mylittlestory.tlps.libs.FlipViewController;
import andr.lexibook.mylittlestory.tlps.model.FlipAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
@SuppressWarnings("deprecation")
public class Pages extends BaseActivity implements PageFactory.Callback, FlipViewController.PlayPauseCallBack {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private Fliplistener flipListener;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private FlipAdapter flipAdapter;
    private PageFactory pageFactory;

    /**
     * add play & pause
     */
    protected Handler mHandler;
    protected TimerThread mTimerThead;
    protected boolean ifAllowFlip = false;
    protected boolean isPaused = false;
    protected boolean isPrepared = false;

    private ImageView ll_play;
    private ImageView ll_pause;
    private AbsoluteLayout.LayoutParams params;
    private View preView;
    private AbsoluteLayout al_pages;

    //about btn
    public final int BTN_WIDTH = 48;
    public final int BTN_HEIGHT = 44;

    protected int[] playPauseLocations = {
            R.array.btn_play_pause_p01
            , R.array.btn_play_pause_p02
            , R.array.btn_play_pause_p03
            , R.array.btn_play_pause_p04
            , R.array.btn_play_pause_p05
            , R.array.btn_play_pause_p06
            , R.array.btn_play_pause_p07
            , R.array.btn_play_pause_p08
            , R.array.btn_play_pause_p09
            , R.array.btn_play_pause_p10
            , R.array.btn_play_pause_p11
            , R.array.btn_play_pause_p12
            , R.array.btn_play_pause_p13
    };

    private int[] dimenXs = {R.dimen.btn_play_pause_p01_x
            , R.dimen.btn_play_pause_p02_x
            , R.dimen.btn_play_pause_p03_x
            , R.dimen.btn_play_pause_p04_x
            , R.dimen.btn_play_pause_p05_x
            , R.dimen.btn_play_pause_p06_x
            , R.dimen.btn_play_pause_p07_x
            , R.dimen.btn_play_pause_p08_x
            , R.dimen.btn_play_pause_p09_x
            , R.dimen.btn_play_pause_p10_x
            , R.dimen.btn_play_pause_p11_x
            , R.dimen.btn_play_pause_p12_x
            , R.dimen.btn_play_pause_p13_x
    };
    private int[] dimenYs = {R.dimen.btn_play_pause_p01_y
            , R.dimen.btn_play_pause_p02_y
            , R.dimen.btn_play_pause_p03_y
            , R.dimen.btn_play_pause_p04_y
            , R.dimen.btn_play_pause_p05_y
            , R.dimen.btn_play_pause_p06_y
            , R.dimen.btn_play_pause_p07_y
            , R.dimen.btn_play_pause_p08_y
            , R.dimen.btn_play_pause_p09_y
            , R.dimen.btn_play_pause_p10_y
            , R.dimen.btn_play_pause_p11_y
            , R.dimen.btn_play_pause_p12_y
            , R.dimen.btn_play_pause_p13_y
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages);
        bgSrc = BgSrc.getInstance(this);
        pageFactory = PageFactory.getInstance(this);
        al_pages = (AbsoluteLayout) findViewById(R.id.al_pages);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipView.setPlayPauseCallBack(this);
        flipAdapter = new FlipAdapter(this);
        flipView.setAdapter(flipAdapter);
        al_pages.addView(flipView);

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
                    isPrepared = true;
                    mPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isFirst = false;
            }
        }
        pageFactory.setCallback(this);
        mHandler = new Handler();
        mTimerThead = new TimerThread();

        ll_play = new ImageView(this);
        ll_pause = new ImageView(this);
        ll_play.setBackgroundDrawable(bgSrc.getPlayDrawable());
        ll_pause.setBackgroundDrawable(bgSrc.getPauseDrawable());
        params = new AbsoluteLayout.LayoutParams(BTN_WIDTH, BTN_HEIGHT, 677, 412);
        params.x = (int) (getWidthScale() * getResources().getDimension(dimenXs[0]));
        params.y = (int) (getHeightScale() * getResources().getDimension(dimenYs[0]));
        params.width = (int) (getWidthScale() * BTN_WIDTH);
        params.height = (int) (getWidthScale() * BTN_HEIGHT);

        setMenuView(findViewById(R.id.any_widget_4_menu_pages));
    }

    @Override
    public void pauseOrPlay(View view, MotionEvent e) {
        preView = view;
        if (setting.isAuto() && (position >= 0 && position < 13)
                && (e.getAction() == MotionEvent.ACTION_DOWN
                && checkLocation(e, getResources().getIntArray(playPauseLocations[position])))) {
            if (ll_pause.getParent() != null)
                ((AbsoluteLayout) ll_pause.getParent()).removeView(ll_pause);
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
            if (isPaused) {
                ll_pause.setLayoutParams(params);
                ((AbsoluteLayout) view).addView(ll_pause);
                isPaused = false;
                if (isPrepared)
                    mPlayer.start();
            } else {
                ll_play.setLayoutParams(params);
                ((AbsoluteLayout) view).addView(ll_play);
                try {
                    mPlayer.pause();
                    isPaused = true;
                } catch (Exception ePause) {
                    System.out.println("ePause: " + ePause.getCause());
                }
            }
        }
    }


    @Override
    public void onFliped(View view) {
        if (preView != null) {
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
        }
    }

    @Override
    public void startFlip(View view) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.release();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
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
            case 12:
                mPlayer = mediaFactory.getPage13();
                break;
            case 13:
                mPlayer = mediaFactory.getPage14();
                break;
        }
        try {
            mPlayer.setOnCompletionListener(pageCompleteListener);
            mPlayer.prepare();
            isPrepared = true;
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
            isPaused = false;
            isPrepared = false;
            if ((position >= 0 && position < 13)) {
                params.x = (int) (getWidthScale() * getResources().getDimension(dimenXs[position]));
                params.y = (int) (getHeightScale() * getResources().getDimension(dimenYs[position]));
                params.width = (int) (getWidthScale() * BTN_WIDTH);
                params.height = (int) (getWidthScale() * BTN_HEIGHT);
            }

            /**
             * about slowwer
             */
            mHandler.postDelayed(mTimerThead, 1000);
            flipView.setFlipByTouchEnabled(false);

            setPosition(position);
            if (setting.getReadMode().isAuto() && !langChanged)
                play(position);
        }
    }

    class TimerThread implements Runnable {

        @Override
        public void run() {
            (Pages.this).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    timer();
                }
            });
        }

    }


    protected void timer() {
        if (!ifAllowFlip) {
            flipView.setFlipByTouchEnabled(true);
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
            if (!isPaused && position >= 0 && position < 13 && !setting.isOOM()) {
                flipView.autoFlip();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Pages onResume ");
        flipView.onResume();
        if (isPaused) {
            isPaused = false;
            if (isPrepared) {
                mPlayer.start();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pages onPause ");
        if (mPlayer != null) {
            try {
                mPlayer.pause();
                isPaused = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flipView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Pages onStop ");
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        isPaused = false;
        isPrepared = false;
    }

    @Override
    protected void onDestroy() {
        flipView.Clear();
        System.out.println("Pages OnDestroy ");
        super.onDestroy();
    }

}