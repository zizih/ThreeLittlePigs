package andr.lexibook.mylittlestory.lrrh.util;

import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import android.os.Environment;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 5/9/13
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadModeToFile implements ISerializeToFile<ReadMode> {

    private ReadMode cls;
    private File file;

    public ReadModeToFile() {
        file = new File(getProjectPath() + File.separator + "LittleRedRidingHood.setting");
    }

    @Override
    public void save(ReadMode cls) {
        try {
            FileOutputStream fo = new FileOutputStream(file);
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
            FileInputStream fi = new FileInputStream(file);
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

    public String getProjectPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
