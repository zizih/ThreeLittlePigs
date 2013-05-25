package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgSrc;
import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;
import andr.lexibook.mylittlestory.lrrh.model.FlipAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class Pages extends BaseActivity {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private Fliplistener flipListener;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private FlipAdapter flipAdapter;
    private PageFactory pageFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bgSrc = BgSrc.getInstance(this);
        pageFactory = PageFactory.getInstance(this);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipAdapter = new FlipAdapter(this);
        flipView.setAdapter(flipAdapter);
        setContentView(flipView);

        flipListener = new Fliplistener();
        flipView.setFlipByTouchEnabled(true);
        flipView.setOnViewFlipListener(flipListener);

        if (setting.getReadMode().isAuto()) {
            langCompleteListener = new LangListener();
            pageCompleteListener = new PageListener();
            flipView.setFlipByTouchEnabled(false);
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
            langChanged = false;
//            if (this.position == 11) {
//                ((Page12) pageFactory.getPage(this.position)).resetListener();
//            }
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

    class Fliplistener implements FlipViewController.ViewFlipListener {

        @Override
        public void onViewFlipped(View view, int position) {
            if (setting.getReadMode().isAuto())
                play(position);
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
            if (position >= 0 && position < 11) {
                flipView.autoFlip();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }

    @Override
    protected void onDestroy() {
        flipView = null;
        mPlayer = null;
        super.onDestroy();
    }
}


