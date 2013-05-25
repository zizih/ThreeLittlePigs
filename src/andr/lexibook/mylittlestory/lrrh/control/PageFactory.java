package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.widget.*;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

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
    //private LruCache<String, WeakReference<PageView>> pages;
    //private android.support.v4.util.LruCache<String, WeakReference<PageView>> pages;
    // private PageLruCache<String, WeakReference<PageView>> pages;
    //private DiskLruCache<String, WeakReference<PageView>> pages;

    private PageFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        pages = new WeakHashMap<String, WeakReference<PageView>>();
        //pages = new LruCache<String, WeakReference<PageView>>(1);
        //pages = new PageLruCache<String, WeakReference<PageView>>(1);
        // pages = new DiskLruCache<String, WeakReference<PageView>>(1);
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
    }

    public static PageFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new PageFactory(ctx);
        return instance;
    }

    public void loadPage(int count) {
        for (int i = 0; i < count; i++) {
            getPage(pagesKey[i]);
        }
    }

    public void loadPage(int current, int count) {
        for (int i = 0; i < count; i++) {
            getPage(pagesKey[i + current]);
        }
    }

    public PageView getPage(int position) {
        return getPage(pagesKey[position]);
    }

    public PageView getPage(String key) {
        if (!pages.containsKey(key) || pages.get(key).get() == null) {
            try {
                pages.put(key, new WeakReference<PageView>((PageView) pagesMap.get(key).getConstructors()[0].newInstance(ctx)));
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                Log.i(" ERR InvocationTargetException ", e.getCause().toString());
                System.gc();
            } catch (InstantiationException e) {
                e.printStackTrace();
                Log.i(" ERR InstantiationException ", e.getCause().toString());
                System.gc();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                Log.i(" ERR IllegalAccessException ", e.getCause().toString());
            }
        }
        return pages.get(key).get();
    }

    public void removePage(int postion) {
        if (pages.containsKey(pagesKey[postion])) {
            pages.remove(pagesKey[postion]);
        }
    }
}
