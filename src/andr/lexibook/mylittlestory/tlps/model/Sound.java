package andr.lexibook.mylittlestory.tlps.model;

import android.media.SoundPool;

/**
 * User: rain
 * Date: 5/14/13
 * Time: 2:46 PM
 */
public class Sound {

    private SoundPool pool;
    private int soundId;

    public Sound(SoundPool pool, int soundId) {
        this.pool = pool;
        this.soundId = soundId;
    }

    public void play(float volume) {
        this.pool.play(soundId, volume, volume, 0, 0, 1);
    }

    public void dispose() {
        this.pool.unload(this.soundId);
    }

    public void pause() {
        this.pool.pause(soundId);
    }

}
