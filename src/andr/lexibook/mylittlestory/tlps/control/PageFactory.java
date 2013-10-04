package andr.lexibook.mylittlestory.tlps.control;

import andr.lexibook.mylittlestory.tlps.ui.R;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.MyProgressDialog;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.tlps.ui.widget.*;
import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * User: rain
 * Date: 5/3/13
 * Time: 11:54 PM
 */
public class PageFactory {

    private Activity ctx;
    private static PageFactory instance;
    private Map<String, WeakReference<PageView>> pages;
    private Map<String, Class<?>> pagesMap;
    private String[] pagesKey;
    private int pageIndex;

    private PageFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        pages = new WeakHashMap<String, WeakReference<PageView>>();
        pagesKey = this.ctx.getResources().getStringArray(R.array.page_index);
        pagesMap = new WeakHashMap<String, Class<?>>();
        pagesMap.put(pagesKey[0], Page01.class);
        pagesMap.put(pagesKey[1], Page02.class);
        pagesMap.put(pagesKey[2], Page03.class);
        pagesMap.put(pagesKey[3], Page04.class);
        pagesMap.put(pagesKey[4], Page05.class);
        pagesMap.put(pagesKey[5], Page06.class);
        pagesMap.put(pagesKey[6], Page07.class);
        pagesMap.put(pagesKey[7], Page08.class);
        pagesMap.put(pagesKey[8], Page09.class);
        pagesMap.put(pagesKey[9], Page10.class);
        pagesMap.put(pagesKey[10], Page11.class);
        pagesMap.put(pagesKey[11], Page12.class);
        pagesMap.put(pagesKey[12], Page13.class);
        pagesMap.put(pagesKey[13], Page14.class);
    }

    public static PageFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new PageFactory(ctx);
        return instance;
    }

    public PageView getPage(int position) {
        pageIndex = position;
        return getPage(pagesKey[position]);
    }

    public PageView getPage(String key) {
        if (!pages.containsKey(key) || pages.get(key).get() == null) {
            try {
                pages.put(key, new WeakReference<PageView>((PageView) pagesMap.get(key).getConstructors()[0].newInstance(ctx)));
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                reloadPage();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return pages.get(key).get();
    }

    private void reloadPage() {
        Setting.getInstance(ctx).setOOM(true);
        callback.diableFlip();

        //dialog
        MyProgressDialog dialog = new MyProgressDialog(ctx, pageIndex);
        dialog.show();

        //after
        Setting.getInstance(ctx).setOOM(false);
        callback.autoFlip();
    }

    public void removePage(int postion) {
        if (pages.containsKey(pagesKey[postion])) {
            pages.remove(pagesKey[postion]);
        }
    }

    public int getCount() {
        return pagesMap.size();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    private Callback callback;

    public interface Callback {
        public void autoFlip();

        public void diableFlip();
    }

}