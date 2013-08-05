package andr.lexibook.mylittlestory.tlps.ui.ViewIml;

import andr.lexibook.mylittlestory.tlps.control.MediaFactory;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.util.AttributeSet;

import java.io.IOException;

/**
 * Created by rain on 6/2/13.
 */
public class BluePigGif extends GifMovieView {

    private boolean isAutoPlayed = false;
    private boolean isSelfPlayed = false;
    private MediaFactory mediaFactory;
    private MediaPlayer autoPlayer;
    private MediaPlayer selfPlayer;
    private MediaPlayer langPlayer;
    private MenuCallBack menuCallBack;
    private MenuListener endListener;

    public BluePigGif(Context context) {
        super(context);
    }

    public BluePigGif(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BluePigGif(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void changLanguage() {
        if (autoPlayer != null && autoPlayer.isPlaying())
            autoPlayer.setVolume(.2f, .2f);
        if (selfPlayer != null && selfPlayer.isPlaying())
            selfPlayer.setVolume(.2f, .2f);
        isSelfPlayed = false;
        isAutoPlayed = false;
    }

    public void setMenuCallBack(MenuCallBack menuCallBack) {
        this.menuCallBack = menuCallBack;
        this.langPlayer = menuCallBack.getLangPlayer();
        if (endListener == null) {
            endListener = new MenuListener();
        }
        if (this.langPlayer != null)
            this.langPlayer.setOnCompletionListener(endListener);
    }

    public interface MenuCallBack {

        public MediaPlayer getLangPlayer();
    }

    class MenuListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (autoPlayer != null && autoPlayer.isPlaying())
                autoPlayer.setVolume(1f, 1f);
            if (selfPlayer != null && selfPlayer.isPlaying())
                selfPlayer.setVolume(1f, 1f);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null) {
            if (!isAutoPlayed && mCurrentAnimationTime < 600) {
                if (menuCallBack != null && langPlayer != null && langPlayer.isPlaying())
                    playAutoLow();
                else {
                    playAuto();
                }
                isAutoPlayed = true;
            }
            if (!isSelfPlayed && mCurrentAnimationTime > 6600 && mCurrentAnimationTime < 7200) {
                playSelf();
                isSelfPlayed = true;
            }
        }
        super.onDraw(canvas);
    }

    private void playAuto() {
        if (mediaFactory == null) {
            mediaFactory = MediaFactory.getInstance(getContext());
        }
        if (autoPlayer != null)
            autoPlayer.release();
        autoPlayer = mediaFactory.getMenuAuto();
        play(autoPlayer);
    }

    private void playAutoLow() {
        if (mediaFactory == null) {
            mediaFactory = MediaFactory.getInstance(getContext());
        }
        if (autoPlayer != null)
            autoPlayer.release();
        autoPlayer = mediaFactory.getMenuAuto();
        try {
            autoPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        autoPlayer.start();
        autoPlayer.setVolume(.2f, .2f);
    }

    private void playSelf() {
        if (mediaFactory == null) {
            mediaFactory = MediaFactory.getInstance(getContext());
        }
        if (selfPlayer != null)
            selfPlayer.release();
        selfPlayer = mediaFactory.getMenuSelf();
        play(selfPlayer);
    }

    private void play(MediaPlayer player) {
        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void releasePlay() {
        if (autoPlayer != null)
            autoPlayer.release();
        if (selfPlayer != null)
            selfPlayer.release();
        //add release gif
        clearAnimation();
        isAutoPlayed = true;
        isSelfPlayed = true;
    }

}
