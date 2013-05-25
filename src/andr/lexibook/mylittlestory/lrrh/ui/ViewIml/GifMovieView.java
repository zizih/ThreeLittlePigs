package andr.lexibook.mylittlestory.lrrh.ui.ViewIml;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.util.ViewUtil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is a View class that wraps Android {@link android.graphics.Movie} object and displays it.
 * You can set GIF as a Movie object or as a resource id from XML or by calling
 * {@link #setMovie(android.graphics.Movie)} or {@link #setMovieResource(int)}.
 * <p/>
 * You can pause and resume GIF animation by calling {@link #setPaused(boolean)}.
 * <p/>
 * The animation is drawn in the center inside of the measured view bounds.
 *
 * @author Sergey Bakhtiarov
 */

public class GifMovieView extends View {

    private static final int DEFAULT_MOVIEW_DURATION = 1000;

    private Context ctx;

    private int mMovieResourceId;
    private Movie mMovie;

    private long mMovieStart;
    private int mCurrentAnimationTime = 0;

    private long mDelayStart;
    private long mDelayPeroid;
    private volatile boolean mDelayed = false;

    private volatile boolean mPaused = false;
    private long mPausedStart = -1;
    private long mPausedTime;

    private volatile boolean mDispeared = false;
    private long mDispearStart;
    private long mDispearTime;

    /**
     * Position for drawing animation frames in the center of the view.
     */
    private float mLeft;
    private float mTop;

    /**
     * Scaling factor to fit the animation within view bounds.
     */
    private float mScaleX;
    private float mScaleY;

    /**
     * Scaled movie frames width and height.
     */
    private int mMeasuredMovieWidth;
    private int mMeasuredMovieHeight;

    private boolean mVisible = true;

    public GifMovieView(Context context) {
        this(context, null);
    }

    public GifMovieView(Context context, AttributeSet attrs) {
        this(context, attrs, R.styleable.CustomTheme_gifMovieViewStyle);
    }

    public GifMovieView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.ctx = context;
        setViewAttributes(context, attrs, defStyle);
    }

    /**
     * 获取gif输入流，设置图片
     */
    public InputStream getIS(String asset) {
        try {
            return ctx.getAssets().open(asset);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMovieAsset(String path) {
        mMovie = Movie.decodeStream(getIS(path));
        requestLayout();
    }

    /**
     * 延时播放
     */
    public void delay(int delayTime) {
        mDelayPeroid = delayTime;
        mDelayStart = android.os.SystemClock.uptimeMillis();
        mDelayed = true;
        invalidate();
    }

    @SuppressLint("NewApi")
    private void setViewAttributes(Context context, AttributeSet attrs, int defStyle) {

        /**
         * Starting from HONEYCOMB have to turn off HW acceleration to draw
         * Movie on Canvas.
         */
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GifMovieView, defStyle,
                R.style.Widget_GifMoviewView);

        mMovieResourceId = array.getResourceId(R.styleable.GifMovieView_gif, -1);
        mPaused = array.getBoolean(R.styleable.GifMovieView_paused, false);

        array.recycle();

        if (mMovieResourceId != -1) {
            mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        }
    }

    public void setMovieResource(int movieResId) {
        this.mMovieResourceId = movieResId;
        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();
    }

    public void setMovie(Movie movie) {
        this.mMovie = movie;
        requestLayout();
    }

    public Movie getMovie() {
        return mMovie;
    }

    public void setMovieTime(int time) {
        mCurrentAnimationTime = time;
        invalidate();
    }

    public void setPaused(boolean paused) {
        this.mPaused = paused;
        /**
         * Calculate new movie start time, so that it resumes from the same
         * frame.
         */
        if (!paused) {
            mMovieStart = android.os.SystemClock.uptimeMillis() - mCurrentAnimationTime;
        }

        invalidate();
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (mMovie != null) {
            int movieWidth = mMovie.width();
            int movieHeight = mMovie.height();

			/*
             * Calculate horizontal scaling
			 */
            float scaleH = 1f;
            int measureModeWidth = MeasureSpec.getMode(widthMeasureSpec);

            if (measureModeWidth != MeasureSpec.UNSPECIFIED) {
                int maximumWidth = MeasureSpec.getSize(widthMeasureSpec);
                if (movieWidth > maximumWidth) {
                    scaleH = (float) movieWidth / (float) maximumWidth;
                }
            }

			/*
             * calculate vertical scaling
			 */
            float scaleW = 1f;
            int measureModeHeight = MeasureSpec.getMode(heightMeasureSpec);

            if (measureModeHeight != MeasureSpec.UNSPECIFIED) {
                int maximumHeight = MeasureSpec.getSize(heightMeasureSpec);
                if (movieHeight > maximumHeight) {
                    scaleW = (float) movieHeight / (float) maximumHeight;
                }
            }

			/*
             * calculate overall scale
			 */
            mScaleX = 1f / scaleW * ViewUtil.getInstance(ctx).getWidthScale();
            mScaleY = 1f / scaleH * ViewUtil.getInstance(ctx).getHeightScale();

            mMeasuredMovieWidth = (int) (movieWidth * mScaleX);
            mMeasuredMovieHeight = (int) (movieHeight * mScaleY);

            setMeasuredDimension(mMeasuredMovieWidth, mMeasuredMovieHeight);

        } else {            /*
             * No movie set, just set minimum available size.
			 */
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    public void resume() {
        mPaused = false;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

		/*
         * Calculate left / top for drawing in center
		 */
        mLeft = (getWidth() - mMeasuredMovieWidth) / 2f;
        mTop = (getHeight() - mMeasuredMovieHeight) / 2f;

        mVisible = getVisibility() == View.VISIBLE;
    }

    private DispearCallback dispearCallback;

    public interface DispearCallback {
        public void dispear(View view);
    }

    public void dispear(long millisecond, DispearCallback callback) {
        mDispeared = true;
        mDispearTime = millisecond;
        mDispearStart = android.os.SystemClock.uptimeMillis();
        this.dispearCallback = callback;
    }

    public void setPaused(long millisecond) {
        mPausedStart = android.os.SystemClock.uptimeMillis();
        mPausedTime = millisecond;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null) {
            //deal with pause
            if (mPausedStart != -1 && (android.os.SystemClock.uptimeMillis() - mPausedStart) >= mPausedTime) {
                drawMovieFrame(canvas, (int) mPausedTime);
                return;
            }

            //deal with dispear
            if (mDispeared && (android.os.SystemClock.uptimeMillis() - mDispearStart) >= mDispearTime) {
                dispearCallback.dispear(this);
                return;
            }

            //deal with isDelay
            if (mDelayed && ((android.os.SystemClock.uptimeMillis() - mDelayStart) <= mDelayPeroid)) {
                invalidate();
                return;
            }

            //deal with isPause
            if (!mPaused) {
                updateAnimationTime();
                drawMovieFrame(canvas);
                invalidateView();
            } else {
                drawMovieFrame(canvas);
            }
        }
    }

    /**
     * Invalidates view only if it is visible.
     * <br>
     */
    @SuppressLint("NewApi")
    private void invalidateView() {
        if (mVisible) {
            invalidate();
        }
    }

    /**
     * Calculate current animation time
     */

    private void updateAnimationTime() {
        long now = android.os.SystemClock.uptimeMillis();
        if (mMovieStart == 0) {
            mMovieStart = now;
        }

        int dur = mMovie.duration();

        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }

        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    /**
     * Draw current GIF frame
     */
    private void drawMovieFrame(Canvas canvas) {
        drawMovieFrame(canvas, mCurrentAnimationTime);
    }

    private void drawMovieFrame(Canvas canvas, int currentAnimationTime) {

        mMovie.setTime(currentAnimationTime);
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.scale(mScaleX, mScaleY);
        mMovie.draw(canvas, mLeft / mScaleX, mTop / mScaleY);
        canvas.restore();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }
}