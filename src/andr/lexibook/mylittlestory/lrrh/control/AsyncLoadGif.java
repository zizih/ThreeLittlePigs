package andr.lexibook.mylittlestory.lrrh.control;

import android.content.Context;
import android.os.AsyncTask;

/**
 * User: rain
 * Date: 5/12/13
 * Time: 6:45 PM
 */
public class AsyncLoadGif extends AsyncTask<Integer, Boolean, Boolean> {

    private PageFactory pageFactory;

    public AsyncLoadGif(Context ctx) {
        pageFactory = PageFactory.getInstance(ctx);
    }


    /**
     * 一个参数表示
     */
    @Override
    protected Boolean doInBackground(Integer... keys) {
        if (keys.length == 1)
            pageFactory.loadPage(keys[0]);
        if (keys.length == 2)
            pageFactory.loadPage(keys[0], keys[1]);
        return true;
    }
}
