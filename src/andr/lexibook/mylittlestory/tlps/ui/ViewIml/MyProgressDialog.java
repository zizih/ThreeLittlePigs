package andr.lexibook.mylittlestory.tlps.ui.ViewIml;

import andr.lexibook.mylittlestory.tlps.control.PageFactory;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by rain on 6/8/13.
 */
public class MyProgressDialog extends ProgressDialog {

    private Handler mHandler;
    private PageFactory pageFactory;
    private int pageIndex;

    public MyProgressDialog(Context context, int pageIndex) {
        super(context);
        this.pageIndex = pageIndex;
        this.pageFactory = PageFactory.getInstance(context);
    }

    @Override
    public void show() {
        super.show();
        Log.i("", "Dialog Show..");
        setCanceledOnTouchOutside(false);
        try {
            Looper.getMainLooper();
            new MyLoadPageAsyc().execute();
            mHandler = new SynHandler();
            Looper.loop();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void cancel() {
        Log.i("", "Dialog Cancle...");
        super.cancel();
    }

    class SynHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            cancel();
            throw new RuntimeException();
        }
    }

    class MyLoadPageAsyc extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                do {
                    Thread.sleep(2000);
                    System.gc();
                }
                while (!pageFactory.newPage(pageIndex));
                mHandler.sendEmptyMessage(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
