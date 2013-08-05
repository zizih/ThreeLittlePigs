package andr.lexibook.mylittlestory.tlps.util;

import andr.lexibook.mylittlestory.tlps.model.ReadMode;
import android.app.Activity;
import android.content.Context;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 5/9/13
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadModeToFile implements ISerializeToFile<ReadMode> {

    private Activity ctx;
    private ReadMode cls;
    private FileOutputStream fo;
    private FileInputStream fi;

    public ReadModeToFile(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    @Override
    public void save(ReadMode cls) {
        try {
            fo = ctx.openFileOutput("3lps.setting",
                    Activity.MODE_PRIVATE);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(cls);
            oo.flush();
            fo.close();
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ReadMode get() {
        try {
            fi = ctx.openFileInput("rhhl.setting");
            ObjectInputStream oi = new ObjectInputStream(fi);
            cls = (ReadMode) oi.readObject();
            fi.close();
            oi.close();
            return cls;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ReadMode();
    }
}
